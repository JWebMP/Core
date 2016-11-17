package za.co.mmagon.jwebswing.components.jqueryui.dialog;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Implements the JQuery UI Dialog
 *
 * @author MMagon
 * @since 28 Mar 2013
 * @version 1.0
 *
 */
public class JQUIDialogFeature extends Feature<JavaScriptPart, JQUIDialogFeature> implements JQUIDialogFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQUIDialog panel;

    public JQUIDialogFeature(JQUIDialog panel)
    {
        super("JWDialog");
        this.panel = panel;

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Mouse.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Resizable.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Draggable.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Dialog.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Button.getCssReference());
        getCssReferences().add(JQUIReferencePool.Resizable.getCssReference());
        getCssReferences().add(JQUIReferencePool.Draggable.getCssReference());
        getCssReferences().add(JQUIReferencePool.Dialog.getCssReference());

    }

    /**
     * Returns the panel associated with this dialog
     * <p>
     * @return
     */
    public JQUIDialog getPanel()
    {
        return panel;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(panel.getJQueryID()).append("dialog(");
        sb.append(panel.getOptions());
        sb.append(");").append(getNewLine());
        addQuery(sb.toString());

    }
}
