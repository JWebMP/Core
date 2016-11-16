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
package za.co.mmagon.jwebswing.components.jqxWidgets.window;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXWindowOptions extends JavaScriptPart
{

    private Boolean autoOpen;// 	Boolean 	true
    private EasingEffects animationType;//	String 	fade
    private Boolean collapsed;//	Boolean 	false
    private Integer collapseAnimationDuration;//	Number 	150
    private String content;// 	String 	''
    private Integer closeAnimationDuration;//	Number 	350
    private Integer closeButtonSize;//	Number 	16
    private JQXWindowCloseButtonActions closeButtonAction;// 	String 	hide
    private Component cancelButton;//	Object 	null
    private JQXWindowDragArea dragArea;// 	Object 	null
    private Boolean draggable;//	Boolean 	true
    private Boolean disabled;//	Boolean 	false
    private JavascriptFunction initContent;// 	Method
    private Boolean isModal;//	Boolean 	false
    private String keyboardCloseKey;// 	Number/string 	'esc'
    private Boolean keyboardNavigation;// 	Boolean 	true
    private Integer minHeight;//	Number/String 	50
    private Integer maxHeight;//Number/String 	600
    private Integer minWidth;//Number/String 	50
    private Integer maxWidth;//Number/String 	600
    private Integer modalOpacity;//	Number 	0.3
    private Integer modalZIndex;//Number 	18000
    private Integer modalBackgroundZIndex;//	Number 	12990
    private Component okButton;//Object 	null
    private JQXWindowPositions position;//Object/String 	center
    private Boolean rtl;//Boolean 	false
    private Boolean resizable;//	Boolean 	true
    private Integer showAnimationDuration;//	Number 	350
    private Boolean showCloseButton;//;//Boolean 	true
    private Boolean showCollapseButton;// 	Boolean 	false
    private String title;//String 	''
    private Integer zIndex;//Number 	9001

    public Boolean getAutoOpen()
    {
        return autoOpen;
    }

    public void setAutoOpen(Boolean autoOpen)
    {
        this.autoOpen = autoOpen;
    }

    public EasingEffects getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(EasingEffects animationType)
    {
        this.animationType = animationType;
    }

    public Boolean getCollapsed()
    {
        return collapsed;
    }

    public void setCollapsed(Boolean collapsed)
    {
        this.collapsed = collapsed;
    }

    public Integer getCollapseAnimationDuration()
    {
        return collapseAnimationDuration;
    }

    public void setCollapseAnimationDuration(Integer collapseAnimationDuration)
    {
        this.collapseAnimationDuration = collapseAnimationDuration;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Integer getCloseAnimationDuration()
    {
        return closeAnimationDuration;
    }

    public void setCloseAnimationDuration(Integer closeAnimationDuration)
    {
        this.closeAnimationDuration = closeAnimationDuration;
    }

    public Integer getCloseButtonSize()
    {
        return closeButtonSize;
    }

    public void setCloseButtonSize(Integer closeButtonSize)
    {
        this.closeButtonSize = closeButtonSize;
    }

    public JQXWindowCloseButtonActions getCloseButtonAction()
    {
        return closeButtonAction;
    }

    public void setCloseButtonAction(JQXWindowCloseButtonActions closeButtonAction)
    {
        this.closeButtonAction = closeButtonAction;
    }

    public Component getCancelButton()
    {
        return cancelButton;
    }

    public void setCancelButton(Component cancelButton)
    {
        this.cancelButton = cancelButton;
    }

    public JQXWindowDragArea getDragArea()
    {
        return dragArea;
    }

    public void setDragArea(JQXWindowDragArea dragArea)
    {
        this.dragArea = dragArea;
    }

    public Boolean getDraggable()
    {
        return draggable;
    }

    public void setDraggable(Boolean draggable)
    {
        this.draggable = draggable;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public JavascriptFunction getInitContent()
    {
        return initContent;
    }

    public void setInitContent(JavascriptFunction initContent)
    {
        this.initContent = initContent;
    }

    public Boolean getIsModal()
    {
        return isModal;
    }

    public void setIsModal(Boolean isModal)
    {
        this.isModal = isModal;
    }

    public String getKeyboardCloseKey()
    {
        return keyboardCloseKey;
    }

    public void setKeyboardCloseKey(String keyboardCloseKey)
    {
        this.keyboardCloseKey = keyboardCloseKey;
    }

    public Boolean getKeyboardNavigation()
    {
        return keyboardNavigation;
    }

    public void setKeyboardNavigation(Boolean keyboardNavigation)
    {
        this.keyboardNavigation = keyboardNavigation;
    }

    public Integer getMinHeight()
    {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight)
    {
        this.minHeight = minHeight;
    }

    public Integer getMaxHeight()
    {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight)
    {
        this.maxHeight = maxHeight;
    }

    public Integer getMinWidth()
    {
        return minWidth;
    }

    public void setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
    }

    public Integer getMaxWidth()
    {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth)
    {
        this.maxWidth = maxWidth;
    }

    public Integer getModalOpacity()
    {
        return modalOpacity;
    }

    public void setModalOpacity(Integer modalOpacity)
    {
        this.modalOpacity = modalOpacity;
    }

    public Integer getModalZIndex()
    {
        return modalZIndex;
    }

    public void setModalZIndex(Integer modalZIndex)
    {
        this.modalZIndex = modalZIndex;
    }

    public Integer getModalBackgroundZIndex()
    {
        return modalBackgroundZIndex;
    }

    public void setModalBackgroundZIndex(Integer modalBackgroundZIndex)
    {
        this.modalBackgroundZIndex = modalBackgroundZIndex;
    }

    public Component getOkButton()
    {
        return okButton;
    }

    public void setOkButton(Component okButton)
    {
        this.okButton = okButton;
    }

    public JQXWindowPositions getPosition()
    {
        return position;
    }

    public void setPosition(JQXWindowPositions position)
    {
        this.position = position;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getResizable()
    {
        return resizable;
    }

    public void setResizable(Boolean resizable)
    {
        this.resizable = resizable;
    }

    public Integer getShowAnimationDuration()
    {
        return showAnimationDuration;
    }

    public void setShowAnimationDuration(Integer showAnimationDuration)
    {
        this.showAnimationDuration = showAnimationDuration;
    }

    public Boolean getShowCloseButton()
    {
        return showCloseButton;
    }

    public void setShowCloseButton(Boolean showCloseButton)
    {
        this.showCloseButton = showCloseButton;
    }

    public Boolean getShowCollapseButton()
    {
        return showCollapseButton;
    }

    public void setShowCollapseButton(Boolean showCollapseButton)
    {
        this.showCollapseButton = showCollapseButton;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getzIndex()
    {
        return zIndex;
    }

    public void setzIndex(Integer zIndex)
    {
        this.zIndex = zIndex;
    }

    public JQXWindowOptions()
    {

    }

}
