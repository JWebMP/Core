package com.jwebmp.core.base.vue;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * This feature adds Vue as the preferred provider
 * @param <J>
 */
public class VueFeature<J extends VueFeature<J>>
		extends Feature<VueFeature, JavaScriptPart,J>
{

	public VueFeature(ComponentHierarchyBase component)
	{
		super("VueFeature", component);


	}

	@Override
	protected void assignFunctionsToComponent()
	{

	}


	/**
	 * Renders the JavaScript for this Builder
	 *
	 * @return An empty string builder
	 *
	 * @see com.jwebmp.core.base.ComponentFeatureBase#renderJavascript()
	 */
	@NotNull
	@Override
	public StringBuilder renderJavascript()
	{
		return new StringBuilder();
	}


}
