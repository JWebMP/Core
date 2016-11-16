/*
 * Copyright (C) 2015 MXM3727
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
package za.co.mmagon.jwebswing.components.jqueryUI.colourpicker;

import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * The options granted by the spectrum plugin
 * <p>
 * @author GedMarc
 * @since 2015/05/02
 */
public class JQUIColourPickerOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The initial color will be set with the color option. If you don't pass in a color, Spectrum will use the value attribute on the input.
     * <p>
     * The color parsing is based on the TinyColor plugin. This should parse any color string you throw at it.
     */
    private String color;
    /**
     * This means that it will always show up at full size, and be positioned as an inline-block element. Look to the left for a full sized flat picker.
     */
    private Boolean flat;
    /**
     * You can add an input to allow free form typing. The color parsing is very permissive in the allowed strings. See TinyColor for more details.
     */
    private Boolean showInput;
    /**
     * Spectrum can show the color that was initially set when opening. This provides an easy way to click back to what was set when opened.
     */
    private Boolean showInitial;
    /**
     * If you specify both the showInput, showInitial, and allowEmpty options, the CSS keeps things in order by wrapping the buttons to the bottom row, and shrinking the input. Note: this is all
     * customizable via CSS.
     */
    private Boolean allowEmpty;
    /**
     * You can allow alpha transparency selection. Check out these examples:
     */
    private Boolean showAlpha;
    /**
     * You can have the colorpicker automatically hide after a palette color is selected.
     */
    private Boolean hideAfterPaletteSelect;
    /**
     * Spectrum can be automatically disabled if you pass in the disabled flag. Additionally, if the input that you initialize spectrum on is disabled, this will be the default value. Note: you cannot
     * enable spectrum if the input is disabled (see below).
     */
    private Boolean disabled;

    private String localStorageKey;
    /**
     * Spectrum can show a palette below the colorpicker to make it convenient for users to choose from frequently or recently used colors. When the colorpicker is closed, the current color will be
     * added to the palette if it isn't there already. Check it out here:
     */
    private Boolean showPalette;
    /**
     * If you'd like, spectrum can show the palettes you specify, and nothing else.
     */
    private Boolean showPaletteOnly;
    /**
     * Spectrum can show a button to toggle the colorpicker next to the palette. This way, the user can choose from a limited number of colors in the palette, but still be able to pick a color that's
     * not in the palette.
     * The default value for togglePaletteOnly is FALSE. Set it to TRUE to enable the Toggle button.
     * <p>
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     */
    private Boolean togglePaletteOnly;
    /**
     * You can show or hide the buttons using the showButtons property. If there are no buttons, the behavior will be to fire the `change` event (and update the original input) when the picker is
     * closed.
     */
    private Boolean showButtons;
    /**
     *
     * <p>
     * Spectrum can keep track of what has been selected by the user with the showSelectionPalette option.
     * <p>
     * If the localStorageKey option is defined, the selection will be saved in the browser's localStorage object
     * <p>
     */
    private Boolean showSelectionPalette;
    /**
     * When clicking outside of the colorpicker, you can force it to fire a change event rather than having it revert the change. This is true by default.
     */
    private Boolean clickoutFiresChange;
    /**
     * You can set the button's text using cancelText and chooseText properties.
     */
    private String cancelText;
    /**
     * You can set the button's text using cancelText and chooseText properties.
     */
    private String chooseText;
    /**
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     */
    private String togglePaletteMoreText;
    /**
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     */
    private String togglePaletteLessText;
    /**
     * You can add an additional class name to the just the container element using the containerClassName property.
     */
    private String containerClassName;
    /**
     * You can add an additional class name to just the replacer element using the replacerClassName property.
     */
    private String replacerClassName;
    /**
     *
     * <p>
     * You can set the format that is displayed in the text box.
     * <p>
     * This will also change the format that is displayed in the titles from the palette swatches.
     * <p>
     */
    private JQUIPaletteFormats preferredFormat;
    /**
     *
     * <p>
     * This is how many elements are allowed in the selectionPallete at once.
     * <p>
     * Elements will be removed from the palette in first in - first out order if this limit is reached.
     * <p>
     */
    private Integer maxSelectionSize;
    /**
     *
     */
    private JQUIColourPalettes palette;
    /**
     *
     * <p>
     * The default values inside of the selection palette. Make sure that showSelectionPalette and showPalette are both enabled.
     * <p>
     * If a localStorageKey is defined, then this value will be overwritten by it.
     * <p>
     */
    private JQUIColourPalette selectionPalette;

    /**
     * The initial color will be set with the color option. If you don't pass in a color, Spectrum will use the value attribute on the input.
     * <p>
     * The color parsing is based on the TinyColor plugin. This should parse any color string you throw at it.
     * <p>
     * @return
     */
    public String getColor()
    {
        return color;
    }

    /**
     * The initial color will be set with the color option. If you don't pass in a color, Spectrum will use the value attribute on the input.
     * <p>
     * The color parsing is based on the TinyColor plugin. This should parse any color string you throw at it.
     * <p>
     * @param color
     */
    public void setColor(ColourNames color)
    {
        this.color = color.getValue();
    }

    /**
     * This means that it will always show up at full size, and be positioned as an inline-block element. Look to the left for a full sized flat picker.
     * <p>
     * @return
     */
    public Boolean getFlat()
    {
        return flat;
    }

    /**
     * This means that it will always show up at full size, and be positioned as an inline-block element. Look to the left for a full sized flat picker.
     * <p>
     * @param flat
     */
    public void setFlat(Boolean flat)
    {
        this.flat = flat;
    }

    /**
     * You can add an input to allow free form typing. The color parsing is very permissive in the allowed strings. See TinyColor for more details.
     * <p>
     * @return
     */
    public Boolean getShowInput()
    {
        return showInput;
    }

    /**
     * You can add an input to allow free form typing. The color parsing is very permissive in the allowed strings. See TinyColor for more details.
     * <p>
     * @param showInput
     */
    public void setShowInput(Boolean showInput)
    {
        this.showInput = showInput;
    }

    /**
     * Spectrum can show the color that was initially set when opening. This provides an easy way to click back to what was set when opened.
     * <p>
     * @return
     */
    public Boolean getShowInitial()
    {
        return showInitial;
    }

    /**
     * Spectrum can show the color that was initially set when opening. This provides an easy way to click back to what was set when opened.
     * <p>
     * @param showInitial
     */
    public void setShowInitial(Boolean showInitial)
    {
        this.showInitial = showInitial;
    }

    /**
     * If you specify both the showInput, showInitial, and allowEmpty options, the CSS keeps things in order by wrapping the buttons to the bottom row, and shrinking the input. Note: this is all
     * customizable via CSS.
     * <p>
     * @return
     */
    public Boolean getAllowEmpty()
    {
        return allowEmpty;
    }

    /**
     * If you specify both the showInput, showInitial, and allowEmpty options, the CSS keeps things in order by wrapping the buttons to the bottom row, and shrinking the input. Note: this is all
     * customizable via CSS.
     * <p>
     * @param allowEmpty
     */
    public void setAllowEmpty(Boolean allowEmpty)
    {
        this.allowEmpty = allowEmpty;
    }

    /**
     * You can allow alpha transparency selection. Check out these examples:
     * <p>
     * @return
     */
    public Boolean getShowAlpha()
    {
        return showAlpha;
    }

    /**
     * You can allow alpha transparency selection. Check out these examples:
     * <p>
     * @param showAlpha
     */
    public void setShowAlpha(Boolean showAlpha)
    {
        this.showAlpha = showAlpha;
    }

    public String getLocalStorageKey()
    {
        return localStorageKey;
    }

    public void setLocalStorageKey(String localStorageKey)
    {
        this.localStorageKey = localStorageKey;
    }

    /**
     * Spectrum can show a palette below the colorpicker to make it convenient for users to choose from frequently or recently used colors. When the colorpicker is closed, the current color will be
     * added to the palette if it isn't there already. Check it out here:
     * <p>
     * @return
     */
    public Boolean getShowPalette()
    {
        return showPalette;
    }

    /**
     * Spectrum can show a palette below the colorpicker to make it convenient for users to choose from frequently or recently used colors. When the colorpicker is closed, the current color will be
     * added to the palette if it isn't there already. Check it out here:
     * <p>
     * @param showPalette
     */
    public void setShowPalette(Boolean showPalette)
    {
        this.showPalette = showPalette;
    }

    /**
     * If you'd like, spectrum can show the palettes you specify, and nothing else.
     * <p>
     * @return
     */
    public Boolean getShowPaletteOnly()
    {
        return showPaletteOnly;
    }

    /**
     * If you'd like, spectrum can show the palettes you specify, and nothing else.
     * <p>
     * @param showPaletteOnly
     */
    public void setShowPaletteOnly(Boolean showPaletteOnly)
    {
        this.showPaletteOnly = showPaletteOnly;
    }

    /**
     * Spectrum can show a button to toggle the colorpicker next to the palette. This way, the user can choose from a limited number of colors in the palette, but still be able to pick a color that's
     * not in the palette.
     * The default value for togglePaletteOnly is FALSE. Set it to TRUE to enable the Toggle button.
     * <p>
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     * <p>
     * @return
     */
    public Boolean getTogglePaletteOnly()
    {
        return togglePaletteOnly;
    }

    /**
     * Spectrum can show a button to toggle the colorpicker next to the palette. This way, the user can choose from a limited number of colors in the palette, but still be able to pick a color that's
     * not in the palette.
     * The default value for togglePaletteOnly is FALSE. Set it to TRUE to enable the Toggle button.
     * <p>
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     * <p>
     * @param togglePaletteOnly
     */
    public void setTogglePaletteOnly(Boolean togglePaletteOnly)
    {
        this.togglePaletteOnly = togglePaletteOnly;
    }

    /**
     *
     * <p>
     * Spectrum can keep track of what has been selected by the user with the showSelectionPalette option.
     * <p>
     * If the localStorageKey option is defined, the selection will be saved in the browser's localStorage object
     * <p>
     * @return
     */
    public Boolean getShowSelectionPalette()
    {
        return showSelectionPalette;
    }

    /**
     *
     * <p>
     * Spectrum can keep track of what has been selected by the user with the showSelectionPalette option.
     * <p>
     * If the localStorageKey option is defined, the selection will be saved in the browser's localStorage object
     * <p>
     * @param showSelectionPalette
     */
    public void setShowSelectionPalette(Boolean showSelectionPalette)
    {
        this.showSelectionPalette = showSelectionPalette;
    }

    /**
     * When clicking outside of the colorpicker, you can force it to fire a change event rather than having it revert the change. This is true by default.
     * <p>
     * @return
     */
    public Boolean getClickoutFiresChange()
    {
        return clickoutFiresChange;
    }

    /**
     * When clicking outside of the colorpicker, you can force it to fire a change event rather than having it revert the change. This is true by default.
     * <p>
     * @param clickoutFiresChange
     */
    public void setClickoutFiresChange(Boolean clickoutFiresChange)
    {
        this.clickoutFiresChange = clickoutFiresChange;
    }

    /**
     * You can set the button's text using cancelText and chooseText properties.
     * <p>
     * @return
     */
    public String getCancelText()
    {
        return cancelText;
    }

    /**
     * You can set the button's text using cancelText and chooseText properties.
     * <p>
     * @param cancelText
     */
    public void setCancelText(String cancelText)
    {
        this.cancelText = cancelText;
    }

    /**
     * You can set the button's text using cancelText and chooseText properties.
     * <p>
     * @return
     */
    public String getChooseText()
    {
        return chooseText;
    }

    /**
     * You can set the button's text using cancelText and chooseText properties.
     * <p>
     * @param chooseText
     */
    public void setChooseText(String chooseText)
    {
        this.chooseText = chooseText;
    }

    /**
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     * <p>
     * @return
     */
    public String getTogglePaletteMoreText()
    {
        return togglePaletteMoreText;
    }

    /**
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     * <p>
     * @param togglePaletteMoreText
     */
    public void setTogglePaletteMoreText(String togglePaletteMoreText)
    {
        this.togglePaletteMoreText = togglePaletteMoreText;
    }

    /**
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     * <p>
     * @return
     */
    public String getTogglePaletteLessText()
    {
        return togglePaletteLessText;
    }

    /**
     * You can also change the text on the Toggle Button with the options togglePaletteMoreText (default is "more") and togglePaletteLessText (default is "less").
     * <p>
     * @param togglePaletteLessText
     */
    public void setTogglePaletteLessText(String togglePaletteLessText)
    {
        this.togglePaletteLessText = togglePaletteLessText;
    }

    /**
     * You can add an additional class name to the just the container element using the containerClassName property.
     * <p>
     * @return
     */
    public String getContainerClassName()
    {
        return containerClassName;
    }

    /**
     * You can add an additional class name to the just the container element using the containerClassName property.
     * <p>
     * @param containerClassName
     */
    public void setContainerClassName(String containerClassName)
    {
        this.containerClassName = containerClassName;
    }

    /**
     * You can add an additional class name to just the replacer element using the replacerClassName property.
     * <p>
     * @return
     */
    public String getReplacerClassName()
    {
        return replacerClassName;
    }

    /**
     * You can add an additional class name to just the replacer element using the replacerClassName property.
     * <p>
     * @param replacerClassName
     */
    public void setReplacerClassName(String replacerClassName)
    {
        this.replacerClassName = replacerClassName;
    }

    /**
     *
     * <p>
     * You can set the format that is displayed in the text box.
     * <p>
     * This will also change the format that is displayed in the titles from the palette swatches.
     * <p>
     */
    public JQUIPaletteFormats getPreferredFormat()
    {
        return preferredFormat;
    }

    /**
     *
     * <p>
     * You can set the format that is displayed in the text box.
     * <p>
     * This will also change the format that is displayed in the titles from the palette swatches.
     * <p>
     */
    public void setPreferredFormat(JQUIPaletteFormats preferredFormat)
    {
        this.preferredFormat = preferredFormat;
    }

    /**
     *
     * <p>
     * This is how many elements are allowed in the selectionPallete at once.
     * <p>
     * Elements will be removed from the palette in first in - first out order if this limit is reached.
     * <p>
     * @return
     */
    public Integer getMaxSelectionSize()
    {
        return maxSelectionSize;
    }

    /**
     *
     * <p>
     * This is how many elements are allowed in the selectionPallete at once.
     * <p>
     * Elements will be removed from the palette in first in - first out order if this limit is reached.
     * <p>
     * @param maxSelectionSize
     */
    public void setMaxSelectionSize(Integer maxSelectionSize)
    {
        this.maxSelectionSize = maxSelectionSize;
    }

    public JQUIColourPalettes getPalette()
    {
        return palette;
    }

    public void setPalette(JQUIColourPalettes palette)
    {
        this.palette = palette;
    }

    /**
     *
     * <p>
     * The default values inside of the selection palette. Make sure that showSelectionPalette and showPalette are both enabled.
     * <p>
     * If a localStorageKey is defined, then this value will be overwritten by it.
     * <p>
     * @return
     */
    public JQUIColourPalette getSelectionPalette()
    {
        return selectionPalette;
    }

    /**
     *
     * <p>
     * The default values inside of the selection palette. Make sure that showSelectionPalette and showPalette are both enabled.
     * <p>
     * If a localStorageKey is defined, then this value will be overwritten by it.
     * <p>
     * @param selectionPalette
     */
    public void setSelectionPalette(JQUIColourPalette selectionPalette)
    {
        this.selectionPalette = selectionPalette;
    }

    /**
     * Spectrum can be automatically disabled if you pass in the disabled flag. Additionally, if the input that you initialize spectrum on is disabled, this will be the default value. Note: you cannot
     * enable spectrum if the input is disabled (see below).
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Spectrum can be automatically disabled if you pass in the disabled flag. Additionally, if the input that you initialize spectrum on is disabled, this will be the default value. Note: you cannot
     * enable spectrum if the input is disabled (see below).
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * You can have the colorpicker automatically hide after a palette color is selected.
     */
    public Boolean getHideAfterPaletteSelect()
    {
        return hideAfterPaletteSelect;
    }

    /**
     * You can have the colorpicker automatically hide after a palette color is selected.
     */
    public void setHideAfterPaletteSelect(Boolean hideAfterPaletteSelect)
    {
        this.hideAfterPaletteSelect = hideAfterPaletteSelect;
    }

    /**
     * You can show or hide the buttons using the showButtons property. If there are no buttons, the behavior will be to fire the `change` event (and update the original input) when the picker is
     * closed.
     * <p>
     * @return
     */
    public Boolean getShowButtons()
    {
        return showButtons;
    }

    /**
     * You can show or hide the buttons using the showButtons property. If there are no buttons, the behavior will be to fire the `change` event (and update the original input) when the picker is
     * closed.
     * <p>
     * @param showButtons
     */
    public void setShowButtons(Boolean showButtons)
    {
        this.showButtons = showButtons;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
