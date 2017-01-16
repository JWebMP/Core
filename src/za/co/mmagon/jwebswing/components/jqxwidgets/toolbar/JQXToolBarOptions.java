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
package za.co.mmagon.jwebswing.components.jqxwidgets.toolbar;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
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
public class JQXToolBarOptions extends JQXDefaultJavaScriptPart

{

    private static final long serialVersionUID = 1L;

    private Boolean disabled;// 	Boolean 	false
    private JavascriptFunction initTools;// 	function 	null
    private Integer minimizeWidth;// 	Number/String 	200
    private Integer minWidth;// 	Number/String 	null
    private Integer maxWidth;// 	Number/String 	null
    private Boolean rtl;// 	Boolean 	false
    private JQXToolbarTools tools;// 	String 	''

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public JavascriptFunction getInitTools()
    {
        return initTools;
    }

    public void setInitTools(JavascriptFunction initTools)
    {
        this.initTools = initTools;
    }

    public Integer getMinimizeWidth()
    {
        return minimizeWidth;
    }

    public void setMinimizeWidth(Integer minimizeWidth)
    {
        this.minimizeWidth = minimizeWidth;
    }

    public Integer getMinWidth()
    {
        return minWidth;
    }

    public void setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
    }

    public Integer getMaxWidth()
    {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth)
    {
        this.maxWidth = maxWidth;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public JQXToolbarTools getTools()
    {
        return tools;
    }

    public void setTools(JQXToolbarTools tools)
    {
        this.tools = tools;
    }

}
