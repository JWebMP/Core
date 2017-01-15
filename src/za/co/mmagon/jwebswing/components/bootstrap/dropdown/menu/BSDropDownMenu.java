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
package za.co.mmagon.jwebswing.components.bootstrap.dropdown.menu;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.bootstrap.dropdown.BSComponentDropDownOptions;
import za.co.mmagon.jwebswing.components.bootstrap.dropdown.BSDropDownChildren;

/**
 * A drop down menu for the bootstrap drop down component
 * <p>
 * @author Marc Magon
 * @since 13 Jan 2017
 * @version 1.0
 */
public class BSDropDownMenu extends Div<BSDropDownMenuChildren, BSDropDownMenuAttributes, BSDropDownMenuFeatures, BSDropDownMenuEvents, BSDropDownMenu>
        implements BSDropDownChildren
{

    private static final long serialVersionUID = 1L;

    private BSDropDownMenuFeature feature;

    /**
     * A new drop down menu list
     */
    public BSDropDownMenu()
    {
        addClass(BSComponentDropDownOptions.Dropdown_Menu);

    }

    public final BSDropDownMenuFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSDropDownMenuFeature(this);
        }
        return feature;
    }

    /**
     * Menu alignment
     * <p>
     * By default, a dropdown menu is automatically positioned 100% from the top and along the left side of its parent. Add .dropdown-menu-right to a .dropdown-menu to right align the dropdown menu.
     * <p>
     * Heads up! Dropdowns are positioned only with CSS and may need some additional styles for exact alignment.
     *
     * @return
     */
    public BSDropDownMenu setRightAligned()
    {
        addClass(BSComponentDropDownOptions.Dropdown_Menu_Right);
        return this;
    }

    /**
     * Returns very little
     *
     * @return
     */
    @Override
    public BSDropDownMenuOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
