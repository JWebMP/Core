package za.co.mmagon.jwebswing.base.servlets.interfaces;

import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.interfaces.IEvent;

/**
 * The base of each component
 *
 * @author Marc Magon
 * @param <T> The types allowed to be added to this component. Must extend IComponent
 * @param <A> The types allowed to be attributes, must be enumerated
 * @param <J> The types of java class to allow, must extends IJavascriptComponent
 * @param <I> The actual implementing class. Used for cloning
 */
public interface IComponent<T, A extends Enum, J extends GlobalFeatures, I extends IEvent>
{

}
