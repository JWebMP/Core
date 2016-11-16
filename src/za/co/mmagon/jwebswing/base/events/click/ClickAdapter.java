package za.co.mmagon.jwebswing.base.events.click;

import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.events.BodyEvents;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.html.interfaces.events.ParagraphEvents;
import za.co.mmagon.jwebswing.components.jqueryUI.button.JQUIButtonEvents;
import za.co.mmagon.jwebswing.components.jqxWidgets.buttongroup.JQXButtonGroupEvents;
import za.co.mmagon.jwebswing.components.jqxWidgets.buttons.JQXButtonEvents;
import za.co.mmagon.jwebswing.components.jqxWidgets.radiobutton.JQXRadioButtonEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * Handles all click events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class ClickAdapter extends Event
        implements ParagraphEvents, BodyEvents, GlobalEvents, JQUIButtonEvents, JQXRadioButtonEvents,
                   JQXButtonEvents,JQXButtonGroupEvents
{

    /**
     * Logger for the Component
     */
    private static final org.apache.log4j.Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("ClickEvent");
    private static final long serialVersionUID = 1L;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public ClickAdapter(ComponentHierarchyBase component)
    {
        super(EventTypes.click, component);
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getComponent().getPage().setjQueryEnabled(true);
            getComponent().getPage().setAngularEnabled(true);
            getComponent().addAttribute(AngularAttributes.ngClick, "perform($event," + renderVariables() + ");");
            getComponent().addAttribute(GlobalAttributes.Style, "cursor:pointer;");
        }
        super.preConfigure();
    }

    /**
     * Triggers on Click
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onClick(AjaxCall call, AjaxResponse response);

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onClick(call, response);
        }
        catch (Exception e)
        {
            log.error("Error In Firing Event", e);
        }
    }

}
