package za.co.mmagon.jwebswing.htmlbuilder.css.text;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage<p>
 * <p>
The text-align property specifies the horizontal alignment of text in an element.<p>
 * Default value: left if direction is ltr, and right if direction is rtl<p>
 * Inherited: yes<p>
 * Version: CSS1<p>
 * JavaScript syntax: 	object.style.textAlign="right"
 * <p>
 * @author Marc Magon
 */
public enum TextAlignments implements CSSEnumeration<TextAlignments>
{
    /**
     * Aligns the text to the left
     */
    Left,
    /**
     * Aligns the text to the Center
     */
    Center,
    /**
     * Aligns the text to the Right
     */
    Right,
    /**
     * Remove Field
     */
    None,
    /**
     * Stretches the lines so that each line has equal width (like in newspapers and magazines)
     */
    Justify,
    /**
     * Specifies that the value of the text-align property should be inherited from the parent element
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
    public TextAlignments getDefault()
    {
        return Unset;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
    
    

    @Override
    public String getJavascriptSyntax()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
