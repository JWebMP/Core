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

package com.jwebmp.base.page;

import com.jwebmp.Page;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.Comment;
import com.jwebmp.base.servlets.enumarations.RequirementsPriority;

import java.util.ArrayList;
import java.util.List;

class TopShelfScriptsInsertPageConfigurator
		extends RequirementsPriorityAbstractInsertPageConfigurator
{
	public TopShelfScriptsInsertPageConfigurator()
	{
		setSortOrder(Integer.MAX_VALUE - 9);
	}

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
