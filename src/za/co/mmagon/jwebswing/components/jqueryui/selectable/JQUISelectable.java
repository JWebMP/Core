/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryui.selectable;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.components.jqueryui.selectmenu.JQUISelectMenuChildren;

/**
 *
 * @author GedMarcs
 * @since Mar 17, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUISelectable extends Div<JQUISelectMenuChildren, NoAttributes, JQUISelectableFeatures, JQUISelectableEvents, JQUISelectable>
{

    private static final long serialVersionUID = 1L;
    private JQUISelectableFeature feature;

    /**
     *
     */
    public JQUISelectable()
    {
        addFeature(feature = new JQUISelectableFeature(this));
    }

    /**
     * Returns the features options
     * <p>
     * @return
     */
    public JQUISelectableOptions getOptions()
    {
        return feature.getOptions();
    }

    public JQUISelectableFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUISelectableFeature(this);
        }
        return feature;
    }

    public void setFeature(JQUISelectableFeature feature)
    {
        this.feature = feature;
    }

}
