package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Lists all the attributes available for the image map
 *
 * @since Forever
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum ImageMapAttributes implements AttributeDefinitions
{
    Element;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
