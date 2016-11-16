package za.co.mmagon.jwebswing.components.jqxWidgets.chart;

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
public class JQXChartFeature extends Feature<JQXChartOptions, JQXChartFeature> implements JQXChartFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXChart forComponent;
    private JQXChartOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXChartFeature(JQXChart forComponent)
    {
        super("JQXChartFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Chart.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Draw.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Data.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXChartOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXChartOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = forComponent.getJQueryID() + "jqxChart(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);
    }
}
