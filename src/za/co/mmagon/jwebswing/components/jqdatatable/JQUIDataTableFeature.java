package za.co.mmagon.jwebswing.components.jqdatatable;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqueryDataTables.JQDataTableReferencePool;

/**
 * Implements the jQuery DataTable plugin
 * <p>
 * @since 2014 09 30
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class JQUIDataTableFeature extends Feature<JQUIDataTableOptions, JQUIDataTableFeature> implements GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new JW Data Table
     * <p>
     * @param component The Table to apply the Data Table features to.
     */
    public JQUIDataTableFeature(Component component)
    {
        super("JWDataFeature", component);
        getJavascriptReferences().add(JQDataTableReferencePool.JQueryDataTables.getJavaScriptReference());
        getCssReferences().add(JQDataTableReferencePool.JQueryDataTables.getCssReference());

    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(getComponent().getJQueryID() + "dataTable(" + getOptions() + ");" + getNewLine());
    }

    private JQUIDataTableOptions options;

    @Override
    public JQUIDataTableOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIDataTableOptions();
        }
        return options;
    }

}
