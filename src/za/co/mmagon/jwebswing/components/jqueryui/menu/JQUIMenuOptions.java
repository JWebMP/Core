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
package za.co.mmagon.jwebswing.components.jqueryui.menu;

import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryui.position.Position;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUIMenuOptions extends JavaScriptPart
{

    private Boolean disabled;
    private JQUIMenuIconSet icons;
    private String menus;
    private Position position;
    /**
     * Customize the ARIA roles used for the menu and menu items.
     * <p>
     * The default uses "menuitem" for items.
     * <p>
     * Setting the role option to "listbox" will use "option" for items.<p>
     * If set to null, no roles will be set, which is useful if the menu is being controlled by another element that is maintaining focus.
     */
    private String role;

    /**
     * Disables the menu if set to true
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Disables the menu if set to true
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Icons to use for submenus, matching an icon provided by the jQuery UI CSS Framework.
     * <p>
     * submenu (string, default: "ui-icon-carat-1-e")
     *
     * @return
     */
    public JQUIMenuIconSet getIcons()
    {
        return icons;
    }

    /**
     * Icons to use for submenus, matching an icon provided by the jQuery UI CSS Framework.
     * <p>
     * submenu (string, default: "ui-icon-carat-1-e")
     *
     * @param icons
     */
    public void setIcons(JQUIMenuIconSet icons)
    {
        this.icons = icons;
    }

    /**
     * Selector for the elements that serve as the menu container, including sub-menus.
     *
     * @return
     */
    public String getMenus()
    {
        return menus;
    }

    /**
     * Selector for the elements that serve as the menu container, including sub-menus.
     *
     * @param menus
     */
    public void setMenus(ComponentTypes menus)
    {
        this.menus = menus.getComponentTag();
    }

    /**
     * <p>
     * Identifies the position of submenus in relation to the associated parent menu item.<p>
     * The of option defaults to the parent menu item, but you can specify another element to position against.<p>
     * You can refer to the jQuery UI Position utility for more details about the various options.
     *
     * @return
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * <p>
     * Identifies the position of submenus in relation to the associated parent menu item.<p>
     * The of option defaults to the parent menu item, but you can specify another element to position against.<p>
     * You can refer to the jQuery UI Position utility for more details about the various options.
     *
     * @param position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * Customize the ARIA roles used for the menu and menu items.<p>
     * The default uses "menuitem" for items. Setting the role option to "listbox" will use "option" for items.
     * <p>
     * If set to null, no roles will be set, which is useful if the menu is being controlled by another element that is maintaining focus.
     *
     * @return
     */
    public String getRole()
    {
        return role;
    }

    /**
     *
     * Customize the ARIA roles used for the menu and menu items.<p>
     * The default uses "menuitem" for items. Setting the role option to "listbox" will use "option" for items.
     * <p>
     * If set to null, no roles will be set, which is useful if the menu is being controlled by another element that is maintaining focus.
     *
     * @param role
     */
    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
