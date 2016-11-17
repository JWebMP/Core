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
package za.co.mmagon.jwebswing.components.jqueryui.accordion;

import za.co.mmagon.jwebswing.base.html.attributes.HeaderTypes;
import za.co.mmagon.jwebswing.htmlbuilder.effects.JWAnimationEffectsPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.mouseevents.MouseEventType;

/**
 * Specifies all the accordion tabs
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUIAccordionOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * Which panel index is currently open.
     */
    private Integer active;
    /**
     * The animation to be used
     */
    private JWAnimationEffectsPart animate;
    /**
     * Whether all the sections can be closed at once. Allows collapsing the active section.
     */
    private Boolean collapsible;
    /**
     * Whether or not the accordion is disabled
     */
    private Boolean disabled;
    /**
     * The event that accordion headers will react to in order to activate the associated panel. Multiple events can be specified, separated by a space.
     */
    private MouseEventType event;
    /**
     * The header type that denotes a header
     */
    private HeaderTypes header;
    /**
     * The type of height handling to apply
     */
    private JQUIAccordionHeightStyle heightStyle;
    /**
     * The closed and open icon style
     */
    private JQUIAccordionIconOptions icons;

    /**
     * Constructs a new instance of the available JQuery UI Accordion Options
     */
    public JQUIAccordionOptions()
    {
    }

    /**
     * Returns the panel that is active
     *
     * @return
     */
    public Integer getActive()
    {
        return active;
    }

    /**
     * Sets the panel that is active
     *
     * @param active
     */
    public void setActive(Integer active)
    {
        this.active = active;
    }

    /**
     * Gets and Sets the Animate
     *
     * @return
     */
    public JWAnimationEffectsPart getAnimate()
    {
        if (animate == null)
        {
            animate = new JWAnimationEffectsPart();
        }
        return animate;
    }

    /**
     * Sets the animation
     *
     * @param animate
     */
    public void setAnimate(JWAnimationEffectsPart animate)
    {
        this.animate = animate;
    }

    /**
     * Returns Whether all the sections can be closed at once. Allows collapsing the active section.
     *
     * @return
     */
    public Boolean getCollapsible()
    {
        return collapsible;
    }

    /**
     * Sets Whether all the sections can be closed at once. Allows collapsing the active section.
     *
     * @param collapsible
     */
    public void setCollapsible(Boolean collapsible)
    {
        this.collapsible = collapsible;
    }

    /**
     * Gets the disabled flag for the accordion
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Sets the disabled flag for the accordion
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Gets all the events that will trigger the accordion
     *
     * @return
     */
    public MouseEventType getEvent()
    {
        return event;
    }

    /**
     * Sets the event that will trigger the accordion
     *
     * @param event
     */
    public void setEvent(MouseEventType event)
    {
        this.event = event;
    }

    /**
     * Gets the header type that marks a group
     *
     * @return
     */
    public HeaderTypes getHeader()
    {
        return header;
    }

    /**
     * Sets the header type to be used as a group
     *
     * @param header
     */
    public void setHeader(HeaderTypes header)
    {
        this.header = header;
    }

    /**
     * Gets the height style
     *
     * @return
     */
    public JQUIAccordionHeightStyle getHeightStyle()
    {
        return heightStyle;
    }

    /**
     * Sets the height style
     *
     * @param heightStyle
     */
    public void setHeightStyle(JQUIAccordionHeightStyle heightStyle)
    {
        this.heightStyle = heightStyle;
    }

    /**
     * Gets the Icon Options
     *
     * @return
     */
    public JQUIAccordionIconOptions getIcons()
    {
        if (icons == null)
        {
            icons = new JQUIAccordionIconOptions();
        }
        return icons;
    }

    /**
     * Sets the icon options
     *
     * @param icons
     */
    public void setIcons(JQUIAccordionIconOptions icons)
    {
        this.icons = icons;
    }
}
