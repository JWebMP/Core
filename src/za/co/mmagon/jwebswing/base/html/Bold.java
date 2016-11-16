package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The b tag is supported in all major browsers.<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The b tag specifies bold text. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE. Tips and Notes<p>
 * <p>
 * Note: According to the HTML 5 specification, the b tag should be used as a LAST resort when no other tag is more appropriate. The HTML 5 specification states that headings should be denoted with<p>
 * the h1 to h6 tags, emphasized text should be denoted with the em tag, important text should be denoted with the strong tag, and marked/highlighted text should use the mark tag.<p>
 * <p>
 * Tip: You can also use the CSS "font-weight" property to set bold text.<p>
 * <p>
 * @author Marc Magon
 */
public class Bold extends Component<Component, NoAttributes, GlobalFeatures, GlobalEvents, Bold> implements ParagraphChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag
{

    /**
     * Constructs a bold section of text
     */
    public Bold()
    {
        this("");
        setTiny(true);
    }

    /**
     * Specifies the text as bold
     *
     * @param text
     */
    public Bold(String text)
    {
        super(ComponentTypes.Bold);
        setText(text);
    }
}
