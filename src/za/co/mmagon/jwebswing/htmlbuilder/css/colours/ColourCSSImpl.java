package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;

/**
 * Defines a Colour by anything
 *
 * @author Marc Magon
 */
public class ColourCSSImpl extends CSSImplementationAdapter<ColourCSS, ColourCSSImpl>
        implements Serializable, CSSImplementationValue, CSSImplementationClass<ColourCSS, ColourCSSImpl>
{

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;
    /**
     * The actual value
     */
    private String value;

    /**
     * Constructs a new Colour CSS
     */
    public ColourCSSImpl()
    {
        //No need for anything here
    }

    /**
     * Constructs a new colour with a value
     *
     * @param value
     */
    public ColourCSSImpl(String value)
    {
        this.value = value;
    }

    @JsonValue
    /**
     * Returns the actual value
     *
     * @return
     */
    public String value()
    {
        return value;
    }

    /**
     * Sets the actual value
     *
     * @param value
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * Returns the value of this colour
     *
     * @return
     */
    @Override
    public String toString()
    {
        return value == null ? "" : value;
    }

}
