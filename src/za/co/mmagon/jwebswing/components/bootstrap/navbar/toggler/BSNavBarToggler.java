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

import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.bootstrap.navbar.BSComponentNavBarOptions;
import za.co.mmagon.jwebswing.components.bootstrap.navbar.BSNavBarChildren;
import za.co.mmagon.jwebswing.components.bootstrap.navs.BSNavs;

/**
 *
 * @author GedMarc
 * @since 21 Jan 2017
 *
 */
public class BSNavBarToggler extends Button implements BSNavBarChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * The specified screen reader aria label to apply when creating the div
     */
    private static String ARIA_LABEL = "Toggle Navigation";

    /**
     * Creates 2 new accessible objects for the nav bar
     *
     * @param togglerAlignment
     */
    public BSNavBarToggler(BSNavBarTogglerAlignments togglerAlignment)
    {
        addClass(BSComponentNavBarOptions.Navbar_Toggler);
        addClass(togglerAlignment);
    }

    /**
     * Nav
     * <p>
     * Navbar navigation links build on our .nav options with their own modifier class and require the use of toggler classes for proper responsive styling.
     * <p>
     * Navigation in navbars will also grow to occupy as much horizontal space as possible to keep your navbar contents securely aligned.
     * <p>
     * Active states—with .active—to indicate the current page can be applied directly to .nav-links or their immediate parent .nav-items.
     *
     * @param <T>
     * @param navs
     *
     * @return
     */
    public <T extends Div & BSNavBarChildren> T createCollapsingDiv(BSNavs navs)
    {
        navs.removeClass("nav");
        navs.addClass("navbar-nav");

        BSNavBarTogglerDiv div = new BSNavBarTogglerDiv();
        div.add(navs);

        addAttribute("data-toggle", "collapse");
        addAttribute("data-target", div.getID(true));
        addAttribute("aria-controls", div.getID());
        addAttribute("aria-expanded", "false");
        addAttribute("aria-label", ARIA_LABEL);
        addAttribute("type", "button");

        return (T) div;
    }

    /**
     * Gets the screen reader aria label
     *
     * @return
     */
    public static String getARIA_LABEL()
    {
        return ARIA_LABEL;
    }

    /**
     * sets the screen reader aria label
     *
     * @param ARIA_LABEL
     */
    public static void setARIA_LABEL(String ARIA_LABEL)
    {
        BSNavBarToggler.ARIA_LABEL = ARIA_LABEL;
    }

}
