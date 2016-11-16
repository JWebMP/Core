package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * In a small-caps font, all lowercase letters are converted to uppercase letters. However, the converted uppercase letters appears in a smaller font size than the original uppercase letters in the
 * text.
 * <p>
 * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.fontVariant="small-caps"
 *
 * @author Marc Magon
 */
public enum FontVariants implements CSSEnumeration<FontVariants>
{
    /**
     * The browser displays a normal font. This is default
     */
    Normal,
    /**
     * The browser displays a small-caps font
     */
    Small_Caps,
    /**
     * Sets this property to its default value
     *
     * see http://www.w3schools.com/cssref/css_initial.asp
     */
    Initial,
    /**
     * Inherits this property from its parent element.
     *
     * see http://www.w3schools.com/cssref/css_inherit.asp
     */
    Inherit,
    /**
     * Sets this field as not set
     */
    Unset;

    ;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public FontVariants getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.fontVariant";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

}
