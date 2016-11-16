package za.co.mmagon.jwebswing.components.jqueryUI.datepicker;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryUI.JQUIReferencePool;

/**
 *
 * @author mmagon
 */
public class JQUIDatePickerFeature extends Feature<JQUIDatePickerOptions, JQUIDatePickerFeature> implements JQUIDatePickerFeatures
{

    private static final long serialVersionUID = 1L;

    /**
     * The circular reference for the Date Picker
     */
    private final JQUIDatePicker dateInput;
    /**
     * The date picker options
     */
    private JQUIDatePickerOptions options;

    /**
     * Constructs a new date picker JS for the given object
     * <p>
     * @param dateInput
     */
    public JQUIDatePickerFeature(JQUIDatePicker dateInput)
    {
        super("dateinput");
        this.dateInput = dateInput;
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.DatePicker.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.DatePicker.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(dateInput.getJQueryID() + "datepicker("
                + getOptions() + ");");

    }

    /**
     * Return the options available for the Date Picker
     * <p>
     * @return
     */
    @Override
    public JQUIDatePickerOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIDatePickerOptions();
        }
        return options;
    }
}
