package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.AppletAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Defines a java Applet tag
 * <p>
 * @since
 * @version
 * @author MMagon
 */
public class Applet extends Component<NoChildren, AppletAttributes, GlobalFeatures, GlobalEvents, Applet>
{

    /**
     * Logger for the Component
     */
    private static final org.apache.log4j.Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("Applet");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    public Applet()
    {
        super(ComponentTypes.Applet.getComponentTag(), ComponentTypes.Applet);
        setTiny(true);
    }

}
