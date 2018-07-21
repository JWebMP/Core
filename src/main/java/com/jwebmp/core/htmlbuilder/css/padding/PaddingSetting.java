package com.jwebmp.core.htmlbuilder.css.padding;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;

/**
 * @author MMagon
 * @version 1.0
 * @since 24 Sep 2013
 */
public enum PaddingSetting
		implements CSSEnumeration<PaddingSetting>
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
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String getJavascriptSyntax()
	{
		return "style.padding";
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
	public PaddingSetting getDefault()
	{
		return Unset;
	}

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}

}
