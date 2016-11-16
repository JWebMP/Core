package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * MetaData Attributes
 *
 * @since 2013/11/13
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum MetaAttributes implements AttributeDefinitions
{
    Name,
    Schema,
    Http_Equiv,
    Content,
    Charset;

    /**
     * Returns the lowercase variant of the attribute
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
