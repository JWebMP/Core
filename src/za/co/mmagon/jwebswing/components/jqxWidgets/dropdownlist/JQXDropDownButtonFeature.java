package za.co.mmagon.jwebswing.components.jqxWidgets.dropdownlist;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXDropDownButtonFeature extends Feature<JQXDropDownListOptions, JQXDropDownButtonFeature> implements JQXDropDownListFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXDropDownButton forComponent;
    private JQXDropDownListOptions options;
    private String setContentMethod;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXDropDownButtonFeature(JQXDropDownButton forComponent)
    {
        super("JQXDropDownListFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ScrollBar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DropDownButton.getJavaScriptReference());
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
        String requiredString = forComponent.getJQueryID() + "jqxDropDownButton(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);
        if (setContentMethod != null)
        {
            addQuery(forComponent.getJQueryID() + "jqxDropDownButton('setContent'," + setContentMethod + ");" + getNewLine());
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
