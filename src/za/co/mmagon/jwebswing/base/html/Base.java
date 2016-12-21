package za.co.mmagon.jwebswing.base.html;

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.BaseAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * The Base Component
 * <p>
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 *
 * <p>
 *
 * Browser Support
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The base tag is supported in all major browsers. Definition and Usage
 * <p>
 * <p>
 * The base tag specifies the base URL/target for all relative URLs in a<p>
 * document.<p>
 * <p>
 * There can be at maximum one base element in a document, and it must be<p>
 * inside the head element. Tips and Notes<p>
 * <p>
 * Tip: Put the base tag as the first element inside the head element, so<p>
 * that other elements in the head section uses the information from the base<p>
 * element.<p>
 * <p>
 * Note: If the base tag is present, it must have either an href attribute or<p>
 * a target attribute, or both.<p>
 */
public class Base extends Component<NoChildren, BaseAttributes, NoFeatures, NoEvents, Component>
        implements NoIDTag, NoClosingTag, HeadChildren, NoClosingBracket, NoClassAttribute
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("Base");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     * Constructs a new Base
     */
    public Base()
    {
        super(ComponentTypes.Base);
    }

    /**
     * Differences Between HTML and XHTML
     * <p>
     * In HTML the base tag has no end tag.
     * <p>
     * In XHTML the base tag must be properly closed.
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        try
        {
            if (getPage().getBrowser().getHtmlVersion().name().startsWith("X"))
            {
                setInlineClosingTag(true);
            }
        }
        catch (Exception e)
        {
            log.log(Level.FINE, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
        }
    }

}
