package za.co.mmagon.jwebswing.components.jqueryui.droppable;

/**
 * Specifies which mode to use for testing whether a draggable is hovering over a droppable. Possible values:
 *
 * "fit": Draggable overlaps the droppable entirely. "intersect": Draggable overlaps the droppable at least 50% in both directions. "pointer": Mouse pointer overlaps the droppable. "touch": Draggable
 * overlaps the droppable any amount.
 *
 * @since 2014/04/14
 * @version 1.0
 * @author MMagon
 *
 * 
 */
public enum JQUIDroppableTolerances
{
    Fit,
    Intersect,
    Pointer,
    Touch;
    
    /**
     * Returns the lower case value of the enumeration
     * @return The lower case value of the enumeration
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
