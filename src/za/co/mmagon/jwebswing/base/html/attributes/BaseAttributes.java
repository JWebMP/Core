package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * The attributes for the Base tag
 *
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum BaseAttributes implements AttributeDefinitions
{
    Target,
    HRef,;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
