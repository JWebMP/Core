package com.jwebmp.generics;

public enum HorizontalOrVertical
{
	Horizontal,
	Vertical;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
