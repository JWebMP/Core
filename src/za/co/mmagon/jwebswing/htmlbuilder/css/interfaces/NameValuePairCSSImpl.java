
package za.co.mmagon.jwebswing.htmlbuilder.css.interfaces;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author ANGELFIRE
 */
public class NameValuePairCSSImpl implements NameValuePairCSS {
    private String name;
    private String value;
    
    
    @Override
    public String name()
    {
        return name;
    }

    @Override
    public String value()
    {
        return value();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getvalue()
    {
        return value;
    }

    public void setvalue(String value)
    {
        this.value = value;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return NameValuePairCSS.class;
    }

}
