package za.co.mmagon.jwebswing.components.jqimagemap.imagemap;

import java.util.ArrayList;
import java.util.Iterator;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapFeatures;
import za.co.mmagon.jwebswing.components.jquerylayout.layout.JQLayoutFeature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.utilities.ColourUtils;

/**
 * @since @version @author MMagon
 *
 * <p>
 */
public class JQImageHeatMapFeature extends Feature<JavaScriptPart, Feature> implements ImageMapFeatures
{

    private JQImageMap imageMap;
    private JQLayoutFeature imageMapFeature;
    private double minimumValue;
    private double maximumValue;
    private String colourMin = "ffffff";
    private String colourMax = "000000";
    private ArrayList<Double> allValues = new ArrayList<>();

    public JQImageHeatMapFeature(JQImageMap imageMap, double minimumValue, double maximumValue)
    {
        super("JWHeatMapFeature");
        this.imageMap = imageMap;
        setComponent(imageMap);
    }

    public JQImageHeatMapFeature(JQImageMap imageMap, ArrayList<Double> allValues)
    {
        super("JWHeatMapFeature");
        this.imageMap = imageMap;
        setComponent(imageMap);
        this.allValues = allValues;
        this.minimumValue = getMinNumber(allValues);
        this.maximumValue = getMaxNumber(allValues);
    }

    public double getMinimumValue()
    {
        this.minimumValue = getMinNumber(allValues);
        this.maximumValue = getMaxNumber(allValues);
        return minimumValue;
    }

    public void setMinimumValue(double minimumValue)
    {
        this.minimumValue = minimumValue;
    }

    public double getMaximumValue()
    {
        this.minimumValue = getMinNumber(allValues);
        this.maximumValue = getMaxNumber(allValues);
        return maximumValue;
    }

    public void setMaximumValue(double maximumValue)
    {
        this.maximumValue = maximumValue;
    }

    public void setValues(ArrayList<Double> allValues)
    {
        this.minimumValue = getMinNumber(allValues);
        this.maximumValue = getMaxNumber(allValues);
        this.allValues = allValues;
    }

    public String getColourForValue(double value)
    {
        return ColourUtils.getColourBetweenColours(getMinimumValue(), getMaximumValue(), value, getColourMin(), getColourMax());
    }

    public String getColourMin()
    {
        return colourMin;
    }

    public void setColourMin(String colourMin)
    {
        this.colourMin = colourMin;
    }

    public String getColourMax()
    {
        return colourMax;
    }

    public void setColourMax(String colourMax)
    {
        this.colourMax = colourMax;
    }

    /**
     * Returns the Minimum Number for the Provinces
     *
     * @return
     */
    private double getMinNumber(ArrayList<Double> provinceValues)
    {
        Double min = 999999999.0;

        for (Iterator<Double> iterator = provinceValues.iterator(); iterator.hasNext();)
        {
            Double type = iterator.next();
            if (type < min)
            {
                min = type;
            }
        }
        return min;
    }

    /**
     * Returns the maximum number for all the provinces
     *
     * @return
     */
    private double getMaxNumber(ArrayList<Double> provinceValues)
    {
        Double max = 0.0;

        for (Iterator<Double> iterator = provinceValues.iterator(); iterator.hasNext();)
        {
            Double type = iterator.next();
            if (type > max)
            {
                max = type;
            }
        }
        return max;
    }

    /**
     * Returns the middle number of the provinces or the custom middle number value entered 0.0 if the middle number is not a number
     *
     * @return
     */
    private double getMiddleNumber()
    {
        double min = getMinimumValue();
        double max = getMaximumValue();
        return (min + max) / 2;
    }

}
