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
package za.co.mmagon.jwebswing.components.jqxwidgets.panel;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;

/**
 * The jqxPanel widget represents a jQuery Panel widget. This widget is a container for other widgets or elements. It automatically adds horizontal and vertical scrollbars, if the content is not fully
 * visible
 * <p>
 * @author Marc Magon
 * @since 20 Dec 2015
 * @version 1.0
 */
public class JQXPanel extends Div<GlobalChildren, JQXPanelAttributes, JQXPanelFeatures, JQXPanelEvents, JQXPanel> //JQXPanelChildrenvv
{

    private static final long serialVersionUID = 1L;
    private JQXPanelFeature feature;

    public JQXPanel()
    {
        addFeature(getFeature());
        addClass("JQXPanel");
    }

    public JQXPanelFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXPanelFeature(this);
        }
        return feature;
    }

    @Override
    public final JQXPanelOptions getOptions()
    {
        return getFeature().getOptions();
    }
}
