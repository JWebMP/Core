package za.co.mmagon.jwebswing.components.jqMetro.metro;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Available attributes for the JWMetro Tile
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public enum TileAttributes implements AttributeDefinitions
{
    data_direction,
    data_mode,
    data_link;

    @Override
    public String toString()
    {
        return super.toString().replace('_', '-');
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
