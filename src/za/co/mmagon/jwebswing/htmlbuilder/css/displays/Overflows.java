package za.co.mmagon.jwebswing.htmlbuilder.css.displays;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The overflow property specifies what happens if content overflows an element's box.
 * Default value: visible
 * Inherited: no
 * Animatable: no. Read about animatable
 * Version: CSS2
 * JavaScript syntax: object.style.overflow="scroll"
 *
 * @author Marc Magon
 */
@CSSAnnotationType
public enum Overflows implements CSSEnumeration<Overflows>
{
    /**
     * If overflow is clipped, a scroll-bar should be added to see the rest of the content
     */
    Auto,
    /**
     * The overflow is clipped, and the rest of the content will be invisible
     */
    Hidden,
    /**
     * The overflow is clipped, but a scroll-bar is added to see the rest of the content
     */
    Scroll,
    /**
     * The overflow is not clipped. It renders outside the element's box. This is default
     */
    Visible,
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
    public Overflows getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.overflow";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS2;
    }
}
