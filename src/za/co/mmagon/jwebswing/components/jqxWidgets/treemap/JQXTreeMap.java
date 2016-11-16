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
package za.co.mmagon.jwebswing.components.jqxWidgets.treemap;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxTreeMap displays hierarchical data as a set of nested rectangles.
 * Each branch of the tree is given a rectangle, which is then tiled with smaller rectangles representing sub-branches.
 * A leaf node's rectangle has an area proportional to a specified dimension on the data.
 * <p>
 * <p>
 * @author Marc Magon
 * @since 25 Dec 2015
 * @version 1.0
 */
public class JQXTreeMap extends Div<JQXTreeMapChildren, JQXTreeMapAttributes, JQXTreeMapFeature, JQXTreeMapEvents, JQXTreeMap>
{

    private static final long serialVersionUID = 1L;
    private JQXTreeMapFeature feature;

    public JQXTreeMap()
    {
        addFeature(getFeature());
    }

    public JQXTreeMapFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXTreeMapFeature(this);
        }
        return feature;
    }

    @Override
    public JQXTreeMapOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
