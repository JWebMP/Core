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
package za.co.mmagon.jwebswing.events.sort;

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
public abstract class SortAdapter extends Event
        implements GlobalEvents
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("SortEvent");
    private static final long serialVersionUID = 1L;
    private SortDirective directive;

    /**
     * Performs a click
     *
     * @param component The component this click is going to be acting on
     */
    public SortAdapter(Component component)
    {
        super(EventTypes.sort, component);

    }

    /**
     * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            
            getComponent().getPage().getAngular().getAngularDirectives().add(getDirective());
            component.addAttribute(AngularAttributes.ngSort, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Returns the angular directive associated with the right click event
     *
     * @return
     */
    public SortDirective getDirective()
    {
        if (directive == null)
        {
            directive = new SortDirective();
        }
        return directive;
    }

    /**
     * Sets the right click angular event
     *
     * @param directive
     */
    public void setDirective(SortDirective directive)
    {
        this.directive = directive;
    }

    /**
     * Triggers on Click
     * <p>
     * @param call     The physical AJAX call
     * @param response The physical Ajax Receiver
     */
    public abstract void onSort(AjaxCall call, AjaxResponse response);

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        try
        {
            onSort(call, response);
        }
        catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Error In Firing Event", e);
        }
    }

}
