package za.co.mmagon.jwebswing.components.jqueryui.colourpicker;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqSpectrum.JQSpectrumColourPickerReferencePool;

/**
 * An implementation of the Spectrum Colour Picker tool
 * <p>
 * <p>
 * http://bgrins.github.io/spectrum/#why
 * <p>
 * @author MMagon
 * @since 25 Jun 2013
 * @version 1.0
 */
public class JQUIColourPickerFeature extends Feature<JQUIColourPickerOptions, JQUIColourPickerFeature>
{

    private static final long serialVersionUID = 1L;
    private JQUIColourPickerOptions colourOptions;
    private final JQUIColourPicker picker;

    /**
     * Constructs a new instance of the JW Colour Picker ComponentFeatureBase
     */
    public JQUIColourPickerFeature(JQUIColourPicker picker)
    {
        super("JWColourPickerFeature");
        this.picker = picker;
        getJavascriptReferences().add(JQSpectrumColourPickerReferencePool.SpectrumColourPicker.getJavaScriptReference());
        getCssReferences().add(JQSpectrumColourPickerReferencePool.SpectrumColourPicker.getCssReference());

    }

    @Override
    public void assignFunctionsToComponent()
    {
        String s = picker.getJQueryID() + "spectrum(" + getOptions() + ");" + getNewLine();
        addQuery(s);
    }

    /**
     * Returns the options associated with the Spectrum Colour Picker
     * <p>
     * @return
     */
    @Override
    public JQUIColourPickerOptions getOptions()
    {
        if (this.colourOptions == null)
        {
            colourOptions = new JQUIColourPickerOptions();
        }
        return colourOptions;
    }

    /**
     * Returns the JQUIColourPicker associated with this feature
     * <p>
     * @return
     */
    public JQUIColourPicker getPicker()
    {
        return picker;
    }

}
