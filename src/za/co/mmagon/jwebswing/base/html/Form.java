package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.FormAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.FormChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;form&gt; tag is used to create an HTML form for user input.<p>
 * <p>
 * The &lt;form&gt; element can contain one or more of the following form elements:
 * <p>
 * <p>
 * &lt;input&gt;
 * <p>
 * &lt;textarea&gt;
 * <p>
 * &lt;button&gt;
 * <p>
 * &lt;select&gt;
 * <p>
 * &lt;option&gt;
 * <p>
 * &lt;optgroup&gt;
 * <p>
 * &lt;fieldset&gt;
 * <p>
 * &lt;label&gt;
 * <p>
 * <p>
 * Browser Support Element &lt;form&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * HTML5 has added two new attributes: autocomplete and novalidate, and removed the accept attribute. Differences Between HTML and XHTML<p>
 * <p>
 * In XHTML, the name attribute is deprecated. Use the global id attribute instead.<p>
 * <p>
 * @author Marc Magon
 * @since forever
 */
public class Form extends Component<FormChildren, FormAttributes, GlobalFeatures, GlobalEvents, Form>
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new form
     */
    public Form()
    {
        super(ComponentTypes.Form);
    }

    /**
     * The label of this form
     */
    private Label label;

    @Override
    protected StringBuilder renderBeforeTag()
    {
        if (label != null)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(super.renderBeforeTag());
            sb.append(label.toString(true));
            return sb;
        }
        else
        {
            return super.renderBeforeTag();
        }
    }
}
