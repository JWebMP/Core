package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HtmlChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.utilities.TextUtilities;

public class Comment extends ComponentHierarchyBase<NoChildren, NoAttributes, NoFeatures, NoEvents, Comment>
        implements HtmlChildren, HeadChildren, ImageMapChildren, BodyChildren
{

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
