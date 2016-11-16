package za.co.mmagon.jwebswing.components.jqxWidgets.datetimeinput;

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
public class JQXDateTimeInputFeature extends Feature<JQXDateTimeInputOptions, JQXDateTimeInputFeature> implements JQXDateTimeInputFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXDateTimeInput forComponent;
    private JQXDateTimeInputOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXDateTimeInputFeature(JQXDateTimeInput forComponent)
    {
        super("JQXDateTimeInputFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DateTimeInput.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Calendar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Globalization.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXDateTimeInputOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXDateTimeInputOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxDateTimeInput(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
