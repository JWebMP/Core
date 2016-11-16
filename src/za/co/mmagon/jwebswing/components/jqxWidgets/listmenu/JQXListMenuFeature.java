package za.co.mmagon.jwebswing.components.jqxWidgets.listmenu;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 20151210
 * @version 1.0
 */
public class JQXListMenuFeature extends Feature<JQXListMenuOptions, JQXListMenuFeature> implements JQXListMenuFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXListMenu forComponent;
    private JQXListMenuOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXListMenuFeature(JQXListMenu forComponent)
    {
        super("JQXListMenuFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ListMenu.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Panel.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ScrollBar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXListMenuOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXListMenuOptions();
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
