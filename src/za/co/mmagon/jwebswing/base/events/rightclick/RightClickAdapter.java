package za.co.mmagon.jwebswing.base.events.rightclick;

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.components.jqueryui.button.JQUIButtonEvents;
import za.co.mmagon.jwebswing.components.jqxwidgets.radiobutton.JQXRadioButtonEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles all on right click events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class RightClickAdapter extends Event implements ParagraphEvents, BodyEvents, GlobalEvents, JQUIButtonEvents, JQXRadioButtonEvents
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("RightClickEvent");
    private static final long serialVersionUID = 1L;
    private RightClickDirective rightClickDirective;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public RightClickAdapter(Component component)
    {
        super(EventTypes.contextmenu, component);

    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getComponent().getPage().getOptions().setjQueryEnabled(true);
            getComponent().getPage().getOptions().setAngularEnabled(true);
            getComponent().getAngularDirectives().add(getDirective());
            component.addAttribute(AngularAttributes.ngRightClick, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Returns the angular directive associated with the right click event
     *
     * @return
     */
    public RightClickDirective getDirective()
    {
        if (rightClickDirective == null)
        {
            rightClickDirective = new RightClickDirective(getComponent().getPage().getAngular());
        }
        return rightClickDirective;
    }

    /**
     * Sets the right click angular event
     *
     * @param rightClickDirective
     */
    public void setDirective(RightClickDirective rightClickDirective)
    {
        this.rightClickDirective = rightClickDirective;
    }

    /**
     * Triggers on Click
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onRightClick(AjaxCall call, AjaxResponse response);

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onRightClick(call, response);
        }
        catch (Exception e)
        {
            log.log(Level.SEVERE,"Error In Firing Event", e);
        }
    }

}
