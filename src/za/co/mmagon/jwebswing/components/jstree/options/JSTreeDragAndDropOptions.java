/*
 * Copyright (C) 2016 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.components.jstree.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptLiteralFunction;

/**
 * This plugin makes it possible to drag and drop tree nodes and rearrange the tree.
 *
 * @author GedMarc
 * @since 23 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeDragAndDropOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * a boolean indicating if a copy should be possible while dragging (by pressint the meta key or Ctrl). Defaults to true.
     */
    private Boolean copy;
    /**
     * a number indicating how long a node should remain hovered while dragging to be opened. Defaults to 500.
     */
    @JsonProperty("open_timeout")
    private Integer openTimeout;

    /**
     * a function invoked each time a node is about to be dragged, invoked in the tree's scope and receives the nodes about to be dragged as an argument (array) and the event that started the drag -
     * return false to prevent dragging
     */
    @JsonProperty("is_draggable")
    private JavascriptLiteralFunction isDraggable;
    /**
     * a boolean indicating if checks should constantly be made while the user is dragging the node (as opposed to checking only on drop), default is true
     */
    @JsonProperty("check_while_dragging")
    private Boolean checkWhileDragging;
    /**
     * a boolean indicating if nodes from this tree should only be copied with dnd (as opposed to moved), default is false
     */
    @JsonProperty("always_copy")
    private Boolean alwaysCopy;
    /**
     * when dropping a node "inside", this setting indicates the position the node should go to - it can be an integer or a string: "first" (same as 0) or "last", default is 0
     */
    @JsonProperty("inside_pos")
    private JSTreeDragAndDropInsidePosition insidePosition;
    /**
     * when starting the drag on a node that is selected this setting controls if all selected nodes are dragged or only the single node, default is true, which means all selected nodes are dragged
     * when the drag is started on a selected node
     */
    @JsonProperty("drag_selection")
    private Boolean dragSelection;
    /**
     * controls whether dnd works on touch devices. If left as boolean true dnd will work the same as in desktop browsers, which in some cases may impair scrolling. If set to boolean false dnd will
     * not work on touch devices. There is a special third option - string "selected" which means only selected nodes can be dragged on touch devices.
     */
    private String touch;
    /**
     * controls whether items can be dropped anywhere on the node, not just on the anchor, by default only the node anchor is a valid drop target. Works best with the wholerow plugin. If enabled on
     * mobile depending on the interface it might be hard for the user to cancel the drop, since the whole tree container will be a valid drop target.
     */
    @JsonProperty("large_drop_target")
    private Boolean largeDropTarget;
    /**
     * controls whether a drag can be initiated from any part of the node and not just the text/icon part, works best with the wholerow plugin. Keep in mind it can cause problems with tree scrolling
     * on mobile depending on the interface - in that case set the touch option to "selected".
     */
    @JsonProperty("large_drag_target")
    private Boolean largeDragTarget;
    /**
     * controls whether use HTML5 dnd api instead of classical. That will allow better integration of dnd events with other HTML5 controls.
     */
    @JsonProperty("use_html5")
    private Boolean useHtml5;

    public JSTreeDragAndDropOptions()
    {

    }

    /**
     * a boolean indicating if a copy should be possible while dragging (by pressint the meta key or Ctrl). Defaults to true.
     *
     * @return
     */
    public Boolean getCopy()
    {
        return copy;
    }

    /**
     * a boolean indicating if a copy should be possible while dragging (by pressint the meta key or Ctrl). Defaults to true.
     *
     * @param copy
     */
    public void setCopy(Boolean copy)
    {
        this.copy = copy;
    }

    /**
     * a number indicating how long a node should remain hovered while dragging to be opened. Defaults to 500.
     *
     * @return
     */
    public Integer getOpenTimeout()
    {
        return openTimeout;
    }

    /**
     * a number indicating how long a node should remain hovered while dragging to be opened. Defaults to 500.
     *
     * @param openTimeout
     */
    public void setOpenTimeout(Integer openTimeout)
    {
        this.openTimeout = openTimeout;
    }

    /**
     * a function invoked each time a node is about to be dragged, invoked in the tree's scope and receives the nodes about to be dragged as an argument (array) and the event that started the drag -
     * return false to prevent dragging
     *
     * @return
     */
    public JavascriptLiteralFunction getIsDraggable()
    {
        return isDraggable;
    }

    /**
     * a function invoked each time a node is about to be dragged, invoked in the tree's scope and receives the nodes about to be dragged as an argument (array) and the event that started the drag -
     * return false to prevent dragging
     *
     * @param isDraggable
     */
    public void setIsDraggable(JavascriptLiteralFunction isDraggable)
    {
        this.isDraggable = isDraggable;
    }

    /**
     * a boolean indicating if checks should constantly be made while the user is dragging the node (as opposed to checking only on drop), default is true
     *
     * @return
     */
    public Boolean getCheckWhileDragging()
    {
        return checkWhileDragging;
    }

    /**
     * a boolean indicating if checks should constantly be made while the user is dragging the node (as opposed to checking only on drop), default is true
     *
     * @param checkWhileDragging
     */
    public void setCheckWhileDragging(Boolean checkWhileDragging)
    {
        this.checkWhileDragging = checkWhileDragging;
    }

    /**
     * a boolean indicating if nodes from this tree should only be copied with dnd (as opposed to moved), default is false
     *
     * @return
     */
    public Boolean getAlwaysCopy()
    {
        return alwaysCopy;
    }

    /**
     * a boolean indicating if nodes from this tree should only be copied with dnd (as opposed to moved), default is false
     *
     * @param alwaysCopy
     */
    public void setAlwaysCopy(Boolean alwaysCopy)
    {
        this.alwaysCopy = alwaysCopy;
    }

    /**
     * when dropping a node "inside", this setting indicates the position the node should go to - it can be an integer or a string: "first" (same as 0) or "last", default is 0
     *
     * @return
     */
    public JSTreeDragAndDropInsidePosition getInsidePosition()
    {
        return insidePosition;
    }

    /**
     * when dropping a node "inside", this setting indicates the position the node should go to - it can be an integer or a string: "first" (same as 0) or "last", default is 0
     *
     * @param insidePosition
     */
    public void setInsidePosition(JSTreeDragAndDropInsidePosition insidePosition)
    {
        this.insidePosition = insidePosition;
    }

    /**
     * when starting the drag on a node that is selected this setting controls if all selected nodes are dragged or only the single node, default is true, which means all selected nodes are dragged
     * when the drag is started on a selected node
     *
     * @return
     */
    public Boolean getDragSelection()
    {
        return dragSelection;
    }

    /**
     * when starting the drag on a node that is selected this setting controls if all selected nodes are dragged or only the single node, default is true, which means all selected nodes are dragged
     * when the drag is started on a selected node
     *
     * @param dragSelection
     */
    public void setDragSelection(Boolean dragSelection)
    {
        this.dragSelection = dragSelection;
    }

    /**
     * controls whether dnd works on touch devices. If left as boolean true dnd will work the same as in desktop browsers, which in some cases may impair scrolling. If set to boolean false dnd will
     * not work on touch devices. There is a special third option - string "selected" which means only selected nodes can be dragged on touch devices.
     *
     * @return
     */
    public String getTouch()
    {
        return touch;
    }

    /**
     * controls whether dnd works on touch devices. If left as boolean true dnd will work the same as in desktop browsers, which in some cases may impair scrolling. If set to boolean false dnd will
     * not work on touch devices. There is a special third option - string "selected" which means only selected nodes can be dragged on touch devices.
     *
     * @param touch
     */
    public void setTouch(String touch)
    {
        this.touch = touch;
    }

    /**
     * controls whether items can be dropped anywhere on the node, not just on the anchor, by default only the node anchor is a valid drop target. Works best with the wholerow plugin. If enabled on
     * mobile depending on the interface it might be hard for the user to cancel the drop, since the whole tree container will be a valid drop target.
     *
     * @return
     */
    public Boolean getLargeDropTarget()
    {
        return largeDropTarget;
    }

    /**
     * controls whether items can be dropped anywhere on the node, not just on the anchor, by default only the node anchor is a valid drop target. Works best with the wholerow plugin. If enabled on
     * mobile depending on the interface it might be hard for the user to cancel the drop, since the whole tree container will be a valid drop target.
     *
     * @param largeDropTarget
     */
    public void setLargeDropTarget(Boolean largeDropTarget)
    {
        this.largeDropTarget = largeDropTarget;
    }

    /**
     * controls whether a drag can be initiated from any part of the node and not just the text/icon part, works best with the wholerow plugin. Keep in mind it can cause problems with tree scrolling
     * on mobile depending on the interface - in that case set the touch option to "selected".
     *
     * @return
     */
    public Boolean getLargeDragTarget()
    {
        return largeDragTarget;
    }

    /**
     * controls whether a drag can be initiated from any part of the node and not just the text/icon part, works best with the wholerow plugin. Keep in mind it can cause problems with tree scrolling
     * on mobile depending on the interface - in that case set the touch option to "selected".
     *
     * @param largeDragTarget
     */
    public void setLargeDragTarget(Boolean largeDragTarget)
    {
        this.largeDragTarget = largeDragTarget;
    }

    /**
     * controls whether use HTML5 dnd api instead of classical. That will allow better integration of dnd events with other HTML5 controls.
     *
     * @return
     */
    public Boolean getUseHtml5()
    {
        return useHtml5;
    }

    /**
     * controls whether use HTML5 dnd api instead of classical. That will allow better integration of dnd events with other HTML5 controls.
     *
     * @param useHtml5
     */
    public void setUseHtml5(Boolean useHtml5)
    {
        this.useHtml5 = useHtml5;
    }

}
