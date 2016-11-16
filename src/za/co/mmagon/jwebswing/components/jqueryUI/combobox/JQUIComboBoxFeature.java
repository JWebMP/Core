package za.co.mmagon.jwebswing.components.jqueryUI.combobox;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryUI.JQUIReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author MMagon
 * @since 30 Mar 2013
 * @version 1.0
 */
public class JQUIComboBoxFeature extends Feature<JavaScriptPart, JQUIComboBoxFeature>
{

    /**
     * The component to display the list at
     */
    private final JQUIComboBox comboBox;

    /**
     * Constructs a new Auto Complete feature
     *
     * @param comboBox The component to display at
     */
    protected JQUIComboBoxFeature(JQUIComboBox comboBox)
    {
        super("JQUIAutoCompleteComboBoxFeature");
        this.comboBox = comboBox;
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Position.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Menu.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Menu.getCssReference());
        getCssReferences().add(JQUIReferencePool.Position.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.AutoComplete.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.AutoComplete_ComboBox.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.AutoComplete.getCssReference());
        getCssReferences().add(JQUIReferencePool.AutoComplete_ComboBox.getCssReference());

    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(comboBox.getJQueryID() + "combobox();");
    }
}
