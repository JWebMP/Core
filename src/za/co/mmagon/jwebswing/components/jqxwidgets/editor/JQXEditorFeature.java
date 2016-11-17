package za.co.mmagon.jwebswing.components.jqxwidgets.editor;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxwidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXEditorFeature extends Feature<JQXEditorOptions, JQXEditorFeature> implements JQXEditorFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXEditor forComponent;
    private JQXEditorOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXEditorFeature(JQXEditor forComponent)
    {
        super("JQXEditorFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ScrollBar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ListBox.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DropDownList.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DropDownButton.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ColorPicker.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Window.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Editor.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ToolTip.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.CheckBox.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXEditorOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXEditorOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxEditor(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
