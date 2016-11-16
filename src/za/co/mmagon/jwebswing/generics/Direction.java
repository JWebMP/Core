package za.co.mmagon.jwebswing.generics;

/**
 * Horizontal or Vertical
 * <p>
 * @since Directions
 * @version
 * @author MMagon
 *
 * <p>
 */
public enum Direction
{

    /**
     * A Horizontal Direction
     */
    Horizontal,
    /**
     * A Vertical Direction
     */
    Vertical;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

}
