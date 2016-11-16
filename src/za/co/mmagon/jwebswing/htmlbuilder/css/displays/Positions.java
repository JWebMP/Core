package za.co.mmagon.jwebswing.htmlbuilder.css.displays;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The position property specifies the type of positioning method used for an element (static, relative, absolute or fixed).
 * Default value: static
 * Inherited: no
 * Version: CSS2
 * JavaScript syntax: object.style.position="absolute"
 *
 * @author Marc Magon
 */
@CSSAnnotationType
public enum Positions implements CSSEnumeration<Positions>
{
    /**
     * The element is positioned relative to its first positioned (not static) ancestor element
     */
    Absolute,
    /**
     * The element is positioned relative to the browser window
     */
    Fixed,
    /**
     * The element is positioned relative to its normal position, so "left:20" adds 20 pixels to the element's LEFT position
     */
    Relative,
    /**
     * The value of the position property is inherited from the parent element
     */
    Static,
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
    public String getValue()
    {
        return name();
    }

    @Override
    public Positions getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.position";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

}
