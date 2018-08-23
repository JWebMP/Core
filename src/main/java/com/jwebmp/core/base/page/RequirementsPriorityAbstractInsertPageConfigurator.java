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

package com.jwebmp.core.base.page;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.CSSLink;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.generics.WebReference;
import com.jwebmp.core.services.IPageConfigurator;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.jwebmp.core.utilities.StaticStrings.*;

abstract class RequirementsPriorityAbstractInsertPageConfigurator
		implements IPageConfigurator
{

	/**
	 * Adds all the stuff for a given priority
	 *
	 * @param css
	 * 		CSS
	 * @param input
	 * 		the hierarchy to read from
	 * @param priority
	 * 		the priority
	 * @param javascript
	 * 		to return JavaScript or not
	 */
	List<ComponentHierarchyBase<?, ?, ?, ?, ?>> getPriorityRequirements(Page<?> page, RequirementsPriority priority, List<ComponentHierarchyBase<?, ?, ?, ?, ?>> input, boolean css, boolean javascript)
	{
		Set<ComponentHierarchyBase<?, ?, ?, ?, ?>> requirements = new LinkedHashSet<>();
		if (css)
		{
			List<CSSLink<?>> links = getAllCssLinks(page, priority);
			for (CSSLink<?> link : links)
			{
				if (!input.contains(link))
				{
					requirements.add(link);
				}
			}
		}
		if (javascript)
		{
			Set<Script<?, ?>> scripts = getAllScripts(page, priority);
			for (Script script : scripts)
			{
				if (!input.contains(script))
				{
					requirements.add(script);
				}
			}
		}
		return new ArrayList<>(requirements);
	}

	/**
	 * Gets all the links for all the bodies components
	 *
	 * @param priority
	 * 		the priority to return
	 *
	 * @return A list of newwly contructed links
	 */
	@NotNull
	List<CSSLink<?>> getAllCssLinks(Page<?> page, @NotNull RequirementsPriority priority)
	{
		List<CSSReference> allReferences = new ArrayList<>(page.getBody()
		                                                       .getCssReferencesAll(priority));
		allReferences.sort(WebReference.getDummyReference());
		ArrayList<CSSLink<?>> allLinks = new ArrayList<>();

		for (CSSReference reference : allReferences)
		{
			CSSLink<?> link = new CSSLink<>(reference);
			if (reference.getSpecifiedClassName() != null && !reference.getSpecifiedClassName()
			                                                           .isEmpty())
			{
				link.addClass(reference.getSpecifiedClassName());
			}
			if (!reference.getAdditionalOptions()
			              .isEmpty())
			{
				for (String additionalOption : reference.getAdditionalOptions())
				{
					link.addAttribute(additionalOption, STRING_EMPTY);
				}
			}
			if (!allLinks.contains(link))
			{
				allLinks.add(link);
			}
		}
		return allLinks;
	}

	/**
	 * Gets all the scripts for all the body components
	 *
	 * @param priority
	 * 		A set of priorities
	 *
	 * @return A set of newly constructed script objects
	 */
	private Set<Script<?, ?>> getAllScripts(Page<?> page, RequirementsPriority priority)
	{
		List<JavascriptReference> allJavascripts = new ArrayList<>(page.getBody()
		                                                               .getJavascriptReferencesAll(priority));
		allJavascripts.sort(WebReference.getDummyReference());
		Set<Script<?, ?>> allScripts = new LinkedHashSet<>();
		for (JavascriptReference reference : allJavascripts)
		{
			Script script = new Script(reference);
			if (!reference.getAdditionalOptions()
			              .isEmpty())
			{
				for (String additionalOption : reference.getAdditionalOptions())
				{
					script.addAttribute(additionalOption, STRING_EMPTY);
				}
			}
			script.setNewLineForClosingTag(false);
			allScripts.add(script);
		}
		return allScripts;
	}
}
