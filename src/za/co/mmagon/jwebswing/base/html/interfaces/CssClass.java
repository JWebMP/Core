package za.co.mmagon.jwebswing.base.html.interfaces;

import java.io.Serializable;

/**
 * Describes an object as a CSS Field entry
 *
 * @since 2014/04/23
 * @author mmagon
 * @version 1.0
 */
public interface CssClass extends Serializable
{

    /**
     *
     * @return The class name this object must yield
     */
    public String getName();
}
