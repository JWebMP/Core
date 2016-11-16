package za.co.mmagon.jwebswing.htmlbuilder.css.measurement;

/**
 * Defines any measurement
 *
 * @author Marc Magon
 * @since forever, so far in fact i wasn't capturing dates...
 */
public final class Measurement
{

    //Measurement;
    private String outputMeasurement;
    private String measurementValue;
    private MeasurementTypes measurementType;

    public Measurement(String fullValue)
    {
        String number = "";
        String afterType = "";
        for (int i = 0; i < fullValue.toCharArray().length; i++)
        {
            Character Char = fullValue.toCharArray()[i];
            if (Character.isDigit(Char))
            {
                number += Char;
            }
            else
            {
                afterType += Char;
            }
        }

        MeasurementTypes measureType = MeasurementTypes.getFromAnnotation(afterType);
        if (measureType == null)
        {
            throw new RuntimeException("Not a Measurement Type");
        }

        this.measurementValue = number;
        this.measurementType = measureType;
    }

    public Measurement(String value, MeasurementTypes measurementType)
    {
        this.measurementValue = value;
        this.measurementType = measurementType;

    }

    public String getOutputMeasurement()
    {
        outputMeasurement = measurementType.isRequiresQuotes() ? "\"" + measurementValue + measurementType.getHtmlAnnotation() + "\"" : measurementValue + measurementType.getHtmlAnnotation();
        return outputMeasurement;
    }

    @Override
    public String toString()
    {
        return getOutputMeasurement();
    }
}
