/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryui.colourpicker;

import za.co.mmagon.jwebswing.base.html.InputTextType;

/**
 * The Spectrum Colour Picker Implementation
 * <p>
 * http://bgrins.github.com/spectrum
 * <p>
 * @author GedMarc
 * @since 01 May 2015
 */
public class JQUIColourPicker extends InputTextType
{

    private static final long serialVersionUID = 1L;
    private final JQUIColourPickerFeature feature;

    public JQUIColourPicker()
    {
        feature = new JQUIColourPickerFeature(this);
        addFeature(feature);
    }

    /**
     * Returns the features available options
     */
    public JQUIColourPickerOptions getOptions()
    {
        return feature.getOptions();
    }
}
