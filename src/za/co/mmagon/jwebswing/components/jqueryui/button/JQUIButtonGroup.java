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
package za.co.mmagon.jwebswing.components.jqueryui.button;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUIButtonGroup extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, JQUIButtonGroup>
{

    private static final long serialVersionUID = 1L;

    private JQUIButtonGroupFeature groupFeature;

    /**
     *
     */
    public JQUIButtonGroup()
    {
        addFeature(getGroupFeature());
    }

    /**
     * Returns the group feature associated with this button group
     * <p>
     * @return
     */
    public final JQUIButtonGroupFeature getGroupFeature()
    {
        if (groupFeature == null)
        {
            groupFeature = new JQUIButtonGroupFeature(this);
        }
        return groupFeature;
    }

    /**
     * Returns the options for this Button Group from the feature
     * <p>
     * @return
     */
    public JQUIButtonGroupOptions getOptions()
    {
        return getGroupFeature().getOptions();
    }

}
