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
package za.co.mmagon.jwebswing.components.bootstrap.collapse;

import za.co.mmagon.jwebswing.base.html.*;

/**
 * Collapse
 * <p>
 * The Bootstrap collapse plugin allows you to toggle content on your pages with a few classes thanks to some helpful JavaScript.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSCollapse
{

    private static final long serialVersionUID = 1L;

    /**
     * Apply a collapse to given components
     *
     * @param linkController
     * @param display
     * @param hideOnStart
     */
    public BSCollapse(Link linkController, Div display, boolean hideOnStart)
    {
        if (display != null)
        {
            display.addClass("collapse");
            if (!hideOnStart)
            {
                display.addClass("in");
            }
        }

        linkController.addAttribute("data-toggle", "collapse");
        linkController.addAttribute("aria-expanded", Boolean.toString(!hideOnStart));
        linkController.addAttribute("aria-controls", display.getID());
        linkController.addAttribute("data-target", display.getID(true));
    }

    /**
     * Apply a collapse to given components
     *
     * @param buttonController
     * @param display
     * @param hideOnStart
     */
    public BSCollapse(Button buttonController, Div display, boolean hideOnStart)
    {
        if (display != null)
        {
            display.addClass("collapse");
            if (!hideOnStart)
            {
                display.addClass("in");
            }
        }

        buttonController.addAttribute("data-toggle", "collapse");
        buttonController.addAttribute("aria-expanded", Boolean.toString(!hideOnStart));
        buttonController.addAttribute("aria-controls", display.getID());
        buttonController.addAttribute("data-target", display.getID(true));
    }
}
