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
package za.co.mmagon.jwebswing.components.newcomponents;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * An implementation of the jsTree project.
 * <p>
 * @author Marc Magon
 * @since 13 Jan 2017
 * @version 1.0
 */
public class BlankComponent extends Div<BlankComponentChildren, BlankComponentAttributes, BlankComponentFeatures, BlankComponentEvents, BlankComponent>
{

    private static final long serialVersionUID = 1L;
    private BlankComponentFeature feature;

    public BlankComponent()
    {
        addFeature(getFeature());
    }

    public final BlankComponentFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BlankComponentFeature(this);
        }
        return feature;
    }

    @Override
    public BlankComponentOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
