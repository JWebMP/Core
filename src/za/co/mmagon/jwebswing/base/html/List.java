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
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Defines the List HTML Tag<p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The ol tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The ol tag defines an ordered list. An ordered list can be numerical or alphabetical.<p>
 * <p>
 * Use the li tag to define list items. Tips and Notes<p>
 * <p>
 * Tip: For unordered list, use the ul tag.<p>
 * <p>
 * Tip: Use CSS to style lists. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "start" and "type" attributes were deprecated in HTML 4.01, but IS supported in HTML5.<p>
 * <p>
 * The "reversed" attribute is new in HTML5.<p>
 * <p>
 * The "compact" attribute is not supported in HTML5.<p>
 * <p>
 * @author Marc Magon
 * @param <C>
 * @param <A>
 * @param <E>
 * @param <J>
 */
public class List<C extends ListChildren, A extends Enum & AttributeDefinitions, E extends GlobalEvents, J extends List>
        extends Component<C, A, GlobalFeatures, E, J>
        implements ListChildren, DisplayObjectType, ListItemChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs an unordered list
     */
    public List()
    {
        this(false);
    }

    /**
     * Specifies if the list is ordered or unordered
     *
     * @param orderedList
     */
    public List(boolean orderedList)
    {
        super(orderedList ? "ol" : "ul", orderedList ? ComponentTypes.OrderedList : ComponentTypes.UnorderedList, false);
    }

    /**
     * Adds a list item to this list
     *
     * @param textToAdd
     *
     * @return
     */
    public ListItem addItem(String textToAdd)
    {
        ListItem li = new ListItem(textToAdd);
        add((C) li);
        return li;
    }

    /**
     * Returns a list of the specified text
     *
     * @param textToAdd
     *
     * @return
     */
    public List addList(String textToAdd)
    {
        ListItem lit = new ListItem(textToAdd);
        List li = new List(false);
        lit.add(li);
        add((C) lit);
        return li;
    }

}
