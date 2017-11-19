package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 */
@Target(
		{
				ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface ColourRGB
{

	int Red() default 0;

	int Green() default 0;

	int Blue() default 0;
}
