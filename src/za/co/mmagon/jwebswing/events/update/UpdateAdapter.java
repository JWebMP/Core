package za.co.mmagon.jwebswing.events.update;

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.components.jqueryui.draggable.JQUIDraggableEvents;
import za.co.mmagon.jwebswing.components.jqueryui.resizable.JQUIResizableEvents;
import za.co.mmagon.jwebswing.components.jqueryui.selectable.JQUISelectableEvents;
import za.co.mmagon.jwebswing.components.jqueryui.slider.JQUISliderEvents;
import za.co.mmagon.jwebswing.components.jqueryui.sortable.JQUISortableEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class UpdateAdapter extends Event
        implements GlobalEvents, JQUIDraggableEvents, JQUIResizableEvents, JQUISelectableEvents, JQUISliderEvents, JQUISortableEvents
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("StopEvent");
    private static final long serialVersionUID = 1L;
    private UpdateDirective directive;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public UpdateAdapter(Component component)
    {
        super(EventTypes.update, component);

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
            component.addAttribute(AngularAttributes.ngStop, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Returns the angular directive associated with the right click event
     *
     * @return
     */
    public UpdateDirective getDirective()
    {
        if (directive == null)
        {
            directive = new UpdateDirective(getComponent().getPage().getAngular());
        }
        return directive;
    }

    /**
     * Sets the right click angular event
     *
     * @param directive
     */
    public void setDirective(UpdateDirective directive)
    {
        this.directive = directive;
    }

    /**
     * Triggers on Click
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onStop(AjaxCall call, AjaxResponse response);

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onStop(call, response);
        }
        catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Error In Firing Event", e);
        }
    }

}
