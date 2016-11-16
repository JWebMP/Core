package za.co.mmagon.jwebswing.htmlbuilder.javascript.events.interfaces;

import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IFeature;

/**
 * The interface denoting an event type
 * <p>
 * @author Marc Magon
 */
public interface IEvent extends IFeature
{

    /**
     * The method that is fired on call
     *
     * @param call     The component that made the call
     * @param response The Response Object Being Returned
     */
    public void fireEvent(AjaxCall call, AjaxResponse response);
}
