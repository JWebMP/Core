package za.co.mmagon.jwebswing.htmlbuilder.css.measurement;

/**
 * Defines any measurement
 *
 * @author Marc Magon
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
        StringBuilder number = new StringBuilder("");
        StringBuilder afterType = new StringBuilder("");
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

        this.measurementValue = number;
        this.measurementType = measureType;
    }

    /**
     * Constructs a measurement with a given value and type
     * @param value
     * @param measurementType 
     */
    public Measurement(String value, MeasurementTypes measurementType)
    {
        this.measurementValue = new StringBuilder(value);
        this.measurementType = measurementType;

    }

    /**
     * Renders the output measurement
     * @return 
     */
    public StringBuilder getOutputMeasurement()
    {
        outputMeasurement = new StringBuilder(
                measurementType.isRequiresQuotes()
                ? "\"" + measurementValue + measurementType.getHtmlAnnotation() + "\""
                : measurementValue + measurementType.getHtmlAnnotation());
        return outputMeasurement;
    }

    @Override
    public String toString()
    {
        return getOutputMeasurement().toString();
    }
}
