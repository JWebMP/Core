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
package za.co.mmagon.jwebswing.components.jqxwidgets.dockpanel;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * The jqxDockPanel widget represents a container for other widgets or elements.
 * <p>
 * It arranges its inner elements depending on the value of the 'dock' attribute.
 * The possible 'dock' attribute values are: 'left, right, top and bottom'.
 * Every UI widget from jQWidgets toolkit needs its JavaScript files to be included in order to work properly.
 * <p>
 * @author Marc Magon
 * @since 13 Dec 2015
 * @version 1.0
 */
public class JQXDockPanel extends Div<JQXDockPanelChildren, JQXDockPanelAttributes, JQXDockPanelFeature, JQXDockPanelEvents, JQXDockPanel>
{

    private static final long serialVersionUID = 1L;
    private JQXDockPanelFeature feature;

    public JQXDockPanel()
    {
        addFeature(getFeature());
    }

    public JQXDockPanelFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXDockPanelFeature(this);
        }
        return feature;
    }

    @Override
    public JQXDockPanelOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
