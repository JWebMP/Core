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
package za.co.mmagon.jwebswing.components.jqxwidgets.treegrid;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxTreeGrid is a lightweight jQuery widget which represents data in a tree-like structure.
 * <p>
 * The TreeGrid(also known as TreeList) widget supports multi column display of hierarchical data, data
 * paging, sorting and filtering, data editing, columns resizing, fixed columns, conditional formatting, aggregates and rows selection.
 * <p>
 * It can read and display the data from your data sources like
 * XML, JSON, Array, CSV or TSV.
 * <p>
 * jqxTreeGrid has intuitive and easy to use APIs and works across devices and browsers.
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXTreeGrid extends Div<JQXTreeGridChildren, JQXTreeGridAttributes, JQXTreeGridFeature, JQXTreeGridEvents, JQXTreeGrid>
{

    private static final long serialVersionUID = 1L;
    private JQXTreeGridFeature feature;

    public JQXTreeGrid()
    {
        addFeature(getFeature());
    }

    public JQXTreeGridFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXTreeGridFeature(this);
        }
        return feature;
    }

    @Override
    public JQXTreeGridOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
