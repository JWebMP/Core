package za.co.mmagon.jwebswing.components.jqueryUI.droppable;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryUI.JQUIReferencePool;

/**
 * The droppable implementation
 * Create targets for draggable elements.
 * <p>
 * The jQuery UI Droppable plugin makes selected elements droppable (meaning they accept being dropped on by draggables).
 * You can specify which draggables each will accept.
 * <p>
 * @since 2014/04/14
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class JQUIDroppableFeature extends Feature<JQUIDroppableOptions, JQUIDroppableFeature> implements JQUIDroppableFeatures
{

    private JQUIDroppableOptions options;

    public JQUIDroppableFeature(Component componentFor)
    {
        super("JWDroppableFeature");
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Mouse.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Droppable.getJavaScriptReference());
        setComponent(component);
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(component.getJQueryID() + "droppable(" + getOptions() + ");");
    }

    /**
     * Returns the Droppable Options
     * <p>
     * @return
     */
    @Override
    public JQUIDroppableOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIDroppableOptions();
        }
        return options;
    }

}
