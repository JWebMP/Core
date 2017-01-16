/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxwidgets.dragdrop;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * jqxDragDrop is a plugin which will make any DOM element draggable. It can be used in combination with many widgets like jqxTree, jqxGrid, jqxListBox and etc.
 * <p>
 * @author GedMarc
 * @since Dec 13, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXDragDropOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private String appendTo;// 	String 	'parent'
    private Boolean disabled;// 	Boolean 	false
    private Integer distance;// 	Number 	5
    private JQXDragDropData data;// 	Object 	null
    private JQXDropAction dropAction;// 	String 	'default'
    private Component dropTarget;// 	String/Object 	null.
    private Integer dragZIndex;// 	Number 	99999
    private JQXDropFeedback feedback;//	String 	'clone'
//initFeedback 	Function 	null
    private Double opacity;// 	Number 	0.6
//onDragEnd 	Function 	null
//onDrag 	Function 	null
//onDragStart 	Function 	null
//onTargetDrop 	Function 	null
//onDropTargetEnter 	Function 	null
//onDropTargetLeave 	Function 	null
    private String restricter;// 	Object/String 	'document'
    private Boolean revert;// 	Boolean 	false
    private Integer revertDuration;// 	Number 	400
    private JQXDragDropTolerance tolerance;// 	String 	'intersect'

    public JQXDragDropOptions()
    {

    }

    public String getAppendTo()
    {
        return appendTo;
    }

    public void setAppendTo(Component appendTo)
    {
        this.appendTo = appendTo.getID(true);
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Integer getDistance()
    {
        return distance;
    }

    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    public JQXDragDropData getData()
    {
        return data;
    }

    public void setData(JQXDragDropData data)
    {
        this.data = data;
    }

    public JQXDropAction getDropAction()
    {
        return dropAction;
    }

    public void setDropAction(JQXDropAction dropAction)
    {
        this.dropAction = dropAction;
    }

    public Component getDropTarget()
    {
        return dropTarget;
    }

    public void setDropTarget(Component dropTarget)
    {
        this.dropTarget = dropTarget;
    }

    public Integer getDragZIndex()
    {
        return dragZIndex;
    }

    public void setDragZIndex(Integer dragZIndex)
    {
        this.dragZIndex = dragZIndex;
    }

    public JQXDropFeedback getFeedback()
    {
        return feedback;
    }

    public void setFeedback(JQXDropFeedback feedback)
    {
        this.feedback = feedback;
    }

    public Double getOpacity()
    {
        return opacity;
    }

    public void setOpacity(Double opacity)
    {
        this.opacity = opacity;
    }

    public String getRestricter()
    {
        return restricter;
    }

    public void setRestricter(Component restricter)
    {
        this.restricter = restricter.getID(true);
    }

    public Boolean getRevert()
    {
        return revert;
    }

    public void setRevert(Boolean revert)
    {
        this.revert = revert;
    }

    public Integer getRevertDuration()
    {
        return revertDuration;
    }

    public void setRevertDuration(Integer revertDuration)
    {
        this.revertDuration = revertDuration;
    }

    public JQXDragDropTolerance getTolerance()
    {
        return tolerance;
    }

    public void setTolerance(JQXDragDropTolerance tolerance)
    {
        this.tolerance = tolerance;
    }

}
