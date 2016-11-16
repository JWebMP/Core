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
package za.co.mmagon.jwebswing.components.c3;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * An implementation of the C3 Graphs project.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class C3 extends Div<C3Children, C3Attributes, C3Features, C3Events, C3>
{

    private static final long serialVersionUID = 1L;
    private C3Feature feature;

    public C3()
    {
        addFeature(getFeature());
    }

    public final C3Feature getFeature()
    {
        if (feature == null)
        {
            feature = new C3Feature(this);
        }
        return feature;
    }

    public C3Options getOptions()
    {
        return getFeature().getOptions();
    }

}
