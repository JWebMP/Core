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
package za.co.mmagon.jwebswing.components.jqxwidgets.numberinput;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxNumberInput represents a jQuery widget that allows you to input currency, percentages and any type of numeric data.
 * <p>
 * The edited data can be presented in various formats.
 * <p>
 * Other built-in capabilities are customizable number of digits and decimal digits, currency symbol's string and position, group and decimal separator character.
 * <p>
 * @author Marc Magon
 * @since 20 Dec 2015
 * @version 1.0
 */
public class JQXNumberInput extends Div<JQXNumberInputChildren, JQXNumberInputAttributes, JQXNumberInputFeature, JQXNumberInputEvents, JQXNumberInput>
{

    private static final long serialVersionUID = 1L;
    private JQXNumberInputFeature feature;

    public JQXNumberInput()
    {
        addFeature(getFeature());
    }

    public JQXNumberInputFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXNumberInputFeature(this);
        }
        return feature;
    }

    @Override
    public JQXNumberInputOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
