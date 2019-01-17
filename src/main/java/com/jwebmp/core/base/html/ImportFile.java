/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Allows the importing of a file into a template
 *
 * @param <J>
 *
 * @author GedMarc
 * @since 06 Feb 2017
 */
public class ImportFile<J extends ImportFile<J>>
		extends Component<IComponentHierarchyBase, NoAttributes, NoFeatures, NoEvents, J>
		implements BodyChildren<IComponentHierarchyBase, J>, ParagraphChildren<IComponentHierarchyBase, J>
{
	/**
	 * The actual name for the template
	 */
	private String templateName;

	/**
	 * Constructs a new instance of an imported file via a stream
	 */
	public ImportFile()
	{
		//Default Constructor
	}

	/**
	 * Constructs a new instance of an imported file via a stream
	 *
	 * @param templateName
	 * 		The name of the template
	 * @param inputStream
	 * 		The given input stream to read from
	 *
	 * @throws java.io.IOException
	 * 		In case of anything
	 */
	public ImportFile(@NotNull String templateName, @NotNull InputStream inputStream) throws IOException
	{
		super(ComponentTypes.Comment);
		this.templateName = templateName;
		setTag("");
		StringBuilder sb;
		try (InputStreamReader isr = new InputStreamReader(inputStream); BufferedReader br = new BufferedReader(isr))
		{
			sb = new StringBuilder();
			br.lines()
			  .forEach(sb::append);
		}
		inputStream.close();
		FileTemplates.setTemplateScript(templateName, sb);
	}

	/**
	 * Builds up the HTML for this component and all it's children - Does not perform Pre Configure or Pre Render Use GetHTML() to
	 * perform a
	 * pre configure and render
	 * <p>
	 * Executes the following methods in order
	 * <p>
	 * (1)preRenderHTML - removed. Placed into toString()
	 * <p>
	 * (2)renderBeforeTag
	 * <p>
	 * (3)renderAdditionalInnerHTMLBeforeChildren
	 * <p>
	 * (4)renderAttributeHTML
	 * <p>
	 * (5)renderAdditionalInnerHTMLAfterChildren.
	 * <p>
	 * (5)postRenderHTML
	 * <p>
	 *
	 * @param tabCount
	 * 		Indentation depth
	 * 		<p>
	 *
	 * @return The HTML
	 */
	@Override
	@NotNull
	protected StringBuilder renderHTML(int tabCount)
	{
		return FileTemplates.renderTemplateScripts(templateName);
	}

	/**
	 * @return hash-int
	 */
	@Override
	public int hashCode()
	{
		return templateName.hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param o
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ImportFile))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}
		ImportFile<?> that = (ImportFile<?>) o;
		return getTemplateName().equals(that.getTemplateName());
	}

	/**
	 * Returns the template name for this file
	 *
	 * @return The name of this template
	 */
	@SuppressWarnings("WeakerAccess")
	public String getTemplateName()
	{
		return templateName;
	}

	/**
	 * Sets the template name
	 *
	 * @param templateName
	 * 		THe template name to use. Mandatory
	 *
	 * @return Always this
	 */
	@SuppressWarnings("unchecked")
	public J setTemplateName(String templateName)
	{
		this.templateName = templateName;
		return (J) this;
	}
}
