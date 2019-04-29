package com.jwebmp.core.enumerations;

public enum AppleMobileStatusBarStyles
{
	Default,
	Black,
	Black_Translucent,

	;

	@Override
	public String toString()
	{
		return super.toString()
		            .toLowerCase()
		            .replace('_', '-');
	}
}
