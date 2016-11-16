package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoClassAttribute;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.OneValidTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * The page title tag<p>
 * <p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The title tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The title tag is required in all HTML documents and it defines the title
 * of<p>
 * the document.<p>
 * <p>
 * The title element:
 * <p>
 * <p>
 * defines a title in the browser toolbar provides a title for the page when
 * it<p>
 * is added to favorites displays a title for the page in search-engine
 * results<p>
 * <p>
 *
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class Title extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, Component>
        implements NoIDTag, HeadChildren, OneValidTag, NoClassAttribute, NoNewLineForRawText, NoNewLineBeforeChildren, NoNewLineBeforeClosingTag
{

    /**
     * Constructs a header title
     *
     * @param title The title of the page
     */
    public Title(String title)
    {
        super("title", ComponentTypes.HeadTitle);
        setText(title);
    }

    /**
     * Returns the current set title
     *
     * @return
     */
    public String getTitle()
    {
        return getText(0).toString();
    }

    /**
     * Sets the pages title.
     *
     * @param title The title of the page
     */
    public void setTitle(String title)
    {
        setText(title);
    }
}
