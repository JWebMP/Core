package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.TableCellAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableRowChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

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
 * @author Marc Magon
 * @version 1.0
 * @since 2012/10/01
 */
public class TableCell extends Component<GlobalChildren, TableCellAttributes, GlobalFeatures, GlobalEvents, TableCell> implements TableRowChildren<TableCellAttributes>
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
            add(GlobalChildren.class.cast(dataDisplay));
        }
    }

    /**
     * A paragraph as a child. Good for testing or Render on Load
     *
     * @param dataDisplay
     */
    public TableCell(String dataDisplay)
    {
        this(new Paragraph(dataDisplay));
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
        return new Integer(s);
    }

    /**
     *
     * @param columnSpan Sets this table cells column span
     */
    public void setColumnSpan(int columnSpan)
    {
        addAttribute(TableCellAttributes.ColSpan, columnSpan);
    }

    /**
     * Gets this table cells row span
     *
     * @return Integer of Row Span
     */
    public int getRowSpan()
    {

        return new Integer(getAttribute(TableCellAttributes.RowSpan));
    }

    /**
     * Sets this objects row span
     *
     * @param rowSpan Integer that is row span
     */
    public void setRowSpan(int rowSpan)
    {
        addAttribute(TableCellAttributes.RowSpan, Integer.toString(rowSpan));
    }
}
