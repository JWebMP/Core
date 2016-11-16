package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.StyleAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoClassAttribute;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * The Style Tag
 * <p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer FireFox Opera Google Chrome Safari<p>
 * <p>
 * The style tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The style tag is used to define style information for an HTML document.<p>
 * <p>
 * Inside the style element you specify how HTML elements should render in a<p>
 * browser.<p>
 * <p>
 * Each HTML document can contain multiple style tags.<p>
 * <p>
 * <p>
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class Style extends ComponentHierarchyBase<NoChildren, StyleAttributes, NoFeatures, NoEvents, Component>
        implements NoIDTag, HeadChildren, NoClassAttribute
{

    /**
     * Constructs a new blank Style tag
     */
    public Style()
    {
        super(ComponentTypes.Style);
        addAttribute(StyleAttributes.Type, "text/css");
    }

    /**
     * Sets the raw CSS Data
     * <p>
     * @param cssString
     */
    public void setCSS(String cssString)
    {
        setText(cssString);
    }

    /**
     * Returns the raw CSS Data
     * <p>
     * @return
     */
    public String getCSS()
    {
        return getText(0).toString();
    }

}
