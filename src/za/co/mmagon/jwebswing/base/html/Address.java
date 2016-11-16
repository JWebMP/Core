package za.co.mmagon.jwebswing.base.html;

import java.io.Serializable;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.AddressChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * <p>
 * Definition and Usage<p>
 * <p>
 * The &gt;address&lt; tag defines the contact information for the author/owner of a document or an article.<p>
 * <p>
 * If the &gt;address&lt; element is inside the &gt;body&lt; element, it represents contact information for the document.<p>
 * <p>
 * If the &gt;address&lt; element is inside an &gt;article&lt; element, it represents contact information for that article.<p>
 * <p>
 * The text in the &gt;address&lt; element usually renders in italic. Most browsers will add a line break before and after the address element.<p>
 * Browser Support Element &gt;address&lt; Yes Yes Yes Yes<p>
 * Yes
 *
 * Tips and Notes
 *
 * Tip: The &gt;address&lt; tag should NOT be used to describe a postal address, unless it is a part of the contact information.
 *
 * Tip: The &gt;address&lt; element will typically be included along with other information in a &gt;footer&lt; element. Differences Between HTML 4.01 and HTML5
 *
 * HTML 4.01 does not support the &gt;article&lt; tag, so in HTML 4.01 the &gt;address&lt; tag always defines the contact information of the document's author/owner. Global Attributes
 *
 * The &gt;address&lt; tag also supports the Global Attributes in HTML. Event Attributes
 *
 * The &gt;address&lt; tag also supports the Event Attributes in HTML.
 *
 * @since
 * @version
 * @author MMagon
 *
 *
 */
public class Address extends Component<AddressChildren, NoAttributes, GlobalFeatures, GlobalEvents, Address> implements NoNewLineBeforeClosingTag, NoNewLineForRawText, Serializable
{

    /**
     * Logger for the Component
     */
    private static final org.apache.log4j.Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("Address");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     * Constructs a new address, usually displayed in italic
     *
     * @param address
     */
    public Address(String address)
    {
        super(ComponentTypes.Address.getComponentTag(), ComponentTypes.Address);
        setText(address);
    }
}
