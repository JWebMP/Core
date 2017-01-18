package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryui.sortable.JQUISortableChildren;
import za.co.mmagon.jwebswing.components.jqueryui.tabs.JQUITabsChildren;
import za.co.mmagon.jwebswing.components.jqxwidgets.dropdownlist.JQXDropDownListChildren;
import za.co.mmagon.jwebswing.components.jqxwidgets.menu.JQXMenuChildren;
import za.co.mmagon.jwebswing.components.jqxwidgets.ribbon.JQXRibbonChildren;

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
 */
public class List<C extends ListChildren, A extends Enum & AttributeDefinitions, J extends List>
        extends Component<C, A, GlobalFeatures, GlobalEvents, J>
        implements ListChildren, JQUITabsChildren, JQUISortableChildren, DisplayObjectType, JQXRibbonChildren, JQXDropDownListChildren,
        JQXMenuChildren, ListItemChildren
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
