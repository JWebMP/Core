package za.co.mmagon.jwebswing.base.events.close;

import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class CloseAdapter extends Event 
        implements GlobalEvents
{

    /**
     * Logger for the Component
     */
    private static final org.apache.log4j.Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("CloseEvent");
    private static final long serialVersionUID = 1L;
    private CloseDirective directive;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public CloseAdapter(Component component)
    {
        super(EventTypes.contextmenu, component);

    }

    /**
     * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getComponent().getPage().setjQueryEnabled(true);
            getComponent().getPage().setAngularEnabled(true);
            getComponent().getPage().getAngular().addDirective(getDirective());
            component.addAttribute(AngularAttributes.ngClose, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Returns the angular directive associated with the right click event
     *
     * @return
     */
    public CloseDirective getDirective()
    {
        if (directive == null)
        {
            directive = new CloseDirective(getComponent().getPage().getAngular());
        }
        return directive;
    }

    /**
     * Sets the right click angular event
     *
     * @param directive
     */
    public void setDirective(CloseDirective directive)
    {
        this.directive = directive;
    }

    /**
     * Triggers on Click
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onClose(AjaxCall call, AjaxResponse response);

    
    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onClose(call, response);
        }
        catch (Exception e)
        {
            LOG.error("Error In Firing Event", e);
        }
    }

}
