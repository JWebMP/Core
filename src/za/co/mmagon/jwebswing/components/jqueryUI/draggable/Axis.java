package za.co.mmagon.jwebswing.components.jqueryUI.draggable;

/**
 * Valid Axis Settings
 * <p>
 * @since 2014/04/13
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
/**
 * Specifies Axis that the draggable feature can be put on
 */
public enum Axis
{

    /**
     * The X Axis
     */
    X,
    /**
     * The Y Axis
     */
    Y;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

}
