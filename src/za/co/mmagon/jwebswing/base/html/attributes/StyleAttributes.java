package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Supplies the available attributes for the style tag
 *
 * @author mmagon
 */
public enum StyleAttributes implements AttributeDefinitions
{
    /**
     * Specifies what media/device the media resource is optimized for
     */
    Media,
    /**
     * Specifies that the style only applies to this elements parent element and the
     * elements child elements
     */
    Scoped,
    /**
     * Specifies the MIME Type of the style sheet
     */
    Type;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
