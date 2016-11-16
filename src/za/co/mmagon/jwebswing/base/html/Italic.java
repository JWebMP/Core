package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;i;&gt; tag defines a part of text in an alternate voice or mood. The content of the &lt;i;&gt; tag is usually displayed in italic.<p>
 * <p>
 * The &lt;i;&gt; tag can be used to indicate a technical term, a phrase from another language, a thought, or a ship name, etc.<p>
 * <p>
 * Use the &lt;i;&gt; element only when there is not a more appropriate semantic element, such as:
 * <p>
 * <p>
 * &lt;em&gt; (emphasized text)
 * <p>
 * &lt;strong&gt; (important text)
 * <p>
 * &lt;mark&gt; (marked/highlighted text)
 * <p>
 * &lt;cite&gt; (the title of a work)
 * <p>
 * &lt;dfn&gt; (a definition term)
 * <p>
 * <p>
 * Browser Support Element<p>
 * &lt;i;&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * In HTML 4.01, the &lt;i;&gt; tag was used to render text in italics. However, this is not necessarily the case with HTML5. Style sheets can be used to format the text inside the &lt;i;&gt;
 * element.<p>
 * <p>
 * @author Marc Magon
 */
public class Italic extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, Italic>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag, ParagraphChildren, GlobalChildren, ListItemChildren
{

    /**
     * Constructs a new paragraph child of Italic
     */
    public Italic()
    {
        this(null);
    }

    /**
     * *
     * Constructs a new italic section with the given text
     * <p>
     * @param text
     */
    public Italic(String text)
    {
        super(ComponentTypes.Italic);
        setText(text);
    }

}
