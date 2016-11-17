package za.co.mmagon.jwebswing.components.jqxwidgets.dropdownlist;

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
public class JQXDropDownListFeature extends Feature<JQXDropDownListOptions, JQXDropDownListFeature> implements JQXDropDownListFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXDropDownList forComponent;
    private JQXDropDownListOptions options;
    private String setContentMethod;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXDropDownListFeature(JQXDropDownList forComponent)
    {
        super("JQXDropDownListFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ScrollBar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ListBox.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DropDownList.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXDropDownListOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXDropDownListOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxDropDownList(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);
        if (setContentMethod != null)
        {
            addQuery(forComponent.getJQueryID() + "jqxDropDownList('setContent'," + setContentMethod + ");");
        }

    }

    public String getSetContentMethod()
    {
        return setContentMethod;
    }

    public void setSetContentMethod(String setContentMethod)
    {
        this.setContentMethod = setContentMethod;
    }

}
