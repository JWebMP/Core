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
package za.co.mmagon.jwebswing.htmlbuilder.css.outline;

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * An outline is a line drawn around an element - outside the border. This can be use to make an element "stand out".
 * <p>
 * The CSS outline properties specify the style, color, and width of an outline.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class OutlineCSSImpl extends CSSImplementationAdapter<OutlineCSS, OutlineCSSImpl> implements CSSImplementationClass<OutlineCSS, OutlineCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "outline-color", cssVersion = CSSVersions.CSS21)
    private ColourCSSImpl outlineColor;
    @CSSDetail(cssName = "outline-color", cssVersion = CSSVersions.CSS21)
    private ColourNames outlineColor$;
    @CSSDetail(cssName = "outline-style", cssVersion = CSSVersions.CSS21)
    private BorderStyles outlineStyle;
    @CSSDetail(cssName = "outline-width", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl outlineWidth;
    @CSSDetail(cssName = "outline-offset", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl outlineOffset;

    public OutlineCSSImpl()
    {
    }

    /**
     * Sets the color of an outline
     *
     * @return
     */
    public ColourCSSImpl getOutlineColor()
    {
        return outlineColor;
    }

    /**
     * Sets the color of an outline
     *
     * @return
     */
    public ColourNames getOutlineColor$()
    {
        return outlineColor$;
    }

    /**
     * Sets the Outline Style
     *
     * @return
     */
    public BorderStyles getOutlineStyle()
    {
        return outlineStyle;
    }

    /**
     * Sets the outline Width
     *
     * @return
     */
    public MeasurementCSSImpl getOutlineWidth()
    {
        return outlineWidth;
    }

    /**
     * Sets the outline Offset
     *
     * @return
     */
    public MeasurementCSSImpl getOutlineOffset()
    {
        return outlineOffset;
    }

    /**
     * Sets the outline Color
     *
     * @param outlineColor
     */
    public void setOutlineColor(ColourCSSImpl outlineColor)
    {
        this.outlineColor = outlineColor;
    }

    /**
     * Sets the outline Color
     *
     * @param outlineColor$
     */
    public void setOutlineColor$(ColourNames outlineColor$)
    {
        this.outlineColor$ = outlineColor$;
    }

    /**
     * Sets the Outline Style
     *
     * @param outlineStyle
     */
    public void setOutlineStyle(BorderStyles outlineStyle)
    {
        this.outlineStyle = outlineStyle;
    }

    /**
     * Sets the outline width
     *
     * @param outlineWidth
     */
    public void setOutlineWidth(MeasurementCSSImpl outlineWidth)
    {
        this.outlineWidth = outlineWidth;
    }

    /**
     * Sets the outline offset
     *
     * @param outlineOffset
     */
    public void setOutlineOffset(MeasurementCSSImpl outlineOffset)
    {
        this.outlineOffset = outlineOffset;
    }

}
