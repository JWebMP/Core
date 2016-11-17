package za.co.mmagon.jwebswing.components.jqueryui.draggable;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Cursors;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * Provides all the options available to the Draggable Feature Implementation
 * <p>
 * @since 2014/09/09
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class JQUIDraggableOptions extends JavaScriptPart
{

    /**
     * If set to false, will prevent the ui-draggable class from being added. This may be desired as a performance optimization when calling .draggable() on hundreds of elements.
     */
    private Boolean addClasses = true;
    /**
     * Which element the draggable helper should be appended to while dragging.
     */
    private String appendTo;
    /**
     * Constrains dragging to either the horizontal (x) or vertical (y) axis. Possible values: "x", "y".
     */
    private Axis axis;

    /**
     * Prevents dragging from starting on specified elements. Default: "input,textarea,button,select,option"
     */
    private ArrayList<String> cancelObjects = new ArrayList();
    /**
     * Allows the draggable to be dropped onto the specified sortables. If this option is used, a draggable can be dropped onto a sortable list and then becomes part of it. Note: The helper option
     * must be set to "clone" in order to work flawlessly.
     */
    private String connectToSortableType;
    /**
     * Constrains dragging to within the bounds of the specified element or region.
     */
    private String containment;
    /**
     * The CSS cursor during the drag operation.
     */
    private String cursor;
    /**
     * Time in milliseconds after mousedown until dragging should start. This option can be used to prevent unwanted drags when clicking on an element.
     */
    private Integer delay;
    /**
     * Disables the draggable if set to true.
     */
    private Boolean disabled;
    /**
     * Distance in pixels after mousedown the mouse must move before dragging should start. This option can be used to prevent unwanted drags when clicking on an element.
     */
    private Integer distance;
    /**
     * Snaps the dragging helper to a grid, every x and y pixels. The array must be of the form [ x, y ].
     */
    private Integer[] grid;
    /**
     * If specified, restricts dragging from starting unless the mousedown occurs on the specified element(s). Only elements that descend from the draggable element are permitted.
     */
    private String handle;
    /**
     * Allows for a helper element to be used for dragging display.
     *
     * The element will be cloned and the clone will be dragged.
     */
    private Boolean helper;
    /**
     * Specify a component to use as a helper component. Warning : This component will be made invisible.
     */
    private String helperComponent;

    /**
     * Prevent iframes from capturing the mousemove events during a drag. Useful in combination with the cursorAt option, or in any case where the mouse cursor may not be over the helper.
     */
    private Boolean iFrameFix;
    /**
     * Opacity for the helper while being dragged.
     */
    private Double opacity;
    /**
     * If set to true, all droppable positions are calculated on every mousemove. Caution: This solves issues on highly dynamic pages, but dramatically decreases performance.
     */
    private Boolean refreshPositions;
    /**
     * Whether the element should revert to its start position when dragging stops.
     *
     * Boolean: If set to true the element will always revert.
     */
    private Boolean revert;
    /**
     * If set to "invalid", revert will only occur if the draggable has not been dropped on a droppable. For "valid", it's the other way around.
     */
    private JQUIDraggableRevertOptions revertOption;
    /**
     * The duration of the revert animation, in milliseconds. Ignored if the revert option is false.
     */
    private Integer revertDuration;
    /**
     * Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted by the droppable.
     */
    private String scope;
    /**
     * If set to true, container auto-scrolls while dragging.
     */
    private Boolean scroll;
    /**
     * Distance in pixels from the edge of the viewport after which the viewport should scroll. Distance is relative to pointer, not the draggable. Ignored if the scroll option is false.
     */
    private Integer scrollSensitivity;
    /**
     * The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Ignored if the scroll option is false.
     */
    private Integer scrollSpeed;
    /**
     * Whether the element should snap to other elements.
     */
    private Boolean snap;
    /**
     * A selector specifying which elements to snap to.
     */
    private String snapComponent;
    /**
     * Determines which edges of snap elements the draggable will snap to. Ignored if the snap option is false. Possible values: "inner", "outer", "both".
     */
    private JQUIDraggableSnapModes snapMode;
    /**
     * The distance in pixels from the snap element edges at which snapping should occur. Ignored if the snap option is false.
     */
    private Integer snapTolerance;
    /**
     * Controls the z-index of the set of elements that match the selector, always brings the currently dragged item to the front. Very useful in things like window managers.
     */
    private Component stack;
    /**
     * Z-index for the helper while being dragged.
     */
    private Integer zIndex;

    /**
     * Returns if Add Classes setting
     *
     * @return
     */
    public Boolean isAddClasses()
    {
        return addClasses;
    }

    /**
     * If set to false, will prevent the ui-draggable class from being added. This may be desired as a performance optimization when calling .draggable() on hundreds of elements.
     *
     * @param addClasses True or false denoting add classes or not
     */
    public void setAddClasses(Boolean addClasses)
    {
        this.addClasses = addClasses;
    }

    /**
     * Which element the draggable helper should be appended to while dragging.
     *
     * @return The component that the draggable helper should be appended to while dragging.
     */
    public String getAppendTo()
    {
        return appendTo;
    }

    /**
     * Which element the draggable helper should be appended to while dragging.
     *
     * @param appendTo Which element the draggable helper should be appended to while dragging.
     */
    public void setAppendTo(Component appendTo)
    {
        this.appendTo = appendTo.getID(true);
    }

    /**
     * Constrains dragging to either the horizontal (x) or vertical (y) axis. Possible values: "x", "y".
     *
     * @return The axis set or Null
     */
    public Axis getAxis()
    {
        return axis;
    }

    /**
     * Constrains dragging to either the horizontal (x) or vertical (y) axis. Possible values: "x", "y" or Null;
     *
     * @param axis
     */
    public void setAxis(Axis axis)
    {
        this.axis = axis;
    }

    /**
     * Prevents dragging from starting on specified elements.
     *
     * @return The component array that is set as prevent dragging
     */
    public ArrayList<String> getCancelObjects()
    {
        return cancelObjects;
    }

    /**
     * Prevents dragging from starting on specified elements.
     *
     * @param cancelObjects An ArrayList of objects to exclude from the Draggable element
     */
    public void setCancelObjects(ArrayList<String> cancelObjects)
    {

        this.cancelObjects = cancelObjects;
    }

    /**
     * Allows the draggable to be dropped onto the specified sortables. If this option is used, a draggable can be dropped onto a sortable list and then becomes part of it. Note: The helper option
     * must be set to "clone" in order to work flawlessly. Requires the jQuery UI Sortable plugin to be included.
     *
     * @return The component linked to
     */
    public String getConnectToSortableType()
    {
        return connectToSortableType;
    }

    /**
     * Allows the draggable to be dropped onto the specified sortables. If this option is used, a draggable can be dropped onto a sortable list and then becomes part of it. Note: The helper option
     * must be set to "clone" in order to work flawlessly. Requires the jQuery UI Sortable plugin to be included.
     *
     * @param connectToSortableType The component to add
     */
    public void setConnectToSortableType(Component connectToSortableType)
    {
        this.connectToSortableType = connectToSortableType.getID(true);
    }

    /**
     * Constrains dragging to within the bounds of the specified element or region.
     *
     * @return The component that dragging is contained to
     */
    public String getContainment()
    {
        return containment;
    }

    /**
     * Constrains dragging to within the bounds of the specified element or region.
     *
     * @param containment The component to contain to
     */
    public void setContainment(Component containment)
    {
        this.containment = containment.getID(true);
    }

    /**
     * The current cursor set or NULL if unset
     *
     * @return
     */
    public String getCursor()
    {
        return cursor;
    }

    /**
     * Sets the cursor during drag operation or NULL to remove setting
     *
     * @param cursor The cursor to set to
     */
    public void setCursor(Cursors cursor)
    {
        this.cursor = cursor.toString();
    }

    /**
     * Time in milliseconds after mousedown until dragging should start. This option can be used to prevent unwanted drags when clicking on an element.
     *
     * @return the time in MS
     */
    public Integer getDelay()
    {
        return delay;
    }

    /**
     * Time in milliseconds after mousedown until dragging should start. This option can be used to prevent unwanted drags when clicking on an element.
     *
     * @param delay The delay in milliseconds to set
     */
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }

    /**
     * Returns if this draggable feature is disabled or not
     *
     * @return The disabled flag
     */
    public Boolean isDisabled()
    {
        return disabled;
    }

    /**
     * Sets the disabled value of the draggable feature
     *
     * @param disabled True sets this disabled. Should update on an AJAX call.
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Distance in pixels after mousedown the mouse must move before dragging should start. This option can be used to prevent unwanted drags when clicking on an element.
     *
     * @return The distance, 0 if unset
     */
    public Integer getDistance()
    {
        return distance;
    }

    /**
     * Distance in pixels after mousedown the mouse must move before dragging should start. This option can be used to prevent unwanted drags when clicking on an element.
     *
     * @param distance The distance to set
     */
    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    /**
     * Get the grid values set or null
     *
     * @return An Integer[] of x and y or null
     */
    public Integer[] getGrid()
    {
        return grid;
    }

    /**
     * Snaps the dragging helper to a grid, every x and y pixels. The array must be of the form [ x, y ].
     *
     * @param x The X Axis
     * @param y The Y Axis
     */
    public void setGrid(Integer x, Integer y)
    {
        this.grid = new Integer[]
        {
            x, y
        };
    }

    /**
     * If specified, restricts dragging from starting unless the mousedown occurs on the specified element(s). Only elements that descend from the draggable element are permitted.
     *
     * @return The component that the handle is set on
     */
    public String getHandle()
    {
        return handle;
    }

    /**
     * If specified, restricts dragging from starting unless the mousedown occurs on the specified element(s). Only elements that descend from the draggable element are permitted.
     *
     * @param handle The component to set the handle on
     */
    public void setHandle(Component handle)
    {
        this.handle = handle.getID(true);
    }

    /**
     * Allows for a helper element to be used for dragging display.
     *
     * The element will be cloned and the clone will be dragged.
     *
     * @return If the element must be cloned
     */
    public Boolean isHelper()
    {
        return helper;
    }

    /**
     * Allows for a helper element to be used for dragging display.
     *
     * The element will be cloned and the clone will be dragged.
     *
     * @param helper Set to clone the element or not
     */
    public void setHelper(Boolean helper)
    {
        this.helper = helper;
    }

    /**
     *
     * Specify a component to use as a helper component. Warning : This component will be made invisible.
     *
     * @return
     */
    public String getHelperComponent()
    {
        return helperComponent;
    }

    /**
     * Specify a component to use as a helper component. Warning : This component will be made invisible.
     *
     * @param helperComponent The component to set it to
     */
    public void setHelperComponent(Component helperComponent)
    {
        this.helperComponent = helperComponent.getID(true);
    }

    /**
     * Prevent iframes from capturing the mousemove events during a drag. Useful in combination with the cursorAt option, or in any case where the mouse cursor may not be over the helper.
     *
     * @return If iFrames will be covered
     */
    public Boolean isiFrameFix()
    {
        return iFrameFix;
    }

    /**
     * Prevent iframes from capturing the mousemove events during a drag. Useful in combination with the cursorAt option, or in any case where the mouse cursor may not be over the helper.
     *
     * @param iFrameFix Set if IFrames will be covered
     */
    public void setiFrameFix(Boolean iFrameFix)
    {
        this.iFrameFix = iFrameFix;
    }

    /**
     * Opacity for the helper while being dragged.
     *
     * @return The opacity of the helper - 0.0 is default
     */
    public Double getOpacity()
    {
        return opacity;
    }

    /**
     * Opacity for the helper while being dragged.
     *
     * @param opacity Sets the opacity to a maximum of 1.0 = 0.0 removes all opacity
     */
    public void setOpacity(Double opacity)
    {
        this.opacity = opacity;
    }

    /**
     * If set to true, all droppable positions are calculated on every mousemove. Caution: This solves issues on highly dynamic pages, but dramatically decreases performance.
     *
     * @return The refresh position setting
     */
    public Boolean isRefreshPositions()
    {
        return refreshPositions;
    }

    /**
     * If set to true, all droppable positions are calculated on every mousemove. Caution: This solves issues on highly dynamic pages, but dramatically decreases performance.
     *
     * @param refreshPositions Sets the refresh position value
     */
    public void setRefreshPositions(Boolean refreshPositions)
    {
        this.refreshPositions = refreshPositions;
    }

    /**
     * @return Whether the element should revert to its start position when dragging stops.
     */
    public Boolean isRevert()
    {
        return revert;
    }

    /**
     * Whether the element should revert to its start position when dragging stops.
     *
     * @param revert Whether the element should revert to its start position when dragging stops.
     */
    public void setRevert(Boolean revert)
    {
        this.revert = revert;
    }

    /**
     *
     * @return If set to "invalid", revert will only occur if the draggable has not been dropped on a droppable. For "valid", it's the other way around.
     */
    public JQUIDraggableRevertOptions getRevertOption()
    {
        return revertOption;
    }

    /**
     *
     * @param revertOption If set to "invalid", revert will only occur if the draggable has not been dropped on a droppable. For "valid", it's the other way around.
     */
    public void setRevertOption(JQUIDraggableRevertOptions revertOption)
    {
        this.revertOption = revertOption;
    }

    /**
     *
     * @return The duration of the revert animation, in milliseconds. Ignored if the revert option is false.
     */
    public Integer getRevertDuration()
    {
        return revertDuration;
    }

    /**
     *
     * @param revertDuration The duration of the revert animation, in milliseconds. Ignored if the revert option is false.
     */
    public void setRevertDuration(Integer revertDuration)
    {
        this.revertDuration = revertDuration;
    }

    /**
     * Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted by the droppable.
     *
     * @return The scope set for this Draggable feature
     */
    public final String getScope()
    {
        return scope;
    }

    /**
     * Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted by the droppable.
     *
     * @param scope The scope to set for this draggable
     */
    public final void setScope(String scope)
    {
        this.scope = scope;
    }

    /**
     *
     * @return If set to true, container auto-scrolls while dragging.
     */
    public Boolean isScroll()
    {
        return scroll;
    }

    /**
     *
     * @param scroll If set to true, container auto-scrolls while dragging.
     */
    public void setScroll(Boolean scroll)
    {
        this.scroll = scroll;
    }

    /**
     *
     * @return Distance in pixels from the edge of the viewport after which the viewport should scroll. Distance is relative to pointer, not the draggable. Ignored if the scroll option is false.
     */
    public Integer getScrollSensitivity()
    {
        return scrollSensitivity;
    }

    /**
     *
     * @param scrollSensitivity Distance in pixels from the edge of the viewport after which the viewport should scroll. Distance is relative to pointer, not the draggable. Ignored if the scroll
     *                          option is false.
     */
    public void setScrollSensitivity(Integer scrollSensitivity)
    {
        this.scrollSensitivity = scrollSensitivity;
    }

    /**
     *
     * @return The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Ignored if the scroll option is false.
     */
    public Integer getScrollSpeed()
    {
        return scrollSpeed;
    }

    /**
     *
     * @param scrollSpeed The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Ignored if the scroll option is false.
     */
    public void setScrollSpeed(Integer scrollSpeed)
    {
        this.scrollSpeed = scrollSpeed;
    }

    /**
     *
     * @return Whether the element should snap to other elements.
     */
    public Boolean isSnap()
    {
        return snap;
    }

    /**
     *
     * @param snap Whether the element should snap to other elements.
     */
    public void setSnap(Boolean snap)
    {
        this.snap = snap;
    }

    /**
     *
     * @return A selector specifying which elements to snap to.
     */
    public String getSnapComponent()
    {
        return snapComponent;
    }

    /**
     *
     * @param snapComponent A selector specifying which elements to snap to.
     */
    public void setSnapComponent(Component snapComponent)
    {
        this.snapComponent = snapComponent.getID(true);
    }

    /**
     *
     * @return Determines which edges of snap elements the draggable will snap to. Ignored if the snap option is false. Possible values: "inner", "outer", "both".
     */
    public JQUIDraggableSnapModes getSnapMode()
    {
        return snapMode;
    }

    /**
     *
     * @param snapMode Determines which edges of snap elements the draggable will snap to. Ignored if the snap option is false. Possible values: "inner", "outer", "both".
     */
    public void setSnapMode(JQUIDraggableSnapModes snapMode)
    {
        this.snapMode = snapMode;
    }

    /**
     *
     * @return The distance in pixels from the snap element edges at which snapping should occur. Ignored if the snap option is false.
     */
    public Integer getSnapToleranceType()
    {
        return snapTolerance;
    }

    /**
     *
     * @param snapToleranceType The distance in pixels from the snap element edges at which snapping should occur. Ignored if the snap option is false.
     */
    public void setSnapToleranceType(Integer snapToleranceType)
    {
        this.snapTolerance = snapToleranceType;
    }

    /**
     *
     * @return The distance in pixels from the snap element edges at which snapping should occur. Ignored if the snap option is false.
     */
    public Integer getSnapTolerance()
    {
        return snapTolerance;
    }

    /**
     *
     * @param snapTolerance The distance in pixels from the snap element edges at which snapping should occur. Ignored if the snap option is false.
     */
    public void setSnapTolerance(Integer snapTolerance)
    {
        this.snapTolerance = snapTolerance;
    }

    /**
     *
     * @return Controls the z-index of the set of elements that match the selector, always brings the currently dragged item to the front. Very useful in things like window managers.
     */
    public Component getStack()
    {
        return stack;
    }

    /**
     *
     * @param stack Controls the z-index of the set of elements that match the selector, always brings the currently dragged item to the front. Very useful in things like window managers.
     */
    public void setStack(Component stack)
    {
        this.stack = stack;
    }

    /**
     *
     * @return Z-index for the helper while being dragged.
     */
    public Integer getzIndex()
    {
        return zIndex;
    }

    /**
     *
     * @param zIndex Z-index for the helper while being dragged.
     */
    public void setzIndex(Integer zIndex)
    {
        this.zIndex = zIndex;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
