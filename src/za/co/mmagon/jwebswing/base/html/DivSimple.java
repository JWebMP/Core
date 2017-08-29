package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * A basic div with the typed mostly taken care of
 * @param <J> This type
 */
public class DivSimple<J> extends Div<GlobalChildren,NoAttributes,GlobalFeatures,GlobalEvents,DivSimple<J>>
{
	/**
	 * Constructs a new simple div
	 */
	public DivSimple()
	{
	}

	/**
	 * Constructs a new simple div
	 * @param myComponent
	 */
	public DivSimple(ComponentTypes myComponent)
	{
		super(myComponent);
	}

	/**
	 * Constructs a new simple div with the given text
	 * @param text Raw text to apply
	 */
	public DivSimple(String text)
	{
		super(text);
	}
}
