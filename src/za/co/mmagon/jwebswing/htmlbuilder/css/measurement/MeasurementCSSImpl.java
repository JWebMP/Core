package za.co.mmagon.jwebswing.htmlbuilder.css.measurement;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSDetail;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSImplementationAdapter;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSImplementationClass;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSImplementationValue;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_EMPTY;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_SINGLE_QUOTES;

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
	public Double value()
	{
		return value;
	}

	/**
	 * Returns the measure formatted in quotes
	 *
	 * @param renderQuotes
	 *
	 * @return
	 */
	@SuppressWarnings("'unused")
	public String toString(boolean renderQuotes)
	{
		return toString().replace(STRING_SINGLE_QUOTES, STRING_EMPTY);
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
		if (Double.class.cast(value).toString().endsWith(".0"))
		{
			Integer valInt = Double.class.cast(value).intValue();
			if (MeasurementType().isRequiresQuotes())
			{
				return STRING_SINGLE_QUOTES + valInt + MeasurementType().getHtmlAnnotation() + STRING_SINGLE_QUOTES;
			}
			else
			{
				return valInt + "" + MeasurementType().getHtmlAnnotation();
			}
		}
		else if (MeasurementType().isRequiresQuotes())
		{
			return STRING_SINGLE_QUOTES + value + MeasurementType().getHtmlAnnotation() + STRING_SINGLE_QUOTES;
		}
		else
		{
			return value + MeasurementType().getHtmlAnnotation();
		}

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
