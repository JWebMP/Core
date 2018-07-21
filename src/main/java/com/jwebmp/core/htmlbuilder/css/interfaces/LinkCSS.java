package com.jwebmp.core.htmlbuilder.css.interfaces;

import com.jwebmp.core.htmlbuilder.css.CSS;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface LinkCSS
{

	CSS hover() default @CSS();

	CSS link() default @CSS();

	CSS visited() default @CSS();

	CSS active() default @CSS();
}
