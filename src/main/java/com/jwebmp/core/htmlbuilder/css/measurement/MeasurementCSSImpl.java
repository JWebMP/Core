package com.jwebmp.core.htmlbuilder.css.measurement;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationValue;
import com.jwebmp.core.utilities.StaticStrings;

/**
 * Any basic measurement
 *
 * @author Marc Magon
 */
public class MeasurementCSSImpl
		extends CSSImplementationAdapter<MeasurementCSS, MeasurementCSSImpl>
		implements CSSImplementationValue, CSSImplementationClass<MeasurementCSS, MeasurementCSSImpl>
{


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
	 * Constructs with the given value in pixels
	 *
	 * @param value
	 */
	public MeasurementCSSImpl(double value)
	{
		this(value, MeasurementTypes.Pixels);
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
	 * Constructs with the given value as pixels
	 *
	 * @param value
	 */
	public MeasurementCSSImpl(int value)
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
		return toString().replace(StaticStrings.STRING_SINGLE_QUOTES, StaticStrings.STRING_EMPTY);
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
		if (((Double) value)
		                .toString()
		                .endsWith(".0"))
		{
			Integer valInt = ((Double) value)
			                             .intValue();
			if (MeasurementType().isRequiresQuotes())
			{
				return StaticStrings.STRING_SINGLE_QUOTES + valInt + MeasurementType().getHtmlAnnotation() + StaticStrings.STRING_SINGLE_QUOTES;
			}
			else
			{
				return valInt + "" + MeasurementType().getHtmlAnnotation();
			}
		}
		else if (MeasurementType().isRequiresQuotes())
		{
			return StaticStrings.STRING_SINGLE_QUOTES + value + MeasurementType().getHtmlAnnotation() + StaticStrings.STRING_SINGLE_QUOTES;
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
