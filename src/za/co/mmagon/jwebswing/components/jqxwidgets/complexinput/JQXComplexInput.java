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
package za.co.mmagon.jwebswing.components.jqxwidgets.complexinput;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxComplexInput represents an input widget for entering complex numbers and getting their real and imaginary parts. The complex input also supports on-keydown and on-change number validation.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXComplexInput extends Div<JQXComplexInputChildren, JQXComplexInputAttributes, JQXComplexInputFeature, JQXComplexInputEvents, JQXComplexInput>
{

    private static final long serialVersionUID = 1L;
    private JQXComplexInputFeature feature;

    public JQXComplexInput()
    {
        addFeature(getFeature());
    }

    public JQXComplexInputFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXComplexInputFeature(this);
        }
        return feature;
    }

    @Override
    public JQXComplexInputOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
