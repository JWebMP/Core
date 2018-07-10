package com.jwebmp.htmlbuilder.css.colours;

import com.jwebmp.htmlbuilder.css.annotations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface ColourCSS
{

	String value() default "";
}
