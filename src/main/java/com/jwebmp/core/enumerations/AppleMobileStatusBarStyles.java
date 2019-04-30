package com.jwebmp.core.enumerations;

public enum AppleMobileStatusBarStyles
{
	Default,
	Black,
	Black_Translucent,
	Blue_Translucent,
	Blue,

	;

	@Override
	public String toString()
	{
		return super.toString()
		            .toLowerCase()
		            .replace('_', '-');
	}
}
