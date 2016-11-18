package za.co.mmagon.jwebswing.htmlbuilder.css.enumarations;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;

/**
 * Definition and Usage
 * <p>
 * The border-bottom-style property sets the style of an element's bottom border.
 * Default value: not specified
 * Inherited: no
 * Version: CSS1
 * JavaScript syntax: object.style.borderBottomStyle="dotted"
 * <p>
 * @author Marc Magon
 */
public enum BorderStyles implements CSSEnumeration<BorderStyles>
{

    /**
     * Specifies no border
     */
    None,
    /**
     * Specifies a dotted border
     */
    Dotted,
    /**
     * Specifies a dashed border
     */
    Dashed,
    /**
     * Specifies a solid border
     */
    Solid,
    /**
     * Specifies a double border
     */
    Double,
    /**
     * Specifies a 3d groove border
     */
    Groove,
    /**
     * Specifies a 3D ridged border. The effect depends on the border-color value
     */
    Ridge,
    /**
     * Specifies a 3D inset border. The effect depends on the border-color value
     */
    Inset,
    /**
     * Specifies a 3D outset border. The effect depends on the border-color value
     */
    Outset,
    Unset;

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public BorderStyles getDefault()
    {
        return Unset;
    }

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
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
