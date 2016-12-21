package za.co.mmagon.jwebswing.base.html;

import java.io.Serializable;
import za.co.mmagon.logger.LogFactory;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.AbbreviationAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.AbbreviationChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;abbr&gt; tag indicates an abbreviation or an acronym, like "WWW" or "NATO".
 * <p>
 * By marking up abbreviations you can give useful information to browsers, spell checkers, translation systems and search-engine indexers.
 * Browser Support Element &lt;abbr&gt; Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: The global title attribute can be used in the &gt;abbr&lt; tag to show the full version of the abbreviation/acronym when you mouse over the &lt;abbr&gt; element.
 * <p>
 * Differences Between HTML 4.01
 * and HTML5
 * <p>
 * NONE. Global Attributes
 * <p>
 * The &lt;abbr&gt; tag also supports the Global Attributes in HTML. Event Attributes
 * <p>
 * The &lt;abbr&gt; tag also supports the Event Attributes in HTML.
 * <p>
 * Default CSS Settings
 * <p>
 * None.
 * <p>
 * @since Forever
 * @version
 * @author MMagon
 * <p>
 *
 */
public class Abbreviation extends Component<AbbreviationChildren, AbbreviationAttributes, GlobalFeatures, GlobalEvents, Abbreviation> implements NoNewLineBeforeClosingTag, NoNewLineForRawText, Serializable
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("Abbreviation");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     * Constructs a new Abbreviation Tag
     */
    public Abbreviation()
    {
        super(ComponentTypes.Abbreviation.getComponentTag(), ComponentTypes.Abbreviation);
    }
}
