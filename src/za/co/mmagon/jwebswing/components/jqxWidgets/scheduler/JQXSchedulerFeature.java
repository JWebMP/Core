package za.co.mmagon.jwebswing.components.jqxWidgets.scheduler;

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
public class JQXSchedulerFeature extends Feature<JQXSchedulerOptions, JQXSchedulerFeature> implements JQXSchedulerFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXScheduler forComponent;
    private JQXSchedulerOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXSchedulerFeature(JQXScheduler forComponent)
    {
        super("JQXSchedulerFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ScrollBar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Data.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Date.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Scheduler.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.SchedulerAPI.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DateTimeInput.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Menu.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Calendar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ToolTip.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Window.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.CheckBox.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.ListBox.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DropDownList.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.NumberInput.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.RadioButton.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Input.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Globalization.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXSchedulerOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXSchedulerOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxScheduler(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
