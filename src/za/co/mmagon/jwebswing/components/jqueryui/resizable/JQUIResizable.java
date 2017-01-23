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
package za.co.mmagon.jwebswing.components.jqueryui.resizable;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;

/**
 *
 * @author Marc Magon
 * @since 07 Aug 2015
 * @version 1.0
 */
public class JQUIResizable extends Div<JQUIResizableChildren, NoAttributes, JQUIResizableFeatures, JQUIResizableEvents, JQUIResizable>
{

    private static final long serialVersionUID = 1L;
    private JQUIResizableFeature feature;

    /**
     * Adds the feature to the resizable
     */
    public JQUIResizable()
    {
        addFeature(feature = new JQUIResizableFeature(this));
    }

    /**
     * Returns the features options
     * <p>
     * @return
     */
    @Override
    public JQUIResizableOptions getOptions()
    {
        return feature.getOptions();
    }

    /**
     * Returns this feature
     *
     * @return
     */
    public JQUIResizableFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUIResizableFeature(this);
        }
        return feature;
    }

    /**
     * Sets this feature
     *
     * @param feature
     */
    public void setFeature(JQUIResizableFeature feature)
    {
        this.feature = feature;
    }
}
