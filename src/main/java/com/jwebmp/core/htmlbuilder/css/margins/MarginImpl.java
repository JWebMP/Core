/*
 * Copyright (C) 2017 Marc Magon
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
package com.jwebmp.core.htmlbuilder.css.margins;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.enumarations.MarginSetting;
import com.jwebmp.core.htmlbuilder.css.interfaces.CSSShortHand;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.jwebmp.core.utilities.StaticStrings;

/**
 * To shorten the code, it is possible to specify all the margin properties in one property.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class MarginImpl
		extends CSSImplementationAdapter<Margin, MarginImpl>
		implements CSSImplementationClass<Margin, MarginImpl>, CSSShortHand
{

	private static final long serialVersionUID = 1L;

	@CSSDetail(cssName = "margin-right",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl marginRight;
	@CSSDetail(cssName = "margin-right",
			cssVersion = CSSVersions.CSS21)
	private MarginSetting marginRight$;
	@CSSDetail(cssName = "margin-left",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl marginLeft;
	@CSSDetail(cssName = "margin-left",
			cssVersion = CSSVersions.CSS21)
	private MarginSetting marginLeft$;
	@CSSDetail(cssName = "margin-top",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl marginTop;
	@CSSDetail(cssName = "margin-top",
			cssVersion = CSSVersions.CSS21)
	private MarginSetting marginTop$;
	@CSSDetail(cssName = "margin-bottom",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl marginBottom;
	@CSSDetail(cssName = "margin-bottom",
			cssVersion = CSSVersions.CSS21)
	private MarginSetting marginBottom$;

	/**
	 * Creates a new instance of the margin impl
	 */
	public MarginImpl()
	{
		//No configuration needed
	}

	@Override
	public String toString()
	{
		String out = "";
		out += marginTop + StaticStrings.STRING_SPACE;
		out += marginTop$ + StaticStrings.STRING_SPACE;
		out += marginRight + StaticStrings.STRING_SPACE;
		out += marginRight$ + StaticStrings.STRING_SPACE;
		out += marginBottom + StaticStrings.STRING_SPACE;
		out += marginBottom$ + StaticStrings.STRING_SPACE;
		out += marginLeft + StaticStrings.STRING_SPACE;
		out += marginLeft$ + StaticStrings.STRING_SPACE;
		out = out.replaceAll("null", StaticStrings.STRING_EMPTY);
		out = out.trim();
		return out;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMarginRight()
	{
		return marginRight;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 * <p>
	 *
	 * @param marginRight
	 */
	public void setMarginRight(MeasurementCSSImpl marginRight)
	{
		this.marginRight = marginRight;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MarginSetting getMarginRight$()
	{
		return marginRight$;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 * <p>
	 *
	 * @param marginRight$
	 */
	public void setMarginRight$(MarginSetting marginRight$)
	{
		this.marginRight$ = marginRight$;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMarginLeft()
	{
		return marginLeft;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 * <p>
	 *
	 * @param marginLeft
	 */
	public void setMarginLeft(MeasurementCSSImpl marginLeft)
	{
		this.marginLeft = marginLeft;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MarginSetting getMarginLeft$()
	{
		return marginLeft$;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 * <p>
	 *
	 * @param marginLeft$
	 */
	public void setMarginLeft$(MarginSetting marginLeft$)
	{
		this.marginLeft$ = marginLeft$;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMarginTop()
	{
		return marginTop;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 * <p>
	 *
	 * @param marginTop
	 */
	public void setMarginTop(MeasurementCSSImpl marginTop)
	{
		this.marginTop = marginTop;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MarginSetting getMarginTop$()
	{
		return marginTop$;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @param marginTop$
	 */
	public void setMarginTop$(MarginSetting marginTop$)
	{
		this.marginTop$ = marginTop$;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMarginBottom()
	{
		return marginBottom;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @param marginBottom
	 */
	public void setMarginBottom(MeasurementCSSImpl marginBottom)
	{
		this.marginBottom = marginBottom;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @return
	 */
	public MarginSetting getMarginBottom$()
	{
		return marginBottom$;
	}

	/**
	 * The CSS margin properties set the size of the white space OUTSIDE the border.
	 *
	 * @param marginBottom$
	 */
	public void setMarginBottom$(MarginSetting marginBottom$)
	{
		this.marginBottom$ = marginBottom$;
	}
}
