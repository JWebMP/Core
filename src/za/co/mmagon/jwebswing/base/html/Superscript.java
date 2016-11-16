package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.PhraseChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * Definition and Usage<p>
 *<p>
 * The &lt;sup&gt; tag defines superscript text.<p>
 * <P>
 * Superscript text appears half a character above the normal line, and is sometimes rendered in a smaller font.<p>
 * <P>
 * Superscript text can be used for footnotes, like WWW[1]<p>
 * .<P>
 * <P>
 * Tip: Use the &lt;sub&gt; tag to define subscript text.<P>
 * Browser Support<p>
 * <P>
 * Element &lt;sup&gt; Yes Yes Yes Yes Yes<p>
 * <P>
 * Differences Between HTML 4.01 and HTML5<P>
 *<p>
 * NONE.<p>
 *
 * @author Marc Magon
 * @since forever
 * @version 1.0
 */
public class Superscript extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, Superscript> implements NoNewLineBeforeClosingTag,NoNewLineForRawText,ParagraphChildren,PhraseChildren
{
    /**
     Constructs and empty super script tag
     */
    public Superscript()
    {
        this(null);
    }

    /**
     * Constructs a new superscript tag with the given raw text
     * @param text 
     */
    public Superscript(String text)
    {
        super("sup", ComponentTypes.SuperScript);
        setText(text);
    }
}
