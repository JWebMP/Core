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
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;li&gt; tag defines a list item.<p>
 * <p>
 * The &lt;li&gt; tag is used in ordered lists(&lt;ol&gt;), unordered lists (&lt;ul&gt;), and in menu lists (&lt;menu&gt;)
 * .<p>
 * Browser Support<p>
 * Element
 * <p>
 * &lt;li&gt; Yes Yes Yes Yes Yes<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "type" attribute is NOT supported in HTML5.<p>
 * s
 * <p>
 * The "value" attribute was deprecated in HTML 4.01, but IS supported in HTML5.<p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use CSS to define the type of list.<p>
 *
 * @author Marc Magon
 * @param <J>
 *
 * @since forever
 * @version 1.0
 */
public class ListItem<J extends ListItem>
        extends Component<ListItemChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements ListChildren, NoNewLineForRawText, ListItemChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a blank text List Item
     */
    public ListItem()
    {
        this("");

    }

    /**
     * Constructs a list item with the given text
     *
     * @param text
     */
    public ListItem(String text)
    {
        super(ComponentTypes.ListItem);
        setText(text);
    }

    /**
     * Returns a list item of the specified text
     *
     * @param textToAdd
     *
     * @return
     */
    public ListItemChildren addItem(String textToAdd)
    {
        ListItem li = new ListItem(textToAdd);
        add(li);
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
        super.add(li);
        return li;
    }
}
