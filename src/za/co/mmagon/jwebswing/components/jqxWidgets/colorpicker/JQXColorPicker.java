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
package za.co.mmagon.jwebswing.components.jqxWidgets.colorpicker;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.jqxWidgets.dropdownlist.JQXDropDownListChildren;

/**
 * jqxColorPicker represents a jQuery UI widget that allows you to easily pick a color. You can configure the jqxColorPicker's color mode, input a color in hex or rgb format.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXColorPicker extends Div<JQXColorPickerChildren, JQXColorPickerAttributes, JQXColorPickerFeature, JQXColorPickerEvents, JQXColorPicker> implements JQXDropDownListChildren
{

    private static final long serialVersionUID = 1L;
    private JQXColorPickerFeature feature;

    public JQXColorPicker()
    {
        addFeature(getFeature());
    }

    public JQXColorPickerFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXColorPickerFeature(this);
        }
        return feature;
    }

    @Override
    public JQXColorPickerOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
