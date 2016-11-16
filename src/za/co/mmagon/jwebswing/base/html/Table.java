package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.TableAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The table tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The table tag defines an HTML table.<p>
 * <p>
 * An HTML table consists of the table element and one or more tr, th, and td elements.<p>
 * <p>
 * The tr element defines a table row, the th element defines a table header, and the td element defines a table cell.<p>
 * <p>
 * A more complex HTML table may also include caption, col, colgroup, thead, tfoot, and tbody elements. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 only supports the "border" attribute, and its value can be "1" or ""
 * .<p>
 * <p>
 * @author Marc Magon
 */
public class Table extends Component<TableChildren, TableAttributes, GlobalFeatures, GlobalEvents, Table>
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs an Empty Table
     */
    public Table()
    {
        super("table", ComponentTypes.Table, false);
    }

    /**
     * Returns the cell spacing
     * <p>
     * @return
     */
    public int getCellSpacing()
    {
        return getAttribute(TableAttributes.CellSpacing, 0);
    }

    /**
     * Sets the cell spacing
     * <p>
     * @param cellSpacing
     */
    public void setCellSpacing(int cellSpacing)
    {
        addAttribute(TableAttributes.CellSpacing, cellSpacing);
    }

    /**
     * Returns the cell padding
     * <p>
     * @return
     */
    public int getCellPadding()
    {
        return getAttribute(TableAttributes.CellSpacing, 0);
    }

    /**
     * Sets the cell padding
     * <p>
     * @param cellPadding
     */
    public void setCellPadding(int cellPadding)
    {
        addAttribute(TableAttributes.CellPadding, cellPadding);
    }
}
