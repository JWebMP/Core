package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * All the valid area attributes
 * Not including HTML 5
 *
 * @since 2013/11/22
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum AreaAttributes implements AttributeDefinitions
{
    /**
     * Specifies an alternate text for the area. Required if the HRef attribute is present
     */
    Alt,
    /**
     * Specifies the coordinates of the area
     */
    Coords,
    /**
     * Specifies the hyper-link target for the area
     */
    HRef,
    /**
     * Specifies the shape of the area
     */
    Shape,
    /**
     * Specifies where to open the target URL
     * <p>
     */
    Target,
    /**
     * The attribute for use with the map highlighting
     */
    Data_MapHilight,
    /**
     * A specific element type
     */
    Element,
    /**
     * Any data element
     */
    Data;

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
