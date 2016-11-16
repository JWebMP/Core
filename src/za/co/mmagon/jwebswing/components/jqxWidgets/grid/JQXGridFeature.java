package za.co.mmagon.jwebswing.components.jqxWidgets.grid;

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
public class JQXGridFeature extends Feature<JQXGridOptions, JQXGridFeature> implements JQXGridFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXGrid forComponent;
    private JQXGridOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXGridFeature(JQXGrid forComponent)
    {
        super("JQXGridFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Data.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ScrollBar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Menu.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ListBox.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DropDownList.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Grid.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridSelection.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridColumnsReOrder.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridColumnsResize.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridSort.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridPager.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridGrouping.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridEditing.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridStateSave.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.GridAggregatesPlugIn.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXGridOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXGridOptions();
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
