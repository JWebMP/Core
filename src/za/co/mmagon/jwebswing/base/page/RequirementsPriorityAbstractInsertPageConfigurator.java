package za.co.mmagon.jwebswing.base.page;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.CSSLink;
import za.co.mmagon.jwebswing.base.html.Script;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.generics.WebReference;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

abstract class RequirementsPriorityAbstractInsertPageConfigurator extends PageConfigurator
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
	protected List<ComponentHierarchyBase> getPriorityRequirements(Page page, RequirementsPriority priority, List<ComponentHierarchyBase> input, boolean css, boolean javascript)
	{
		Set<ComponentHierarchyBase> requirements = new LinkedHashSet<>();
		if (css)
		{
			List<CSSLink> links = getAllCssLinks(page, priority);
			for (CSSLink link : links)
			{
				if (!input.contains(link))
				{
					requirements.add(link);
				}
			}
		}
		if (javascript)
		{
			Set<Script> scripts = getAllScripts(page, priority);
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
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	protected List<CSSLink> getAllCssLinks(Page page, @NotNull RequirementsPriority priority)
	{
		List<CSSReference> allReferences = new ArrayList<>(page.getBody().getCssReferencesAll(priority));
		allReferences.sort(WebReference.getDummyReference());
		ArrayList<CSSLink> allLinks = new ArrayList<>();

		for (CSSReference reference : allReferences)
		{
			CSSLink link = new CSSLink(reference);
			if (reference.getSpecifiedClassName() != null && !reference.getSpecifiedClassName().isEmpty())
			{
				link.addClass(reference.getSpecifiedClassName());
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
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Set<Script> getAllScripts(Page page, RequirementsPriority priority)
	{
		List<JavascriptReference> allJavascripts = new ArrayList<>(page.getBody().getJavascriptReferencesAll(priority));
		allJavascripts.sort(WebReference.getDummyReference());
		Set<Script> allScripts = new LinkedHashSet<>();
		for (JavascriptReference reference : allJavascripts)
		{
			Script script = new Script(reference);
			script.setNewLineForClosingTag(false);
			allScripts.add(script);
		}
		return allScripts;
	}
}
