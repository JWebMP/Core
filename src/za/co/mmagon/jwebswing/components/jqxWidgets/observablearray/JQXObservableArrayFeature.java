package za.co.mmagon.jwebswing.components.jqxWidgets.observablearray;

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
public class JQXObservableArrayFeature extends Feature<JQXObservableArrayOptions, JQXObservableArrayFeature> implements JQXObservableArrayFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXObservableArray forComponent;
    private JQXObservableArrayOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXObservableArrayFeature(JQXObservableArray forComponent)
    {
        super("JQXObservableArrayFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXObservableArrayOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXObservableArrayOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxTree(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
