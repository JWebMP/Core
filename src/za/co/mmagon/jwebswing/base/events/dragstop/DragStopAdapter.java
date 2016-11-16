package za.co.mmagon.jwebswing.base.events.dragstop;

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
public abstract class DragStopAdapter extends Event 
        implements GlobalEvents
{

    /**
     * Logger for the Component
     */
    private static final org.apache.log4j.Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("DragStopEvent");
    private static final long serialVersionUID = 1L;
    private DragStopDirective directive;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public DragStopAdapter(Component component)
    {
        super(EventTypes.dragStop, component);

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
            component.addAttribute(AngularAttributes.ngDragStop, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Returns the angular directive associated with the right click event
     *
     * @return
     */
    public DragStopDirective getDirective()
    {
        if (directive == null)
        {
            directive = new DragStopDirective(getComponent().getPage().getAngular());
        }
        return directive;
    }

    /**
     * Sets the right click angular event
     *
     * @param directive
     */
    public void setDirective(DragStopDirective directive)
    {
        this.directive = directive;
    }

    /**
     * Triggers on Drag Stop
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onDragStop(AjaxCall call, AjaxResponse response);

    
    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onDragStop(call, response);
        }
        catch (Exception e)
        {
            LOG.error("Error In Firing Event", e);
        }
    }

}
