/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.htmlbuilder.css.backgrounds;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSSImpl;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.enumarations.Repeats;
import com.jwebmp.core.htmlbuilder.css.image.ImageCSSImpl;
import com.jwebmp.core.htmlbuilder.css.interfaces.CSSShortHand;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;

import java.util.Arrays;

/**
 * CSS Background Short Hand Object
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BackgroundImpl
		extends CSSImplementationAdapter<Background, BackgroundImpl>
		implements CSSShortHand, CSSImplementationClass<Background, BackgroundImpl>
{


	@CSSDetail(cssName = "background-attachment",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundAttachment")
	private BackgroundAttachments backgroundAttachment;
	@CSSDetail(cssName = "background-color",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundColor")
	private ColourCSSImpl backgroundColor;
	@CSSDetail(cssName = "background-color",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundColor")
	private ColourNames backgroundColor$;
	@CSSDetail(cssName = "background-image",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundImage")
	private ImageCSSImpl backgroundImage;
	@CSSDetail(cssName = "background-image",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundImage")
	private ImageCSSImpl[] backgroundImage$;
	@CSSDetail(cssName = "background-position",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundPosition")
	private BackgroundPositions backgroundPosition;
	@CSSDetail(cssName = "background-repeat",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundRepeat")
	private Repeats backgroundRepeat;
	@CSSDetail(cssName = "background-clip",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundClip")
	private BackgroundClip backgroundClip;
	@CSSDetail(cssName = "background-origins",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundOrigins")
	private BackgroundOrigins backgroundOrigin;
	@CSSDetail(cssName = "background-size",
			cssVersion = CSSVersions.CSS21,
			jsName = "backgroundSize")
	private MeasurementCSSImpl[] backgroundSize;

	@Override
	public String toString()
	{
		String output = backgroundColor +
		                StaticStrings.STRING_SPACE +
		                backgroundColor$ +
		                StaticStrings.STRING_SPACE +
		                backgroundImage +
		                StaticStrings.STRING_SPACE +
		                backgroundPosition +
		                StaticStrings.STRING_SPACE +
		                Arrays.toString(
				                backgroundSize) +
		                StaticStrings.STRING_SPACE +
		                backgroundRepeat +
		                StaticStrings.STRING_SPACE +
		                backgroundOrigin +
		                StaticStrings.STRING_SPACE +
		                backgroundClip +
		                StaticStrings.STRING_SPACE +
		                backgroundAttachment;
		output = output.replaceAll("null", "");
		output = output.trim();
		return output;
	}

	/**
	 * Specifies the background color of an element
	 *
	 * @return
	 */
	public ColourCSSImpl getBackgroundColor()
	{
		return backgroundColor;
	}

	/**
	 * Sets the background colour
	 *
	 * @param backgroundColor
	 */
	public void setBackgroundColor(ColourCSSImpl backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	/**
	 * Specifies the background color of an element
	 *
	 * @return
	 */
	public ColourNames getBackgroundColor$()
	{
		return backgroundColor$;
	}

	/**
	 * Sets the background colour
	 *
	 * @param backgroundColor$
	 */
	public void setBackgroundColor$(ColourNames backgroundColor$)
	{
		this.backgroundColor$ = backgroundColor$;
	}

	/**
	 * Specifies one or more background images for an element
	 *
	 * @return
	 */
	public ImageCSSImpl getBackgroundImage()
	{
		return backgroundImage;
	}

	/**
	 * Sets the background image
	 *
	 * @param backgroundImage
	 */
	public void setBackgroundImage(ImageCSSImpl backgroundImage)
	{
		this.backgroundImage = backgroundImage;
	}

	/**
	 * Specifies the position of a background image
	 *
	 * @return
	 */
	public BackgroundPositions getBackgroundPosition()
	{
		return backgroundPosition;
	}

	/**
	 * Sets the background position
	 *
	 * @param backgroundPosition
	 */
	public void setBackgroundPosition(BackgroundPositions backgroundPosition)
	{
		this.backgroundPosition = backgroundPosition;
	}

	/**
	 * Sets how a background image will be repeated
	 *
	 * @return
	 */
	public Repeats getBackgroundRepeat()
	{
		return backgroundRepeat;
	}

	/**
	 * Sets the background repeat
	 *
	 * @param backgroundRepeat
	 */
	public void setBackgroundRepeat(Repeats backgroundRepeat)
	{
		this.backgroundRepeat = backgroundRepeat;
	}

	/**
	 * Specifies the painting area of the background
	 *
	 * @return
	 */
	public BackgroundClip getBackgroundClip()
	{
		return backgroundClip;
	}

	/**
	 * Sets the background clip
	 *
	 * @param backgroundClip
	 */
	public void setBackgroundClip(BackgroundClip backgroundClip)
	{
		this.backgroundClip = backgroundClip;
	}

	/**
	 * Specifies where the background image(s) is/are positioned
	 *
	 * @return
	 */
	public BackgroundOrigins getBackgroundOrigin()
	{
		return backgroundOrigin;
	}

	/**
	 * Sets the background clip
	 *
	 * @param backgroundOrigin
	 */
	public void setBackgroundOrigin(BackgroundOrigins backgroundOrigin)
	{
		this.backgroundOrigin = backgroundOrigin;
	}

	/**
	 * Specifies the size of the background image(s)
	 *
	 * @return
	 */
	public MeasurementCSSImpl[] getBackgroundSize()
	{
		return backgroundSize;
	}

	/**
	 * Sets the background size
	 *
	 * @param backgroundSize
	 */
	public void setBackgroundSize(MeasurementCSSImpl[] backgroundSize)
	{
		this.backgroundSize = backgroundSize;
	}

	/**
	 * Specifies one or more background images for an element
	 *
	 * @return
	 */
	public ImageCSSImpl[] getBackgroundImage$()
	{
		return backgroundImage$;
	}

	/**
	 * Sets the background image
	 *
	 * @param backgroundImage$
	 */
	public void setBackgroundImage$(ImageCSSImpl[] backgroundImage$)
	{
		this.backgroundImage$ = backgroundImage$;
	}

	/**
	 * Sets whether a background image is fixed or scrolls with the rest of the page
	 *
	 * @return
	 */
	public BackgroundAttachments getBackgroundAttachment()
	{
		return backgroundAttachment;
	}

	/**
	 * Sets the background attachment
	 *
	 * @param backgroundAttachment
	 */
	public void setBackgroundAttachment(BackgroundAttachments backgroundAttachment)
	{
		this.backgroundAttachment = backgroundAttachment;
	}

}
