/*
 * Copyright (C) 2014 mmagon
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
package za.co.mmagon.jwebswing.components.jqueryui.dialog;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqueryui.position.Position;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The options available for the JQuery Dialog feature
 *
 * @author mmagon
 */
public class JQUIDialogOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The component to append to
     */
    private Component appendTo;
    /**
     * If the component should auto open
     */
    private Boolean autoOpen;
    /**
     * TODO : buttons implementation
     */
    //private Component[] buttons;
    /**
     * if it should close on esc key
     */
    private Boolean closeOnEscape;
    /**
     * the text for the close item
     */
    private String closeText;
    /**
     * The class for the dialog
     */
    private String dialogClass;
    /**
     * if the dialog is draggable
     */
    private Boolean draggable;
    /**
     * The height of the Draggable item
     */
    private Integer height;
    /**
     * If this dialog should hide
     */
    private Boolean hide;
    /**
     * The maximum height for this dialog
     */
    private Integer maxHeight;
    /**
     * The maximum width for this dialog
     */
    private Integer maxWidth;
    /**
     * The minimum height for this dialog
     */
    private Integer minHeight;
    /**
     * The minimum width for this dialog
     */
    private Integer minWidth;
    /**
     * If the dialog is a modal
     */
    private Boolean modal;
    /**
     * the position of the modal
     */
    private Position position;
    /**
     * If the modal is resiable
     */
    private Boolean resizable;
    /**
     * Show the dialog
     */
    private Boolean show;
    /**
     * The title of the dialog
     */
    private String title;
    /**
     * The width of the dialog
     */
    private Integer width;

    /**
     * Which element the dialog (and overlay, if modal) should be appended to.
     *
     * @return
     */
    public Component getAppendTo()
    {
        return appendTo;
    }

    /**
     * Which element the dialog (and overlay, if modal) should be appended to.
     *
     * @param appendTo
     */
    public void setAppendTo(Component appendTo)
    {
        this.appendTo = appendTo;
    }

    /**
     * If set to true, the dialog will automatically open upon initialization. If false, the dialog will stay hidden until the open() method is called.
     *
     * @return
     */
    public Boolean getAutoOpen()
    {
        return autoOpen;
    }

    /**
     * If set to true, the dialog will automatically open upon initialization. If false, the dialog will stay hidden until the open() method is called.
     *
     * @param autoOpen
     */
    public void setAutoOpen(Boolean autoOpen)
    {
        this.autoOpen = autoOpen;
    }

    /**
     * Specifies whether the dialog should close when it has focus and the user presses the escape (ESC) key.
     *
     * @return
     */
    public Boolean getCloseOnEscape()
    {
        return closeOnEscape;
    }

    /**
     * Specifies whether the dialog should close when it has focus and the user presses the escape (ESC) key.
     *
     * @param closeOnEscape
     */
    public void setCloseOnEscape(Boolean closeOnEscape)
    {
        this.closeOnEscape = closeOnEscape;
    }

    /**
     * Specifies the text for the close button. Note that the close text is visibly hidden when using a standard theme
     *
     * @return
     */
    public String getCloseText()
    {
        return closeText;
    }

    /**
     * Specifies the text for the close button. Note that the close text is visibly hidden when using a standard theme
     *
     * @param closeText
     */
    public void setCloseText(String closeText)
    {
        this.closeText = closeText;
    }

    /**
     * The specified class name(s) will be added to the dialog, for additional theming.
     *
     * @return
     */
    public String getDialogClass()
    {
        return dialogClass;
    }

    /**
     * The specified class name(s) will be added to the dialog, for additional theming.
     *
     * @param dialogClass
     */
    public void setDialogClass(String dialogClass)
    {
        this.dialogClass = dialogClass;
    }

    /**
     * If set to true, the dialog will be draggable by the title bar. Requires the jQuery UI Draggable widget to be included.
     *
     * @return
     */
    public Boolean getDraggable()
    {
        return draggable;
    }

    /**
     * If set to true, the dialog will be draggable by the title bar. Requires the jQuery UI Draggable widget to be included.
     *
     * @param draggable
     */
    public void setDraggable(Boolean draggable)
    {
        this.draggable = draggable;
    }

    /**
     * The height of the dialog.
     *
     * @return
     */
    public Integer getHeight()
    {
        return height;
    }

    /**
     * The height of the dialog.
     *
     * @param height
     */
    public void setHeight(Integer height)
    {
        this.height = height;
    }

    /**
     * If and how to animate the hiding of the dialog.
     *
     * @return
     */
    public Boolean getHide()
    {
        return hide;
    }

    /**
     * If and how to animate the hiding of the dialog.
     *
     * @param hide
     */
    public void setHide(Boolean hide)
    {
        this.hide = hide;
    }

    /**
     * The maximum height to which the dialog can be resized, in pixels.
     *
     * @return
     */
    public Integer getMaxHeight()
    {
        return maxHeight;
    }

    /**
     * The maximum height to which the dialog can be resized, in pixels.
     *
     * @param maxHeight
     */
    public void setMaxHeight(Integer maxHeight)
    {
        this.maxHeight = maxHeight;
    }

    /**
     * The maximum width to which the dialog can be resized, in pixels.
     *
     * @return
     */
    public Integer getMaxWidth()
    {
        return maxWidth;
    }

    /**
     * The maximum width to which the dialog can be resized, in pixels.
     *
     * @param maxWidth
     */
    public void setMaxWidth(Integer maxWidth)
    {
        this.maxWidth = maxWidth;
    }

    /**
     * The minimum height to which the dialog can be resized, in pixels.
     *
     * @return
     */
    public Integer getMinHeight()
    {
        return minHeight;
    }

    /**
     * The minimum height to which the dialog can be resized, in pixels.
     *
     * @param minHeight
     */
    public void setMinHeight(Integer minHeight)
    {
        this.minHeight = minHeight;
    }

    /**
     * The minimum width to which the dialog can be resized, in pixels.
     *
     * @return
     */
    public Integer getMinWidth()
    {
        return minWidth;
    }

    /**
     * The minimum width to which the dialog can be resized, in pixels.
     *
     * @param minWidth
     */
    public void setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
    }

    /**
     * If set to true, the dialog will have modal behavior; other items on the page will be disabled, i.e., cannot be interacted with. Modal dialogs create an overlay below the dialog but above other
     * page elements.
     *
     * @return
     */
    public Boolean getModal()
    {
        return modal;
    }

    /**
     * If set to true, the dialog will have modal behavior; other items on the page will be disabled, i.e., cannot be interacted with. Modal dialogs create an overlay below the dialog but above other
     * page elements.
     *
     * @param modal
     */
    public void setModal(Boolean modal)
    {
        this.modal = modal;
    }

    /**
     *
     * <p>
     * Specifies where the dialog should be displayed when opened. The dialog will handle collisions such that as much of the dialog is visible as possible.
     * <p>
     * The of property defaults to the window, but you can specify another element to position against. You can refer to the jQuery UI Position utility for more details about the available properties.
     *
     * @return
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     *
     * <p>
     * Specifies where the dialog should be displayed when opened. The dialog will handle collisions such that as much of the dialog is visible as possible.
     * <p>
     * The of property defaults to the window, but you can specify another element to position against. You can refer to the jQuery UI Position utility for more details about the available properties.
     *
     * @param position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * If set to true, the dialog will be resizable. Requires the jQuery UI Resizable widget to be included
     *
     * @return
     */
    public Boolean getResizable()
    {
        return resizable;
    }

    /**
     * If set to true, the dialog will be resizable. Requires the jQuery UI Resizable widget to be included
     *
     * @param resizable
     */
    public void setResizable(Boolean resizable)
    {
        this.resizable = resizable;
    }

    /**
     * If and how to animate the showing of the dialog.
     *
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * If and how to animate the showing of the dialog.
     *
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Specifies the title of the dialog. If the value is null, the title attribute on the dialog source element will be used.
     *
     * @return
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Specifies the title of the dialog. If the value is null, the title attribute on the dialog source element will be used.
     *
     * @param title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * The width of the dialog, in pixels
     *
     * @return
     */
    public Integer getWidth()
    {
        return width;
    }

    /**
     * The width of the dialog, in pixels
     *
     * @param width
     */
    public void setWidth(Integer width)
    {
        this.width = width;
    }
}
