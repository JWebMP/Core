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
package za.co.mmagon.jwebswing.components.jqxwidgets.grid;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * The Grid is a powerful jQuery widget that displays tabular data. It offers rich support for interacting with data, including paging, grouping, sorting, filtering and editing.
 * <p>
 * @author Marc Magon
 * @since 15 Dec 2015
 * @version 1.0
 */
public class JQXGrid extends Div<JQXGridChildren, JQXGridAttributes, JQXGridFeature, JQXGridEvents, JQXGrid>
{

    private static final long serialVersionUID = 1L;
    private JQXGridFeature feature;

    public JQXGrid()
    {
        addFeature(getFeature());
    }

    public JQXGridFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXGridFeature(this);
        }
        return feature;
    }

    @Override
    public JQXGridOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
