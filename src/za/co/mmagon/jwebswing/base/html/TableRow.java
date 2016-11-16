package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableBodyGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableFooterGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableHeaderGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableRowChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Component denoting TR of HTML<p>
 * Definition and Usage<p>
 * <p>
 * The &lt;tr&gt; tag defines a row in an HTML table.<p>
 * <p>
 * A &lt;tr&gt; element contains one or more &lt;th&gt; or &lt;td&gt; elements.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &lt;tr&gt; Yes Yes Yes Yes Yes<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * All the layout attributes are removed in HTML5.<p>
 *
 *
 *
 * @author Marc Magon
 * @version 1.0
 * @since 2012/10/01
 */
public class TableRow extends Component<TableRowChildren, NoAttributes, GlobalFeatures, GlobalEvents, TableRow> implements TableChildren<NoAttributes>, TableHeaderGroupChildren, TableBodyGroupChildren, TableFooterGroupChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new default table row with no Ajax support
     */
    public TableRow()
    {
        super(ComponentTypes.TableRow);
        setTiny(true);
    }
}
