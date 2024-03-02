package com.jwebmp.core.base.page;

import com.guicedee.client.*;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.services.*;


import jakarta.validation.constraints.NotNull;
import java.util.Set;

import static com.jwebmp.core.implementations.JWebMPServicesBindings.*;

/**
 * Inserts the CSS Links into the page
 */
@SuppressWarnings("unused")
public class CSSLinksInsertPageConfigurator
		extends RequirementsPriorityAbstractInsertPageConfigurator<CSSLinksInsertPageConfigurator>
{
	/**
	 * Constructor CSSLinksInsertPageConfigurator creates a new CSSLinksInsertPageConfigurator instance.
	 */
	public CSSLinksInsertPageConfigurator()
	{
		//No config required
	}

	@NotNull
	@Override
	public Page<?> configure(IPage<?> pager)
	{
		Page page = (Page)pager;
		if (!page.isConfigured() && enabled())
		{
			renderBeforeLinks(page);
			for (RequirementsPriority requirementsPriority : RequirementsPriority.values())
			{
				page.getHead()
				    .getChildren()
				    .addAll(getAllCssLinks(page, requirementsPriority));
			}
			for (Object o : page.getHead()
			                    .getChildren())
			{
				ComponentHierarchyBase<?,?,?,?,?> headObject = (ComponentHierarchyBase<?,?,?,?,?>) o;
				headObject.preConfigure();
			}
			renderAfterLinks(page);
		}
		return page;
	}

	private void renderBeforeLinks(Page<?> page)
	{
		Set<RenderBeforeLinks> renderB = IGuiceContext.get(RenderBeforeLinksKey);
		Paragraph<?> before = new Paragraph<>().setTextOnly(true);
		for (RenderBeforeLinks render : renderB)
		{
			before.setText(before.getText(0)
			                     .toString() + render.render(page)
			                                         .toString());
		}
		if (before.getText(0)
		          .toString()
		          .trim()
		          .length() > 0)
		{
			page.getHead()
			    .add(before);
		}
	}

	private void renderAfterLinks(Page<?> page)
	{
		Set<RenderAfterLinks> renderA = IGuiceContext.get(RenderAfterLinksKey);
		Paragraph<?> after = new Paragraph<>().setTextOnly(true);
		for (RenderAfterLinks render : renderA)
		{
			after.setText(after.getText(0)
			                   .toString() + render.render(page)
			                                       .toString());
		}
		if (after.getText(0)
		         .toString()
		         .trim()
		         .length() > 0)
		{
			page.getHead()
			    .add(after);
		}
	}

	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE - 10;
	}
}
