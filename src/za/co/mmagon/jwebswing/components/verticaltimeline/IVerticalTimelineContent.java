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

import za.co.mmagon.jwebswing.base.html.H2;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.html.Span;

/**
 *
 * @author GedMarc
 * @since Oct 24, 2016
 * 
 */
public interface IVerticalTimelineContent 
{

    /**
     * Returns the header object
     * @return
     */
    H2 getHeader();

    /**
     * The link for the read more
     * @return
     */
    Link getReadMoreLink();

    /**
     * Gets the span for where the date displays
     * @return
     */
    Span getSpanText();

    /**
     * Returns the text object
     * @return
     */
    Paragraph getText();

    /**
     * Sets the header object
     * @param header
     */
    void setHeader(H2 header);

    /**
     * Sets the read more link
     * @param readMoreLink
     */
    void setReadMoreLink(Link readMoreLink);

    /**
     * Sets the span for where the date displays
     * @param spanText
     */
    void setSpanText(Span spanText);

    /**
     * Sets the text object
     * @param text
     */
    void setText(Paragraph text);

    /**
     * Changes the default action of set text to the correct way for the time-line
     * @param text the text to apply
     * @return this
     */
    VerticalTimelineContent setText(String text);

}
