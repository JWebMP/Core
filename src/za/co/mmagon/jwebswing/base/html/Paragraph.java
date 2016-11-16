package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.ParagraphAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.DetailsChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryUI.tabs.JQUITabsChildren;

/**
 * This class defines a paragraph as per<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The<p>
 * &lt;p&gt;
 * <p>
 * tag defines a paragraph.<p>
 * <p>
 * Browsers automatically add some space (m<p>
 * argin) before and after each<p>
 * &lt;p&gt;
 * <p>
 * element. The margins can be modified with CSS (with the margin properties). Browser Support Element<p>
 * &lt;p&gt;
 * <p>
 * Yes Yes Yes Yes Yes Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The align attribute is not supported in HTML5.<p>
 * <p>
 * @author Marc Magon
 * @since forever, 2008 or 2007 sometime I think - will need to check on the original version named "radio on live".
 * @version 1.0
 */
public class Paragraph extends Component<ParagraphChildren, ParagraphAttributes, GlobalFeatures, GlobalEvents, Paragraph>
        implements BodyChildren, NoNewLineForRawText, ParagraphChildren, DetailsChildren, JQUITabsChildren
{

    /**
     * Constructs a blank paragraph
     */
    public Paragraph()
    {
        this("");
    }

    /**
     * Constructs a new paragraph with the raw text set as the input text
     * <p>
     * @param text
     */
    public Paragraph(String text)
    {
        super("p", ComponentTypes.Paragraph);
        setText(text);
    }
}
