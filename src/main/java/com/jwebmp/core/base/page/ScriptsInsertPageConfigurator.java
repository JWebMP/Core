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

package com.jwebmp.core.base.page;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.services.RenderAfterScripts;
import com.jwebmp.core.services.RenderBeforeScripts;
import com.guicedee.guicedinjection.GuiceContext;

import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.jwebmp.core.services.JWebMPServicesBindings.*;

public class ScriptsInsertPageConfigurator
		extends RequirementsPriorityAbstractInsertPageConfigurator<ScriptsInsertPageConfigurator>
{
	public ScriptsInsertPageConfigurator()
	{
		//No config required
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	public Page<?> configure(Page<?> page)
	{
		if (!page.isConfigured() && enabled())
		{
			ComponentHierarchyBase addable;
			if (page.getOptions()
			        .isScriptsInHead())
			{
				addable = page.getHead();
			}
			else
			{
				addable = page.getBody();
			}

			getScripts(page, addable);
			for (Object o : page.getHead()
			                    .getChildren())
			{
				ComponentHierarchyBase headObject = (ComponentHierarchyBase) o;
				headObject.preConfigure();
			}
		}
		return page;
	}

	private void getScripts(Page page, ComponentHierarchyBase scriptAddTo)
	{
		renderBeforeScripts(scriptAddTo);
		addScriptsTo(page, scriptAddTo);
		renderAfterScripts(scriptAddTo);
	}

	@SuppressWarnings("unchecked")
	private void renderBeforeScripts(ComponentHierarchyBase scriptAddTo)
	{
		Set<RenderBeforeScripts> renderB = GuiceContext.get(RenderBeforeScriptsKey);
		Paragraph before = new Paragraph().setTextOnly(true);
		renderB.forEach(render -> before.setText(before.getText(0)
		                                               .toString() + render.render(scriptAddTo.getPage())
		                                                                   .toString()));
		if (before.getText(0)
		          .toString()
		          .trim()
		          .length() > 0)
		{
			scriptAddTo.add(before);
		}
	}

	/**
	 * Adds scripts to a component, ordered by priority and sort order.
	 * <p>
	 * Does not do top shelf
	 *
	 * @param component
	 * 		The component to add scripts to
	 */
	@SuppressWarnings("unchecked")
	private void addScriptsTo(Page<?> page, ComponentHierarchyBase component)
	{
		List<ComponentHierarchyBase<?, ?, ?, ?, ?>> requirements = new CopyOnWriteArrayList<>();

		List<RequirementsPriority> arrs = new ArrayList<>(Arrays.asList(RequirementsPriority.values()));
		for (RequirementsPriority priority : arrs)
		{
			if (priority.equals(RequirementsPriority.Top_Shelf))
			{
				continue;
			}
			List<ComponentHierarchyBase<?, ?, ?, ?, ?>> alls = getPriorityRequirements(page, priority, requirements, false, true);
			alls.forEach(component::add);
		}
	}

	@SuppressWarnings("unchecked")
	private void renderAfterScripts(ComponentHierarchyBase scriptAddTo)
	{
		Set<RenderAfterScripts> renderA = GuiceContext.get(RenderAfterScriptsKey);
		Paragraph after = new Paragraph().setTextOnly(true);
		for (RenderAfterScripts render : renderA)
		{
			after.setText(after.getText(0)
			                   .toString() + render.render(scriptAddTo.getPage())
			                                       .toString());
		}
		if (after.getText(0)
		         .toString()
		         .trim()
		         .length() > 0)
		{
			scriptAddTo.add(after);
		}
	}

	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE - 8;
	}
}
