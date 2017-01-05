package za.co.mmagon.jwebswing.events.unselected;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.components.jqueryui.selectable.JQUISelectableEvents;
import za.co.mmagon.jwebswing.components.jqxwidgets.buttongroup.JQXButtonGroupEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * This event is triggered when a button is unselected - in checkbox or radio buttons mode. 
 *
 * @author Marc Magon
 */
public abstract class UnSelectedEvent extends Event 
        implements JQUISelectableEvents,JQXButtonGroupEvents
{

    private static final long serialVersionUID = 1L;

    /**
     * This event is triggered when a button is unselected - in checkbox or radio buttons mode. 
     *
     * @param component The component this click is going to be acting on
     */
    public UnSelectedEvent(Component component)
    {
        super(EventTypes.unselected, component);
    }

    /**
     * Triggers on Activation
     * <p>
     * @param ajaxObject   The physical AJAX call
     * @param ajaxReceiver The physical Ajax Receiver
     */
    public abstract void onUnSelected(AjaxCall ajaxObject, AjaxResponse ajaxReceiver);

    /**
     * The method that is fired on call
     *
     * @param ajaxObject   The component that made the call
     * @param ajaxReceiver The Response Object Being Returned
     */
    @Override
    public void fireEvent(AjaxCall ajaxObject, AjaxResponse ajaxReceiver)
    {
        onUnSelected(ajaxObject, ajaxReceiver);
    }

}
