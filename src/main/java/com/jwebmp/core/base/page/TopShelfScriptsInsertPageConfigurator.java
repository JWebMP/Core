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
import com.jwebmp.core.base.html.Comment;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TopShelfScriptsInsertPageConfigurator
		extends RequirementsPriorityAbstractInsertPageConfigurator
{
	public TopShelfScriptsInsertPageConfigurator()
	{
		//No config required
	}

	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE - 9;
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	public Page<?> configure(Page<?> page)
	{
		if (!page.isConfigured())
		{
			List<ComponentHierarchyBase<?, ?, ?, ?, ?>> reqs = getPriorityRequirements(page, RequirementsPriority.Top_Shelf, new ArrayList<>(), true, true);
			if (!reqs.isEmpty())
			{
				page.getHead()
				    .add(new Comment("Priority [" + RequirementsPriority.Top_Shelf + "] Values"));
			}
			page.getHead()
			    .getChildren()
			    .addAll(reqs);
		}
		return page;
	}
}
