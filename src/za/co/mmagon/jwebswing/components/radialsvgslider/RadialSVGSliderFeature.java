package za.co.mmagon.jwebswing.components.radialsvgslider;

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
public class RadialSVGSliderFeature extends Feature<RadialSVGSliderOptions, RadialSVGSliderFeature> implements RadialSVGSliderFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private RadialSVGSliderOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public RadialSVGSliderFeature(Component forComponent)
    {
        super("RadialSVGSliderFeature");
        setComponent(forComponent);
        getJavascriptReferences().add(SnapSVGReferencePool.SnapSVG.getJavaScriptReference());
        getJavascriptReferences().add(RadialSVGSliderReferencePool.RadialSVG.getJavaScriptReference());
        getCssReferences().add(RadialSVGSliderReferencePool.RadialSVG.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public RadialSVGSliderOptions getOptions()
    {
        if (options == null)
        {
            options = new RadialSVGSliderOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
    }
}
