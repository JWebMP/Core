package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.html.attributes.*;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.utilities.*;

/**
 * Defines a basic comment line
 *
 * @author GedMarc
 */
public class Comment extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, Comment>
        implements HtmlChildren, HeadChildren, ImageMapChildren, BodyChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Adds the specified comment in a comment block for HTML
     * <p>
     * @param comment
     */
    public Comment(String comment)
    {
        super(ComponentTypes.Comment);
        setText(comment);
    }

    /**
     * Over-rides the render HTML tag
     * <p>
     * @param tabCount The specified tab count
     * <p>
     * @return A customized string for comments
     */
    @Override
    protected StringBuilder renderHTML(int tabCount)
    {
        return !isTiny() ? new StringBuilder(TextUtilities.getTabString(tabCount) + "<!-- " + getText(0) + " -->") : new StringBuilder();
    }
}
