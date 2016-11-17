package za.co.mmagon.jwebswing.components.jqueryui.selectable;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;

/**
 * Handles selectable objects.
 * <p>
 * Use the mouse to select elements, individually or in a group.
 *
 * @since 2014/05/16
 * @version 1.0
 * @author MMagon
 *
 */
public class JQUISelectableFeature extends Feature<JQUISelectableOptions, JQUISelectableFeature> implements JQUISelectableFeatures
{

    private static final long serialVersionUID = 1L;

    private JQUISelectableOptions options;

    /**
     * Construct a new instance of a selectable feature Sets name to JWSelectableFeature
     *
     * @param component The component to assign the feature to
     */
    public JQUISelectableFeature(Component component)
    {
        super("JWSelectableFeature");
        setComponent(component);
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Selectable.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Selectable.getCssReference());
    }

    /**
     * The JQuery String
     * <p>
     */
    @Override
    public void assignFunctionsToComponent()
    {
        StringBuilder selectableString = new StringBuilder(getComponent().getJQueryID() + "selectable(");
        selectableString.append(getOptions().toString());
        selectableString.append(");").append(getNewLine());
        addQuery(selectableString.toString());
    }

    @Override
    public JQUISelectableOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUISelectableOptions();
        }
        return options;
    }

}
