package com.jwebmp.core.htmlbuilder.css.measurement;

import com.jwebmp.core.utilities.StaticStrings;

/**
 * Defines any measurement
 *
 * @author GedMarc
 * @since forever, so far in fact i wasn't capturing dates...
 */
public final class Measurement
{

	/**
	 * The output measurement
	 */
	private StringBuilder outputMeasurement;
	/**
	 * The value to be displayed
	 */
	private StringBuilder measurementValue;
	/**
	 * The measurement type
	 */
	private MeasurementTypes measurementType;

	/**
	 * A measurement of any text that is readable using isDigit()
	 *
	 * @param fullValue
	 */
	public Measurement(String fullValue)
	{
		StringBuilder number = new StringBuilder();
		StringBuilder afterType = new StringBuilder();
		for (int i = 0; i < fullValue.toCharArray().length; i++)
		{
			Character character = fullValue.toCharArray()[i];
			if (Character.isDigit(character))
			{
				number.append(character);
			}
			else
			{
				afterType.append(character);
			}
		}

		MeasurementTypes measureType = MeasurementTypes.getFromAnnotation(afterType.toString());
		if (measureType == null)
		{
			throw new NullPointerException("Not a Measurement Type");
		}

		measurementValue = number;
		measurementType = measureType;
	}

	/**
	 * Constructs a measurement with a given value and type
	 *
	 * @param value
	 * @param measurementType
	 */
	public Measurement(String value, MeasurementTypes measurementType)
	{
		measurementValue = new StringBuilder(value);
		this.measurementType = measurementType;

	}

	@Override
	public String toString()
	{
		return getOutputMeasurement().toString();
	}

	/**
	 * Renders the output measurement
	 *
	 * @return
	 */
	public StringBuilder getOutputMeasurement()
	{
		outputMeasurement = new StringBuilder(measurementType.isRequiresQuotes()
		                                      ? StaticStrings.STRING_DOUBLE_QUOTES + measurementValue + measurementType.getHtmlAnnotation() + StaticStrings.STRING_DOUBLE_QUOTES
		                                      : measurementValue + measurementType.getHtmlAnnotation());
		return outputMeasurement;
	}
}
