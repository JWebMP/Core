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
package za.co.mmagon.jwebswing.components.jqxwidgets.draw;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxDraw is a small jQuery-based plugin which allows you to draw shapes and texts using VML, SVG and HTML5.
 * <p>
 * @author Marc Magon
 * @since 13 Dec 2015
 * @version 1.0
 */
public class JQXDraw extends Div<JQXDrawChildren, JQXDrawAttributes, JQXDrawFeature, JQXDrawEvents, JQXDraw>
{

    private static final long serialVersionUID = 1L;
    private JQXDrawFeature feature;

    public JQXDraw()
    {
        addFeature(getFeature());
    }

    public JQXDrawFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXDrawFeature(this);
        }
        return feature;
    }

    @Override
    public JQXDrawOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
