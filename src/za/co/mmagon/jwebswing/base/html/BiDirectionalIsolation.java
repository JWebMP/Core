package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * bdi stands for Bi-directional Isolation.<p>
 * <p>
 * The &gt;bdi&lt; tag isolates a part of text that might be formatted in a<p>
 * different direction from other text outside it.<p>
 * <p>
 * This element is useful when embedding user-generated content with an unknown<p>
 * directionality. Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully<p>
 * supports the element. Element &gt;bdi&lt; 16.0 Not supported 10.0 Not<p>
 * supported Not supported<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &gt;bdi&lt; tag is new in HTML5.<p>
 *
 * @author Marc Magon
 */
public class BiDirectionalIsolation extends Component<Component, NoAttributes, GlobalFeatures, GlobalEvents, BiDirectionalIsolation> implements GlobalChildren, ParagraphChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag
{

    /**
     * Constructs a bold section of text
     */
    public BiDirectionalIsolation()
    {
        this("");
    }

    /**
     * Specifies the text as bold
     *
     * @param text
     */
    public BiDirectionalIsolation(String text)
    {
        super(ComponentTypes.BiDirectionalIsolation);
        setText(text);
    }
}
