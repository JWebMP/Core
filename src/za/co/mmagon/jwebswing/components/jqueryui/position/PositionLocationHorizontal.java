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
     * Position to the left
     */
    left,
    /**
     * Position to the Center
     */
    center,
    /**
     * Position to the right
     */
    right,
    left_bottom,;

    @Override
    public String toString()
    {
        return super.toString().replace('_', ' ');
    }

}
