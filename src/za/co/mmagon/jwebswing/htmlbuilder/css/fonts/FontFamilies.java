package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The font-family property specifies the font for an element.
 * <p>
 * The font-family property can hold several font names as a "fallback" system. If the browser does not support the first font, it tries the next font.
 * <p>
 * There are two types of font family names:
 * <p>
 * family-name - The name of a font-family, like "times", "courier", "arial", etc.
 * generic-family - The name of a generic-family, like "serif", "sans-serif", "cursive", "fantasy", "monospace".
 * <p>
 * Start with the font you want, and always end with a generic family, to let the browser pick a similar font in the generic family, if no other fonts are available.
 * <p>
 * Note: Separate each value with a comma.
 * <p>
 * Note: If a font name contains white-space, it must be quoted. Single quotes must be used when using the "style" attribute in HTML.
 * Default value: not specified
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.fontFamily="arial,sans-serif"
 * <p>
 * @author Marc Magon
 */
public enum FontFamilies implements CSSEnumeration<FontFamilies>
{

    Times$New$Roman,
    Georgia,
    Courier$New,
    Verdana,
    Arial,
    Lucida$Console,
    None,
    /**
     * Sets this field as not set
     */
    Unset;

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public FontFamilies getDefault()
    {
        return Unset;
    }

    @Override
    public String toString()
    {
        return super.toString().replace('$', ' ').toLowerCase();
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.fontFamily";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

}
