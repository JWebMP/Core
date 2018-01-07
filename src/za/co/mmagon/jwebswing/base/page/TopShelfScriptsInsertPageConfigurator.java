package za.co.mmagon.jwebswing.base.page;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Comment;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

import java.util.ArrayList;
import java.util.List;

class TopShelfScriptsInsertPageConfigurator extends RequirementsPriorityAbstractInsertPageConfigurator
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
			List<ComponentHierarchyBase> reqs = getPriorityRequirements(page, RequirementsPriority.Top_Shelf, new ArrayList<>(),
			                                                            true, true);
			if (!reqs.isEmpty())
			{
				page.getHead().add(new Comment("Priority [" + RequirementsPriority.Top_Shelf + "] Values"));
			}
			page.getHead().getChildren().addAll(reqs);
		}
		return page;
	}
}
