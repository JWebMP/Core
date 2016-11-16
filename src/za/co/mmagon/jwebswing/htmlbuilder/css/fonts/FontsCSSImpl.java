package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 * The CSS font properties define the font family, boldness, size, and the style of a text.
 * <p>
 * see http://www.w3schools.com/css/css_font.asp
 *
 * @author Marc Magon
 */
public class FontsCSSImpl implements FontsCSS
{

    private FontFamilies Font_Family;
    private MeasurementCSSImpl Font_Size;
    private FontStyles Font_Style;
    private FontVariants Font_Variant;
    private FontWeights Font_Weight;
    private Integer Font_Weight$;

    /**
     * Returns the font family assigned
     *
     * @return
     */
    @Override
    public FontFamilies Font_Family()
    {
        return Font_Family;
    }

    /**
     * Sets the font family assigned
     *
     * @param Font_Family
     */
    public void setFont_Family(FontFamilies Font_Family)
    {
        this.Font_Family = Font_Family;
    }

    /**
     * Sets the font size
     *
     * @return
     */
    @Override
    public MeasurementCSSImpl Font_Size()
    {
        return Font_Size;
    }

    /**
     * sets the font size
     *
     * @param Font_Size
     */
    public void setFont_Size(MeasurementCSSImpl Font_Size)
    {
        this.Font_Size = Font_Size;
    }

    /**
     * Set the font style
     *
     * @return
     */
    @Override
    public FontStyles Font_Style()
    {
        return Font_Style;
    }

    /**
     * Set the font style
     *
     * @param Font_Style
     */
    public void setFont_Style(FontStyles Font_Style)
    {
        this.Font_Style = Font_Style;
    }

    /**
     * Sets the applicable font variant
     *
     * @return
     */
    @Override
    public FontVariants Font_Variant()
    {
        return Font_Variant;
    }

    /**
     * Sets the applicable font variant
     *
     * @param Font_Variant
     */
    public void setFont_Variant(FontVariants Font_Variant)
    {
        this.Font_Variant = Font_Variant;
    }

    /**
     * Sets the font weight
     *
     * @return
     */
    @Override
    public FontWeights Font_Weight()
    {
        return Font_Weight;
    }

    /**
     * Sets the font weight
     *
     * @param Font_Weight
     */
    public void setFont_Weight(FontWeights Font_Weight)
    {
        this.Font_Weight = Font_Weight;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return FontsCSS.class;
    }

    /**
     * Sets the font weight
     *
     * @return
     */
    @Override
    public int Font_Weight$()
    {
        return Font_Weight$;
    }

    /**
     * Sets the font weight
     *
     * @param Font_Weight$
     */
    public void setFont_Weight$(Integer Font_Weight$)
    {
        this.Font_Weight$ = Font_Weight$;
    }

}
