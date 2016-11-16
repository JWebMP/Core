package za.co.mmagon.jwebswing.generics;

/**
 * Specifies all the 8 point Compass Points
 * 
 * @since 2014/05/16
 * @version 1.0
 * @author MMagon
 *  
 * History : Previously Resize Handler Points
 * 
 */

public enum CompassPoints 
{
    /**
     * North
     */
    N, 
    /**
     * East
     */
    E, 
    /**
     * South
     */
    S, 
    /**
     * West
     */
    W, 
    /**
     * North-East
     */
    NE, 
    /**
     * South-East
     */
    SE, 
    /**
     * South West
     */
    SW, 
    /**
     * North West
     */
    NW, 
    /**
     * All Handles
     */
    ALL;
    
    /**
     * Returns the name of this Resize Handler
     * @return Lowercase Name
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
        
    }
}
