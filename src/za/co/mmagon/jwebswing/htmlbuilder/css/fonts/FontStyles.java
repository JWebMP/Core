package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The font-style property specifies the font style for a text.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.fontStyle="italic"
 *
 * @author Marc Magon
 */
public enum FontStyles implements CSSEnumeration<FontStyles>
{
    /**
     * The browser displays a normal font style. This is default
     */
    Normal,
    /**
     * The browser displays an italic font style
     */
    Italic,
    /**
     * The browser displays an oblique font style
     */
    Oblique,
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

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public FontStyles getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.fontStyle";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

}
