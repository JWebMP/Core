package za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter.options.JQXDataAdapterOptions;
import za.co.mmagon.jwebswing.components.jqxWidgets.dataadapter.options.JQXDataAdapterSourceData;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @param <A>
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXDataAdapterFeature<A extends JQXDataAdapterSourceData> extends Feature<JQXDataAdapterOptions<A>, JQXDataAdapterFeature> implements JQXDataAdapterFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXDataAdapter forComponent;
    private JQXDataAdapterOptions<A> options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXDataAdapterFeature(JQXDataAdapter forComponent)
    {
        super("JQXDataApapterFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Data.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());

    }

    /**
     * Returns all the data adapter options
     * <p>
     * @return
     */
    @Override
    public JQXDataAdapterOptions<A> getOptions()
    {
        if (options == null)
        {
            options = new JQXDataAdapterOptions<>();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = "var " + getDAID() + " = new $.jqx.dataAdapter(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        if ((getOptions().getData() != null) || getOptions().getLocaldata() != null)
        {
            addQuery(requiredString);
        }

    }

    /**
     * Returns the Data Adapter ID
     * @return 
     */
    private String getDAID()
    {
        return forComponent.getDAID();
    }

}
