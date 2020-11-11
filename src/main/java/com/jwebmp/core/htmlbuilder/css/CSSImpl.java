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

package com.jwebmp.core.htmlbuilder.css;

import com.jwebmp.core.htmlbuilder.css.animatable.AnimateCSSImpl;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundCSSImpl;
import com.jwebmp.core.htmlbuilder.css.borders.BorderCSSImpl;
import com.jwebmp.core.htmlbuilder.css.displays.DisplayCSSImpl;
import com.jwebmp.core.htmlbuilder.css.fonts.FontsCSSImpl;
import com.jwebmp.core.htmlbuilder.css.heightwidth.HeightWidthCSSImpl;
import com.jwebmp.core.htmlbuilder.css.lists.ListCSSImpl;
import com.jwebmp.core.htmlbuilder.css.margins.MarginsCSSImpl;
import com.jwebmp.core.htmlbuilder.css.outline.OutlineCSSImpl;
import com.jwebmp.core.htmlbuilder.css.padding.PaddingCSSImpl;
import com.jwebmp.core.htmlbuilder.css.tables.TableCSSImpl;
import com.jwebmp.core.htmlbuilder.css.text.TextCSSImpl;

import jakarta.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is an object implementation of the CSS Annotations
 * <p>
 *
 * @author GedMarc
 * @since 2012/10/01
 */
public class CSSImpl
		extends CSSImplementationAdapter<CSS, CSSImpl>
		implements CSSImplementationClass<CSS, CSSImpl>
{


	/**
	 * The animation CSS
	 */
	private AnimateCSSImpl animatable;
	/**
	 * The getBackground css
	 */
	private BackgroundCSSImpl background;
	/**
	 * The getBorder CSS
	 */
	private BorderCSSImpl border;
	/**
	 * The getDisplay CSS
	 */
	private DisplayCSSImpl display;
	/**
	 * The font CSS
	 */
	private FontsCSSImpl font;
	/**
	 * The getDimensions CSS
	 */
	private HeightWidthCSSImpl dimensions;
	/**
	 * getList Style CSS
	 */
	private ListCSSImpl list;
	/**
	 * getMargin CSS
	 */
	private MarginsCSSImpl margins;
	/**
	 * getOutline CSS
	 */
	private OutlineCSSImpl outline;
	/**
	 * getPadding CSS
	 */
	private PaddingCSSImpl padding;
	/**
	 * getTable CSS
	 */
	private TableCSSImpl table;
	/**
	 * Text CSS
	 */
	private TextCSSImpl text;

	/**
	 * Construct a new instance
	 */
	public CSSImpl()
	{
		//No need to configure anything on startup
	}

	/**
	 * Returns all the maps of the underlying objects
	 *
	 * @return
	 */
	@Override
	public Map<StringBuilder, Object> getMap()
	{
		Map<StringBuilder, Object> returnable = new HashMap<>();
		returnable.putAll(getBackground().getMap());
		returnable.putAll(getDimensions().getMap());
		returnable.putAll(getMargins().getMap());
		returnable.putAll(getDisplay().getMap());
		returnable.putAll(getPadding().getMap());
		returnable.putAll(getText().getMap());
		returnable.putAll(getBorder().getMap());
		returnable.putAll(getFont().getMap());
		returnable.putAll(getList().getMap());
		returnable.putAll(getOutline().getMap());
		returnable.putAll(getTable().getMap());
		returnable.putAll(getAnimatable().getMap());
		return returnable;
	}

	/**
	 * Gets the background css
	 *
	 * @return
	 */
	@NotNull
	public BackgroundCSSImpl getBackground()
	{
		if (background == null)
		{
			background = new BackgroundCSSImpl();
		}
		return background;
	}

	/**
	 * Sets the background object
	 *
	 * @param background
	 */
	public void setBackground(BackgroundCSSImpl background)
	{
		this.background = background;
	}

	/**
	 * Returns dimension settings for the object
	 *
	 * @return
	 */
	@NotNull
	public HeightWidthCSSImpl getDimensions()
	{
		if (dimensions == null)
		{
			dimensions = new HeightWidthCSSImpl();
		}
		return dimensions;
	}

	/**
	 * Returns the margins
	 *
	 * @return
	 */
	@NotNull
	public MarginsCSSImpl getMargins()
	{
		if (margins == null)
		{
			margins = new MarginsCSSImpl();
		}
		return margins;
	}

	/**
	 * Returns the display
	 *
	 * @return
	 */
	@NotNull
	public DisplayCSSImpl getDisplay()
	{
		if (display == null)
		{
			display = new DisplayCSSImpl();
		}
		return display;
	}

	/**
	 * Returns the padding
	 *
	 * @return
	 */
	@NotNull
	public PaddingCSSImpl getPadding()
	{
		if (padding == null)
		{
			padding = new PaddingCSSImpl();
		}
		return padding;
	}

	/**
	 * Returns the text
	 *
	 * @return
	 */
	@NotNull
	public TextCSSImpl getText()
	{
		if (text == null)
		{
			text = new TextCSSImpl();
		}
		return text;
	}

	/**
	 * Gets the border
	 *
	 * @return
	 */
	@NotNull
	public BorderCSSImpl getBorder()
	{
		if (border == null)
		{
			border = new BorderCSSImpl();
		}
		return border;
	}

	/**
	 * @return
	 */
	@NotNull
	public FontsCSSImpl getFont()
	{
		if (font == null)
		{
			font = new FontsCSSImpl();
		}
		return font;
	}

	/**
	 * Returns the list
	 *
	 * @return
	 */
	@NotNull
	public ListCSSImpl getList()
	{
		if (list == null)
		{
			list = new ListCSSImpl();
		}
		return list;
	}

	/**
	 * Returns the outline
	 *
	 * @return
	 */
	@NotNull
	public OutlineCSSImpl getOutline()
	{
		if (outline == null)
		{
			outline = new OutlineCSSImpl();
		}
		return outline;
	}

	/**
	 * Returns the table
	 *
	 * @return
	 */
	@NotNull
	public TableCSSImpl getTable()
	{
		if (table == null)
		{
			table = new TableCSSImpl();
		}
		return table;
	}

	/**
	 * Returns the animatable object
	 *
	 * @return
	 */
	@NotNull
	public AnimateCSSImpl getAnimatable()
	{
		if (animatable == null)
		{
			animatable = new AnimateCSSImpl();
		}
		return animatable;
	}

	/**
	 * Sets animatable object
	 *
	 * @param animatable
	 */
	public void setAnimatable(AnimateCSSImpl animatable)
	{
		this.animatable = animatable;
	}

	/**
	 * Sets the table object
	 *
	 * @param table
	 */
	public void setTable(TableCSSImpl table)
	{
		this.table = table;
	}

	/**
	 * Sets the outline object
	 *
	 * @param outline
	 */
	public void setOutline(OutlineCSSImpl outline)
	{
		this.outline = outline;
	}

	/**
	 * Sets the list object
	 *
	 * @param list
	 */
	public void setList(ListCSSImpl list)
	{
		this.list = list;
	}

	/**
	 * Sets the font object
	 *
	 * @param font
	 */
	public void setFont(FontsCSSImpl font)
	{
		this.font = font;
	}

	/**
	 * Sets the border object
	 *
	 * @param border
	 */
	public void setBorder(BorderCSSImpl border)
	{
		this.border = border;
	}

	/**
	 * Sets the text object
	 *
	 * @param text
	 */
	public void setText(TextCSSImpl text)
	{
		this.text = text;
	}

	/**
	 * Sets the padding object
	 *
	 * @param padding
	 */
	public void setPadding(PaddingCSSImpl padding)
	{
		this.padding = padding;
	}

	/**
	 * Sets the display object
	 *
	 * @param display
	 */
	public void setDisplay(DisplayCSSImpl display)
	{
		this.display = display;
	}

	/**
	 * Sets the margins object
	 *
	 * @param margins
	 */
	public void setMargins(MarginsCSSImpl margins)
	{
		this.margins = margins;
	}

	/**
	 * Sets the dimensions object
	 *
	 * @param dimensions
	 */
	public void setDimensions(HeightWidthCSSImpl dimensions)
	{
		this.dimensions = dimensions;
	}
}
