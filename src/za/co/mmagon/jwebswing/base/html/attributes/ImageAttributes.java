package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Valid attributes for images
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public enum ImageAttributes implements AttributeDefinitions
{
    /**
     * Specifies the URL of an image
     */
    Src,
    /**
     * Specifies an alternate text for an image
     */
    ImageReplacementText,
    /**
     * Specifies an image as a server-side image-map
     */
    IsMap,
    /**
     * Specifies an image as a client-side image-map
     */
    UseMap,
    /**
     * Alternative text to display
     */
    Alt,
    /**
     * Specifies width as an attribute
     */
    Width,
    /**
     * Specifies height as an attribute
     */
    Height;

    /**
     * Returns the lowercase variant
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
