package za.co.mmagon.jwebswing.components.modernizr;

import za.co.mmagon.jwebswing.components.newcomponents.*;
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
public class ModernizrFeature extends Feature<BlankComponentOptions, ModernizrFeature> implements ModernizrFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component forComponent;
    private BlankComponentOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public ModernizrFeature(Component forComponent)
    {
        super("ModernizrFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(ModernizrReferencePool.ModernizrReference.getJavaScriptReference());
        // getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public BlankComponentOptions getOptions()
    {
        if (options == null)
        {
            options = new BlankComponentOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
    }
}
