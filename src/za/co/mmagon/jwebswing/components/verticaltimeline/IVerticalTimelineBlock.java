/*
 * Copyright (C) 2016 GedMarc
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

package za.co.mmagon.jwebswing.components.verticaltimeline;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Div;

/**
 *
 * @author GedMarc
 * @since Oct 24, 2016
 * 
 */
public interface IVerticalTimelineBlock 
{

    /**
     * Returns the content div. Never null
     *
     * @return
     */
    VerticalTimelineContent getContent();

    /**
     * Returns this image component.
     * May return null
     *
     * @return
     */
    Component getImageComponent();

    /**
     * Gets the image container. Never null
     * @return
     */
    Div getImageContainer();

    /**
     * Sets the content div
     *
     * @param content
     */
    void setContent(VerticalTimelineContent content);

    /**
     * Sets this image component
     *
     * @param imageComponent
     */
    void setImageComponent(Component imageComponent);

    /**
     * Sets the image container
     * @param imageContainer
     */
    void setImageContainer(Div imageContainer);

}
