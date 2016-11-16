/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.jqxWidgets.menu;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.List;

/**
 * jqxMenu represents a jQuery menu widget that makes it easy to add menus to your website or web application. With the jqxMenu you can create website menus, customized context menus, or
 * application-style menu bars with just a small amount of scripting.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXMenu extends Div<JQXMenuChildren, JQXMenuAttributes, JQXMenuFeature, JQXMenuEvents, JQXMenu>
{

    private static final long serialVersionUID = 1L;
    private JQXMenuFeature feature;

    private List menuList;

    public JQXMenu()
    {
        addFeature(getFeature());
        add(menuList = new List(false));
    }

    public JQXMenuFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXMenuFeature(this);
        }
        return feature;
    }

    @Override
    public JQXMenuOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Gets the menu list for this
     *
     * @return
     */
    public List getMenuList()
    {
        return menuList;
    }

    /**
     * Sets the list for this menu
     *
     * @param menuList
     */
    public void setMenuList(List menuList)
    {
        this.menuList = menuList;
    }

}
