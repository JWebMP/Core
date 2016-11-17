package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryui.tabs.JQUITabsChildren;

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
 * @since forever
 * @version 1.0
 */
public class ListItem extends Component<ListItemChildren, NoAttributes, GlobalFeatures, GlobalEvents, ListItem>
        implements ListChildren, JQUITabsChildren, NoNewLineForRawText, ListItemChildren
{

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
     * @return
     */
    @Override
    public ListItemChildren add(String textToAdd)
    {
        ListItem li = new ListItem(textToAdd);
        add(li);
        return li;
    }

    /**
     * Returns a list of the specified text
     *
     * @param textToAdd
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
