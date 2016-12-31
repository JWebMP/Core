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
package za.co.mmagon.jwebswing.components.bootstrap;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Shortcut for writing column Div's and spans for bootstrap
 *
 * @author GedMarc
 * @since Oct 10, 2016
 * @version 1.0
 *
 */
public class BSColumn extends Div
{

    private static final long serialVersionUID = 1L;

    /**
     * Supply a list of column options for this div
     *
     * @param columnOptions
     */
    public BSColumn(IBSComponentOptions... columnOptions)
    {
        if (columnOptions != null)
        {
            for (IBSComponentOptions columnOption : columnOptions)
            {
                addClass(columnOption.toString());
            }
        }
    }

    /**
     * Constructs a new instance with the given column options
     *
     * @param columnOptions
     *
     * @return
     */
    public static BSColumn newInstance(IBSComponentOptions... columnOptions)
    {
        return new BSColumn(columnOptions);
    }
}
