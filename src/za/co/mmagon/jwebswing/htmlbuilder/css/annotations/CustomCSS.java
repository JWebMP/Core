package za.co.mmagon.jwebswing.htmlbuilder.css.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.interfaces.NameValuePairCSS;

/**
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
