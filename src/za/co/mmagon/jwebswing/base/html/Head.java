package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HtmlChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * The head tag for HTML
 * <p>
 * Definition and Usage
 * <p>
 * The &lt;head&gt; element is a container for all the head elements.<p>
 * <p>
 * The &lt;head&gt; element can include a title for the document, scripts, styles, meta information, and more.<p>
 * <p>
 * The following elements can go inside the &lt;head&gt; element:
 * <p>
 * <p>
 * &lt;title&gt; (this element is required in an HTML document)
 * <p>
 * &lt;style&gt;
 * <p>
 * &lt;base&gt;
 * <p>
 * &lt;link&gt;
 * <p>
 * &lt;meta&gt;
 * <p>
 * &lt;script&gt;
 * <p>
 * &lt;noscript&gt;
 * <p>
 * <p>
 * Browser Support Element
 * &lt;head&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * In HTML 4.01 the &lt;head&gt; element is required.<p>
 * <p>
 * In HTML5, the &lt;head&gt; element can be omitted. The following code will validate as HTML5:
 * <p>
 * <p>
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 * <p>
 * <p>
 */
public class Head extends ComponentHierarchyBase<HeadChildren, NoAttributes, NoFeatures, NoEvents, Component>
        implements NoIDTag, HtmlChildren, NoClassAttribute
{

    /**
     * Constructs a new Head Tag
     */
    public Head()
    {
        super(ComponentTypes.Head);
    }
}
