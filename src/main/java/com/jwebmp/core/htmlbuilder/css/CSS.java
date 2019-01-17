package com.jwebmp.core.htmlbuilder.css;

import com.jwebmp.core.htmlbuilder.css.animatable.AnimateCSS;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundCSS;
import com.jwebmp.core.htmlbuilder.css.borders.BorderCSS;
import com.jwebmp.core.htmlbuilder.css.displays.DisplayCSS;
import com.jwebmp.core.htmlbuilder.css.fonts.FontsCSS;
import com.jwebmp.core.htmlbuilder.css.heightwidth.HeightWidthCSS;
import com.jwebmp.core.htmlbuilder.css.lists.ListCSS;
import com.jwebmp.core.htmlbuilder.css.margins.MarginsCSS;
import com.jwebmp.core.htmlbuilder.css.outline.OutlineCSS;
import com.jwebmp.core.htmlbuilder.css.padding.PaddingCSS;
import com.jwebmp.core.htmlbuilder.css.tables.TableCSS;
import com.jwebmp.core.htmlbuilder.css.text.TextCSS;

import java.lang.annotation.*;

/**
 * This class holds CSS Enumerations that are global across all HTML elements One day when they implement extends for Enums and @interfaces I suppose, Then we can do proper
 * generic, till then, just
 * bare with it I guess
 * <p>
 * Based on w3 schools
 * <p>
 *
 * @author GedMarc
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
@Documented
public @interface CSS
{

	/**
	 * Animation CSS properties (CSS3)
	 *
	 * @return
	 */
	AnimateCSS Animatable() default @AnimateCSS;

	/**
	 * Background Properties
	 *
	 * @return
	 */
	BackgroundCSS Background() default @BackgroundCSS;

	/**
	 * Border properties
	 *
	 * @return
	 */
	BorderCSS Border() default @BorderCSS;

	/**
	 * Display properties
	 *
	 * @return
	 */
	DisplayCSS Display() default @DisplayCSS;

	/**
	 * Font properties
	 *
	 * @return
	 */
	FontsCSS Font() default @FontsCSS;

	/**
	 * Dimension Properties
	 *
	 * @return
	 */
	HeightWidthCSS Dimensions() default @HeightWidthCSS;

	/**
	 * List Properties
	 *
	 * @return
	 */
	ListCSS List() default @ListCSS;

	/**
	 * Margin Properties
	 *
	 * @return
	 */
	MarginsCSS Margins() default @MarginsCSS;

	/**
	 * Outline Properties
	 *
	 * @return
	 */
	OutlineCSS Outline() default @OutlineCSS;

	/**
	 * Padding Properties
	 *
	 * @return
	 */
	PaddingCSS Padding() default @PaddingCSS;

	/**
	 * Table Properties
	 *
	 * @return
	 */
	TableCSS Table() default @TableCSS;

	/**
	 * Text Properties
	 *
	 * @return
	 */
	TextCSS Text() default @TextCSS;
}
