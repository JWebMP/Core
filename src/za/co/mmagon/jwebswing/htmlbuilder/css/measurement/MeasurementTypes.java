package za.co.mmagon.jwebswing.htmlbuilder.css.measurement;

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;

/**
 *
 * @author Marc Magon
 */
public enum MeasurementTypes implements CSSEnumeration<MeasurementTypes>
{

    Percent(true, "%"),
    Inch(true, "in"),
    Centimeter(true, "cm"),
    Millimeter(true, "mm"),
    Points(true, "pt"),
    /**
     * 1em is equal to the current font size. 2em means 2 times the size of the current font.
     * E.g., if an element is displayed with a font of 12 pt, then '2em' is 24 pt.
     * The 'em' is a very useful unit in CSS, since it can adapt automatically to the font that the reader uses
     */
    EM(true, "em"),
    /**
     * one ex is the x-height of a font (x-height is usually about half the font-size)
     */
    EX(true, "ex"),
    Pica(true, "pi"),
    Pixels(true, "px"),
    None(false, "");
    private final boolean requiresQuotes;
    private final String htmlAnnotation;

    @Override
    public String toString()
    {
        return getHtmlAnnotation();
    }

    private MeasurementTypes(boolean requiresQuotes, String htmlAnnotation)
    {
        this.requiresQuotes = requiresQuotes;
        this.htmlAnnotation = htmlAnnotation;
    }

    public boolean isRequiresQuotes()
    {
        return requiresQuotes;
    }

    public String getHtmlAnnotation()
    {
        return htmlAnnotation;
    }

    /**
     * Returns a measurement type from the annotation
     * @param annotation
     * @return 
     */
    public static MeasurementTypes getFromAnnotation(String annotation)
    {
        for (MeasurementTypes measurementTypes : values())
        {
            if (measurementTypes.getHtmlAnnotation().equalsIgnoreCase(annotation))
            {
                return measurementTypes;
            }
        }
        return null;
    }

    @Override
    public String getValue()
    {
        return getHtmlAnnotation();
    }

    @Override
    public MeasurementTypes getDefault()
    {
        return None;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return null;
    }
}
