package za.co.mmagon.jwebswing.base.events.beforeclose;

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class BeforeCloseAdapter extends Event
        implements GlobalEvents
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("BeforeCloseEvent");
    private static final long serialVersionUID = 1L;
    private BeforeCloseDirective directive;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public BeforeCloseAdapter(Component component)
    {
        super(EventTypes.beforeClose, component);

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
            getComponent().getAngularDirectives().add(getDirective());
            component.addAttribute(AngularAttributes.ngBeforeClose, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Returns the angular directive associated with the right click event
     *
     * @return
     */
    public BeforeCloseDirective getDirective()
    {
        if (directive == null)
        {
            directive = new BeforeCloseDirective(getComponent().getPage().getAngular());
        }
        return directive;
    }

    /**
     * Sets the right click angular event
     *
     * @param directive
     */
    public void setDirective(BeforeCloseDirective directive)
    {
        this.directive = directive;
    }

    /**
     * Triggers on Click
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onBeforeClose(AjaxCall call, AjaxResponse response);

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onBeforeClose(call, response);
        }
        catch (Exception e)
        {
            LOG.log(Level.SEVERE,"Error In Firing Event", e);
        }
    }

}
