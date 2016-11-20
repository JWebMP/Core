package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * The CSS font properties define the font family, boldness, size, and the style of a text.
 * <p>
 * see http://www.w3schools.com/css/css_font.asp
 *
 * @author Marc Magon
 *
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface FontsCSS
{

    /**
     * The font-family property specifies the font for an element.
     *
     * @return
     */
    public FontFamilies FontFamily() default FontFamilies.Unset;

    /**
     * Specifies the font size of text
     * @return 
     */
    public MeasurementCSS FontSize() default @MeasurementCSS;

    /**
     * The font-style property specifies the font style for a text.
     * @return 
     */
    public FontStyles FontStyle() default FontStyles.Unset;

    /**
     * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
     * @return 
     */
    public FontVariants FontVariant() default FontVariants.Unset;

    /**
     * Specifies the weight of a font
     * @return 
     */
    public FontWeights FontWeight() default FontWeights.Unset;

    /**
     * Specifies the weight of a font
     * @return 
     */
    public int FontWeight$() default CSSPropertiesFactory.DefaultIntValue;
}
