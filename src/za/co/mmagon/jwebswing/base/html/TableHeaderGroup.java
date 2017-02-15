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
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableHeaderGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The thead tag is supported in all major browsers.<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The thead tag is used to group header content in an HTML table.<p>
 * <p>
 * The thead element is used in conjunction with the tbody and tfoot elements to specify each part of a table (header, body, footer)
 * .<p>
 * <p>
 * Browsers can use these elements to enable scrolling of the table body independently of the header and footer. Also, when printing a large table that spans multiple pages, these elements can
 * enable<p>
 * the table header and footer to be printed at the top and bottom of each page.<p>
 * <p>
 * The thead tag must be used in the following context: As a child of a table element, after any caption, and colgroup elements, and before any tbody, tfoot, and tr elements. Tips and<p>
 * Notes<p>
 * <p>
 * Note: The thead element must have one or more tr tags inside.<p>
 * <p>
 * Tip: The thead, tbody, and tfoot elements will not affect the layout of the table by default. However, you can use CSS to style these elements. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * None of the HTML 4.01 attributes are supported in HTML5.<p>
 *
 * @author Marc Magon
 * @param <J>
 *
 * @since forever
 * @version 1.0
 */
public class TableHeaderGroup<J extends TableHeaderGroup>
        extends Component<TableHeaderGroupChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements TableChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new blank header group
     */
    public TableHeaderGroup()
    {
        super(ComponentTypes.TableHeaderGroup);
    }

}
