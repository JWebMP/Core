package za.co.mmagon.jwebswing.components.jqxWidgets.calendar;

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
public class JQXCalendarFeature extends Feature<JQXCalendarOptions, JQXCalendarFeature> implements JQXCalendarFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXCalendar forComponent;
    private JQXCalendarOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXCalendarFeature(JQXCalendar forComponent)
    {
        super("JWTooltip");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.DateTimeInput.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Calendar.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Globalization.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXCalendarOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXCalendarOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = forComponent.getJQueryID() + "jqxCalendar(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);
    }
}
