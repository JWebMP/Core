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

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.H2;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * A content div for the vertical Timeline
 * @author GedMarc
 * @since Oct 24, 2016
 * 
 */
public class VerticalTimelineContent extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, VerticalTimelineContent> implements IVerticalTimelineContent
{
    /**
     * The header of the time-line block
     */
    private H2 header;
    /**
     * The actual text for the block
     */
    private Paragraph text;
    /**
     * The link for the read more text
     */
    private Link readMoreLink;
    /**
     * A span showing the date of the occurance
     */
    private Span spanText;
    
    private static final long serialVersionUID = 1L;

    public VerticalTimelineContent()
    {
        addClass("cd-timeline-content");
    }
    
    /**
     * Returns the vertical time-line content as only a content
     * @return 
     */
    public IVerticalTimelineContent asVerticalTimelineContent()
    {
        return this;
    }

    @Override
    public void preConfigure()
    {
        if(!isConfigured())
        {
            add(getHeader());
            add(getText());
            add(getReadMoreLink());
            add(getSpanText());
        }
        super.preConfigure();
    }
    
    /**
     * Returns the header object
     * @return 
     */
    @Override
    public H2 getHeader()
    {
        if(this.header == null)
        {
            setHeader(new H2(""));
        }
        return header;
    }

    /**
     * Sets the header object
     * @param header 
     */
    @Override
    public void setHeader(H2 header)
    {
        this.header = header;
    }

    /**
     * Returns the text object 
     * @return 
     */
    @Override
    public Paragraph getText()
    {
        return text;
    }

    /**
     * Sets the text object
     * @param text 
     */
    @Override
    public void setText(Paragraph text)
    {
        this.text = text;
    }

    /**
     * Changes the default action of set text to the correct way for the time-line
     * @param text the text to apply
     * @return this
     */
    @Override
    public VerticalTimelineContent setText(String text)
    {
        setText(new Paragraph(text));
        return this;
    }
    
    /**
     * The link for the read more
     * @return 
     */
    @Override
    public Link getReadMoreLink()
    {
        if(readMoreLink == null)
        {
            setReadMoreLink(new Link());
        }
        return readMoreLink;
    }

    /**
     * Sets the read more link
     * @param readMoreLink 
     */
    @Override
    public void setReadMoreLink(Link readMoreLink)
    {
        this.readMoreLink = readMoreLink;
        if(this.readMoreLink != null)
        {
            this.readMoreLink.addClass("cd-read-more");
        }
    }

    /**
     * Gets the span for where the date displays
     * @return 
     */
    @Override
    public Span getSpanText()
    {
        if(spanText == null)
        {
            setSpanText(new Span());
        }
        return spanText;
    }

    /**
     * Sets the span for where the date displays
     * @param spanText 
     */
    @Override
    public void setSpanText(Span spanText)
    {
        this.spanText = spanText;
        if(this.spanText != null)
        {
            this.spanText.addClass("cd-date");
        }
    }
}
