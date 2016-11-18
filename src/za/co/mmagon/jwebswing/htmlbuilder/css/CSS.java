package za.co.mmagon.jwebswing.htmlbuilder.css;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.Annotations.CustomCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.animatable.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.borders.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
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
 * This class holds CSS Enumerations that are global across all HTML elements
 * One day when they implement extends for Enums and @interfaces I suppose,
 * Then we can do proper generic, till then, just bare with it I guess
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
     * @return 
     */
    public CSSAnimatable animatable() default @CSSAnimatable;
    /**
     * Specify any custom css you want
     * @return 
     */
    public CustomCSS custom() default @CustomCSS;
    /**
     * Background Properties
     * @return 
     */
    public BackgroundCSS background() default @BackgroundCSS;
    /**
     * Border properties
     * @return 
     */
    public BorderCSS border() default @BorderCSS;
    /**
     * Colour properties
     * @return 
     */
    public ColourCSS colour() default @ColourCSS;
    /**
     * Display properties
     * @return 
     */
    public DisplayCSS display() default @DisplayCSS;
    /**
     * Font properties
     * @return 
     */
    public FontsCSS font() default @FontsCSS;
    /**
     * Dimension Properties
     * @return 
     */
    public HeightWidthCSS dimensions() default @HeightWidthCSS;
    /**
     * List Properties
     * @return 
     */
    public ListCSS list() default @ListCSS;
    /**
     * Margin Properties
     * @return 
     */
    public MarginsCSS margins() default @MarginsCSS;
    /**
     * Outline Properties
     * @return 
     */
    public OutlineCSS outline() default @OutlineCSS;
    /**
     * Padding Properties
     * @return 
     */
    public PaddingCSS padding() default @PaddingCSS;
    /**
     * Table Properties
     * @return 
     */
    public TableCSS table() default @TableCSS;
    /**
     * Text Properties
     * @return 
     */
    public TextCSS text() default @TextCSS;
}
