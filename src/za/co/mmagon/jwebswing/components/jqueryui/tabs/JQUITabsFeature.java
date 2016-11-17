package za.co.mmagon.jwebswing.components.jqueryui.tabs;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;

/**
 * The JQuery UI Tabs Implementation
 * <p>
 * @author MMagon
 * @since 29 Mar 2013
 * @version 1.0
 */
public class JQUITabsFeature extends Feature<JQUITabOptions, JQUITabsFeature> implements JQUITabsFeatures
{

    private static final long serialVersionUID = 1L;
    private final JQUITab tab;
    private JQUITabOptions options;

    /**
     * The JW Tabs feature
     * <p>
     * @param tab
     */
    public JQUITabsFeature(JQUITab tab)
    {
        super("JWTabs");
        this.tab = tab;

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Tabs.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Tabs.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(tab.getJQueryID() + "tabs(" + getOptions() + ");");
    }

    /**
     * Returns the options fields for the tab
     * <p>
     * @return
     */
    @Override
    public JQUITabOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUITabOptions();
        }
        return options;
    }

}
