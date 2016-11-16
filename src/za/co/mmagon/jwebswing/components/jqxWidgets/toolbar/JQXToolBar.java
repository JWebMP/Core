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
package za.co.mmagon.jwebswing.components.jqxWidgets.toolbar;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxToolBar is a jQuery widget which represents a toolbar where different tools (including widgets) can be automatically added. By default, jqxToolBar supports the widgets jqxButton,
 * jqxToggleButton, jqxDropDownList, jqxComboBox and jqxInput but custom tools can also be added.
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXToolBar extends Div<JQXToolBarChildren, JQXToolBarAttributes, JQXToolBarFeature, JQXToolBarEvents, JQXToolBar>
{

    private static final long serialVersionUID = 1L;
    private JQXToolBarFeature feature;

    public JQXToolBar()
    {
        addFeature(getFeature());
    }

    public JQXToolBarFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXToolBarFeature(this);
        }
        return feature;
    }

    @Override
    public JQXToolBarOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
