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
package za.co.mmagon.jwebswing.components.jqxWidgets.complexinput;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Dec 11, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXComplexInputOptions extends JQXDefaultJavaScriptPart
{

    private JQXDecimalNotations decimalNotation;// 	String 	'default'
    private Boolean disabled;// 	Boolean 	false

    private String placeHolder;// 	String 	''
    private Boolean roundedCorners;// 	boolean 	true
    private Boolean rtl;// 	Boolean 	false
    private Boolean spinButtons;// 	boolean 	false
    private Double spinButtonsStep;// 	Number 	1
    private String value;// 	String 	''

    public JQXComplexInputOptions()
    {

    }

    public JQXDecimalNotations getDecimalNotation()
    {
        return decimalNotation;
    }

    public void setDecimalNotation(JQXDecimalNotations decimalNotation)
    {
        this.decimalNotation = decimalNotation;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
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

    public Boolean getSpinButtons()
    {
        return spinButtons;
    }

    public void setSpinButtons(Boolean spinButtons)
    {
        this.spinButtons = spinButtons;
    }

    public Double getSpinButtonsStep()
    {
        return spinButtonsStep;
    }

    public void setSpinButtonsStep(Double spinButtonsStep)
    {
        this.spinButtonsStep = spinButtonsStep;
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
