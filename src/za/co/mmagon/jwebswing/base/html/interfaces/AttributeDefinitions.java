package za.co.mmagon.jwebswing.base.html.interfaces;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This interface marks a class or enumeration as a valid attribute value set
 *
 * @author MMagon
 * @since 21 Jul 2013
 * @version 1.0
 */
public interface AttributeDefinitions
{

    /**
     * returns the attribute tag name to use
     *
     * @return
     */
    @JsonValue
    @Override
    public String toString();

    /**
     * Returns if this attribute is just a keyword, or a key/value pair
     *
     * @return
     */
    public boolean isKeyword();
}
