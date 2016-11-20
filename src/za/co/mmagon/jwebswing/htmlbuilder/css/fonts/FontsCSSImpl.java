package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * The CSS font properties define the font family, boldness, size, and the style of a text.
 * <p>
 * see http://www.w3schools.com/css/css_font.asp
 *
 * @author Marc Magon
 */
public class FontsCSSImpl extends CSSImplementationAdapter<FontsCSS, FontsCSSImpl> implements CSSImplementationClass<FontsCSS, FontsCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "font-family", cssVersion = CSSVersions.CSS21)
    private FontFamilies fontFamily;
    @CSSDetail(cssName = "font-size", cssVersion = CSSVersions.CSS21)
    private MeasurementCSSImpl fontSize;
    @CSSDetail(cssName = "font-style", cssVersion = CSSVersions.CSS21)
    private FontStyles fontStyle;
    @CSSDetail(cssName = "font-variant", cssVersion = CSSVersions.CSS21)
    private FontVariants fontVariant;
    @CSSDetail(cssName = "font-weight", cssVersion = CSSVersions.CSS21)
    private FontWeights fontWeight;
    @CSSDetail(cssName = "font-weight", cssVersion = CSSVersions.CSS21)
    private Integer fontWeight$;

    /**
     * Returns the font family assigned
     *
     * @return
     */
    public FontFamilies getFontFamily()
    {
        return fontFamily;
    }

    /**
     * Sets the font size
     *
     * @return
     */
    public MeasurementCSSImpl getFontSize()
    {
        return fontSize;
    }

    /**
     * Set the font style
     *
     * @return
     */
    public FontStyles getFontStyle()
    {
        return fontStyle;
    }

    /**
     * Sets the applicable font variant
     *
     * @return
     */
    public FontVariants getFontVariant()
    {
        return fontVariant;
    }

    /**
     * Sets the font weight
     *
     * @return
     */
    public FontWeights getFontWeight()
    {
        return fontWeight;
    }

    /**
     * Sets the font weight
     *
     * @return
     */
    public int getFontWeight$()
    {
        return fontWeight$;
    }

    /**
     * Sets the font family
     *
     * @param fontFamily
     */
    public void setFontFamily(FontFamilies fontFamily)
    {
        this.fontFamily = fontFamily;
    }

    /**
     * Sets the font size
     *
     * @param fontSize
     */
    public void setFontSize(MeasurementCSSImpl fontSize)
    {
        this.fontSize = fontSize;
    }

    /**
     * Sets the font style
     *
     * @param fontStyle
     */
    public void setFontStyle(FontStyles fontStyle)
    {
        this.fontStyle = fontStyle;
    }

    /**
     * Sets the font variant
     *
     * @param fontVariant
     */
    public void setFontVariant(FontVariants fontVariant)
    {
        this.fontVariant = fontVariant;
    }

    /**
     * Sets the font weight
     *
     * @param fontWeight
     */
    public void setFontWeight(FontWeights fontWeight)
    {
        this.fontWeight = fontWeight;
    }

    /**
     * Sets the font weight
     *
     * @param fontWeight$
     */
    public void setFontWeight$(Integer fontWeight$)
    {
        this.fontWeight$ = fontWeight$;
    }

}
