package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 *
 * @since
 * @version
 * @author MMagon
 *
 *
 */
public enum BodyAttributes implements AttributeDefinitions
{
    JWType;

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
