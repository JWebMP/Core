package za.co.mmagon.jwebswing.htmlbuilder.css;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.animatable.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.borders.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.margins.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.outline.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.padding.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.tables.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.*;

/**
 * This class holds CSS Enumerations that are global across all HTML elements One day when they implement extends for Enums and @interfaces I suppose, Then we can do proper generic, till then, just
 * bare with it I guess
 * <p>
 * Based on w3 schools
 * <p>
 * @author Marc Magon
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface CSS
{

    /**
     * Animation CSS properties (CSS3)
     *
     * @return
     */
    public AnimateCSS Animatable() default @AnimateCSS;

    /**
     * Background Properties
     *
     * @return
     */
    public BackgroundCSS Background() default @BackgroundCSS;

    /**
     * Border properties
     *
     * @return
     */
    public BorderCSS Border() default @BorderCSS;

    /**
     * Display properties
     *
     * @return
     */
    public DisplayCSS Display() default @DisplayCSS;

    /**
     * Font properties
     *
     * @return
     */
    public FontsCSS Font() default @FontsCSS;

    /**
     * Dimension Properties
     *
     * @return
     */
    public HeightWidthCSS Dimensions() default @HeightWidthCSS;

    /**
     * List Properties
     *
     * @return
     */
    public ListCSS List() default @ListCSS;

    /**
     * Margin Properties
     *
     * @return
     */
    public MarginsCSS Margins() default @MarginsCSS;

    /**
     * Outline Properties
     *
     * @return
     */
    public OutlineCSS Outline() default @OutlineCSS;

    /**
     * Padding Properties
     *
     * @return
     */
    public PaddingCSS Padding() default @PaddingCSS;

    /**
     * Table Properties
     *
     * @return
     */
    public TableCSS Table() default @TableCSS;

    /**
     * Text Properties
     *
     * @return
     */
    public TextCSS Text() default @TextCSS;
}
