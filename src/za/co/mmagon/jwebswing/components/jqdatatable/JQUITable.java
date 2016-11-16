package za.co.mmagon.jwebswing.components.jqdatatable;

import za.co.mmagon.jwebswing.base.html.Table;
import za.co.mmagon.jwebswing.base.html.TableBodyGroup;
import za.co.mmagon.jwebswing.base.html.TableCaption;
import za.co.mmagon.jwebswing.base.html.TableFooterGroup;
import za.co.mmagon.jwebswing.base.html.TableHeaderGroup;
import za.co.mmagon.jwebswing.base.html.TableRow;
import za.co.mmagon.jwebswing.base.html.attributes.TableAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.components.jqueryUI.tabs.JQUITabsChildren;

/**
 * The JWDataTable implementation
 *
 * @param <T> The table row type this table reflects
 * @since 2014 09 30
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class JQUITable<T extends TableRow> extends Table implements JQUITabsChildren, GlobalChildren
{

    private static final long serialVersionUID = 1L;
    /**
     * The header grouping for a data table
     */
    private TableHeaderGroup headerGroup;
    /**
     * The footer grouping for a data table
     */
    private TableFooterGroup footerGroup;
    /**
     * The table grouping for a data table
     */
    private TableBodyGroup bodyGroup;
    /**
     * The caption item for a table
     */
    private TableCaption captionOfTable;

    /**
     * Construct a new interactive table that is theme compatible, with cell spacing and padding as 0
     * <p>
     * @param headerGroup The table header group creating for
     */
    public JQUITable(TableHeaderGroup headerGroup)
    {
        addAttribute(TableAttributes.CellSpacing, 0);
        addAttribute(TableAttributes.CellPadding, 0);
        this.headerGroup = headerGroup;

    }

    /**
     * Gets the header group for this Data Table
     *
     * @return
     */
    public TableHeaderGroup getHeaderGroup()
    {
        if (headerGroup == null)
        {
            headerGroup = new TableHeaderGroup();
        }
        if (!getChildren().contains(headerGroup))
        {
            add(headerGroup);
        }
        return headerGroup;
    }

    /**
     * Gets the footer group for this data table
     *
     * @return
     */
    public TableFooterGroup getFooterGroup()
    {

        if (footerGroup == null)
        {
            footerGroup = new TableFooterGroup();
        }
        if (!getChildren().contains(footerGroup))
        {
            add(footerGroup);
        }
        return footerGroup;
    }

    /**
     * Gets the body group for this data table
     *
     * @return
     */
    public TableBodyGroup getBodyGroup()
    {
        if (bodyGroup == null)
        {
            bodyGroup = new TableBodyGroup();
        }
        if (!getChildren().contains(bodyGroup))
        {
            add(bodyGroup);
        }
        return bodyGroup;
    }

    /**
     * Returns the Table Caption associated with this object plus positioning utilities
     *
     * @return
     */
    public TableCaption getCaptionOfTable()
    {
        if (captionOfTable == null)
        {
            captionOfTable = new TableCaption(null);
        }
        return captionOfTable;
    }

    /**
     * Sets the header group for this table
     * <p>
     * @param headerGroup
     */
    public void setHeaderGroup(TableHeaderGroup headerGroup)
    {
        this.headerGroup = headerGroup;
    }

    /**
     * sets the footer group for this table
     * <p>
     * @param footerGroup
     */
    public void setFooterGroup(TableFooterGroup footerGroup)
    {
        this.footerGroup = footerGroup;
    }

    /**
     * Sets the body group for the table
     * <p>
     * @param bodyGroup
     */
    public void setBodyGroup(TableBodyGroup bodyGroup)
    {
        this.bodyGroup = bodyGroup;
    }

    /**
     * Sets the caption for the table
     */
    public void setCaptionOfTable(TableCaption captionOfTable)
    {
        this.captionOfTable = captionOfTable;
    }
}
