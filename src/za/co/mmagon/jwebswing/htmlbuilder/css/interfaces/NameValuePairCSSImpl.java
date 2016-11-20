package za.co.mmagon.jwebswing.htmlbuilder.css.interfaces;

import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;

/**
 * A default name value pair
 *
 * @author ANGELFIRE
 */
public class NameValuePairCSSImpl extends CSSImplementationAdapter<NameValuePairCSS, NameValuePairCSSImpl>
        implements CSSImplementationClass<NameValuePairCSS, NameValuePairCSSImpl>
{

    private static final long serialVersionUID = 1L;

    private String name;
    private String value;

    /**
     * The name of this pair
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the name value pair
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name of this value pair
     *
     * @return
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of this value pair
     *
     * @param value
     */
    public void setValue(String value)
    {
        this.value = value;
    }
}
