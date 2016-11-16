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
package za.co.mmagon.jwebswing.components.jqxWidgets.panel;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXPanelOptions extends JQXDefaultJavaScriptPart
{

    private Boolean autoUpdate;// 	Boolean 	false
    private Boolean disabled;// 	Boolean 	false
    private Boolean rtl;// 	Boolean 	false
    private JQXPanelSizeModes sizeMode;// 	String 	'fixed'
    private Integer scrollBarSize;// 	Number 	17

    public JQXPanelOptions()
    {

    }

    public Boolean getAutoUpdate()
    {
        return autoUpdate;
    }

    /**
     * Automatically updates the panel, if its children size is changed.
     *
     * @param autoUpdate
     */
    public void setAutoUpdate(Boolean autoUpdate)
    {
        this.autoUpdate = autoUpdate;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public JQXPanelSizeModes getSizeMode()
    {
        return sizeMode;
    }

    public void setSizeMode(JQXPanelSizeModes sizeMode)
    {
        this.sizeMode = sizeMode;
    }

    public Integer getScrollBarSize()
    {
        return scrollBarSize;
    }

    public void setScrollBarSize(Integer scrollBarSize)
    {
        this.scrollBarSize = scrollBarSize;
    }

}
