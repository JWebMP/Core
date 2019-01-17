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

package com.jwebmp.core.htmlbuilder.css.displays;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSEnumeration;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The display property defines how a certain HTML element should be displayed.
 * Default value: inline Inherited: no Version:
 * CSS1 JavaScript syntax: object.style.display="inline"
 *
 * @author GedMarc
 * @version 1.0
 * @since 2013/01/22
 */
@CSSAnnotationType
public enum Displays
		implements CSSEnumeration<Displays>
{
	/**
	 * Default value. Displays an element as an inline element (like &lt;span&gt;)
	 */
	Inline,
	/**
	 * Displays an element as a block element (like
	 * &lt;p&gt;
	 * )
	 */
	Block,
	/**
	 * Displays an element as an block_level flex container. New in CSS3
	 */
	Flex,
	/**
	 * Displays an element as an inline_level flex container. New in CSS3
	 */
	Inline_flex,
	/**
	 * The element is displayed as an inline_level table
	 */
	Inline_table,
	/**
	 * Let the element behave like a &lt;li&gt; element
	 */
	List_item,
	/**
	 * Displays an element as either block or inline, depending on context
	 */
	Run_in,
	/**
	 * Let the element behave like a &lt;table&gt; element
	 */
	Table,
	/**
	 * Let the element behave like a &lt;caption&gt; element
	 */
	Table_caption,
	/**
	 * Let the element behave like a &lt;colgroup&gt; element
	 */
	Table_column_group,
	/**
	 * Let the element behave like a &lt;thead&gt; element
	 */
	Table_header_group,
	/**
	 * Let the element behave like a &lt;tfoot&gt; element
	 */
	Table_footer_group,
	/**
	 * Let the element behave like a &lt;tbody&gt; element
	 */
	Table_row_group,
	/**
	 * Let the element behave like a &lt;td&gt; element
	 */
	Table_cell,
	/**
	 * Let the element behave like a &lt;col&gt; element
	 */
	Table_column,
	/**
	 * Let the element behave like a &lt;tr&gt; element
	 */
	Table_row,
	/**
	 * The element will not be displayed at all (has no effect on layout)
	 */
	None,
	/**
	 * Sets this property to its default value. Read about initial
	 */
	Initial,
	/**
	 * Inherits this property from its parent element. Read about inherit;
	 */
	Inherit,
	/**
	 * Sets this field as not set
	 */
	Unset;

	@Override
	public String getJavascriptSyntax()
	{
		return "style.display";
	}

	@Override
	public CSSVersions getCSSVersion()
	{
		return CSSVersions.CSS1;
	}

	@Override
	public String getValue()
	{
		return name();
	}

	@Override
	public Displays getDefault()
	{
		return Unset;
	}

	@Override
	public String toString()
	{
		return super.toString()
		            .toLowerCase()
		            .replaceAll("_", "-");
	}

}
