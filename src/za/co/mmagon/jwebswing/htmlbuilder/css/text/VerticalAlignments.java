package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The vertical-align property sets the vertical alignment of an element.
 * Default value: baseline
 * Inherited: no
 * Version: CSS1
 * JavaScript syntax: object.style.verticalAlign="bottom"
 *
 * @author Marc Magon
 */
public enum VerticalAlignments implements CSSEnumeration<VerticalAlignments>
{
    /**
     * Align the baseline of the element with the baseline of the parent element. This is default
     */
    Baseline,
    /**
     * Aligns the element as it was subscript
     */
    Sub,
    /**
     * Aligns the element as it was superscript
     */
    Super,
    /**
     * The top of the element is aligned with the top of the tallest element on the line
     */
    Top,
    /**
     * The top of the element is aligned with the top of the parent element's font
     */
    Text_Top,
    /**
     * The element is placed in the middle of the parent element
     */
    Middle,
    /**
     * The bottom of the element is aligned with the lowest element on the line
     */
    Bottom,
    /**
     * The bottom of the element is aligned with the bottom of the parent element's font
     */
    Text_Bottom,
    /**
     * Specifies that the value of the vertical-align property should be inherited from the parent element
     */
    Inherited,
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
    public VerticalAlignments getDefault()
    {
        return Unset;
    }

    @Override
    public String toString()
    {
        return super.toString().toLowerCase().replace('_', '-');
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.verticalAlign";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

}
