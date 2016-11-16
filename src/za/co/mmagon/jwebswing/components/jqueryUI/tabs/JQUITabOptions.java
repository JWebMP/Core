/*
 * Copyright (C) 2015 MXM3727
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
package za.co.mmagon.jwebswing.components.jqueryUI.tabs;

import za.co.mmagon.jwebswing.htmlbuilder.effects.JWAnimationEffectsPart;
import za.co.mmagon.jwebswing.components.jqueryUI.accordion.JQUIAccordionHeightStyle;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.mouseevents.MouseEventType;

/**
 * The options for the tab component
 * <p>
 * @author Marc Magon
 * @since 2014/04/27
 */
public class JQUITabOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * The panel to show as active
     */
    private Integer active;
    /**
     * Whether or not the tab is collapsible
     */
    private Boolean collapsible;
    /**
     * The disabled value of the
     */
    private Boolean disabled;
    /**
     * The mouse event to activate on
     */
    private MouseEventType event;
    /**
     * The height style
     */
    private JQUIAccordionHeightStyle heightStyle;
    /**
     * The animation effect for hide
     */
    private JWAnimationEffectsPart hide;
    /**
     * The animation effect for show
     */
    private JWAnimationEffectsPart show;

    /**
     * Which panel is currently open.
     * Multiple types supported:
     * <p>
     * Boolean: Setting active to false will collapse all panels. This requires the collapsible option to be true.
     * Integer: The zero-based index of the panel that is active (open). A negative value selects panels going backward from the last panel.
     * <p>
     * @return
     */
    public Integer getActive()
    {
        return active;
    }

    /**
     * Which panel is currently open.
     * Multiple types supported:
     * <p>
     * Boolean: Setting active to false will collapse all panels. This requires the collapsible option to be true.
     * Integer: The zero-based index of the panel that is active (open). A negative value selects panels going backward from the last panel.
     * <p>
     * @param active
     */
    public void setActive(Integer active)
    {
        this.active = active;
    }

    /**
     * When set to true, the active panel can be closed.
     * Code examples:
     * <p>
     * Initialize the tabs with the collapsible option specified:
     * <p>
     * @return
     */
    public Boolean getCollapsible()
    {
        return collapsible;
    }

    /**
     * When set to true, the active panel can be closed.
     * Code examples:
     * <p>
     * Initialize the tabs with the collapsible option specified:
     * <p>
     * @param collapsible
     */
    public void setCollapsible(Boolean collapsible)
    {
        this.collapsible = collapsible;
    }

    /**
     * Which tabs are disabled.
     * Multiple types supported:
     * <p>
     * Boolean: Enable or disable all tabs.
     * <p>
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Which tabs are disabled.
     * Multiple types supported:
     * <p>
     * Boolean: Enable or disable all tabs.
     * <p>
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * The type of event that the tabs should react to in order to activate the tab. To activate on hover, use "mouseover".
     * <p>
     * @return
     */
    public MouseEventType getEvent()
    {
        return event;
    }

    /**
     * The type of event that the tabs should react to in order to activate the tab. To activate on hover, use "mouseover".
     * <p>
     * @param event
     */
    public void setEvent(MouseEventType event)
    {
        this.event = event;
    }

    /**
     * Controls the height of the tabs widget and each panel. Possible values:
     * <p>
     * "auto": All panels will be set to the height of the tallest panel.
     * "fill": Expand to the available height based on the tabs' parent height.
     * "content": Each panel will be only as tall as its content.
     * <p>
     * @return
     */
    public JQUIAccordionHeightStyle getHeightStyle()
    {
        return heightStyle;
    }

    /**
     * Controls the height of the tabs widget and each panel. Possible values:
     * <p>
     * "auto": All panels will be set to the height of the tallest panel.
     * "fill": Expand to the available height based on the tabs' parent height.
     * "content": Each panel will be only as tall as its content.
     * <p>
     * @param heightStyle
     */
    public void setHeightStyle(JQUIAccordionHeightStyle heightStyle)
    {
        this.heightStyle = heightStyle;
    }

    /**
     * If and how to animate the hiding of the panel.
     * <p>
     * @return
     */
    public JWAnimationEffectsPart getHide()
    {
        return hide;
    }

    /**
     * If and how to animate the hiding of the panel.
     * <p>
     * @param hide
     */
    public void setHide(JWAnimationEffectsPart hide)
    {
        this.hide = hide;
    }

    /**
     * If and how to animate the showing of the panel.
     * <p>
     * @return
     */
    public JWAnimationEffectsPart getShow()
    {
        return show;
    }

    /**
     * If and how to animate the showing of the panel.
     * <p>
     * @param show
     */
    public void setShow(JWAnimationEffectsPart show)
    {
        this.show = show;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
