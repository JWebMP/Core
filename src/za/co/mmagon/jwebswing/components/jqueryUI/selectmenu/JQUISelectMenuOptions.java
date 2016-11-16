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
package za.co.mmagon.jwebswing.components.jqueryUI.selectmenu;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqueryUI.position.Position;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since Mar 9, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUISelectMenuOptions extends JavaScriptPart
{

    /**
     * Which element to append the menu to. When the value is null, the parents of the select are checked for a class name of ui-front. If an element with the ui-front class name is found, the menu is
     * appended to that element.<p>
     * Regardless of the value, if no element is found, the menu is appended to the body.
     */
    private String appendTo;
    /**
     * Disables the select menu if set to true.
     */
    private Boolean disabled;
    /**
     * Icons to use for the button, matching an icon defined by the jQuery UI CSS Framework.<p>
     * button (string, default: "ui-icon-triangle-1-s")
     */
    private JQUISelectMenuIconsOptions icons;
    /**
     * Identifies the position of the menu in relation to the associated button element. You can refer to the jQuery UI Position utility for more details about the various options.
     */
    private Position position;
    /**
     * The width of the menu, in pixels. When the value is null, the width of the native select is used.
     */
    private Integer width;

    /**
     * Which element to append the menu to. When the value is null, the parents of the select are checked for a class name of ui-front. If an element with the ui-front class name is found, the menu is
     * appended to that element.<p>
     * Regardless of the value, if no element is found, the menu is appended to the body.
     *
     * @return
     */
    public String getAppendTo()
    {
        return appendTo;
    }

    /**
     * Which element to append the menu to. When the value is null, the parents of the select are checked for a class name of ui-front. If an element with the ui-front class name is found, the menu is
     * appended to that element.<p>
     * Regardless of the value, if no element is found, the menu is appended to the body.
     *
     * @param appendTo
     */
    public void setAppendTo(Component appendTo)
    {
        this.appendTo = appendTo.getID(true);
    }

    /**
     * Disables the selectmenu if set to true.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Disables the selectmenu if set to true.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Icons to use for the button, matching an icon defined by the jQuery UI CSS Framework.<p>
     * button (string, default: "ui-icon-triangle-1-s")
     *
     * @return
     */
    public JQUISelectMenuIconsOptions getIcons()
    {
        return icons;
    }

    /**
     * Icons to use for the button, matching an icon defined by the jQuery UI CSS Framework.<p>
     * button (string, default: "ui-icon-triangle-1-s")
     *
     * @param icons
     */
    public void setIcons(JQUISelectMenuIconsOptions icons)
    {
        this.icons = icons;
    }

    /**
     * Identifies the position of the menu in relation to the associated button element. You can refer to the jQuery UI Position utility for more details about the various options.
     *
     * @return
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * Identifies the position of the menu in relation to the associated button element. You can refer to the jQuery UI Position utility for more details about the various options.
     *
     * @param position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * The width of the menu, in pixels. When the value is null, the width of the native select is used.
     *
     * @return
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * The width of the menu, in pixels. When the value is null, the width of the native select is used.
     *
     * @param width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
