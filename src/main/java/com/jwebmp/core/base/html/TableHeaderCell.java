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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.TableCellAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.TableRowChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

import jakarta.validation.constraints.NotNull;

/**
 * A Basic Table Cell Component<p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The td tag is supported in all major browsers.
 * <p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The td tag defines a standard cell in an HTML table.<p>
 * <p>
 * An HTML table has two kinds of cells:
 * <p>
 * <p>
 * Header cells - contains header information (created with the th element) Standard cells - contains data (created with the td element)
 * <p>
 * <p>
 * The text in th elements are bold and centered by default.<p>
 * <p>
 * The text in td elements are regular and left-aligned by default.
 * <p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use the colspan and rowspan attribute to let the content span over multiple columns or rows! Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Some HTML 4.01 attributes are not supported in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * @since 2012/10/01
 */
public class TableHeaderCell<J extends TableHeaderCell<J>>
		extends Component<IComponentHierarchyBase, TableCellAttributes, GlobalFeatures, GlobalEvents, J>
		implements TableRowChildren<IComponentHierarchyBase, J>
{

	/**
	 * Constructs a normal table cell
	 */
	public TableHeaderCell()
	{
		this((GlobalChildren) null);
	}

	/**
	 * Constructs a table cell with the given child.
	 *
	 * @param dataDisplay
	 * 		The component that is a child
	 */
	public TableHeaderCell(GlobalChildren dataDisplay)
	{
		super(ComponentTypes.TableCell);
		if (dataDisplay != null)
		{
			add((Component) dataDisplay);
		}
		setTag("th");
	}

	/**
	 * A paragraph as a child. Good for testing or Render on Load
	 *
	 * @param dataDisplay
	 */
	public TableHeaderCell(String dataDisplay)
	{
		this(new Paragraph<>(dataDisplay)
				     .setTextOnly(true));
	}

	/**
	 * Returns this table cell column span
	 *
	 * @return Integer of Column Span
	 */
	public int getColumnSpan()
	{
		String s = getAttribute(TableCellAttributes.ColSpan);
		if (s == null || s.isEmpty())
		{
			s = "0";
		}
		return Integer.parseInt(s);
	}

	/**
	 * @param columnSpan
	 * 		Sets this table cells column span
	 */
	@SuppressWarnings("unchecked")
	public J setColumnSpan(int columnSpan)
	{
		addAttribute(TableCellAttributes.ColSpan, columnSpan);
		return (J) this;
	}

	/**
	 * Gets this table cells row span
	 *
	 * @return Integer of Row Span
	 */
	public int getRowSpan()
	{
		return Integer.parseInt(getAttribute(TableCellAttributes.RowSpan));
	}

	/**
	 * Sets this objects row span
	 *
	 * @param rowSpan
	 * 		Integer that is row span
	 */
	@SuppressWarnings("unchecked")
	public J setRowSpan(int rowSpan)
	{
		addAttribute(TableCellAttributes.RowSpan, Integer.toString(rowSpan));
		return (J) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J add(@NotNull String textToAdd)
	{
		setText(textToAdd);
		return (J) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public J add(String textToAdd, boolean inline)
	{
		setText(textToAdd);
		return (J) this;
	}
}
