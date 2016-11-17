package za.co.mmagon.jwebswing.components.jqueryui.draggable;

/**
 * Keeps the revert settings for a draggable
 * <p>
 * @since 2014/04/14
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public enum JQUIDraggableRevertOptions
{

    /**
     * If set to "invalid", revert will only occur if the draggable has not been dropped on a droppable.
     */
    Invalid,
    /**
     * If set to "valid", revert will only occur if the draggable has been dropped on a droppable.
     * Why would anyone use this?
     */
    Valid;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

}
