package com.jwebmp.core.htmlbuilder.css.displays;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.enumarations.CSSEnumeration;

/**
 * The float property specifies whether or not an element should float.
 * <p>
 * The clear property is used to control the behavior of floating elements.
 *
 * @author GedMarc
 */
public enum Floats
		implements CSSEnumeration<Floats>
{
	/**
	 * The element floats to the left
	 */
	Left,
	/**
	 * The element floats to the right
	 */
	Right,
	/**
	 * The element doesn't float
	 */
	None,
	/**
	 * Sets this property to its default value
	 * <p>
	 * see http://www.w3schools.com/cssref/css_initial.asp
	 */
	Initial,
	/**
	 * Inherits this property from its parent element.
	 * <p>
	 * see http://www.w3schools.com/cssref/css_inherit.asp
	 */
	Inherit,
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}

	@Override
	public String getJavascriptSyntax()
	{
		return "style.cssFloat";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getValue()
	{
		return name();
	}

	@Override
	public Floats getDefault()
	{
		return Unset;
	}
}
