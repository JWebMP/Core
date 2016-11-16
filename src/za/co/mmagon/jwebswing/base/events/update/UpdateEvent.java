package za.co.mmagon.jwebswing.base.events.update;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.components.jqueryUI.sortable.JQUISortableEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * Handles all on update events. Override methods.
 *
 * @author Marc Magon
 */
public abstract class UpdateEvent extends Event implements JQUISortableEvents
{

    private static final long serialVersionUID = 1L;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public UpdateEvent(Component component)
    {
        super(EventTypes.update, component);
    }

    /**
     * Triggers on Update
     * <p>
     * @param ajaxObject   The physical AJAX call
     * @param ajaxReceiver The physical Ajax Receiver
     */
    public abstract void onUpdate(AjaxCall ajaxObject, AjaxResponse ajaxReceiver);

    /**
     * The method that is fired on call
     *
     * @param ajaxObject   The component that made the call
     * @param ajaxReceiver The Response Object Being Returned
     */
    @Override
    public void fireEvent(AjaxCall ajaxObject, AjaxResponse ajaxReceiver)
    {
        onUpdate(ajaxObject, ajaxReceiver);
    }

}
