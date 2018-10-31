/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.logger.LogFactory;
import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.regex.Matcher;

import static java.lang.String.*;

/**
 * Contains a cached set of file templates usually per page
 *
 * @author GedMarc
 * @since A long time ago in a galaxy far away
 */
public class FileTemplates

{
	private static final java.util.logging.Logger LOG = LogFactory.getLog("FileTemplates");
	/**
	 * All registered templates
	 */
	@JsonIgnore
	private static final Map<String, StringBuilder> TemplateScripts = new ConcurrentHashMap<>();
	/**
	 * All registered variables
	 */
	@JsonIgnore
	private static final Map<String, StringBuilder> TemplateVariables = new ConcurrentHashMap<>();


	private FileTemplates()
	{

	}

	/**
	 * Removes a template
	 *
	 * @param templateName
	 */
	public static void removeTemplate(String templateName)
	{
		TemplateScripts.remove(templateName);
	}

	/**
	 * Gets the text string for the template script
	 *
	 * @param templateName
	 *
	 * @return
	 */
	public static StringBuilder getTemplateScript(String templateName)
	{
		return TemplateScripts.get(templateName);
	}

	/**
	 * Get the map of all the template scripts
	 *
	 * @param template
	 *
	 * @return A final HashMap
	 */
	public static StringBuilder renderTemplateScripts(String template)
	{
		if (TemplateScripts.containsKey(template) && TemplateScripts.get(template) != null)
		{
			return processTemplate(template, getTemplateScripts().get(template)
			                                                     .toString());
		}

		return new StringBuilder();
	}

	/**
	 * Replaces all instances of the following
	 *
	 * @param templateName
	 * 		The name of the template being processed
	 * @param template
	 * 		The physical string to process
	 *
	 * @return
	 */
	public static StringBuilder processTemplate(String templateName, String template)
	{
		String templateOutput = template;
		for (String templateVariable : getTemplateVariables().keySet())
		{
			String templateScript = null;
			try
			{
				templateScript = Matcher.quoteReplacement(getTemplateVariables().get(templateVariable)
				                                                                .toString());
				templateOutput = templateOutput.replaceAll(StaticStrings.STRING_EMPTY + templateVariable + StaticStrings.STRING_EMPTY, templateScript);
			}
			catch (NullPointerException iae)
			{
				LOG.log(Level.WARNING, "[Error]-[Unable to find specified template];[Script]-[" + templateVariable + "]", iae);
			}
			catch (IllegalArgumentException iae)
			{
				LOG.log(Level.WARNING, format("[Error]-[Invalid Variable Name for Regular Expression Search];[Variable]-[{0}];[Script]-[{1}]", templateVariable, templateScript),
				        iae);
			}
		}
		TemplateScripts.put(templateName, new StringBuilder(templateOutput.trim()));
		return TemplateScripts.get(templateName);
	}

	/**
	 * Sets all the template scripts currently loaded in memory
	 *
	 * @return
	 */
	public static Map<String, StringBuilder> getTemplateScripts()
	{
		return TemplateScripts;
	}

	/**
	 * Returns all the template variables currently loaded into memory
	 *
	 * @return
	 */
	public static Map<String, StringBuilder> getTemplateVariables()
	{
		return TemplateVariables;
	}

	/**
	 * Replaces all instances of the following
	 * <p>
	 * %%APP%% - the angular module application name %%DIRECTIVES%% - the angular directives %%MODULES%% the modules generates
	 * %%CONTROLLER%% the modules generates
	 *
	 * @param templateName
	 * 		The template name
	 * @param template
	 * 		the template to build
	 *
	 * @return the name
	 */
	public static StringBuilder compileTemplate(String templateName, String template)
	{
		return processTemplate(templateName, template);
	}

	/**
	 * Replaces all instances of the following
	 * <p>
	 * %%APP%% - the angular module application name %%DIRECTIVES%% - the angular directives %%MODULES%% the modules generates
	 * %%CONTROLLER%% the modules generates
	 *
	 * @param referenceClass
	 * 		The class to find where the file is at
	 * @param templateName
	 * 		the template to use
	 *
	 * @return the name
	 */
	public static StringBuilder compileTemplate(Class referenceClass, String templateName)
	{
		String template = getFileTemplate(referenceClass, templateName).toString();
		return processTemplate(templateName, template);
	}

	/**
	 * Returns the template as a string
	 *
	 * @param referenceClass
	 * 		The class to reference to locate the file
	 * @param templateName
	 * 		The file without .min.js or .js attached to it
	 *
	 * @return The string for the file
	 */
	public static StringBuilder getFileTemplate(Class referenceClass, String templateName)
	{
		return getFileTemplate(referenceClass, templateName, templateName);
	}

	/**
	 * Returns the template as a string
	 *
	 * @param referenceClass
	 * 		The class to reference to locate the file
	 * @param templateName
	 * 		The file without .min.js or .js attached to it
	 * @param fileName
	 *
	 * @return The string for the file
	 */
	public static StringBuilder getFileTemplate(Class referenceClass, String templateName, String fileName)
	{
		return getFileTemplate(referenceClass, templateName, fileName, false);
	}

	/**
	 * Returns the template as a string
	 *
	 * @param referenceClass
	 * 		The class to reference to locate the file
	 * @param templateName
	 * 		The file without .min.js or .js attached to it
	 * @param fileName
	 *
	 * @return The string for the file
	 */
	public static StringBuilder getFileTemplate(Class referenceClass, String templateName, String fileName, boolean alwaysRefresh)
	{
		StringBuilder template = TemplateScripts.get(templateName);
		if (template == null || alwaysRefresh)
		{
			try
			{
				String templateFileName = fileName;
				if (!(fileName.contains(".html") || fileName.contains(".htm") || fileName.contains(".js") || fileName.contains(".css") || fileName.contains(
						".min") || fileName.contains(".txt")))
				{
					templateFileName += ".js";
				}
				if (templateFileName.endsWith(".min"))
				{
					templateFileName = templateFileName + ".js";
				}
				String contents = IOUtils.toString(referenceClass.getResourceAsStream(templateFileName), StaticStrings.UTF8_CHARSET);
				setTemplateScript(templateName, new StringBuilder(contents));
			}
			catch (FileNotFoundException ex)
			{
				LOG.log(Level.SEVERE, "[Error]-[unable to find template file];[TemplateFile]-[" + templateName + "];[TemplatePath]-[" + referenceClass.getResource(templateName)
				                                                                                                                                      .getPath() + "]", ex);
			}
			catch (IOException ex)
			{
				LOG.log(Level.SEVERE, "Unable to read file contents jwangular template File", ex);
			}
			catch (NullPointerException npe)
			{
				LOG.log(Level.SEVERE, "template file [" + fileName + "(.js)] not found.");
			}
			catch (Exception npe)
			{
				LOG.log(Level.SEVERE, "Exception Rendering Template", npe);
			}
		}
		return TemplateScripts.get(templateName);
	}

	/**
	 * Sets the template script
	 *
	 * @param templateName
	 * @param templateScript
	 */
	public static void setTemplateScript(String templateName, StringBuilder templateScript)
	{
		TemplateScripts.put(templateName, templateScript);
	}
}
