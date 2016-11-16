package za.co.mmagon.jwebswing.components.jqxWidgets.ribbon;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jquery.JQueryReferencePool;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXRibbonFeature extends Feature<JQXRibbonOptions, JQXRibbonFeature> implements JQXRibbonFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component forComponent;
    private JQXRibbonOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXRibbonFeature(Component forComponent)
    {
        super("JQXRibbonFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Ribbon.getJavaScriptReference());
        getJavascriptReferences().add(JQueryReferencePool.JQXWidgetFixes.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());

        setSortOrder(10);
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXRibbonOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXRibbonOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        //jqx ribbon 3.9.1 bug - removes all classes from underlying divs
        addQuery("jqxWidgetPreCallClassFix('" + forComponent.getID() + "');" + getNewLine());

        String requiredString = forComponent.getJQueryID() + "jqxRibbon(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

        addQuery("jqxWidgetPostCallClassFix('" + forComponent.getID() + "');" + getNewLine());

    }
}
