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
package za.co.mmagon.jwebswing.components.jqxwidgets.formattedinput;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXFormattedInputOptions extends JQXDefaultJavaScriptPart
{

    private Boolean disabled;// 	Boolean 	false
    private JQXDecimalNotation decimalNotation;// 	String 	"default"
    private Boolean dropDown;// 	Boolean 	false
    private Integer dropDownWidth;// 	Number/String 	null
    private Long min;// 	String 	'-9223372036854775808'
    private Long max;//	'9223372036854775807'
    private String placeHolder;// 	String 	''
    private Integer popupZIndex;// 	Number 	20000
    private Boolean roundedCorners;// 	boolean 	true
    private Boolean rtl;// 	Boolean 	false
    private Integer radix;// 	Number/String 	10
    private Boolean spinButtons;// 	Boolean 	true
    private Integer spinButtonsStep;// 	Number 	1
    private Boolean upperCase;// 	boolean 	false
    private String value;// 	String 	'0'

    public JQXFormattedInputOptions()
    {

    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public JQXDecimalNotation getDecimalNotation()
    {
        return decimalNotation;
    }

    public void setDecimalNotation(JQXDecimalNotation decimalNotation)
    {
        this.decimalNotation = decimalNotation;
    }

    public Boolean getDropDown()
    {
        return dropDown;
    }

    public void setDropDown(Boolean dropDown)
    {
        this.dropDown = dropDown;
    }

    public Integer getDropDownWidth()
    {
        return dropDownWidth;
    }

    public void setDropDownWidth(Integer dropDownWidth)
    {
        this.dropDownWidth = dropDownWidth;
    }

    public Long getMin()
    {
        return min;
    }

    public void setMin(Long min)
    {
        this.min = min;
    }

    public Long getMax()
    {
        return max;
    }

    public void setMax(Long max)
    {
        this.max = max;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    public Integer getPopupZIndex()
    {
        return popupZIndex;
    }

    public void setPopupZIndex(Integer popupZIndex)
    {
        this.popupZIndex = popupZIndex;
    }

    public Boolean getRoundedCorners()
    {
        return roundedCorners;
    }

    public void setRoundedCorners(Boolean roundedCorners)
    {
        this.roundedCorners = roundedCorners;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Integer getRadix()
    {
        return radix;
    }

    public void setRadix(Integer radix)
    {
        this.radix = radix;
    }

    public Boolean getSpinButtons()
    {
        return spinButtons;
    }

    public void setSpinButtons(Boolean spinButtons)
    {
        this.spinButtons = spinButtons;
    }

    public Integer getSpinButtonsStep()
    {
        return spinButtonsStep;
    }

    public void setSpinButtonsStep(Integer spinButtonsStep)
    {
        this.spinButtonsStep = spinButtonsStep;
    }

    public Boolean getUpperCase()
    {
        return upperCase;
    }

    public void setUpperCase(Boolean upperCase)
    {
        this.upperCase = upperCase;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
