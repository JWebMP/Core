package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 *
 * @author Marc Magon
 */
public enum TextTransforms implements CSSEnumeration<TextTransforms>
{
    /**
     * No capitalization. The text renders as it is. This is default
     */
    None,
    /**
     * Transforms the first character of each word to uppercase
     */
    Capitalize,
    /**
     * Transforms the text to uppercase
     */
    Uppercase,
    /**
     * Transforms the text to lowercase
     */
    Lowercase,
    /**
     * Inherits the value
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
        return name().toLowerCase();
    }

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public TextTransforms getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.textTransform";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }
}
