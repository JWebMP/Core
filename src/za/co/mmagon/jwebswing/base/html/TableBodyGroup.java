package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.html.interfaces.children.TableChildren;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableBodyGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;tbody&gt; tag is used to group the body content in an HTML table.<p>
 * <p>
 * The &lt;tbody&gt; element is used in conjunction with the &lt;thead&gt; and &lt;tfoot&gt; elements to specify each part of a table (body, header, footer)
 * .<p>
 * <p>
 * Browsers can use these elements to enable scrolling of the table body independently of the header and footer. Also, when printing a large table that spans multiple pages, these elements can enable
 * the table header and footer to be printed at the top and bottom of each page.<p>
 * <p>
 * The &lt;tbody&gt; tag must be used in the following context: As a child of a &lt;table&gt; element, after any &lt;caption&gt;, &lt;colgroup&gt;, and &lt;thead&gt; elements.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &lt;tbody&gt; Yes Yes Yes Yes Yes<p>
 * Tips and Notes<p>
 * <p>
 * Note: The &lt;tbody&gt; element must have one or more &lt;tr&gt; tags inside.<p>
 * <p>
 * Tip: The &lt;thead&gt;, &lt;tbody&gt;, and &lt;tfoot&gt; elements will not affect the layout of the table by default. However, you can use CSS to style these elements.<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * None of the HTML 4.01 attributes are supported in HTML5.<p>
 *
 *
 * @author Marc Magon
 * @since forever
 * @version 1.0
 */
public class TableBodyGroup extends Component<TableBodyGroupChildren, NoAttributes, GlobalFeatures, GlobalEvents, TableBodyGroup> implements TableChildren<NoAttributes>
{
    /**
     * Constructs a new instance of a table body group
     */
    public TableBodyGroup()
    {
        super(ComponentTypes.TableBodyGroup);
    }
}
