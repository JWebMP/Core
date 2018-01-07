package za.co.mmagon.jwebswing.base.page;

import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.interfaces.RenderAfterLinks;
import za.co.mmagon.jwebswing.interfaces.RenderBeforeLinks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

class CSSLinksInsertPageConfigurator extends RequirementsPriorityAbstractInsertPageConfigurator
{
	public CSSLinksInsertPageConfigurator()
	{
		setSortOrder(Integer.MAX_VALUE - 10);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page<?> configure(Page<?> page)
	{
		if (!page.isConfigured())
		{
			renderBeforeLinks(page);
			for (RequirementsPriority requirementsPriority : RequirementsPriority.values())
			{
				page.getHead().getChildren().addAll(getAllCssLinks(page, requirementsPriority));
			}
			for (Object o : page.getHead().getChildren())
			{
				ComponentHierarchyBase headObject = (ComponentHierarchyBase) o;
				headObject.preConfigure();
			}
			renderAfterLinks(page);
		}
		return page;
	}

	private void renderBeforeLinks(Page page)
	{
		Set<Class<? extends RenderBeforeLinks>> renderBeforeScripts = GuiceContext.reflect().getSubTypesOf(RenderBeforeLinks.class);
		List<RenderBeforeLinks> renderB = new ArrayList<>();
		for (Class<? extends RenderBeforeLinks> renderBeforeScript : renderBeforeScripts)
		{
			RenderBeforeLinks s = GuiceContext.getInstance(renderBeforeScript);
			renderB.add(s);
		}
		renderB.sort(Comparator.comparingInt(RenderBeforeLinks::sortOrder));
		Paragraph before = new Paragraph().setTextOnly(true);
		for (RenderBeforeLinks render : renderB)
		{
			before.setText(before.getText(0).toString() + render.render().toString());
		}
		if (before.getText(0).toString().trim().length() > 0)
		{
			page.getHead().add(before);
		}
	}

	private void renderAfterLinks(Page page)
	{
		//After
		Set<Class<? extends RenderAfterLinks>> renderAfterLinks = GuiceContext.reflect().getSubTypesOf(RenderAfterLinks.class);
		List<RenderAfterLinks> renderA = new ArrayList<>();
		for (Class<? extends RenderAfterLinks> renderBeforeScript : renderAfterLinks)
		{
			RenderAfterLinks s = GuiceContext.getInstance(renderBeforeScript);
			renderA.add(s);
		}
		renderA.sort(Comparator.comparingInt(RenderAfterLinks::sortOrder));
		Paragraph after = new Paragraph().setTextOnly(true);
		for (RenderAfterLinks render : renderA)
		{
			after.setText(after.getText(0).toString() + render.render().toString());
		}
		if (after.getText(0).toString().trim().length() > 0)
		{
			page.getHead().add(after);
		}
	}
}
