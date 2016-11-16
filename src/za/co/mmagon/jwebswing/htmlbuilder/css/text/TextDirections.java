package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The direction property specifies the text direction/writing direction.
 * Default value: ltr
 * Inherited: yes
 * Version: CSS2
 * JavaScript syntax: object.style.direction="rtl"
 *
 * @author Marc Magon
 */
public enum TextDirections implements CSSEnumeration<TextDirections>
{
    /**
     * The writing direction is right-to-left
     */
    Rtl,
    /**
     * The writing direction is left-to-right. This is default
     */
    Ltr,
    /**
     * Specifies that the value of the direction property should be inherited from the parent element
     */
    Inherited,
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
    public TextDirections getDefault()
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
        return CSSVersions.CSS2;
    }
}
