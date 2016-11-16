package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.CodeAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.PhraseChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari
 * <p>
 * The code tag is supported in all major browsers. Definition and Usage
 * <p>
 * The code tag is a phrase tag. It defines a piece of computer code.
 * <p>
 * Tip: This tag is not deprecated, but it is possible to achieve richer effect with CSS.
 * <p>
 * <p>
 * Allowed Children :
 * <p>
 * All phrase tags: Tag Description<p>
 * &lt;em&gt; Renders as emphasized text<p>
 * &lt;strong&gt; Defines important text<p>
 * &lt;code&gt; Defines a piece of computer code<p>
 * &lt;samp&gt; Defines sample output from a computer program<p>
 * &lt;kbd&gt; Defines keyboard input<p>
 * &lt;var&gt; Defines a variable<p>
 * <p>
 * 1
 *
 * @author Marc Magon
 * @since Forever
 * @version 1.0
 */
public class Code extends Component<NoChildren, CodeAttributes, GlobalFeatures, GlobalEvents, Code> implements PhraseChildren
{

    /**
     * Constructs a new Code Objects
     */
    public Code()
    {
        super(ComponentTypes.Code);
        setTiny(true);
    }
}
