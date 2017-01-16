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
package za.co.mmagon.jwebswing.components.jqxwidgets.docking;

import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
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
public class JQXDockingOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Boolean cookies;// 	Boolean 	false
    private JQXCookieOptions cookieOptions;// 	Object 	{}
    private Boolean disabled;// 	Boolean 	false
    private Double floatingWindowOpacity;// 	Number 	0.3
    private Boolean keyboardNavigation;// 	Boolean 	false
    private JQXDockingModes mode;// 	String 	default
    private Orientation orientation;// 	String 	horizontal
    private Boolean rtl;// 	Boolean 	false
    private JQXWindowsMode windowsMode;// 	Object 	null
    private Integer windowsOffset;// 	Number 	5

    public JQXDockingOptions()
    {

    }

    public Boolean getCookies()
    {
        return cookies;
    }

    public void setCookies(Boolean cookies)
    {
        this.cookies = cookies;
    }

    public JQXCookieOptions getCookieOptions()
    {
        return cookieOptions;
    }

    public void setCookieOptions(JQXCookieOptions cookieOptions)
    {
        this.cookieOptions = cookieOptions;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Double getFloatingWindowOpacity()
    {
        return floatingWindowOpacity;
    }

    public void setFloatingWindowOpacity(Double floatingWindowOpacity)
    {
        this.floatingWindowOpacity = floatingWindowOpacity;
    }

    public Boolean getKeyboardNavigation()
    {
        return keyboardNavigation;
    }

    public void setKeyboardNavigation(Boolean keyboardNavigation)
    {
        this.keyboardNavigation = keyboardNavigation;
    }

    public JQXDockingModes getMode()
    {
        return mode;
    }

    public void setMode(JQXDockingModes mode)
    {
        this.mode = mode;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public JQXWindowsMode getWindowsMode()
    {
        return windowsMode;
    }

    public void setWindowsMode(JQXWindowsMode windowsMode)
    {
        this.windowsMode = windowsMode;
    }

    public Integer getWindowsOffset()
    {
        return windowsOffset;
    }

    public void setWindowsOffset(Integer windowsOffset)
    {
        this.windowsOffset = windowsOffset;
    }

}
