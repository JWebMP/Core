package com.jwebmp.core.htmlbuilder.css.colours;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.base.client.CSSVersions;
import com.guicedee.guicedinjection.json.StaticStrings;

import java.io.Serializable;

/**
 * @author GedMarc
 */
public class ColourHex
		implements CssColour<ColourHex>, Serializable
{


	private String thisHex;

	public ColourHex(String thisHex)
	{
		if (thisHex.startsWith(StaticStrings.STRING_HASH))
		{
			this.thisHex = thisHex;
		}
		else
		{
			this.thisHex = StaticStrings.STRING_HASH + thisHex;
		}
	}

	public ColourHex(ColourNames colourName)
	{
		thisHex = colourName.toString();
	}

	@Override
	public String getJavascriptSyntax()
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getValue()
	{
		return thisHex;
	}

	@Override
	public ColourHex getDefault()
	{
		return new ColourHex("#ffffff");
	}

	public void setThisHex(String thisHex)
	{
		this.thisHex = thisHex;
	}

	@JsonValue(true)
	@Override
	public String toString()
	{
		return thisHex;
	}
}
