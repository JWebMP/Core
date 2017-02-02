package za.co.mmagon.jwebswing.events.click;

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.components.bootstrap.buttons.BSButtonEvents;
import za.co.mmagon.jwebswing.components.jqueryui.button.JQUIButtonEvents;
import za.co.mmagon.jwebswing.components.jqxwidgets.buttongroup.JQXButtonGroupEvents;
import za.co.mmagon.jwebswing.components.jqxwidgets.buttons.JQXButtonEvents;
import za.co.mmagon.jwebswing.components.jqxwidgets.radiobutton.JQXRadioButtonEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles all click events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class ClickAdapter extends Event<JavaScriptPart, ClickAdapter>
        implements ParagraphEvents, BodyEvents, GlobalEvents, JQUIButtonEvents, JQXRadioButtonEvents,
        JQXButtonEvents, JQXButtonGroupEvents, BSButtonEvents
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("ClickEvent");
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
            getComponent().getPage().getOptions().setjQueryEnabled(true);
            getComponent().getPage().getOptions().setAngularEnabled(true);
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
            log.log(Level.SEVERE, "Error In Firing Event", e);
        }
    }

}
