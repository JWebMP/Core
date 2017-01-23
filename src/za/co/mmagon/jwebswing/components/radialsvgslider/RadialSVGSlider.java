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
package za.co.mmagon.jwebswing.components.radialsvgslider;

import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListStyleType;

/**
 * An implementation of the Radial SVG Slider.
 * <p>
 * Customized to be generic. https://codyhouse.co/gem/radial-svg-slider/
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class RadialSVGSlider extends Div<RadialSVGSliderChildren, RadialSVGSliderAttributes, RadialSVGSliderFeatures, RadialSVGSliderEvents, RadialSVGSlider>
{

    private static final long serialVersionUID = 1L;
    private RadialSVGSliderFeature feature;

    @ListCSS(ListStyleType = ListStyleType.none)

    private RadialSVGSliderList radialSliderList;

    public RadialSVGSlider()
    {
        addFeature(getFeature());
        addClass("cd-radial-slider-wrapper");
        addAttribute(GlobalAttributes.Style, "margin-top: 0px;margin-bottom: 0px;");
    }

    /**
     * Adds a face to this
     *
     * @param content The content div to add
     *
     * @return
     */
    public RadialSVGSliderListItem addFace(Div content)
    {
        return addFace(content, "");
    }

    /**
     * Adds a face to this
     *
     * @param content       The content div to add
     * @param backgroundUrl The background image URL to apply
     *
     * @return
     */
    public RadialSVGSliderListItem addFace(Div content, String backgroundUrl)
    {
        RadialSVGSliderListItem li = new RadialSVGSliderListItem();
        li.setContent(content);
        if (backgroundUrl != null)
        {
            li.setFaceBackgroundImageUrl(backgroundUrl);
        }
        getRadialSliderList().add(li);
        return li;
    }

    /**
     * Returns the radial slider list
     *
     * @return
     */
    public RadialSVGSliderList getRadialSliderList()
    {
        if (radialSliderList == null)
        {
            setRadialSliderList(new RadialSVGSliderList());
        }
        return radialSliderList;
    }

    /**
     * Sets the radial slider list
     *
     * @param radialSliderList
     */
    public void setRadialSliderList(RadialSVGSliderList radialSliderList)
    {
        remove(this.radialSliderList);
        this.radialSliderList = radialSliderList;
        if (this.radialSliderList != null)
        {
            this.radialSliderList.addClass("cd-radial-slider");
            this.radialSliderList.addAttribute(RadialSVGSliderListAttributes.Radius1, 60);
            this.radialSliderList.addAttribute(RadialSVGSliderListAttributes.Radius2, 1364);
            this.radialSliderList.addAttribute(RadialSVGSliderListAttributes.CenterX1, 110);
            this.radialSliderList.addAttribute(RadialSVGSliderListAttributes.CenterX2, 1290);
            this.radialSliderList.addAttribute(GlobalAttributes.Style, "margin-top: 0px;margin-bottom: 0px;padding-left:0");
            add(this.radialSliderList);
        }
    }

    /**
     * Renders the default stuff that doesn't need to be built
     *
     * @return
     */
    @Override
    protected StringBuilder renderAfterChildren()
    {
        return new StringBuilder(getNewLine() + getNewLine()
                + getCurrentTabIndentString() + "\t" + "<ul class=\"cd-radial-slider-navigation\" style=\"list-style-type:none;\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "<li><a href=\"#0\" class=\"next\">Next</a></li>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "<li><a href=\"#0\" class=\"prev\">Prev</a></li>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "</ul> <!-- .cd-radial-slider-navigation -->" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "<div class=\"cd-round-mask\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "<svg viewBox=\"0 0 1400 800\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "<defs>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "<mask id=\"cd-left-mask\" height='800px' width=\"1400px\" x=\"0\" y=\"0\" maskUnits=\"userSpaceOnUse\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "\t" + "<path fill=\"white\" d=\"M0,0v800h1400V0H0z M110,460c-33.137,0-60-26.863-60-60s26.863-60,60-60s60,26.863,60,60S143.137,460,110,460z\"/>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "</mask>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "<mask id=\"cd-right-mask\" height='800px' width=\"1400px\" x=\"0\" y=\"0\" maskUnits=\"userSpaceOnUse\">" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "\t" + "<path fill=\"white\" d=\"M0,0v800h1400V0H0z M1290,460c-33.137,0-60-26.863-60-60s26.863-60,60-60s60,26.863,60,60S1323.137,460,1290,460z\"/>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "\t" + "</mask>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "\t" + "</defs>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "\t" + "</svg>" + getNewLine()
                + getCurrentTabIndentString() + "\t" + "</div>");
    }

    /**
     * Sets the classes correctly on the children
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            int size = getRadialSliderList().getChildren().size();
            if (size > 0)
            {
                getRadialSliderList().getChildren().get(0).addClass("visible");
            }
            if (size > 1)
            {
                getRadialSliderList().getChildren().get(1).addClass("next-slide");
                getRadialSliderList().getChildren().get(size - 1).addClass("prev-slide");
            }
        }
        super.preConfigure();
    }

    public final RadialSVGSliderFeature getFeature()
    {
        if (feature == null)
        {
            feature = new RadialSVGSliderFeature(this);
        }
        return feature;
    }

    @Override
    public RadialSVGSliderOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Creates a default slide
     *
     * @param headerText  The header text of the slide
     * @param defaultText The default text of the slide
     * @param linkUrl     The link for the main button
     * @param linkText    the text for the link
     *
     * @return
     */
    public static Div createDefaultSlide(String headerText, String defaultText, String linkUrl, String linkText)
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

}
