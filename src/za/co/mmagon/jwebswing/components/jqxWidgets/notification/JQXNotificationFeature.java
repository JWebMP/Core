package za.co.mmagon.jwebswing.components.jqxWidgets.notification;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.jqxWidgets.panel.JQXPanelFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXNotificationFeature extends Feature<JQXNotificationOptions, JQXNotificationFeature> implements JQXNotificationFeatures, GlobalFeatures, JQXPanelFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component forComponent;
    private JQXNotificationOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXNotificationFeature(Component forComponent)
    {
        super("JQXNotificationFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Notification.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    @Override
    public JQXNotificationOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXNotificationOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxNotification(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
