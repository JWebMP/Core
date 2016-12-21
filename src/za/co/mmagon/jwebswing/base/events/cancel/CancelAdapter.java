package za.co.mmagon.jwebswing.base.events.cancel;

import za.co.mmagon.logger.LogFactory;
import java.util.logging.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.ajax.*;
import za.co.mmagon.jwebswing.base.angular.*;
import za.co.mmagon.jwebswing.base.events.anewevents.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.*;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class CancelAdapter extends Event
        implements GlobalEvents
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("CancelEvent");
    private static final long serialVersionUID = 1L;
    private EventDirective directive;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public CancelAdapter(Component component)
    {
        super(EventTypes.cancel, component);

    }

    /**
     * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getComponent().getPage().getOptions().setjQueryEnabled(true);
            getComponent().getPage().getOptions().setAngularEnabled(true);
            getComponent().getPage().getAngular().addDirective(getDirective());
            component.addAttribute(AngularAttributes.ngCancel, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Returns the angular directive associated with the right click event
     *
     * @return
     */
    public EventDirective getDirective()
    {
        if (directive == null)
        {
            directive = new EventDirective(getComponent().getPage().getAngular());
        }
        return directive;
    }

    /**
     * Sets the right click angular event
     *
     * @param directive
     */
    public void setDirective(EventDirective directive)
    {
        this.directive = directive;
    }

    /**
     * Triggers on Cancel
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onCancel(AjaxCall call, AjaxResponse response);

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onCancel(call, response);
        }
        catch (Exception e)
        {
            LOG.log(Level.SEVERE,"Error In Firing Event", e);
        }
    }

}
