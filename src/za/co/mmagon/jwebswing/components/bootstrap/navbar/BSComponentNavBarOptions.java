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
package za.co.mmagon.jwebswing.components.bootstrap.navbar;

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Navbar
 * <p>
 * The navbar is a wrapper that positions branding, navigation, and other elements in a concise header. It’s easily extensible and, thanks to our Collapse plugin, can easily integrate responsive
 * behaviors.
 *
 * @author GedMarc
 */
public enum BSComponentNavBarOptions implements IBSComponentOptions
{
    /**
     * Navbar
     * <p>
     * The navbar is a wrapper that positions branding, navigation, and other elements in a concise header. It’s easily extensible and, thanks to our Collapse plugin, can easily integrate responsive
     * behaviors.
     */
    Navbar,
    /*
     * Navbars come with built-in support for a handful of sub-components. Choose from the following as needed: <p> .navbar-brand for your company, product, or project name.
     */
    Navbar_Brand,
    /**
     * .navbar-toggler for use with our collapse plugin and other navigation toggling behaviors.
     */
    Navbar_Toggler,
    /**
     * The icon for the navbar toggler (in an italic component)
     */
    Navbar_Toggler_Icon,
    /**
     * .navbar-text for adding vertically centered strings of text.
     */
    Navbar_Text,
    /**
     * Default for navbar
     */
    Navbar_Default,
    /**
     * Align the navbar right
     */
    Navbar_Right;

    private BSComponentNavBarOptions()
    {

    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
