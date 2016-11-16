package za.co.mmagon.jwebswing.components.jqxWidgets.toolbar;

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
public class JQXToolBarFeature extends Feature<JQXToolBarOptions, JQXToolBarFeature> implements JQXToolBarFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXToolBar forComponent;
    private JQXToolBarOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXToolBarFeature(JQXToolBar forComponent)
    {
        super("JQXToolBarFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ScrollBar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ListBox.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DropDownList.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ComboBox.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Input.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Toolbar.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXToolBarOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXToolBarOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxToolBar(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
