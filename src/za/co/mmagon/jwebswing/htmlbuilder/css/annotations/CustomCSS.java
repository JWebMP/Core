package za.co.mmagon.jwebswing.htmlbuilder.css.annotations;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.interfaces.NameValuePairCSS;

/**
 * Defines any name value pair of a CSS
 *
 * @author mmagon
 */
@za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CustomCSS
{

    public NameValuePairCSS[] value() default @NameValuePairCSS;
}
