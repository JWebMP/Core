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
package za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.image.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
public class BackgroundCSSImpl implements BackgroundCSS
{
    @CSSDetail(cssName = "background-attachment",cssVersion = CSSVersions.CSS21,jsName = "backgroundAttachment")
    private BackgroundAttachments Background_Attachment;
    @CSSDetail(cssName = "background-color",cssVersion = CSSVersions.CSS21,jsName = "backgroundColor")
    private ColourCSS BackgroundColor;
    @CSSDetail(cssName = "background-color",cssVersion = CSSVersions.CSS21,jsName = "backgroundColor")
    private ColourNames Background_Color$;
    @CSSDetail(cssName = "background-image",cssVersion = CSSVersions.CSS21,jsName = "backgroundImage")
    private ImageCSS Background_Image;
    @CSSDetail(cssName = "background-image",cssVersion = CSSVersions.CSS21,jsName = "backgroundImage")
    private ImageCSS[] Background_Image$;
    @CSSDetail(cssName = "background-position",cssVersion = CSSVersions.CSS21,jsName = "backgroundPosition")
    private BackgroundPositions Background_Position;
    @CSSDetail(cssName = "background-repeat",cssVersion = CSSVersions.CSS21,jsName = "backgroundRepeat")
    private Repeats Background_Repeat;
    @CSSDetail(cssName = "background-blendmode",cssVersion = CSSVersions.CSS21,jsName = "backgroundBlendmode")
    private BackgroundBlendMode Background_BlendMode;
    @CSSDetail(cssName = "background-clip",cssVersion = CSSVersions.CSS21,jsName = "backgroundClip")
    private BackgroundClip Background_Clip;
    @CSSDetail(cssName = "background-attachment",cssVersion = CSSVersions.CSS21,jsName = "backgroundAttachment")
    private BackgroundOrigins Background_Origin;
    @CSSDetail(cssName = "background-attachment",cssVersion = CSSVersions.CSS21,jsName = "backgroundAttachment")
    private BackgroundSizes Background_Size$;
    @CSSDetail(cssName = "background-attachment",cssVersion = CSSVersions.CSS21,jsName = "backgroundAttachment")
    private MeasurementCSS[] Background_Size;
    @CSSDetail(cssName = "background-attachment",cssVersion = CSSVersions.CSS21,jsName = "backgroundAttachment")
    private Background Background;

    /**
     * Specifies the background color of an element
     *
     * @return
     */
    @Override
    public ColourCSS BackgroundColor()
    {
        return BackgroundColor;
    }

    /**
     * Specifies the background color of an element
     *
     * @return
     */
    @Override
    public ColourNames Background_Color$()
    {
        return Background_Color$;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @return
     */
    @Override
    public ImageCSS Background_Image()
    {
        return Background_Image;
    }

    /**
     * Specifies the position of a background image
     *
     * @return
     */
    @Override
    public BackgroundPositions Background_Position()
    {
        return Background_Position;
    }

    /**
     * Sets how a background image will be repeated
     *
     * @return
     */
    @Override
    public Repeats Background_Repeat()
    {
        return Background_Repeat;
    }

    /**
     * Specifies the blending mode of each background layer (color/image)
     *
     * @return
     */
    @Override
    public BackgroundBlendMode Background_BlendMode()
    {
        return Background_BlendMode;
    }

    /**
     * Specifies the painting area of the background
     *
     * @return
     */
    @Override
    public BackgroundClip Background_Clip()
    {
        return Background_Clip;
    }

    /**
     * Specifies where the background image(s) is/are positioned
     *
     * @return
     */
    @Override
    public BackgroundOrigins Background_Origin()
    {
        return Background_Origin;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @return
     */
    @Override
    public MeasurementCSS[] Background_Size()
    {
        return Background_Size;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @return
     */
    @Override
    public BackgroundSizes Background_Size$()
    {
        return Background_Size$;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return BackgroundCSS.class;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @return
     */
    @Override
    public ImageCSS[] Background_Image$()
    {
        return Background_Image$;
    }

    /**
     * Sets whether a background image is fixed or scrolls with the rest of the page
     */
    @Override
    public BackgroundAttachments Background_Attachment()
    {
        return Background_Attachment;
    }

    /**
     * Sets whether a background image is fixed or scrolls with the rest of the page
     */
    public void setBackground_Attachment(BackgroundAttachments Background_Attachment)
    {
        this.Background_Attachment = Background_Attachment;
    }

    /**
     * Specifies the background color of an element
     *
     * @param BackgroundColor
     */
    public void setBackgroundColor(ColourCSS BackgroundColor)
    {
        this.BackgroundColor = BackgroundColor;
    }

    /**
     * Specifies the background color of an element
     *
     * @param Background_Color$
     */
    public void setBackground_Color$(ColourNames Background_Color$)
    {
        this.Background_Color$ = Background_Color$;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @param Background_Image
     */
    public void setBackground_Image(ImageCSS Background_Image)
    {
        this.Background_Image = Background_Image;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @param Background_Image$
     */
    public void setBackground_Image$(ImageCSS[] Background_Image$)
    {
        this.Background_Image$ = Background_Image$;
    }

    /**
     * Specifies the position of a background image
     *
     * @param Background_Position
     */
    public void setBackground_Position(BackgroundPositions Background_Position)
    {
        this.Background_Position = Background_Position;
    }

    /**
     * Sets how a background image will be repeated
     *
     * @param Background_Repeat
     */
    public void setBackground_Repeat(Repeats Background_Repeat)
    {
        this.Background_Repeat = Background_Repeat;
    }

    /**
     * Specifies the blending mode of each background layer (color/image)
     *
     * @param Background_BlendMode
     */
    public void setBackground_BlendMode(BackgroundBlendMode Background_BlendMode)
    {
        this.Background_BlendMode = Background_BlendMode;
    }

    /**
     * Specifies the painting area of the background
     *
     * @param Background_Clip
     */
    public void setBackground_Clip(BackgroundClip Background_Clip)
    {
        this.Background_Clip = Background_Clip;
    }

    /**
     * Specifies where the background image(s) is/are positioned
     *
     * @param Background_Origin
     */
    public void setBackground_Origin(BackgroundOrigins Background_Origin)
    {
        this.Background_Origin = Background_Origin;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @param Background_Size$
     */
    public void setBackground_Size$(BackgroundSizes Background_Size$)
    {
        this.Background_Size$ = Background_Size$;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @param Background_Size
     */
    public void setBackground_Size(MeasurementCSS[] Background_Size)
    {
        this.Background_Size = Background_Size;
    }

    /**
     * Set different background properties in one declaration
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.Background Background()
    {
        return Background;
    }

    /**
     * Set different background properties in one declaration
     *
     * @param Background
     */
    public void setBackground(za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.Background Background)
    {
        this.Background = Background;
    }

}
