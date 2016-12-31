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
package za.co.mmagon.jwebswing.components.bootstrap.componentoptions;

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Responsive utilities
 * <p>
 * For faster mobile-friendly development, use these utility classes for showing and hiding content by device via media query. Also included are utility classes for toggling content when printed.
 * <p>
 * Try to use these on a limited basis and avoid creating entirely different versions of the same site. Instead, use them to complement each device’s presentation. Available classes
 * <p>
 * The .hidden-*-up classes hide the element when the viewport is at the given breakpoint or wider. For example, .hidden-md-up hides an element on medium, large, and extra-large viewports. The
 * .hidden-*-down classes hide the element when the viewport is at the given breakpoint or smaller. For example, .hidden-md-down hides an element on extra-small, small, and medium viewports. There are
 * no explicit “visible”/”show” responsive utility classes; you make an element visible by simply not hiding it at that breakpoint size. You can combine one .hidden-*-up class with one .hidden-*-down
 * class to show an element only on a given interval of screen sizes. For example, .hidden-sm-down.hidden-xl-up shows the element only on medium and large viewports. Using multiple .hidden-*-up
 * classes or multiple .hidden-*-down classes is redundant and pointless. These classes don’t attempt to accommodate less common cases where an element’s visibility can’t be expressed as a single
 * contiguous range of viewport breakpoint sizes; you will instead need to use custom CSS in such cases.
 *
 * @author GedMarc
 * @since Oct 10, 2016
 * @version 1.0
 *
 */
public enum BSComponentResponsiveOptions implements IBSComponentOptions
{
    /**
     * Hide this component when small only
     */
    Hidden_SM,
    /**
     * Hide this component extra small only
     */
    Hidden_XS,
    /**
     * Hide this component when medium
     */
    Hidden_MD,
    /**
     * Hide this component when large
     */
    Hidden_LG,
    /**
     * Hide when XL
     */
    Hidden_XL,
    /**
     * Hide for XS and SM
     */
    Hidden_SM_Down,
    /**
     * Hide for XS, SM and MD
     */
    Hidden_MD_Down,
    /**
     * Only display on XL
     */
    Hidden_LG_Down,
    /**
     * Invisible
     */
    @Deprecated
    Hidden_XL_Down,
    /**
     * Hide for XS and UP (invisible
     */
    @Deprecated
    Hidden_XS_Up,
    /**
     * Hide for SM and UP
     */
    Hidden_SM_Up,
    /**
     * Hide for MD screens and up
     */
    Hidden_MD_Up,
    /**
     * Hide for Large and up
     */
    Hidden_LG_Up,;

    private BSComponentResponsiveOptions()
    {

    }

    /**
     * Replaces the text with its HTML class equivalent
     * @return 
     */
    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
