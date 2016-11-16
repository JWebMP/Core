package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * Definition and Usage
 * <p>
 * The &lt;sub&gt; tag defines subscript text.<p> 
 * Subscript text appears half a character below the normal line, and is sometimes rendered in a smaller font.<p>
 * Subscript text can be used for chemical
 * formulas, like H2O.
 * <p>
 *
Tip: Use the &lt;sup&gt; tag to define superscripted text.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &lt;sub&gt; Yes Yes Yes Yes Yes<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE.<p>
 * @author Marc Magon
 * @since forever
 * @version 1.0
 */
public class Subscript extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, Subscript> implements NoNewLineBeforeClosingTag,NoNewLineForRawText
{
    /**
     * Constructs an empty sub script
     */
    public Subscript()
    {
        this(null);
    }

    /**
     * Constructs a new subscript section with the relevant text as raw text
     * @param text 
     */
    public Subscript(String text)
    {
        super("sub", ComponentTypes.Subscript);
        setText(text);
    }

}
