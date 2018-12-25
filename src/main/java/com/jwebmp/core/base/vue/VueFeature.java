package com.jwebmp.core.base.vue;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

/**
 * This feature adds Vue as the preferred provider
 *
 * @param <J>
 */
public class VueFeature<J extends VueFeature<J>>
		extends Feature<VueFeature, JavaScriptPart, J>
{

	/**
	 * The name of this vue application
	 */
	private static String appName = "appDomId";

	public VueFeature(ComponentHierarchyBase component)
	{
		super("VueFeature", component);


	}

	/**
	 * Method getAppName returns the appName of this VueFeature object.
	 * <p>
	 * The name of this vue application
	 *
	 * @return the appName (type String) of this VueFeature object.
	 */
	public static String getAppName()
	{
		return appName;
	}

	/**
	 * Method setAppName sets the appName of this VueFeature object.
	 * <p>
	 * The name of this vue application
	 *
	 * @param appName
	 * 		the appName of this VueFeature object.
	 */
	public static void setAppName(String appName)
	{
		VueFeature.appName = appName;
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
