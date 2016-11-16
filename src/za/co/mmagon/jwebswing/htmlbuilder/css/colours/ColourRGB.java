package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 *
 * @author Marc Magon
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface ColourRGB
{

    public int Red() default 0;

    public int Green() default 0;

    public int Blue() default 0;
}
