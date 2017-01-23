package za.co.mmagon.jwebswing.components.jqueryui.position;

/**
 * Positions for the location horizontal
 * <p>
 * @author MMagon
 * @since 07 Apr 2013
 * @version 1.0
 */
public enum PositionLocationHorizontal
{

    /**
     * Position to the Left
     */
    Left,
    /**
     * Position to the Center
     */
    Center,
    /**
     * Position to the Right
     */
    Right,
    /**
     * Places at Left bottom
     */
    Left_Bottom,;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase().replace('_', ' ');
    }

}
