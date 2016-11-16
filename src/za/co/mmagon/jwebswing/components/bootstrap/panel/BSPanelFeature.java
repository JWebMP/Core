package za.co.mmagon.jwebswing.components.bootstrap.panel;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class BSPanelFeature extends Feature<BSPanelOptions, BSPanelFeature> implements BSPanelFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private BSPanelOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */ 
    public BSPanelFeature(Component forComponent)
    {
        super("Blank");
        setComponent(forComponent);
        // getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        // getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public BSPanelOptions getOptions()
    {
        if (options == null)
        {
            options = new BSPanelOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
    }
}
