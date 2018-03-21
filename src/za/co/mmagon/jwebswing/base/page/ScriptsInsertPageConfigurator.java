package za.co.mmagon.jwebswing.base.page;

import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.interfaces.RenderAfterScripts;
import za.co.mmagon.jwebswing.interfaces.RenderBeforeDynamicScripts;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class ScriptsInsertPageConfigurator
		extends RequirementsPriorityAbstractInsertPageConfigurator
{
	public ScriptsInsertPageConfigurator()
	{
		setSortOrder(Integer.MAX_VALUE - 8);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page<?> configure(Page<?> page)
	{
		if (!page.isConfigured())
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

	private void renderBeforeScripts(ComponentHierarchyBase scriptAddTo)
	{
		//script rendering in body
		Set<Class<? extends RenderBeforeDynamicScripts>> renderBeforeScripts = GuiceContext.reflect()
		                                                                                   .getSubTypesOf(RenderBeforeDynamicScripts.class);
		List<RenderBeforeDynamicScripts> renderB = new ArrayList<>();
		for (Class<? extends RenderBeforeDynamicScripts> renderBeforeScript : renderBeforeScripts)
		{
			RenderBeforeDynamicScripts s = GuiceContext.getInstance(renderBeforeScript);
			renderB.add(s);
		}

		renderB.sort(Comparator.comparingInt(RenderBeforeDynamicScripts::sortOrder));
		Paragraph before = new Paragraph().setTextOnly(true);
		renderB.forEach(render -> before.setText(before.getText(0)
		                                               .toString() + render.render()
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

	private void renderAfterScripts(ComponentHierarchyBase scriptAddTo)
	{
		Set<Class<? extends RenderAfterScripts>> renderAfterScripts = GuiceContext.reflect()
		                                                                          .getSubTypesOf(RenderAfterScripts.class);
		List<RenderAfterScripts> renderA = new ArrayList<>();
		for (Class<? extends RenderAfterScripts> renderBeforeScript : renderAfterScripts)
		{
			RenderAfterScripts s = GuiceContext.getInstance(renderBeforeScript);
			renderA.add(s);
		}
		renderA.sort(Comparator.comparingInt(RenderAfterScripts::sortOrder));
		Paragraph after = new Paragraph().setTextOnly(true);
		for (RenderAfterScripts render : renderA)
		{
			after.setText(after.getText(0)
			                   .toString() + render.render()
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
}
