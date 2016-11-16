package za.co.mmagon.jwebswing.htmlbuilder.css.measurement;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 *
 * @author Marc Magon
 */
public class MeasurementCSSImpl implements MeasurementCSS, Serializable
{

    private double value;
    private MeasurementTypes MeasurementType;
    public static final MeasurementCSSImpl hundredPercent = new MeasurementCSSImpl(100, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyNinePoint8Percent = new MeasurementCSSImpl(99.8, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyNinePercent = new MeasurementCSSImpl(99, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyEightPercent = new MeasurementCSSImpl(98, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetySevenPercent = new MeasurementCSSImpl(97, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetySixPercent = new MeasurementCSSImpl(96, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyFivePercent = new MeasurementCSSImpl(95, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyFourPercent = new MeasurementCSSImpl(94, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyThreePercent = new MeasurementCSSImpl(93, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyTwoPercent = new MeasurementCSSImpl(92, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyOnePercent = new MeasurementCSSImpl(91, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl ninetyPercent = new MeasurementCSSImpl(90, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl eightySevenPercent = new MeasurementCSSImpl(87, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl eightySixPercent = new MeasurementCSSImpl(86, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl eightyFivePercent = new MeasurementCSSImpl(85, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl eightyPercent = new MeasurementCSSImpl(80, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl seventyPercent = new MeasurementCSSImpl(70, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl fiftyPercent = new MeasurementCSSImpl(50, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl twentyPercent = new MeasurementCSSImpl(20, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl tenPercent = new MeasurementCSSImpl(10, MeasurementTypes.Percent);
    public static final MeasurementCSSImpl zero = new MeasurementCSSImpl(0, MeasurementTypes.Pixels);

    public MeasurementCSSImpl()
    {
    }

    public MeasurementCSSImpl(MeasurementCSS measurementCSS)
    {

    }

    public MeasurementCSSImpl(double value, MeasurementTypes measurementType)
    {
        this.value = value;
        MeasurementType = measurementType;
    }

    public MeasurementCSSImpl(double value)
    {
        this(value, MeasurementTypes.Pixels);
    }

    public MeasurementCSSImpl(int value, MeasurementTypes measurementType)
    {
        this.value = value;
        MeasurementType = measurementType;
    }

    public MeasurementCSSImpl(int value)
    {
        this(value, MeasurementTypes.Pixels);
    }

    public void setvalue(int value)
    {
        this.value = value;
    }

    public void setMeasurementType(MeasurementTypes measurementType)
    {
        MeasurementType = measurementType;
    }

    @Override
    public double value()
    {
        return value;
    }

    @JsonValue(true)
    @JsonRawValue
    @Override
    public String toString()
    {
        if (MeasurementType == null)
        {
            return "";
        }
        if (Double.class.cast(value).toString().endsWith(".0")) //format as an integer
        {
            Integer valInt = Double.class.cast(value).intValue();
            if (MeasurementType.isRequiresQuotes())
            {
                return "'" + valInt + "" + MeasurementType.getHtmlAnnotation() + "'";
            }
            else
            {
                return valInt + "" + MeasurementType.getHtmlAnnotation();
            }
        }
        else if (MeasurementType.isRequiresQuotes())
        {
            return "'" + value + "" + MeasurementType.getHtmlAnnotation() + "'";
        }
        else
        {
            return value + "" + MeasurementType.getHtmlAnnotation();
        }

    }

    public String toString(boolean renderQuotes)
    {
        if (renderQuotes)
        {
            return "'" + value + "" + MeasurementType.getHtmlAnnotation() + "'";
        }
        else
        {
            return value + "" + MeasurementType.getHtmlAnnotation();
        }
    }

    @Override
    public MeasurementTypes MeasurementType()
    {
        return MeasurementType;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return MeasurementCSS.class;
    }

}
