/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.navbar.toggler;

import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 *
 * @author GedMarc
 * @since 21 Jan 2017
 *
 */
public enum BSNavBarTogglerSizes implements IBSComponentOptions
{
    /**
     * Navbars require a wrapping .navbar with .navbar-toggleable-* for responsive collapsing and color scheme classes.
     */
    Navbar_Toggleable_XS,
    /**
     * Navbars require a wrapping .navbar with .navbar-toggleable-* for responsive collapsing and color scheme classes.
     */
    Navbar_Toggleable_SM,
    /**
     * Navbars require a wrapping .navbar with .navbar-toggleable-* for responsive collapsing and color scheme classes.
     */
    Navbar_Toggleable_MD,
    /**
     * Navbars require a wrapping .navbar with .navbar-toggleable-* for responsive collapsing and color scheme classes.
     */
    Navbar_Toggleable_LG,
    /**
     * Navbars require a wrapping .navbar with .navbar-toggleable-* for responsive collapsing and color scheme classes.
     */
    Navbar_Toggleable_XL,;

    private BSNavBarTogglerSizes()
    { //Nothing Needed
    }

    @JsonValue
    @Override
    public String toString()
    {
        String name = name().toLowerCase().replaceAll("\\$", " ").replaceAll("_", "-");
        return name;
    }
}
