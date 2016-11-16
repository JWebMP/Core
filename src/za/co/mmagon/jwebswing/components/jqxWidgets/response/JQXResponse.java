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
package za.co.mmagon.jwebswing.components.jqxWidgets.response;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxResponse is a plug-in which provides information about the OS, Browser, View Port, Device Type and common features of the Device like Touch Support, Size, SVG, Canvas and VML support, etc.
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXResponse extends Div<JQXResponseChildren, JQXResponseAttributes, JQXResponseFeature, JQXResponseEvents, JQXResponse>
{

    private static final long serialVersionUID = 1L;
    private JQXResponseFeature feature;

    public JQXResponse()
    {
        addFeature(getFeature());
    }

    public JQXResponseFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXResponseFeature(this);
        }
        return feature;
    }

    @Override
    public JQXResponseOptions getOptions()
    {
        return getFeature().getOptions();
    }
}
