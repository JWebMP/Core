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
package za.co.mmagon.jwebswing.components.bootstrap.navs;

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Navs Navigation available in Bootstrap share general markup and styles, from the base .nav class to the active and disabled states. Swap modifier classes to switch between each style..
 *
 * @author GedMarc
 */
public enum BSComponentNavsOptions implements IBSComponentOptions
{
    /**
     * Base nav The base .nav component is built with flexbox and provide a strong foundation for building all types of navigation components. It includes some style overrides (for working with
     * lists), some link padding for larger hit areas, and basic disabled styling. No active states are included in the base nav.
     */
    Nav,
    /**
     * Tabs Takes the basic nav from above and adds the .nav-tabs class to generate a tabbed interface. Use them to create tabbable regions with our tab JavaScript plugin.
     */
    Nav_Tabs,
    /**
     * Nav List Item
     */
    Nav_Item,
    /**
     * An actual navigation link
     */
    Nav_Link,
    /**
     * Nav_Pills
     */
    Nav_Pills,
    /**
     * If the link is active (no effect on the base)
     */
    Active,
    /**
     * Sets the link as disabled
     */
    Disabled,
    /**
     * Horizontal alignment Change the horizontal alignment of your nav with flexbox utilities. By default, navs are left-aligned, but you can easily change them to center or right aligned.
     * <p>
     * Centered with .justify-content-center:
     */
    Justify_Content_Center,
    /**
     * Horizontal alignment Change the horizontal alignment of your nav with flexbox utilities. By default, navs are left-aligned, but you can easily change them to center or right aligned.
     */
    Justify_Content_End;

    private BSComponentNavsOptions()
    {

    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
