package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableRowChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryui.themes.JQUIThemeBlocks;

/**
 * Browser Support
 * <p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The th tag is supported in all major browsers.
 * <p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The th tag defines a header cell in an HTML table.<p>
 * <p>
 * An HTML table has two kinds of cells:
 * <p>
 * <p>
 * Header cells - contains header information (created with the th element) Standard cells - contains data (created with the td element)
 * <p>
 * <p>
 * The text in th elements are bold and centered by default.<p>
 * <p>
 * The text in td elements are regular and left-aligned by default.
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use the colspan and rowspan attribute to let the content span over multiple columns or rows! Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Some HTML 4.01 attributes are not supported in HTML5.<p>
 *
 * @author MMagon
 * @since Forever
 * @version 1.0
 */
public class TableHeader extends Component<Component, NoAttributes, GlobalFeatures, GlobalEvents, TableHeader>
        implements TableChildren<NoAttributes>, TableRowChildren<NoAttributes>, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    /**
     * Constructs an empty Table Header
     */
    public TableHeader()
    {
        this(null);
    }

    /**
     * Constructs a new header with the given text
     *
     * @param headerText
     */
    public TableHeader(String headerText)
    {
        super(ComponentTypes.TableHeader);
        setText(headerText);
        /*
         *
         */
    }

    /**
     * *
     * Adds the theming classes to the header
     */
    public void addTheming()
    {
        addClass(JQUIThemeBlocks.UI_Widget_Header);
        addClass(JQUIThemeBlocks.UI_State_Hover);
        addClass(JQUIThemeBlocks.UI_Priority_Primary);
    }

    /**
     * Removes the default theming classes from the header
     */
    public void removeTheming()
    {
        /*
         * removeClass(JQUIThemeBlocks.UI_Widget_Header);
         * removeClass(JQUIThemeBlocks.UI_State_Hover);
         * removeClass(JQUIThemeBlocks.UI_Priority_Primary);
         */
    }
}
