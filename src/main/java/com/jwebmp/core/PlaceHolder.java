package com.jwebmp.core;

import com.jwebmp.core.base.html.DivSimple;

/**
 * A default place holding div usually for component replacement
 *
 * @author Marc Magon
 * @since 10 Apr 2017
 */
public class PlaceHolder<J extends PlaceHolder<J>>
		extends DivSimple<J>
{


	/*
	 * Constructs a new PlaceHolder with the given ID
	 */
	public PlaceHolder(String id)
	{
		setID(id);
	}
}
