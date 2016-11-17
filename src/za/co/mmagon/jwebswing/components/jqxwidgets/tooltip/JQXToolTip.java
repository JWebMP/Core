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
package za.co.mmagon.jwebswing.components.jqxwidgets.tooltip;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxTooltip represents a jQuery widget that displays a popup message.
 * The widget can be used in combination with any html element. You just need to call the jqxTooltip's 'add' method and pass the
 * html element as parameter.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXToolTip extends Div<JQXToolTipChildren, JQXToolTipAttributes, JQXToolTipFeature, JQXToolTipEvents, JQXToolTip>
{

    private static final long serialVersionUID = 1L;
    private JQXToolTipFeature feature;

    public JQXToolTip()
    {
        addFeature(getFeature());
    }

    public JQXToolTipFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXToolTipFeature(this);
        }
        return feature;
    }

    @Override
    public JQXToolTipOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
