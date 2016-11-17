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
package za.co.mmagon.jwebswing.components.jqxwidgets.rating;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxRating represents a jQuery UI widget that allows you to choose a rating.
 * You can configure the jqxRating items size, image and the number of displayed items
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXRating extends Div<JQXRatingChildren, JQXRatingAttributes, JQXRatingFeature, JQXRatingEvents, JQXRating>
{

    private static final long serialVersionUID = 1L;
    private JQXRatingFeature feature;

    public JQXRating()
    {
        addFeature(getFeature());
    }

    public JQXRatingFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXRatingFeature(this);
        }
        return feature;
    }

    @Override
    public JQXRatingOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
