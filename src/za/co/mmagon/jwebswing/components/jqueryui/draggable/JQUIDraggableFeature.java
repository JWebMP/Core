package za.co.mmagon.jwebswing.components.jqueryui.draggable;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;

/**
 * Implements the JQuery Draggable functionality on an object
 *
 * @since 2014/04/13
 * @version 1.0
 * @author MMagon
 *
 * 1.0 Complete API implemented
 */
public class JQUIDraggableFeature extends Feature<JQUIDraggableOptions, JQUIDraggableFeature> implements JQUIDraggableFeatures
{

    private static final long serialVersionUID = 1L;
    private JQUIDraggableOptions draggableOptions = new JQUIDraggableOptions();
    private final Component component;

    /**
     * Add the draggable to a component
     * <p>
     * Used to group sets of draggable and droppable items, in addition to droppable's accept option.
     * A draggable with the same scope value as a droppable will be accepted by the droppable.
     * <p>
     * @param component The component that must get the feature
     * @param scope     The scope of this component.
     */
    public JQUIDraggableFeature(Component component, String scope)
    {
        super("JWDraggableFeature");

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Mouse.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Draggable.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Draggable.getCssReference());
        this.component = component;
        getOptions().setScope(scope);
        this.component.addFeature(this);
    }

    /**
     * Creates the JQuery String for this feature
     * <p>
     */
    @Override
    public void assignFunctionsToComponent()
    {
        String draggableString = component.getJQueryID() + "draggable(";
        draggableString += draggableOptions;
        draggableString += ");" + getNewLine();
        addQuery(draggableString);
    }

    /**
     * Gets this features available options
     * <p>
     * @return
     */
    @Override
    public final JQUIDraggableOptions getOptions()
    {
        if (draggableOptions == null)
        {
            draggableOptions = new JQUIDraggableOptions();
        }
        return draggableOptions;
    }

}
