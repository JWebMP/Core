package com.jwebmp;

import com.jwebmp.base.html.DivSimple;

/**
 * A default place holding div usually for component replacement
 *
 * @author Marc Magon
 * @since 10 Apr 2017
 */
public class PlaceHolder<J extends PlaceHolder<J>>
		extends DivSimple<J>
{

	private static final long serialVersionUID = 1L;

	/*
	 * Constructs a new PlaceHolder with the given ID
	 */
	public PlaceHolder(String id)
	{
		setID(id);
	}
}
