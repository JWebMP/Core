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
package za.co.mmagon.jwebswing.components.bootstrap.navs;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * Navs Navigation available in Bootstrap share general markup and styles, from the base .nav class to the active and disabled states. Swap modifier classes to switch between each style.
 * <p>
 * @author Marc Magon
 * @since 17 Jan 2017
 * @version 1.0
 */
public class BSNavs extends Div<BSNavsChildren, BSNavsAttributes, BSNavsFeatures, BSNavsEvents, BSNavs>
{

    private static final long serialVersionUID = 1L;
    /**
     * The associated feature
     */
    private BSNavsFeature feature;

    /**
     * Navs Navigation available in Bootstrap share general markup and styles, from the base .nav class to the active and disabled states. Swap modifier classes to switch between each style.
     */
    public BSNavs()
    {
        setTag("nav");
        addClass(BSComponentNavsOptions.Nav);
        addAttribute("role", "navigation");
    }

    /**
     * Sets this navigation bar as centered
     *
     * @return
     */
    public BSNavs setCentered()
    {
        addClass(BSComponentNavsOptions.Justify_Content_Center);
        return this;
    }

    /**
     * Sets this navigation bar as right aligned
     *
     * @return
     */
    public BSNavs setRightAligned()
    {
        addClass(BSComponentNavsOptions.Justify_Content_End);
        return this;
    }

    /**
     * Returns the feature if any is required
     *
     * @return
     */
    public final BSNavsFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSNavsFeature(this);
        }
        return feature;
    }

    /**
     * Returns the options if any is required
     *
     * @return
     */
    @Override
    public BSNavsOptions getOptions()
    {
        return getFeature().getOptions();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }

}
