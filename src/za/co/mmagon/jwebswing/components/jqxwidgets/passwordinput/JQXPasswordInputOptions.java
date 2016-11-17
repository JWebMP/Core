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
package za.co.mmagon.jwebswing.components.jqxwidgets.passwordinput;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the Password Input library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXPasswordInputOptions extends JQXDefaultJavaScriptPart
{

    private Boolean disabled;// 	Boolean 	false
    //localization 	Object
    private Integer maxLength;// 	Number 	null
    private String placeHolder;// 	String 	null
    private JavascriptFunction passwordStrength;// 	Function 	null
    private Boolean rtl;// 	Boolean 	false
    private Boolean strengthColors;// 	Object
    private Boolean showStrength;// 	Boolean 	true
    private JQXPasswordInputPosition showStrengthPosition;// 	String 	"right"
    private JavascriptFunction strengthTypeRenderer;// 	Function 	null
    private Boolean showPasswordIcon;// 	Boolean 	true

    public JQXPasswordInputOptions()
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

    public Integer getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength)
    {
        this.maxLength = maxLength;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    public JavascriptFunction getPasswordStrength()
    {
        return passwordStrength;
    }

    public void setPasswordStrength(JavascriptFunction passwordStrength)
    {
        this.passwordStrength = passwordStrength;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getStrengthColors()
    {
        return strengthColors;
    }

    public void setStrengthColors(Boolean strengthColors)
    {
        this.strengthColors = strengthColors;
    }

    public Boolean getShowStrength()
    {
        return showStrength;
    }

    public void setShowStrength(Boolean showStrength)
    {
        this.showStrength = showStrength;
    }

    public JQXPasswordInputPosition getShowStrengthPosition()
    {
        return showStrengthPosition;
    }

    public void setShowStrengthPosition(JQXPasswordInputPosition showStrengthPosition)
    {
        this.showStrengthPosition = showStrengthPosition;
    }

    public JavascriptFunction getStrengthTypeRenderer()
    {
        return strengthTypeRenderer;
    }

    public void setStrengthTypeRenderer(JavascriptFunction strengthTypeRenderer)
    {
        this.strengthTypeRenderer = strengthTypeRenderer;
    }

    public Boolean getShowPasswordIcon()
    {
        return showPasswordIcon;
    }

    public void setShowPasswordIcon(Boolean showPasswordIcon)
    {
        this.showPasswordIcon = showPasswordIcon;
    }

}
