/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryui.selectable;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.interfaces.CssClass;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since Mar 17, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUISelectableOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * Which element the selectable helper should be appended to while dragging.
     */
    private String appendTo;
    /**
     * This determines whether to refresh (recalculate) the position and size of each selectee at the beginning of each select operation. If you have many items, you may want to set this to false and
     * call the refresh() method manually. Default is true
     */
    private Boolean autoRefresh = true;
    /**
     * Prevents selecting if you start on elements matching the selector
     */
    private final ArrayList<CssClass> cancel = new ArrayList<>();
    /**
     * Time in milliseconds to define when the selecting should start. This helps prevent unwanted selections when clicking on an element.
     */
    private Integer delay;
    /**
     * Tolerance, in pixels, for when selecting should start. If specified, selecting will not start until the mouse has been dragged beyond the specified distance.
     */
    private Integer distance;
    /**
     * The matching child elements will be made selectees (able to be selected).
     */
    private final ArrayList<ComponentTypes> filter = new ArrayList<>();

    /**
     *
     */
    public JQUISelectableOptions()
    {

    }

    /**
     * Which element the selectable helper should be appended to while dragging.
     *
     * @return The component that the selectable helper should be appended to while dragging.
     */
    public String getAppendTo()
    {
        return appendTo;
    }

    /**
     * Which element the selectable helper should be appended to while dragging.
     *
     * @param appendTo Which element the selectable helper should be appended to while dragging.
     */
    public void setAppendTo(Component appendTo)
    {
        this.appendTo = appendTo.getID(true);
    }

    /**
     *
     * This determines whether to refresh (recalculate) the position and size of each selectee at the beginning of each select operation. If you have many items, you may want to set this to false and
     * call the refresh() method manually. Default is true
     *
     * @return Is Auto Refresh
     */
    public Boolean isAutoRefresh()
    {
        return autoRefresh;
    }

    /**
     * This determines whether to refresh (recalculate) the position and size of each selectee at the beginning of each select operation. If you have many items, you may want to set this to false and
     * call the refresh() method manually.
     *
     * @param autoRefresh Whether to refresh on call
     */
    public void setAutoRefresh(Boolean autoRefresh)
    {
        this.autoRefresh = autoRefresh;
    }

    /**
     * Prevents selecting if you start on elements matching the selector
     *
     * @return The list of CssClasses that don't start on the selector
     */
    public ArrayList<CssClass> getCancel()
    {
        return cancel;
    }

    /**
     * Time in milliseconds to define when the selecting should start. This helps prevent unwanted selections when clicking on an element.
     *
     * @return The Delay
     */
    public Integer getDelay()
    {
        return delay;
    }

    /**
     * Time in milliseconds to define when the selecting should start. This helps prevent unwanted selections when clicking on an element.
     *
     * @param delay The delay to set
     */
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }

    /**
     * Tolerance, in pixels, for when selecting should start. If specified, selecting will not start until the mouse has been dragged beyond the specified distance.
     *
     * @return The distance in pixels
     */
    public Integer getDistance()
    {
        return distance;
    }

    /**
     * Tolerance, in pixels, for when selecting should start. If specified, selecting will not start until the mouse has been dragged beyond the specified distance.
     *
     * @param distance Sets the distance in pixels
     */
    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
