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
package za.co.mmagon.jwebswing.components.jqxwidgets.tree;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.jqxwidgets.layout.JQXLayoutChildren;

/**
 * jqxTree represents a jQuery Tree widget that displays a hierarchical collection of items. You can populate it from 'UL' or by using its 'source' property.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXTree extends Div<JQXTreeChildren, JQXTreeAttributes, JQXTreeFeatures, JQXTreeEvents, JQXTree> implements JQXLayoutChildren
{

    private static final long serialVersionUID = 1L;
    private JQXTreeFeature feature;
    // private JQXPanelFeature panelFeature;

    public JQXTree()
    {
        addFeature(getFeature());
    }

    public JQXTreeFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXTreeFeature(this);
        }
        return feature;
    }

    @Override
    public JQXTreeOptions getOptions()
    {
        return getFeature().getOptions();
    }
}
