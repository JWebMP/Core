package za.co.mmagon.jwebswing.htmlbuilder.css.fonts;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The font-weight property sets how thick or thin characters in text should be displayed.
 * Default value: normal
 * Inherited: yes
 * Version: CSS1
 * JavaScript syntax: object.style.fontWeight="900"
 *
 * @author Marc Magon
 */
public enum FontWeights implements CSSEnumeration<FontWeights>
{
    /**
     * Defines lighter characters
     */
    Lighter,
    /**
     * Defines normal characters. This is default
     */
    Normal,
    /**
     * Defines thick characters
     */
    Bold,
    /**
     * Defines thicker characters
     */
    Bolder,
    /**
     * Sets this property to its default value
     * <p>
     * see http://www.w3schools.com/cssref/css_initial.asp
     */
    Initial,
    /**
     * Inherits this property from its parent element.
     * <p>
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
        return name().toLowerCase();
    }

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public FontWeights getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.fontWeight";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

}
