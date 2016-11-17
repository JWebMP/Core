package za.co.mmagon.jwebswing.components.jqxwidgets.treemap;

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
public class JQXTreeMapFeature extends Feature<JQXTreeMapOptions, JQXTreeMapFeature> implements JQXTreeMapFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXTreeMap forComponent;
    private JQXTreeMapOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXTreeMapFeature(JQXTreeMap forComponent)
    {
        super("JQXTreeMapFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ToolTip.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.TreeMap.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXTreeMapOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXTreeMapOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxTreeMap(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
