package za.co.mmagon.jwebswing;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * A default place holding div usually for component replacement
 *
 * @author Marc Magon
 * @since 10 Apr 2017
 */
public class PlaceHolder extends Div
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
