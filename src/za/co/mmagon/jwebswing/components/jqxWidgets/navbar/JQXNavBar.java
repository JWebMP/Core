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
package za.co.mmagon.jwebswing.components.jqxWidgets.navbar;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;

/**
 * jqxNavBar is a small widget which is built from UL and LI tags. It can be used for creating responsive horizontal/vertical layouts or simple navigation menus.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXNavBar extends Div<GlobalChildren, JQXNavBarAttributes, JQXNavBarFeatures, JQXNavBarEvents, JQXNavBar>
{

    private static final long serialVersionUID = 1L;
    private JQXNavBarFeature feature;

    public JQXNavBar()
    {
        addFeature(getFeature());
    }

    public JQXNavBarFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXNavBarFeature(this);
        }
        return feature;
    }

    @Override
    public JQXNavBarOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
