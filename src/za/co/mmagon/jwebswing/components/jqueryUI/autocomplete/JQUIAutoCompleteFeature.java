package za.co.mmagon.jwebswing.components.jqueryUI.autocomplete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.Input;
import za.co.mmagon.jwebswing.components.pools.jqueryUI.JQUIReferencePool;

/**
 *
 * @author MMagon
 * @since 30 Mar 2013
 * @version 1.0
 */
public class JQUIAutoCompleteFeature extends Feature<JQUIAutoCompleteOptions, JQUIAutoCompleteFeature> implements JQUIAutoCompleteFeatures
{

    private static final long serialVersionUID = 1L;

    /**
     * The component to display the list at
     */
    @JsonIgnore
    private final Input menuDisplayAtComponent;
    /**
     * Options
     */
    @JsonIgnore
    private JQUIAutoCompleteOptions options;

    /**
     * Constructs a new Auto Complete feature
     *
     * @param menuDisplayAtComponent The component to display at
     */
    public JQUIAutoCompleteFeature(Input menuDisplayAtComponent)
    {
        super("JWAutoCompleteFeature");
        this.menuDisplayAtComponent = menuDisplayAtComponent;

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Position.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Menu.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Menu.getCssReference());
        getCssReferences().add(JQUIReferencePool.Position.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.AutoComplete.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.AutoComplete.getCssReference());

    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(menuDisplayAtComponent.getJQueryID() + "autocomplete("
                + getOptions() + ");" + getNewLine());
    }

    /**
     * Returns an instance of the auto complete options
     * <p>
     * @return
     */
    @Override
    public JQUIAutoCompleteOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIAutoCompleteOptions();
        }
        return options;
    }

}
