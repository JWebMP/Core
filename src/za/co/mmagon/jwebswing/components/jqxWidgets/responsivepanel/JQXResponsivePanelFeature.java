package za.co.mmagon.jwebswing.components.jqxWidgets.responsivepanel;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXResponsivePanelFeature extends Feature<JQXResponsivePanelOptions, JQXResponsivePanelFeature> implements JQXResponsivePanelFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXResponsivePanel forComponent;
    private JQXResponsivePanelOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXResponsivePanelFeature(JQXResponsivePanel forComponent)
    {
        super("JQXResponsivePanelFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ResponsivePanel.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXResponsivePanelOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXResponsivePanelOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxResponsivePanel(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
