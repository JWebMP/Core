package za.co.mmagon.jwebswing.htmlbuilder.javascript.events.commandEvent;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * This class enables a JQuery call to execute a java function directly after it
 * is rendered
 * <p>
 * @since 2012-12-30
 * @author MMagon
 */
public abstract class PerformCommandEvent extends Event<JavaScriptPart, Event>
{

    public PerformCommandEvent(Component component)
    {
        super(EventTypes.performCommand, component);
    }

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        perform(call, response);
    }

    /**
     * Executes the JavaScript lines of code directly after the component is executed
     *
     * @param call
     * @param response
     */
    public abstract void perform(AjaxCall call, AjaxResponse response);
}
