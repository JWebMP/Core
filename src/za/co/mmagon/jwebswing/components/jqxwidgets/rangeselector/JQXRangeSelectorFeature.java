package za.co.mmagon.jwebswing.components.jqxwidgets.rangeselector;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxwidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXRangeSelectorFeature extends Feature<JQXRangeSelectorOptions, JQXRangeSelectorFeature> implements JQXRangeSelectorFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXRangeSelector forComponent;
    private JQXRangeSelectorOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXRangeSelectorFeature(JQXRangeSelector forComponent)
    {
        super("JQXRangeSelectorFeaturev");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Data.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.RangeSelector.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXRangeSelectorOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXRangeSelectorOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxRangeSelector(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
