package za.co.mmagon.jwebswing.components.bootstrap.toggle;

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
public class BSToggleFeature extends Feature<BSToggleOptions, BSToggleFeature> implements BSToggleFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;
 
    private final Component forComponent;
    private BSToggleOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public BSToggleFeature(Component forComponent)
    {
        super("Blank");
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
    public BSToggleOptions getOptions()
    {
        if (options == null)
        {
            options = new BSToggleOptions();
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
