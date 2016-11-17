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
package za.co.mmagon.jwebswing.components.jqxwidgets.splitter;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * AjqxSplitter represents a widget consisting of a moveable split bar(s) that divides a container's display area into two or more resizable and collapsible panels.
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXSplitter extends Div<JQXSplitterChildren, JQXSplitterAttributes, JQXSplitterFeature, JQXSplitterEvents, JQXSplitter>
{

    private static final long serialVersionUID = 1L;
    private JQXSplitterFeature feature;

    public JQXSplitter()
    {
        addFeature(getFeature());
    }

    public JQXSplitterFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXSplitterFeature(this);
        }
        return feature;
    }

    @Override
    public JQXSplitterOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
