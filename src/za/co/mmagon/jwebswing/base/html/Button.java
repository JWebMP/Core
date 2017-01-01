package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.ButtonAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.bootstrap.cards.BSCardChildren;

/**
 * Definition and Usage &gt;p&lt;
 * <p>
 * The &gt;button&lt; tag defines a clickable button. &gt;p&lt;
 * <p>
 * Inside a &gt;button&lt; element you can put content, like text or images.<p>
 * This is the difference between this element and buttons created with the &gt;input&lt; element. &gt;p&lt;
 * <p>
 * Tip: Always specify the type attribute for a &gt;button&lt; element.<p>
 * Different browsers use different default types for the &gt;button&lt; element. Browser Support
 * <p>
 * Element &gt;button&lt; Yes Yes Yes Yes Yes &gt;p&lt;
 * <p>
 * Tips and Notes &gt;p&lt;
 * <p>
 * Note: If you use the &gt;button&lt; element in an HTML form, different browsers may submit different values.
 * <p>
 * Use &gt;input&lt; to create buttons in an HTML form.<p>
 * Differences Between HTML 4.01 and HTML5 &gt;p&lt; HTML5 has the following new attributes: autofocus, form, formaction, formenctype, formmethod, formnovalidate, and formtarget. &gt;p&lt;
 * <p>
 * @author Marc Magon
 * @since 2014/12/20
 */
public class Button extends Component<GlobalChildren, ButtonAttributes, GlobalFeatures, GlobalEvents, Button>
        implements GlobalChildren, BSCardChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new button object with no text
     */
    public Button()
    {
        this("");
    }

    /**
     * Constructs a new button object with the given text
     * <p>
     * @param text The text to show on the button
     */
    public Button(String text)
    {
        super(ComponentTypes.Button);
        setText(text);
    }
}
