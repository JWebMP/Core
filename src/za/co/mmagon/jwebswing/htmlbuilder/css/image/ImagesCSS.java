package za.co.mmagon.jwebswing.htmlbuilder.css.image;

import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * A list of URL's for a background Image
 *
 * @author mmagon
 * @since 2016/01/17
 */
@CSSAnnotationType
@Target(
		{
				ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ImagesCSS
{

	ImageCSS[] value() default @ImageCSS;
}
