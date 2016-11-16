package za.co.mmagon.jwebswing.components.jqueryUI.datepicker;

import java.util.Date;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;

/**
 * The DatePicker is tied to a standard form input field.
 * <p>
 * Focus on the input (click, or use the tab key) to open an interactive calendar in a small overlay.
 * Choose a date, click elsewhere on the page (blur the input), or hit the Esc key to close.
 * <p>
 * If a date is chosen, feedback is shown as the input's value.
 * <p>
 * @author mmagon
 */
public class JQUIDatePicker extends Div<JQUIDatePickerChildren, NoAttributes, JQUIDatePickerFeatures, JQUIDatePickerEvents, JQUIDatePicker>
{

    private static final long serialVersionUID = 1L;

    private JQUIDatePickerFeature inputFeature;

    /**
     * Creates a new JWDatePicker for the selected date
     * <p>
     * @param selectedDate
     */
    public JQUIDatePicker(Date selectedDate)
    {
        super();
        inputFeature = new JQUIDatePickerFeature(this);
        if (selectedDate != null)
        {
            inputFeature.getOptions().setDefaultDate(selectedDate.toString());
        }
        addFeature(inputFeature);
    }

    /**
     * Constructs a new date picker
     */
    public JQUIDatePicker()
    {
        this(new Date());
    }

    /**
     * Returns the options of an item
     * <p>
     * @return
     */
    public JQUIDatePickerOptions getOptions()
    {
        return inputFeature.getOptions();
    }

    /**
     * Returns the feature of this date picker
     * <p>
     * @return
     */
    public JQUIDatePickerFeature getInputFeature()
    {
        if (inputFeature == null)
        {
            inputFeature = new JQUIDatePickerFeature(this);
        }
        return inputFeature;
    }

}
