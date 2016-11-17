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
package za.co.mmagon.jwebswing.components.jqxwidgets.colorpicker;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXColourModes;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXColorPickerOptions extends JQXDefaultJavaScriptPart
{

    private JQXColourModes colorMode;// 	String 	'saturation'
    private Boolean disabled;// 	Boolean 	false
    private Boolean showTransparent;// 	Boolean 	false
    private ColourHex color;

    public JQXColorPickerOptions()
    {

    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

    public JQXColourModes getColorMode()
    {
        return colorMode;
    }

    public void setColorMode(JQXColourModes colorMode)
    {
        this.colorMode = colorMode;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getShowTransparent()
    {
        return showTransparent;
    }

    public void setShowTransparent(Boolean showTransparent)
    {
        this.showTransparent = showTransparent;
    }

    public ColourHex getColor()
    {
        return color;
    }

    public void setColor(ColourHex color)
    {
        this.color = color;
    }

}
