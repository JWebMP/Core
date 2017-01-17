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
package za.co.mmagon.jwebswing.components.bootstrap.navbar;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 *
 * <p>
 * @author Marc Magon
 * @since 13 Jan 2017
 * @version 1.0
 */
public class BSNavBar extends Div<BSNavBarChildren, BSNavBarAttributes, BSNavBarFeatures, BSNavBarEvents, BSNavBar>
{

    private static final long serialVersionUID = 1L;

    /**
     * Navbar
     * <p>
     * The navbar is a wrapper that positions branding, navigation, and other elements in a concise header. It’s easily extensible and, thanks to our Collapse plugin, can easily integrate responsive
     * behaviors.
     */
    public BSNavBar()
    {
        setTag("nav");
    }

    @Override
    public BSNavBarOptions getOptions()
    {
        return new BSNavBarOptions();
    }

}