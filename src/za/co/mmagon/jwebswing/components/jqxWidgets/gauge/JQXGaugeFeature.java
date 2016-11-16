package za.co.mmagon.jwebswing.components.jqxWidgets.gauge;

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
public class JQXGaugeFeature extends Feature<JQXGaugeOptions, JQXGaugeFeature> implements JQXGaugeFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXGauge forComponent;
    private JQXGaugeOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXGaugeFeature(JQXGauge forComponent)
    {
        super("JQXGaugeFeatures");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Chart.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Gauge.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXGaugeOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXGaugeOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxGauge(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
