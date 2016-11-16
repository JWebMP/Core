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
package za.co.mmagon.jwebswing.components.radialsvgslider;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.H2;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.utilities.GUIDGenerator;

/**
 * A default SVG slider list item(face) that renders
 *
 * @author GedMarc
 * @since Oct 26, 2016
 *
 */
public class RadialSVGSliderListItem extends ListItem
{

    private static final long serialVersionUID = 1L;

    /**
     * The background image URL to use
     */
    private String faceBackgroundImageUrl = "bower_components/radial-svg-slider-jwebswing/img/img-1.jpg";
    private String clipPathUniqueID;
    private String circleUniqueID; 
    
    /**
     * The content container
     */
    private Div contentContainer;
    /**
     * The content wrapper
     */
    private Div contentWrapper;
    /**
     * The physical content
     */
    private Div content;

    /**
     * Constructs a new face (list item) for the Radial SVG Slider 
     */
    public RadialSVGSliderListItem()
    {
        clipPathUniqueID = GUIDGenerator.generateGuid();
        circleUniqueID = GUIDGenerator.generateGuid();
    }

    @Override
    public void preConfigure()
    {
        if(!isConfigured())
        {
            if(getChildren().isEmpty())
            {
               getContent(); //force the build of the wrapper
            }
            getPage().setjQueryEnabled(true);
        }
        
        super.preConfigure();
    }
  
    /**
     * Generates the SVG syntax for the face 
     * @return 
     */
    @Override
    protected StringBuilder renderBeforeChildren()
    {
        return new StringBuilder(getNewLine() 
                + getCurrentTabIndentString() + "\t" + "<div class=\"svg-wrapper\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "<svg viewBox=\"0 0 1400 800\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "<title>Animated SVG</title>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "<defs>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "<clipPath id=\"" + clipPathUniqueID + "\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "\t" + "<circle id=\"" + circleUniqueID + "\" cx=\"110\" cy=\"400\" r=\"1364\"/>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "</clipPath>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "</defs>" + getNewLine()
                + getCurrentTabIndentString() + "" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "<image height='800px' width=\"1400px\" clip-path=\"url(#" + clipPathUniqueID + ")\" xlink:href=\"" + getFaceBackgroundImageUrl() + "\"></image>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "</svg>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "</div>" + getNewLine());
    }

    /**
     * Returns the background image URL assigned
     *
     * @return
     */
    public String getFaceBackgroundImageUrl()
    {
        return faceBackgroundImageUrl;
    }

    /**
     * Sets the face background image URL
     *
     * @param faceBackgroundImageUrl
     */
    public void setFaceBackgroundImageUrl(String faceBackgroundImageUrl)
    {
        this.faceBackgroundImageUrl = faceBackgroundImageUrl;
    }

    /**
     * Returns the contentContainer div. Never Null
     * @return 
     */
    protected Div getContentContainer()
    {
        if(contentContainer == null)
        {
            setContentContainer(new Div());
        }
        return contentContainer;
    }

    /**
     * Sets the contentContainer Div
     * @param contentContainer 
     */
    protected void setContentContainer(Div contentContainer)
    {
        this.contentContainer = contentContainer;
        if(this.contentContainer != null)
        {
            this.contentContainer.addClass("cd-radial-slider-content");
            add(contentContainer);
        }
    }

    /**
     * Returns the contentContainer wrapper
     * @return 
     */
    protected Div getContentWrapper()
    {
        if(contentWrapper == null)
        {
            setContentWrapper(new Div());
        }
        return contentWrapper;
    }

    /**
     * Sets the contentContainer wrapper
     * @param contentWrapper 
     */
    protected void setContentWrapper(Div contentWrapper)
    {
        this.contentWrapper = contentWrapper;
        if(this.contentWrapper != null)
        {
            this.contentWrapper.addClass("wrapper");
            getContentContainer().add(this.contentWrapper);
        }
    }

    /**
     * Returns the content. Never null
     * @return 
     */
    public Div getContent()
    {
        if(this.content == null)
        {
            setContent(new Div());
        }
        return content;
    }

    /**
     * Sets the content.
     * @param content 
     */
    public void setContent(Div content)
    {
        this.content = content;
        if(this.content != null)
        {
            getContentWrapper().add(this.content);
        }
    }
    
    /**
     * Creates a default slide
     * @param headerText The header text of the slide
     * @param defaultText The default text of the slide
     * @param linkUrl The link for the main button
     * @param linkText the text for the link
     * @return 
     */
    public static Div createDefaultSlide(String headerText, String defaultText,String linkUrl, String linkText)
    {
        Div d = new Div();
        H2 hText = new H2(headerText);
        Paragraph p = new Paragraph(defaultText);
        Link newLink = new Link(linkUrl);
        newLink.addClass("cd-btn");
        newLink.setText(linkText);
        
        d.add(hText);
        d.add(p);
        d.add(newLink);
        return d;
    }

    /**
     * Returns the current id given to the clip path element
     * @return 
     */
    public String getClipPathUniqueID()
    {
        return clipPathUniqueID;
    }

    /**
     * Sets the unique id given to the clip path element
     * @param clipPathUniqueID 
     */
    public void setClipPathUniqueID(String clipPathUniqueID)
    {
        this.clipPathUniqueID = clipPathUniqueID;
    }

    /**
     * Gets the unique id assigned to the circles
     * @return 
     */
    public String getCircleUniqueID()
    {
        return circleUniqueID;
    }

    /**
     * Sets the assigned numbers to the circles
     * @param circleUniqueID 
     */
    public void setCircleUniqueID(String circleUniqueID)
    {
        this.circleUniqueID = circleUniqueID;
    }
    
}
