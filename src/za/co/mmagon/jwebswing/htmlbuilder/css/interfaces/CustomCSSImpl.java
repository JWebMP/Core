
package za.co.mmagon.jwebswing.htmlbuilder.css.interfaces;

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.Annotations.CustomCSS;

/**
 *
 * @author ANGELFIRE
 */
public class CustomCSSImpl implements CustomCSS{
    private NameValuePairCSSImpl[] valuePair;
    
    
    @Override
    public NameValuePairCSSImpl[] value()
    {
        return valuePair;
    }

    public NameValuePairCSSImpl[] getValuePair()
    {
        return valuePair;
    }

    public void setvalue(NameValuePairCSSImpl[] valuePair)
    {
        this.valuePair = valuePair;
    }
    
    public void setvalue(NameValuePairCSS[] valuePair)
    {
        this.valuePair = (NameValuePairCSSImpl[]) valuePair;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return CustomCSS.class;
    }

}
