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

import com.google.common.base.Strings;
import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.TableCellAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.TableRowChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
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
 * @author GedMarc
 * @version 1.0
 * @since 2012/10/01
 */
@SuppressWarnings("MissingClassJavaDoc")
public class TableCell<J extends TableCell<J>>
        extends Component<GlobalChildren, TableCellAttributes, GlobalFeatures, GlobalEvents, J>
        implements TableRowChildren
{
    /**
     * Constructs a normal table cell
     */
    public TableCell()
    {
        this((GlobalChildren) null);
    }

    /**
     * Constructs a table cell with the given child.
     *
     * @param dataDisplay The component that is a child
     */
    public TableCell(GlobalChildren dataDisplay)
    {
        super(ComponentTypes.TableCell);
        if (dataDisplay != null)
        {
            add(dataDisplay);
        }
    }

    /**
     * A paragraph as a child. Good for testing or Render on Load
     *
     * @param dataDisplay The display for the table cell
     */
    public TableCell(String dataDisplay)
    {
        this((GlobalChildren) null);
        setText(dataDisplay);
    }

    /**
     * Returns this table cell column span
     *
     * @return Integer of Column Span
     */
    public int getColumnSpan()
    {
        String s = getAttribute(TableCellAttributes.ColSpan);
        if (Strings.isNullOrEmpty(s))
        {
            s = "0";
        }
        return Integer.parseInt(s);
    }

    /**
     * @param columnSpan Sets this table cells column span
     */
    @NotNull
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
     * @param rowSpan Integer that is row span
     */
    @NotNull
    @SuppressWarnings("unchecked")
    public J setRowSpan(int rowSpan)
    {
        addAttribute(TableCellAttributes.RowSpan, Integer.toString(rowSpan));
        return (J) this;
    }

    @Override
    public J bind(String variableName)
    {
        setText("{{" + variableName + "}}");
        return (J) this;
    }
}
