package za.co.mmagon.jwebswing.components.moment;

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
public class MomentFeature extends Feature<MomentOptions, MomentFeature> implements MomentFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;
    private MomentOptions options;

    /**
     * Constructs a feature for
     * <p>
     * @param forComponent
     */
    public MomentFeature(Component forComponent)
    {
        super("MomentJS");
        forComponent.getAngularModules().add(new MomentAngularModule(forComponent));
        setComponent(forComponent);
        getJavascriptReferences().add(MomentReferencePool.MomentReference.getJavaScriptReference());
        getJavascriptReferences().add(MomentReferencePool.MomentAngularReference.getJavaScriptReference());
    }

    @Override
    public void preConfigure()
    {
        super.preConfigure();
    }

    /**
     * No Options
     * <p>
     * @return
     */
    @Override
    public MomentOptions getOptions()
    {
        if (options == null)
        {
            options = new MomentOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
    }
}
