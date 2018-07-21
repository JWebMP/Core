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
package com.jwebmp.core.htmlbuilder.css.tables;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 * The look of an HTML table can be greatly improved with CSS:
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class TableCSSImpl
		extends CSSImplementationAdapter<TableCSS, TableCSSImpl>
		implements CSSImplementationClass<TableCSS, TableCSSImpl>
{

	private static final long serialVersionUID = 1L;
	@CSSDetail(cssName = "border-collapse",
			cssVersion = CSSVersions.CSS21)
	private TableBorderCollapse borderCollapse;
	@CSSDetail(cssName = "table-caption-side",
			cssVersion = CSSVersions.CSS21)
	private TableCaptionSides tableCaptionSide;
	@CSSDetail(cssName = "border-spacing",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl borderSpacing;

	/**
	 * Constructs a new Table CSS class
	 */
	public TableCSSImpl()
	{
		//Nothing needed
	}

	/**
	 * Specifies whether or not table borders should be collapsed
	 *
	 * @return
	 */
	public TableBorderCollapse getBorderCollapse()
	{
		return borderCollapse;
	}

	/**
	 * Specifies whether or not table borders should be collapsed
	 *
	 * @param borderCollapse
	 */
	public void setBorderCollapse(TableBorderCollapse borderCollapse)
	{
		this.borderCollapse = borderCollapse;
	}

	/**
	 * Where to place the caption
	 *
	 * @return
	 */
	public TableCaptionSides getTableCaptionSide()
	{
		return tableCaptionSide;
	}

	/**
	 * Sets which side the caption must be on
	 *
	 * @param tableCaptionSide
	 */
	public void setTableCaptionSide(TableCaptionSides tableCaptionSide)
	{
		this.tableCaptionSide = tableCaptionSide;
	}

	/**
	 * What the border spacing should be
	 *
	 * @return
	 */
	public MeasurementCSSImpl getBorderSpacing()
	{
		return borderSpacing;
	}

	/**
	 * Specifies whether or not table borders should be collapsed
	 *
	 * @param borderSpacing
	 */
	public void setBorderSpacing(MeasurementCSSImpl borderSpacing)
	{
		this.borderSpacing = borderSpacing;
	}

}
