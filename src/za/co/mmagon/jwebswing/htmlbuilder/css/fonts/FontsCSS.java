package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSPropertiesFactory;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

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
    public FontFamilies Font_Family() default FontFamilies.Unset;

    /**
     * Specifies the font size of text
     */
    public MeasurementCSS Font_Size() default @MeasurementCSS;

    /**
     * The font-style property specifies the font style for a text.
     */
    public FontStyles Font_Style() default FontStyles.Unset;

    /**
     * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
     */
    public FontVariants Font_Variant() default FontVariants.Unset;

    /**
     * Specifies the weight of a font
     */
    public FontWeights Font_Weight() default FontWeights.Unset;

    /**
     * Specifies the weight of a font
     */
    public int Font_Weight$() default CSSPropertiesFactory.DefaultIntValue;
}
