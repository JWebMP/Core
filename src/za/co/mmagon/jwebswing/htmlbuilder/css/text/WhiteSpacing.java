package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The white-space property specifies how white-space inside an element is handled.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.whiteSpace="pre"
 *
 * @author Marc Magon
 */
public enum WhiteSpacing implements CSSEnumeration<WhiteSpacing>
{
    /**
     * Sequences of whitespace will collapse into a single whitespace. Text will wrap when necessary. This is default
     */
    Normal,
    /**
     * Sequences of whitespace will collapse into a single whitespace.
     * Text will never wrap to the next line. The text continues on the same line until a br/ tag is encountered
     */
    NoWrap,
    /**
     * Whitespace is preserved by the browser. Text will only wrap on line breaks Acts like the pre tag in HTML
     */
    Pre,
    /**
     * Sequences of whitespace will collapse into a single whitespace. Text will wrap when necessary, and on line breaks
     */
    Pre_Line,
    /**
     * Whitespace is preserved by the browser. Text will wrap when necessary, and on line breaks
     */
    Pre_Wrap,
    /**
     * Specifies that the value of the white-space property should be inherited from the parent element
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
    public WhiteSpacing getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.whiteSpace";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }
}
