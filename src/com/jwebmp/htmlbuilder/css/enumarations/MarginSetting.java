package com.jwebmp.htmlbuilder.css.enumarations;

import com.jwebmp.base.client.CSSVersions;
import com.jwebmp.htmlbuilder.css.CSSEnumeration;

/**
 * @author MMagon
 * @version 1.0
 * @since 24 Sep 2013
 */
public enum MarginSetting
		implements CSSEnumeration<MarginSetting>
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
	public String getJavascriptSyntax()
	{
		return "style.margin";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return CSSVersions.CSS3;
	}

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
}
