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
package za.co.mmagon.jwebswing.components.jqxwidgets.checkbox;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the JQX CheckBox library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXCheckBoxOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Integer animationShowDelay;// 	Number 	250
    private Integer animationHideDelay;// 	Number 	300
    private String boxSize;// 	String 	"13px"
    private Boolean checked;// 	Boolean 	false
    private Boolean disabled;// 	Boolean 	false
    private Boolean enableContainerClick;// 	Boolean 	true
    private String groupName;// 	String 	""
    private Boolean hasThreeStates;// 	Boolean 	false
    private Boolean locked;// 	Boolean 	false
    private Boolean rtl;// 	Boolean 	false

    public JQXCheckBoxOptions()
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

    public String getBoxSize()
    {
        return boxSize;
    }

    public void setBoxSize(String boxSize)
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

    public Boolean getLocked()
    {
        return locked;
    }

    public void setLocked(Boolean locked)
    {
        this.locked = locked;
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
