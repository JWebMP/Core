/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jstree.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.components.bootstrap.Glyphicons;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptLiteralFunction;

/**
 * an object of actions, or a function that accepts a node and a callback function and calls the callback function with an object of actions available for that node (you can also return the items
 * too).
 * <p>
 * Each action consists of a key (a unique name) and a value which is an object with the following properties (only label and action are required). Once a menu item is activated the action function
 * will be invoked with an object containing the following keys: item - the contextmenu item definition as seen below, reference - the DOM node that was used (the tree node), element - the contextmenu
 * DOM element, position - an object with x/y properties indicating the position of the menu.
 * <p>
 * separator_before - a boolean indicating if there should be a separator before this item
 * <p>
 * separator_after - a boolean indicating if there should be a separator after this item
 * <p>
 * _disabled - a boolean indicating if this action should be disabled
 * <p>
 * label - a string - the name of the action (could be a function returning a string)
 * <p>
 * title - a string - an optional tooltip for the item
 * <p>
 * action - a function to be executed if this item is chosen, the function will receive
 * <p>
 * icon - a string, can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class
 * <p>
 * shortcut - shortcutKeycode which will trigger the action if the menu is open (for example 113 for rename, which equals F2)
 * <p>
 * shortcut_label - shortcut label (like for example F2 for rename)
 * <p>
 * submenu - an object with the same structure as $.jstree.defaults.contextmenu.items which can be used to create a submenu - each key will be rendered as a separate option in a submenu that will
 * appear once the current item is hovered
 *
 * @author GedMarc
 * @since 23 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeContextMenuItemsOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * a boolean indicating if there should be a separator before this item
     */
    @JsonProperty("separator_before")
    private Boolean separatorBefore;
    /**
     * a boolean indicating if there should be a separator after this item
     */
    @JsonProperty("separator_after")
    private Boolean separatorAfter;
    /**
     * a boolean indicating if this action should be disabled
     */
    @JsonProperty("_disabled")
    private Boolean disabled;
    /**
     * a string - the name of the action (could be a function returning a string)
     */
    private String label;
    /**
     * a string - an optional tooltip for the item
     */
    @JsonProperty("title")
    private String tooltip;

    /**
     * a function to be executed if this item is chosen, the function will receive
     */
    private JavascriptLiteralFunction action;
    /**
     * a string, can be a path to an icon or a className,
     * <p>
     * if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class
     */
    private String icon;
    /**
     * shortcutKeycode which will trigger the action if the menu is open (for example 113 for rename, which equals F2)
     */
    @JsonProperty("shortcut")
    private Integer shortcutKeycode;
    /**
     * shortcut label (like for example F2 for rename)
     */
    @JsonProperty("shortcut_label")
    private String shortcutLabel;
    /**
     * an object with the same structure as $.jstree.defaults.contextmenu.items which can be used to create a submenu - each key will be rendered as a separate option in a submenu that will appear
     * once the current item is hovered
     */
    private JSTreeContextMenuItemsOptions submenu;

    public JSTreeContextMenuItemsOptions()
    {

    }

    /**
     * a boolean indicating if there should be a separator before this item
     *
     * @return
     */
    public Boolean getSeparatorBefore()
    {
        return separatorBefore;
    }

    /**
     * a boolean indicating if there should be a separator before this item
     *
     * @param separatorBefore
     */
    public void setSeparatorBefore(Boolean separatorBefore)
    {
        this.separatorBefore = separatorBefore;
    }

    /**
     * a boolean indicating if there should be a separator after this item
     *
     * @return
     */
    public Boolean getSeparatorAfter()
    {
        return separatorAfter;
    }

    /**
     * a boolean indicating if there should be a separator after this item
     *
     * @param separatorAfter
     */
    public void setSeparatorAfter(Boolean separatorAfter)
    {
        this.separatorAfter = separatorAfter;
    }

    /**
     * a boolean indicating if this action should be disabled
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * a boolean indicating if this action should be disabled
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * a string - the name of the action (could be a function returning a string)
     *
     * @return
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * a string - the name of the action (could be a function returning a string)
     *
     * @param label
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * a string - an optional tooltip for the item
     *
     * @return
     */
    public String getTooltip()
    {
        return tooltip;
    }

    /**
     * a string - an optional tooltip for the item
     *
     * @param tooltip
     */
    public void setTooltip(String tooltip)
    {
        this.tooltip = tooltip;
    }

    /**
     * a function to be executed if this item is chosen, the function will receive
     *
     * @return
     */
    public JavascriptLiteralFunction getAction()
    {
        return action;
    }

    /**
     * a function to be executed if this item is chosen, the function will receive
     *
     * @param action
     */
    public void setAction(JavascriptLiteralFunction action)
    {
        this.action = action;
    }

    /**
     * a string, can be a path to an icon or a className,
     * <p>
     * if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class
     *
     * @return
     */
    public String getIcon()
    {
        return icon;
    }

    /**
     * a string, can be a path to an icon or a className,
     * <p>
     * if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class
     *
     * @param icon
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    /**
     * a string, can be a path to an icon or a className,
     * <p>
     * if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class
     *
     * @param icon
     */
    public void setIcon(FontAwesomeIcons icon)
    {
        this.icon = icon.toString();
    }

    /**
     * a string, can be a path to an icon or a className,
     * <p>
     * if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class
     *
     * @param icon
     */
    public void setIcon(Glyphicons icon)
    {
        this.icon = icon.toString();
    }

    /**
     * shortcutKeycode which will trigger the action if the menu is open (for example 113 for rename, which equals F2)
     *
     * @return
     */
    public Integer getShortcutKeycode()
    {
        return shortcutKeycode;
    }

    /**
     * shortcutKeycode which will trigger the action if the menu is open (for example 113 for rename, which equals F2)
     *
     * @param shortcutKeycode
     */
    public void setShortcutKeycode(Integer shortcutKeycode)
    {
        this.shortcutKeycode = shortcutKeycode;
    }

    /**
     * shortcut label (like for example F2 for rename)
     *
     * @return
     */
    public String getShortcutLabel()
    {
        return shortcutLabel;
    }

    /**
     * shortcut label (like for example F2 for rename)
     *
     * @param shortcutLabel
     */
    public void setShortcutLabel(String shortcutLabel)
    {
        this.shortcutLabel = shortcutLabel;
    }

    /**
     * an object with the same structure as $.jstree.defaults.contextmenu.items which can be used to create a submenu - each key will be rendered as a separate option in a submenu that will appear
     * once the current item is hovered
     *
     * @return never null
     */
    public JSTreeContextMenuItemsOptions getSubmenu()
    {
        if (submenu == null)
        {
            submenu = new JSTreeContextMenuItemsOptions();
        }
        return submenu;
    }

    /**
     * an object with the same structure as $.jstree.defaults.contextmenu.items which can be used to create a submenu - each key will be rendered as a separate option in a submenu that will appear
     * once the current item is hovered
     *
     * @param submenu
     */
    public void setSubmenu(JSTreeContextMenuItemsOptions submenu)
    {
        this.submenu = submenu;
    }

}
