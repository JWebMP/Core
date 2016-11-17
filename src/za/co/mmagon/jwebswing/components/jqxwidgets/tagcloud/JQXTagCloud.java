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
package za.co.mmagon.jwebswing.components.jqxwidgets.tagcloud;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxTagCloud is a jQuery widget is a flexible UI component that displays a collection of user-generated tags accompanying the articles, posts, or videos on your website.
 * Each tag has weight value which corresponds to its popularity, importance or recurrence on the page.
 * The keywords in the cloud can have their own URL which navigates to a collection of items associated with the relevant tag.
 * The user can easily customize the appearance of the control, choose the items that will be displayed in the cloud, their font size and color, sort the tags alphabetically or by value, in ascending
 * or descending order.
 * <p>
 * @author Marc Magon
 * @since 24 Dec 2015
 * @version 1.0
 */
public class JQXTagCloud extends Div<JQXTagCloudChildren, JQXTagCloudAttributes, JQXTagCloudFeature, JQXTagCloudEvents, JQXTagCloud>
{

    private static final long serialVersionUID = 1L;
    private JQXTagCloudFeature feature;

    public JQXTagCloud()
    {
        addFeature(getFeature());
    }

    public JQXTagCloudFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXTagCloudFeature(this);
        }
        return feature;
    }

    @Override
    public JQXTagCloudOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
