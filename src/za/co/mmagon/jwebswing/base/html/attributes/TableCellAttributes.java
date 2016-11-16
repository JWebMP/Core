package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Valid additional attributes for table cells
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public enum TableCellAttributes implements AttributeDefinitions
{
    ColSpan,
    RowSpan;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
