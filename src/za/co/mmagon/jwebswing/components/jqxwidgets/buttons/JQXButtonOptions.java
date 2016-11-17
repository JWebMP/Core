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
package za.co.mmagon.jwebswing.components.jqxwidgets.buttons;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXRoundedCornerTypes;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXButtonOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * Specifies the interval between two Click events. This property is available only in the jqxRepeatButton. The jqxRepeatButton raises Click events repeatedly when the button is pressed.
     */
    private Integer delay;// 	Number 	50
    /**
     * Enables or disables the button.
     */
    private Boolean disabled;// 	Boolean 	false
    /**
     * Enables or disables the rounded corners functionality. This property setting has effect in browsers which support CSS border-radius.
     * Possible Values:
     * <p>
     * 'all' - for all corners
     * <p>
     * 'top'- for top corners
     * <p>
     * 'bottom' - for bottom corners
     * <p>
     * 'left' - for left corners
     * <p>
     * 'right' - for right corners
     * <p>
     * 'top-right' - for top right corners
     * <p>
     * 'top-left' - for top left corners
     * <p>
     * 'bottom-right' - for bottom right corners
     * <p>
     * 'bottom-left' - for bottom left corners
     */
    private JQXRoundedCornerTypes roundedCorners;// 	String 	'jqx-rc-all'
    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     */
    private Boolean rtl;//;// 	false
    /**
     * etermines the button's template as an alternative of the default styles.
     * Possible Values:
     * <p>
     * 'default' - the default button's template. The button's style depends only on its "theme" property value.
     * <p>
     * 'primary' - dark blue button for extra visual weight.
     * <p>
     * 'success' - green button for successful or positive action.
     * <p>
     * 'warning' - orange button which indicates caution.
     * <p>
     * 'danger' - red button which indicates a dangerous or negative action.
     * <p>
     * 'inverse' - dark gray button, not tied to a semantic action or use.
     * <p>
     * 'info' - blue button, not tied to a semantic action or use.
     * <p>
     * 'link' - making it look like a link .
     */
    private JQXButtonTemplates template;// 	String 	'default'
    private Boolean toggled;// 	Boolean 	false

    private String imgSrc;
    private Integer imgWidth;
    private Integer imgHeight;
    private JQXButtonImagesPositions imgPosition;
    private JQXButtonImagesPositions textPosition;
    private JQXButtonTextImageRelation textImageRelation;
    
    private String value;

    public JQXButtonOptions()
    {

    }

    /**
     * Specifies the interval between two Click events. This property is available only in the jqxRepeatButton. The jqxRepeatButton raises Click events repeatedly when the button is pressed.
     *
     * @return
     */
    public Integer getDelay()
    {
        return delay;
    }

    /**
     * Specifies the interval between two Click events. This property is available only in the jqxRepeatButton. The jqxRepeatButton raises Click events repeatedly when the button is pressed.
     *
     * @param delay
     */
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }

    /**
     * Enables or disables the button.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Enables or disables the button.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Enables or disables the rounded corners functionality. This property setting has effect in browsers which support CSS border-radius.
     * Possible Values:
     * <p>
     * 'all' - for all corners
     * <p>
     * 'top'- for top corners
     * <p>
     * 'bottom' - for bottom corners
     * <p>
     * 'left' - for left corners
     * <p>
     * 'right' - for right corners
     * <p>
     * 'top-right' - for top right corners
     * <p>
     * 'top-left' - for top left corners
     * <p>
     * 'bottom-right' - for bottom right corners
     * <p>
     * 'bottom-left' - for bottom left corners
     *
     * @return
     */
    public JQXRoundedCornerTypes getRoundedCorners()
    {
        return roundedCorners;
    }

    /**
     * Enables or disables the rounded corners functionality. This property setting has effect in browsers which support CSS border-radius.
     * Possible Values:
     * <p>
     * 'all' - for all corners
     * <p>
     * 'top'- for top corners
     * <p>
     * 'bottom' - for bottom corners
     * <p>
     * 'left' - for left corners
     * <p>
     * 'right' - for right corners
     * <p>
     * 'top-right' - for top right corners
     * <p>
     * 'top-left' - for top left corners
     * <p>
     * 'bottom-right' - for bottom right corners
     * <p>
     * 'bottom-left' - for bottom left corners
     *
     * @param roundedCorners
     */
    public void setRoundedCorners(JQXRoundedCornerTypes roundedCorners)
    {
        this.roundedCorners = roundedCorners;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @return
     */
    public Boolean getRtl()
    {
        return rtl;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @param rtl
     */
    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    /**
     * etermines the button's template as an alternative of the default styles.
     * Possible Values:
     * <p>
     * 'default' - the default button's template. The button's style depends only on its "theme" property value.
     * <p>
     * 'primary' - dark blue button for extra visual weight.
     * <p>
     * 'success' - green button for successful or positive action.
     * <p>
     * 'warning' - orange button which indicates caution.
     * <p>
     * 'danger' - red button which indicates a dangerous or negative action.
     * <p>
     * 'inverse' - dark gray button, not tied to a semantic action or use.
     * <p>
     * 'info' - blue button, not tied to a semantic action or use.
     * <p>
     * 'link' - making it look like a link .
     *
     * @return
     */
    public JQXButtonTemplates getTemplate()
    {
        return template;
    }

    /**
     * etermines the button's template as an alternative of the default styles.
     * Possible Values:
     * <p>
     * 'default' - the default button's template. The button's style depends only on its "theme" property value.
     * <p>
     * 'primary' - dark blue button for extra visual weight.
     * <p>
     * 'success' - green button for successful or positive action.
     * <p>
     * 'warning' - orange button which indicates caution.
     * <p>
     * 'danger' - red button which indicates a dangerous or negative action.
     * <p>
     * 'inverse' - dark gray button, not tied to a semantic action or use.
     * <p>
     * 'info' - blue button, not tied to a semantic action or use.
     * <p>
     * 'link' - making it look like a link .
     *
     * @param template
     */
    public void setTemplate(JQXButtonTemplates template)
    {
        this.template = template;
    }

    /**
     * Sets or gets the button's toggle state. ( available in jqxToggleButton ).
     *
     * @return
     */
    public Boolean getToggled()
    {
        return toggled;
    }

    /**
     * Sets or gets the button's toggle state. ( available in jqxToggleButton ).
     *
     * @param toggled
     */
    public void setToggled(Boolean toggled)
    {
        this.toggled = toggled;
    }

    /**
     * Set the imgSrc property.
     * <p>
     * $('#jqxButton').jqxButton({ imgSrc: '../../images/andrew.png' });
     *
     * @return
     */
    public String getImgSrc()
    {
        return imgSrc;
    }

    /**
     * Set the imgSrc property.
     * <p>
     * $('#jqxButton').jqxButton({ imgSrc: '../../images/andrew.png' });
     *
     * @param imgSrc
     */
    public void setImgSrc(String imgSrc)
    {
        this.imgSrc = imgSrc;
    }

    /**
     * Sets or gets the button's image width. 
     * @return 
     */
    public Integer getImgWidth()
    {
        return imgWidth;
    }

    /**
     * Sets or gets the button's image width. 
     * @param imgWidth 
     */
    public void setImgWidth(Integer imgWidth)
    {
        this.imgWidth = imgWidth;
    }

    /**
     * Sets or gets the button's image height. 
     * @return 
     */
    public Integer getImgHeight()
    {
        return imgHeight;
    }

    /**
     * Sets or gets the button's image height. 
     * @param imgHeight 
     */
    public void setImgHeight(Integer imgHeight)
    {
        this.imgHeight = imgHeight;
    }

    /**
     * Sets or gets the button's image position. Possible values: "left", "top", "center", "bottom", "right", "topLeft", "bottomLeft", "topRight", "bottomRight". 
     * @return 
     */
    public JQXButtonImagesPositions getImgPosition()
    {
        return imgPosition;
    }

    /**
     * Sets or gets the button's image position. Possible values: "left", "top", "center", "bottom", "right", "topLeft", "bottomLeft", "topRight", "bottomRight". 
     * @param imgPosition 
     */
    public void setImgPosition(JQXButtonImagesPositions imgPosition)
    {
        this.imgPosition = imgPosition;
    }

    /**
     * Sets or gets the button's image position. Possible values: "left", "top", "center", "bottom", "right", "topLeft", "bottomLeft", "topRight", "bottomRight". 
     * @return 
     */
    public JQXButtonImagesPositions getTextPosition()
    {
        return textPosition;
    }

    /**
     * Sets or gets the button's image position. Possible values: "left", "top", "center", "bottom", "right", "topLeft", "bottomLeft", "topRight", "bottomRight". 
     * @param textPosition 
     */
    public void setTextPosition(JQXButtonImagesPositions textPosition)
    {
        this.textPosition = textPosition;
    }

    /**
     * Sets or gets the button's text image relation. Possible values: "imageBeforeText", "imageAboveText", "textAboveImage", "textBeforeImage" and "overlay". 
     * @return 
     */
    public JQXButtonTextImageRelation getTextImageRelation()
    {
        return textImageRelation;
    }

    /**
     * Sets or gets the button's text image relation. Possible values: "imageBeforeText", "imageAboveText", "textAboveImage", "textBeforeImage" and "overlay". 
     * @param textImageRelation 
     */
    public void setTextImageRelation(JQXButtonTextImageRelation textImageRelation)
    {
        this.textImageRelation = textImageRelation;
    }

    /**
     * Sets or gets the button's value. 
     * @return 
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets or gets the button's value. 
     * @param value 
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    
}
