package za.co.mmagon.jwebswing.htmlbuilder.css.interfaces;

import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.interfaces.CustomCSSImpl;

/**
 * Any custom css record you want
 *
 * @author ANGELFIRE
 */
public class CustomCSSImpl extends CSSImplementationAdapter<CustomCSS, CustomCSSImpl> implements CSSImplementationClass<CustomCSS, CustomCSSImpl>
{

    private static final long serialVersionUID = 1L;

    private NameValuePairCSSImpl[] valuePair;

    /**
     * A Name Value Pair for CSS Properties
     *
     * @return
     */
    public NameValuePairCSSImpl[] value()
    {
        return valuePair;
    }

    /**
     * Sets the name value pair
     *
     * @param valuePair
     */
    public void setvalue(NameValuePairCSS[] valuePair)
    {
        this.valuePair = (NameValuePairCSSImpl[]) valuePair;
    }
}
