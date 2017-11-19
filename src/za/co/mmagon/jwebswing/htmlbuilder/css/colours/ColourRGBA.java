package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

import java.lang.annotation.Documented;

/**
 * @author Marc Magon
 */
@CSSAnnotationType
@Documented
public @interface ColourRGBA
{

	int Red() default 0;

	int Green() default 0;

	int Blue() default 0;

	int Alpha() default 0;
}
