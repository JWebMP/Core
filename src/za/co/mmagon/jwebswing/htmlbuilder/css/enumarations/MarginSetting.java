package za.co.mmagon.jwebswing.htmlbuilder.css.enumarations;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * @author MMagon
 * @version 1.0
 * @since 24 Sep 2013
 */
public enum MarginSetting implements CSSEnumeration<MarginSetting>
{
	/**
	 * Sets to auto, use to center items
	 */
	Auto,
	/**
	 * Inherit from parent
	 */
	Inherit,
	/**
	 * None
	 */
	None,

	Unset;

	@Override
	public String getValue()
	{
		return name().toLowerCase();
	}

	@Override
	public MarginSetting getDefault()
	{
		return Unset;
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.margin";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return CSSVersions.CSS3;
	}
}
