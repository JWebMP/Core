package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Registers that the component has No Attributes
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public enum NoAttributes implements AttributeDefinitions
{

    ;

    @Override
    public boolean isKeyword()
    {
        return false;
    }

}
