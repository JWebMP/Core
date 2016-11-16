package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * Defines a Colour by anything
 * @author Marc Magon
 */
public class ColourCSSImpl implements ColourCSS, Serializable
{
    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;
    /**
     * The actual value
     */
    private String value;

    public ColourCSSImpl()
    {
    }

    /**
     * Constructs a new colour with a value
     * @param value 
     */
    public ColourCSSImpl(String value)
    {
        this.value = value;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return ColourCSS.class;
    }

    /**
     * Returns the actual value
     * @return 
     */
    @Override
    public String value()
    {
        return value;
    }
    /**
     * Sets the actual value
     * @param value 
     */
    public void setValue(String value)
    {
        this.value = value;
    }
    /**
     * Returns the value of this colour
     * @return 
     */
    @Override
    public String toString()
    {
        return value;
    }

}
