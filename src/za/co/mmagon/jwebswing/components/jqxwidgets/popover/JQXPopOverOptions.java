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
package za.co.mmagon.jwebswing.components.jqxwidgets.popover;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
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
public class JQXPopOverOptions extends JQXDefaultJavaScriptPart
{

    private Integer arrowOffsetValue;// 	Number 	0
    private Integer animationOpenDelay;// 	String/Number 	'fast'
    private Integer animationCloseDelay;// 	String/Number 	'fast'
    private Boolean autoClose;// 	Boolean 	true
    private EasingEffects animationType;// 	String 	'none'
    private JavascriptFunction initContent;// 	String 	null
    private Boolean isModal;// 	Boolean 	false
    private JQXPopOverOffset offset;// 	Object 	null
    private JQXBoxPositions position;// 	String 	'left'
    private Boolean rtl;// 	Boolean 	false
    private String selector;// 	Id/jQuery Selector 	null
    private Boolean showArrow;// 	Boolean 	true
    private Boolean showCloseButton;// 	Boolean 	false
    private String title;// 	String 	""

    public JQXPopOverOptions()
    {

    }

    public Integer getArrowOffsetValue()
    {
        return arrowOffsetValue;
    }

    public void setArrowOffsetValue(Integer arrowOffsetValue)
    {
        this.arrowOffsetValue = arrowOffsetValue;
    }

    public Integer getAnimationOpenDelay()
    {
        return animationOpenDelay;
    }

    public void setAnimationOpenDelay(Integer animationOpenDelay)
    {
        this.animationOpenDelay = animationOpenDelay;
    }

    public Integer getAnimationCloseDelay()
    {
        return animationCloseDelay;
    }

    public void setAnimationCloseDelay(Integer animationCloseDelay)
    {
        this.animationCloseDelay = animationCloseDelay;
    }

    public Boolean getAutoClose()
    {
        return autoClose;
    }

    public void setAutoClose(Boolean autoClose)
    {
        this.autoClose = autoClose;
    }

    public EasingEffects getAnimationType()
    {
        return animationType;
    }

    public void setAnimationType(EasingEffects animationType)
    {
        this.animationType = animationType;
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

    public JQXPopOverOffset getOffset()
    {
        return offset;
    }

    public void setOffset(JQXPopOverOffset offset)
    {
        this.offset = offset;
    }

    public JQXBoxPositions getPosition()
    {
        return position;
    }

    public void setPosition(JQXBoxPositions position)
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

    public String getSelector()
    {
        return selector;
    }

    public void setSelector(Component selector)
    {
        this.selector = selector.getID(true);
    }

    public Boolean getShowArrow()
    {
        return showArrow;
    }

    public void setShowArrow(Boolean showArrow)
    {
        this.showArrow = showArrow;
    }

    public Boolean getShowCloseButton()
    {
        return showCloseButton;
    }

    public void setShowCloseButton(Boolean showCloseButton)
    {
        this.showCloseButton = showCloseButton;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}
