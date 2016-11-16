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
package za.co.mmagon.jwebswing.components.jqxWidgets.response;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXResponseOptions extends JavaScriptPart
{

    private String browser;// 	Returns information about the Browser.
    private String device;// 	Returns information about the Device.
    private String document;// 	Returns information about the document.
    private String destroy;// 	Destroys the plug-in.
    private String resize;// 	Callback function or functions called when the browser's window is resized.
    private String isHidden;// 	Checks whether a HTML Element is hidden.
    private String inViewPort;// 	Checks whether a HTML Element is in the view port.
    private String os;// 	Returns information about the OS.
    private String refresh;// 	Refreshes the plug-in properties.
    private String scroll;// 	Returns information about the Scrollbars position.
    private String viewPort;// 	Returns information about the view port.

    public JQXResponseOptions()
    {

    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getDevice()
    {
        return device;
    }

    public void setDevice(String device)
    {
        this.device = device;
    }

    public String getDocument()
    {
        return document;
    }

    public void setDocument(String document)
    {
        this.document = document;
    }

    public String getDestroy()
    {
        return destroy;
    }

    public void setDestroy(String destroy)
    {
        this.destroy = destroy;
    }

    public String getResize()
    {
        return resize;
    }

    public void setResize(String resize)
    {
        this.resize = resize;
    }

    public String getIsHidden()
    {
        return isHidden;
    }

    public void setIsHidden(String isHidden)
    {
        this.isHidden = isHidden;
    }

    public String getInViewPort()
    {
        return inViewPort;
    }

    public void setInViewPort(String inViewPort)
    {
        this.inViewPort = inViewPort;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getRefresh()
    {
        return refresh;
    }

    public void setRefresh(String refresh)
    {
        this.refresh = refresh;
    }

    public String getScroll()
    {
        return scroll;
    }

    public void setScroll(String scroll)
    {
        this.scroll = scroll;
    }

    public String getViewPort()
    {
        return viewPort;
    }

    public void setViewPort(String viewPort)
    {
        this.viewPort = viewPort;
    }

}
