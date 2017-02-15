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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
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
 * @param <J>
 *
 * @since 2012/10/01
 */
public class TableRow<J extends TableRow>
        extends Component<TableRowChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements TableChildren, TableHeaderGroupChildren, TableBodyGroupChildren, TableFooterGroupChildren
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
