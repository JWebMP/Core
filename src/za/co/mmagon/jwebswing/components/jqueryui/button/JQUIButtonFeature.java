package za.co.mmagon.jwebswing.components.jqueryui.button;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;

/**
 * The JavaScript implementation of the JWButton
 *
 * @author MMagon
 * @since 09 Mar 2013
 * @version 1.0
 */
public class JQUIButtonFeature extends Feature<JQUIButtonOptions, JQUIButtonFeature> implements JQUIButtonFeatures
{

    private static final long serialVersionUID = 1L;
    /**
     * The component that we are turning into a button
     */
    private final Component comp;
    /**
     * The specified options
     */
    private JQUIButtonOptions options;

    /**
     * Turns a component into a button
     * <p>
     * @param comp
     */
    public JQUIButtonFeature(Component comp)
    {
        super("JWButtonFeature");
        this.comp = comp;
        //comp.addAttribute(GlobalAttributes.JWType, "button");
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Button.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());
        getCssReferences().add(JQUIReferencePool.Button.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(comp.getJQueryID() + "button(" + getOptions() + ");" + getNewLine());
    }

    /**
     * Returns the options for a button
     * <p>
     * @return
     */
    @Override
    public JQUIButtonOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIButtonOptions();
        }
        return options;
    }
}
