package za.co.mmagon.jwebswing.htmlbuilder.css.measurement;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSDetail;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;

/**
 * Any basic measurement
 *
 * @author Marc Magon
 */
public class MeasurementCSSImpl extends CSSImplementationAdapter<MeasurementCSS, MeasurementCSSImpl>
        implements CSSImplementationValue, CSSImplementationClass<MeasurementCSS, MeasurementCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail
    private double value;

    private MeasurementTypes measurementType;

    /**
     * Constructs an empty measurement
     */
    public MeasurementCSSImpl()
    {
        //nothing required
    }

    /**
     * Constructs with the given value and/or measurement type
     *
     * @param value
     * @param measurementType
     */
    public MeasurementCSSImpl(double value, MeasurementTypes measurementType)
    {
        this.value = value;
        this.measurementType = measurementType;
    }

    /**
     * Constructs with the given value in pixels
     *
     * @param value
     */
    public MeasurementCSSImpl(double value)
    {
        this(value, MeasurementTypes.Pixels);
    }

    /**
     * Constructs with the given value and measurement type
     *
     * @param value
     * @param measurementType
     */
    public MeasurementCSSImpl(int value, MeasurementTypes measurementType)
    {
        this.value = value;
        this.measurementType = measurementType;
    }

    /**
     * Constructs with the given value as pixels
     *
     * @param value
     */
    public MeasurementCSSImpl(int value)
    {
        this(value, MeasurementTypes.Pixels);
    }

    /**
     * Sets the value
     *
     * @param value
     */
    public void setvalue(int value)
    {
        this.value = value;
    }

    /**
     * Sets the measurement type
     *
     * @param measurementType
     */
    public void setMeasurementType(MeasurementTypes measurementType)
    {
        this.measurementType = measurementType;
    }

    /**
     * Returns the double value
     *
     * @return
     */
    public double value()
    {
        return value;
    }

    /**
     * Returns the measurement formatted
     *
     * @return
     */
    @JsonValue(true)
    @JsonRawValue
    @Override
    public String toString()
    {
        /*
         * if (measurementType == null) { return ""; }
         */
        if (Double.class.cast(value).toString().endsWith(".0")) //format as an integer
        {
            Integer valInt = Double.class.cast(value).intValue();
            if (MeasurementType().isRequiresQuotes())
            {
                return "'" + valInt + "" + MeasurementType().getHtmlAnnotation() + "'";
            }
            else
            {
                return valInt + "" + MeasurementType().getHtmlAnnotation();
            }
        }
        else if (MeasurementType().isRequiresQuotes())
        {
            return "'" + value + "" + MeasurementType().getHtmlAnnotation() + "'";
        }
        else
        {
            return value + "" + MeasurementType().getHtmlAnnotation();
        }

    }

    /**
     * Returns the measure formatted in quotes
     *
     * @param renderQuotes
     *
     * @return
     */
    public String toString(boolean renderQuotes)
    {
        return toString().replace("\'", "");
        /*
         * if (renderQuotes) { return "'" + value + "" + MeasurementType() == null ? "" : MeasurementType().getHtmlAnnotation() + "'"; } else { return value + "" + MeasurementType() == null ? "" :
         * MeasurementType().getHtmlAnnotation();
        }
         */
    }

    /**
     * Returns the measurement type
     *
     * @return
     */
    public MeasurementTypes MeasurementType()
    {
        if (measurementType == null)
        {
            measurementType = MeasurementTypes.Pixels;
        }

        return measurementType;
    }
}
