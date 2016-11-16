package za.co.mmagon.jwebswing.components.jstree;

import za.co.mmagon.jwebswing.components.newcomponents.*;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JSTreeFeature extends Feature<JSTreeOptions, JSTreeFeature> implements JSTreeFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component forComponent;
    private JSTreeOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JSTreeFeature(Component forComponent)
    {
        super("JSTreeFeature");
        this.forComponent = forComponent;
        // getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        // getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JSTreeOptions getOptions()
    {
        if (options == null)
        {
            options = new JSTreeOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = forComponent.getJQueryID() + "blank(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);
    }
}
