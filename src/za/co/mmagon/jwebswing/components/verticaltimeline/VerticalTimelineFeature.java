package za.co.mmagon.jwebswing.components.verticaltimeline;

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
public class VerticalTimelineFeature extends Feature<VerticalTimelineOptions, VerticalTimelineFeature> implements VerticalTimelineFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private VerticalTimelineOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public VerticalTimelineFeature(Component forComponent)
    {
        super("VerticalTimelineFeature");
        setComponent(forComponent);
        getJavascriptReferences().add(VerticalTimelineReferencePool.VerticalTimelineReference.getJavaScriptReference());
        getCssReferences().add(VerticalTimelineReferencePool.VerticalTimelineReference.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public VerticalTimelineOptions getOptions()
    {
        if (options == null)
        {
            options = new VerticalTimelineOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
    }
}
