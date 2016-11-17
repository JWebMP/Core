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
package za.co.mmagon.jwebswing.components.jqxwidgets.radiobutton;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXRadioButtonOptions extends JQXDefaultJavaScriptPart
{

    private Integer animationShowDelay;// 	Number 	250
    private Integer animationHideDelay;// 	Number 	300
    private MeasurementCSSImpl boxSize;// 	String 	"13px"
    private Boolean checked;// 	Boolean 	false
    private Boolean disabled;// 	Boolean 	false
    private Boolean enableContainerClick;// 	Boolean 	true
    private String groupName;// 	String 	""
    private Boolean hasThreeStates;// 	Boolean 	false
    private Boolean rtl;// 	Boolean 	false

    public JQXRadioButtonOptions()
    {

    }

    public Integer getAnimationShowDelay()
    {
        return animationShowDelay;
    }

    public void setAnimationShowDelay(Integer animationShowDelay)
    {
        this.animationShowDelay = animationShowDelay;
    }

    public Integer getAnimationHideDelay()
    {
        return animationHideDelay;
    }

    public void setAnimationHideDelay(Integer animationHideDelay)
    {
        this.animationHideDelay = animationHideDelay;
    }

    public MeasurementCSSImpl getBoxSize()
    {
        return boxSize;
    }

    public void setBoxSize(MeasurementCSSImpl boxSize)
    {
        this.boxSize = boxSize;
    }

    public Boolean getChecked()
    {
        return checked;
    }

    public void setChecked(Boolean checked)
    {
        this.checked = checked;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEnableContainerClick()
    {
        return enableContainerClick;
    }

    public void setEnableContainerClick(Boolean enableContainerClick)
    {
        this.enableContainerClick = enableContainerClick;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public Boolean getHasThreeStates()
    {
        return hasThreeStates;
    }

    public void setHasThreeStates(Boolean hasThreeStates)
    {
        this.hasThreeStates = hasThreeStates;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

}
