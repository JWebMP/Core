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
package za.co.mmagon.jwebswing.components.jqxwidgets.rangeselector;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxRangeSelector is a widget which can easily be used to select a numeric or date range. The API of jqxRangeSelector allows for a variety of user settings to be applied such as setting the range in
 * numbers, days, weeks, months, years, etc .
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXRangeSelector extends Div<JQXRangeSelectorChildren, JQXRangeSelectorAttributes, JQXRangeSelectorFeature, JQXRangeSelectorEvents, JQXRangeSelector>
{

    private static final long serialVersionUID = 1L;
    private JQXRangeSelectorFeature feature;

    public JQXRangeSelector()
    {
        addFeature(getFeature());
    }

    public JQXRangeSelectorFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXRangeSelectorFeature(this);
        }
        return feature;
    }

    @Override
    public JQXRangeSelectorOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
