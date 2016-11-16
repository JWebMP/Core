package za.co.mmagon.jwebswing.components.bootstrap;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;

/**
 * Adds the bootstrap component features to the application
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class BootstrapFeature extends Feature implements BootstrapFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private Body forComponent;
    private BootstrapOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public BootstrapFeature(Body forComponent)
    {
        super("BootstrapFeature");
        this.forComponent = forComponent;
        forComponent.getJavascriptReferences().add(BootstrapReferencePool.BootstrapCoreReference.getJavaScriptReference());
        forComponent.getCssReferences().add(BootstrapReferencePool.BootstrapCoreReference.getCssReference());
        forComponent.getCssReferences().add(BootstrapReferencePool.BootstrapSBAdmin2Reference.getCssReference());
        forComponent.getCssReferences().add(BootstrapReferencePool.BootstrapSocialThemeReference.getCssReference());
    }

    /**
     * Returns all the options, currently none I think
     * <p>
     * @return
     */
    @Override
    public BootstrapOptions getOptions()
    {
        if (options == null)
        {
            options = new BootstrapOptions();
        }
        return options;
    }
}
