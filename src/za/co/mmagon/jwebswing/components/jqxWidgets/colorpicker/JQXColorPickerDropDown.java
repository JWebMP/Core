/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.jqxWidgets.colorpicker;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXColourModes;
import za.co.mmagon.jwebswing.components.jqxWidgets.dropdownlist.JQXDropDownButton;
import za.co.mmagon.jwebswing.components.jqxWidgets.dropdownlist.JQXDropDownListFeatures;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * jqxColorPicker represents a jQuery UI widget that allows you to easily pick a color. You can configure the jqxColorPicker's color mode, input a color in hex or rgb format.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXColorPickerDropDown extends JQXDropDownButton
{

    private static final long serialVersionUID = 1L;
    private JQXColorPicker colourPicker;
    private ColourHex colour;

    public JQXColorPickerDropDown()
    {
        colourPicker = new JQXColorPicker();
        colour = new ColourHex("ffaabb");
        getFeature().setSetContentMethod("getTextElementByColor(new $.jqx.color({ hex: '" + colour + "' }))");
        getFeatures().add(0, colourPicker.getFeature());
        getFeatures().add(new ColourPickerDropDownUpdate(this));
        colourPicker.getOptions().setHeight(220);
        colourPicker.getOptions().setWidth(220);
        colourPicker.getOptions().setColorMode(JQXColourModes.Hue);
        colourPicker.getOptions().setColor(colour);
        add(colourPicker);
    }

    public JQXColorPicker getColourPicker()
    {
        return colourPicker;
    }

    public void setColourPicker(JQXColorPicker colourPicker)
    {
        this.colourPicker = colourPicker;
    }

    public ColourHex getColour()
    {
        return colour;
    }

    public void setColour(ColourHex colour)
    {
        this.colour = colour;
    }

    public class ColourPickerDropDownUpdate extends Feature<JavaScriptPart, ColourPickerDropDownUpdate> implements GlobalFeatures, JQXDropDownListFeatures
    {

        private JQXColorPickerDropDown dropDown;

        public ColourPickerDropDownUpdate(JQXColorPickerDropDown dropDown)
        {
            super("JQXColourPickerContentUpdater");
            this.dropDown = dropDown;
            setComponent(dropDown);
        }

        @Override
        public void assignFunctionsToComponent()
        {
            addQuery("$('" + dropDown.getColourPicker().getID(true) + "').on('colorchange', function (event) {" + getNewLine()
                    + "$('" + dropDown.getID(true) + "').jqxDropDownButton('setContent', getTextElementByColor(event.args.color));" + getNewLine()
                    + "});" + getNewLine());
        }
    }
}
