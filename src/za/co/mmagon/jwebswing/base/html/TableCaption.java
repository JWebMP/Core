package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;caption&gt; tag defines a table caption.
 * <p>
 * The &lt;caption&gt; tag must be inserted immediately after the table tag.
 * <p>
 * Note: You can specify only one caption per table.
 * <p>
 * Tip: By default, a table caption will be center-aligned above a table. However, the CSS properties text-align and caption-side can be used to align and place the caption. Browser Support Element
 * &lt;caption&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The align attribute is removed from HTML5.
 * <p>
 * @author Marc Magon
 * @since forever
 */
public class TableCaption extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, TableCaption> implements TableChildren<NoAttributes>, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new table caption
     * <p>
     * @param caption The caption
     */
    public TableCaption(String caption)
    {
        super(ComponentTypes.TableCaption);
        setText(caption);
    }
}
