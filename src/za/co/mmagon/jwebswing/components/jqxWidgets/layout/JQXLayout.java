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
package za.co.mmagon.jwebswing.components.jqxWidgets.layout;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxLayout represents a jQuery widget which allows the creation of complex layouts with panels that can be nested, resized, pinned, unpinned and closed.
 * <p>
 * @author Marc Magon
 * @since 15 Dec 2015
 * @version 1.0
 */
public class JQXLayout extends Div<JQXLayoutChildren, JQXLayoutAttributes, JQXLayoutFeature, JQXLayoutEvents, JQXLayout>
{

    private static final long serialVersionUID = 1L;
    private JQXLayoutFeature feature;

    public JQXLayout()
    {
        addFeature(getFeature());
    }

    public final JQXLayoutFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXLayoutFeature(this);
        }
        return feature;
    }

    @Override
    public JQXLayoutOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
