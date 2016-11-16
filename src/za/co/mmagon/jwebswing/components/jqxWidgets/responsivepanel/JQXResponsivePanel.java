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
package za.co.mmagon.jwebswing.components.jqxWidgets.responsivepanel;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxResponsivePanel represents a panel widget with a responsive behaviour.
 * The responsive panel collapses when the browser window's width becomes less than a set value (collapseBreakpoint) and the
 * panel is then accessible by clicking a button.
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXResponsivePanel extends Div<JQXResponsivePanelChildren, JQXResponsivePanelAttributes, JQXResponsivePanelFeature, JQXResponsivePanelEvents, JQXResponsivePanel>
{

    private static final long serialVersionUID = 1L;
    private JQXResponsivePanelFeature feature;

    public JQXResponsivePanel()
    {
        addFeature(getFeature());
    }

    public JQXResponsivePanelFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXResponsivePanelFeature(this);
        }
        return feature;
    }

    @Override
    public JQXResponsivePanelOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
