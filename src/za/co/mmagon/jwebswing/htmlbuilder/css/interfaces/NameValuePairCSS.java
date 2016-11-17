package za.co.mmagon.jwebswing.htmlbuilder.css.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Any name and value pair
 * @author magon
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface NameValuePairCSS
{

    public String name() default "";

    public String value() default "";
}
