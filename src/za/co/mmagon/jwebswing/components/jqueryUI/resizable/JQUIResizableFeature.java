package za.co.mmagon.jwebswing.components.jqueryUI.resizable;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IFeature;
import za.co.mmagon.jwebswing.components.pools.jqueryUI.JQUIReferencePool;

/**
 * Controls items being resizable
 *
 * @since Forever
 * @author Marc Magon
 */
public class JQUIResizableFeature extends Feature<JQUIResizableOptions, JQUIResizableFeature> implements IFeature
{

    private JQUIResizableOptions options;

    public JQUIResizableFeature(Component component)
    {
        super("JWResizableFeature");
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Mouse.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Resizable.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());
        getCssReferences().add(JQUIReferencePool.Resizable.getCssReference());
        setComponent(component);
    }

    @Override
    public void assignFunctionsToComponent()
    {
        StringBuilder resizableString = new StringBuilder(getComponent().getJQueryID() + "resizable(");
        resizableString.append(getOptions().toString());
        resizableString.append(");").append(getNewLine());
        addQuery(resizableString.toString());
    }

    @Override
    public JQUIResizableOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIResizableOptions();
        }
        return options;
    }

}
