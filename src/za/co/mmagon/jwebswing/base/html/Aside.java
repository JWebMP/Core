package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The aside tag defines some content aside from the content it is placed in.<p>
 * <p>
 * The aside content should be related to the surrounding content. Browser
 * Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully
 * supports the element.
 * <p>
 * Element aside 6.0 9.0 4.0 5.0 11.1
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The aside tag is new in HTML5. Tips and Notes<p>
 * <p>
 * Tip: The aside content could be placed as a sidebar in an article. Global
 * Attributes<p>
 * <p>
 * The aside tag also supports the Global Attributes in HTML. Event
 * Attributes<p>
 * <p>
 * The aside tag also supports the Event Attributes in HTML.<p>
 *
 * @since 2014/10/26
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class Aside extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, Aside> implements GlobalChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    /**
     * Logger for the Component
     */
    private static final org.apache.log4j.Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("Aside");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     * Constructs a new ASide with the given text set as Raw Text
     *
     * @param text The text for this ASide
     */
    public Aside(String text)
    {
        super(ComponentTypes.Aside.getComponentTag(), ComponentTypes.Aside);
        setText(text);
    }

}
