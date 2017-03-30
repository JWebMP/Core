/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.events.click;

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles all click events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class ClickAdapter extends Event<JavaScriptPart, ClickAdapter>
        implements ParagraphEvents, BodyEvents, GlobalEvents
{

    /**
     * Logger for the Component
     */
    @ComponentInformation(name = "Click Event", description = "Server Side Event for Click.",
            url = "https://www.armineasy.com/JWebSwing", wikiUrl = "https://github.com/GedMarc/JWebSwing/wiki")
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

            getComponent().addAttribute(AngularAttributes.ngClick, "jw.isLoading || perform($event," + renderVariables() + ");");
            if (getComponent().getAttribute(AngularAttributes.ngDisabled) == null)
            {
                getComponent().addAttribute(AngularAttributes.ngDisabled, "jw.isLoading");
            }
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
