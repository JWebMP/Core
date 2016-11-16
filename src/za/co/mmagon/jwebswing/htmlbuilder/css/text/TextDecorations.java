package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The text-decoration property specifies the decoration added to text.
 * <p>
 * Note: The color of the decoration should be set by the "color" property.
 * Default value: none
 * Inherited: no
 * Version: CSS1
 * JavaScript syntax: object.style.textDecoration="overline"
 *
 * @author Marc Magon
 */
public enum TextDecorations implements CSSEnumeration<TextDecorations>
{
    /**
     * Defines a normal text. This is default
     */
    None,
    /**
     * Defines underlined text
     */
    Underline,
    /**
     * Defines overline text
     */
    Overline,
    /**
     * Strike through text
     */
    Line_Through,
    /**
     * Blink Text
     * Note: The "blink" value is not supported in IE, Chrome, or Safari.
     */
    Blink,
    /**
     * Specifies that the value of the text-decoration property should be inherited from the parent element
     * Note: The value "inherit" is not supported in IE7 and earlier. IE8 requires a !DOCTYPE. IE9 supports "inherit".
     */
    Inherit,
    /**
     * Sets this field as not set
     */
    Unset;

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
    public TextDecorations getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.textDecoration";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }
}
