package za.co.mmagon.jwebswing.components.jqxwidgets.buttons;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxwidgets.JQXReferencePool;

/**
 * Adds on a JQX Button Feature, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXButtonFeature extends Feature<JQXButtonOptions, JQXButtonFeature> implements JQXButtonFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private JQXButtonOptions options;

    /**
     * Constructs a new JQX Button ComponentFeatureBase for a component.
     * <p>
     * @param forComponent
     */
    public JQXButtonFeature(Component forComponent)
    {
        super("JQXButtonsFeature");
        setComponent(forComponent);
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
    }

    /**
     * Returns all the buttons options
     * <p>
     * @return
     */
    @Override
    public JQXButtonOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXButtonOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = getComponent().getJQueryID() + "jqxButton(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);
    }
}
