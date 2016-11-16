package za.co.mmagon.jwebswing.htmlbuilder.css.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSS;
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
public @interface LinkCSS
{

    public CSS hover() default @CSS();

    public CSS link() default @CSS();

    public CSS visited() default @CSS();

    public CSS active() default @CSS();
}
