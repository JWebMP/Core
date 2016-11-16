package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Valid attributes for Tables
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public enum TableAttributes implements AttributeDefinitions
{
    CellSpacing,
    CellPadding;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
