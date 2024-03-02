package com.jwebmp.core.htmlbuilder.css.colours;

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * @author GedMarc
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
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
