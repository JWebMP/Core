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
package za.co.mmagon.jwebswing.components.jqxWidgets.numberinput;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxWidgets.buttons.JQXButtonTemplates;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXNumberInputOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Boolean allowNull;
    private Double decimal;// 	Number 	0
    private Boolean disabled;// 	Boolean 	false
    private Integer decimalDigits;// 	Number 	2
    private Character decimalSeparator;// 	Char 	'.'
    private Integer digits;// 	Number 	8
    private Character groupSeparator;// 	Char 	','
    private Integer groupSize;// 	Number 	3
    private JQXNumberInputOptionsModes inputMode;// 	String 	'advanced'
    private Integer min;// 	Number 	-99999999
    private Integer max;// 	Number 	99999999
    private String negativeSymbol;// 	String 	'-'
    private Character promptChar;// 	Char 	-
    private String placeHolder;
    private Boolean rtl;// 	Boolean 	false
    private Boolean readOnly;// 	Boolean 	false
    private String spinMode;// 	String 	'advanced'
    private Boolean spinButtons;// 	Boolean 	false
    private Integer spinButtonsWidth;// 	Number 	18
    private Integer spinButtonsStep;// 	Number 	1
    private String symbol;// 	String 	''
    private JQXNumberInputTextAlignments symbolPosition;// 	String 	'left'
    private JQXNumberInputTextAlignments textAlign;// 	String 	'right'
    private JQXButtonTemplates template;

    /**
     * Determines whether the widget's value could be null.
     *
     * @return
     */
    public Boolean getAllowNull()
    {
        return allowNull;
    }

    /**
     * Determines whether the widget's value could be null.
     *
     * @param allowNull
     */
    public void setAllowNull(Boolean allowNull)
    {
        this.allowNull = allowNull;
    }

    /**
     * Sets or gets the input's number.
     *
     * @return
     */
    public Double getDecimal()
    {
        return decimal;
    }

    /**
     * Sets or gets the input's number.
     *
     * @param decimal
     */
    public void setDecimal(Double decimal)
    {
        this.decimal = decimal;
    }

    /**
     * Determines whether jqxNumberInput is disabled.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Determines whether jqxNumberInput is disabled.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Indicates the number of decimal places to use in numeric values.
     *
     * @return
     */
    public Integer getDecimalDigits()
    {
        return decimalDigits;
    }

    /**
     * Indicates the number of decimal places to use in numeric values.
     *
     * @param decimalDigits
     */
    public void setDecimalDigits(Integer decimalDigits)
    {
        this.decimalDigits = decimalDigits;
    }

    /**
     * Sets or gets the char to use as the decimal separator in numeric values.
     *
     * @return
     */
    public Character getDecimalSeparator()
    {
        return decimalSeparator;
    }

    /**
     * Sets or gets the char to use as the decimal separator in numeric values.
     *
     * @param decimalSeparator
     */
    public void setDecimalSeparator(Character decimalSeparator)
    {
        this.decimalSeparator = decimalSeparator;
    }

    /**
     * Sets or gets the digits in the input
     *
     * @return
     */
    public Integer getDigits()
    {
        return digits;
    }

    /**
     * Sets or gets the digits in the input
     *
     * @param digits
     */
    public void setDigits(Integer digits)
    {
        this.digits = digits;
    }

    /**
     * Sets or gets the string that separates groups of digits to the left of the decimal in numeric values.
     *
     * @return
     */
    public Character getGroupSeparator()
    {
        return groupSeparator;
    }

    /**
     * Sets or gets the string that separates groups of digits to the left of the decimal in numeric values.
     *
     * @param groupSeparator
     */
    public void setGroupSeparator(Character groupSeparator)
    {
        this.groupSeparator = groupSeparator;
    }

    /**
     * Sets or gets the number of digits in each group to the left of the decimal in numeric values.
     * default 3
     *
     * @return
     */
    public Integer getGroupSize()
    {
        return groupSize;
    }

    /**
     * Sets or gets the number of digits in each group to the left of the decimal in numeric values.
     *
     * @param groupSize
     */
    public void setGroupSize(Integer groupSize)
    {
        this.groupSize = groupSize;
    }

    /**
     * Sets or gets the input's mode.
     * Possible Values:
     * <p>
     * 'advanced'- the number input behavior resembles a masked input with numeric mask
     * <p>
     * 'simple'-the widget works as a normal textbox, but restricts the user's input to numbers
     *
     * @return
     */
    public JQXNumberInputOptionsModes getInputMode()
    {
        return inputMode;
    }

    /**
     * Sets or gets the input's mode.
     * Possible Values:
     * <p>
     * 'advanced'- the number input behavior resembles a masked input with numeric mask
     * <p>
     * 'simple'-the widget works as a normal textbox, but restricts the user's input to numbers
     *
     * @param inputMode
     */
    public void setInputMode(JQXNumberInputOptionsModes inputMode)
    {
        this.inputMode = inputMode;
    }

    /**
     * Sets or gets the input's minimum value.
     *
     * @return
     */
    public Integer getMin()
    {
        return min;
    }

    /**
     * Sets or gets the input's minimum value.
     *
     * @param min
     */
    public void setMin(Integer min)
    {
        this.min = min;
    }

    /**
     * Sets or gets the input's maximum value.
     *
     * @return
     */
    public Integer getMax()
    {
        return max;
    }

    /**
     * Sets or gets the input's maximum value.
     *
     * @param max
     */
    public void setMax(Integer max)
    {
        this.max = max;
    }

    /**
     * Sets or gets the string to use as negative symbol.
     *
     * @return
     */
    public String getNegativeSymbol()
    {
        return negativeSymbol;
    }

    /**
     * Sets or gets the string to use as negative symbol.
     *
     * @param negativeSymbol
     */
    public void setNegativeSymbol(String negativeSymbol)
    {
        this.negativeSymbol = negativeSymbol;
    }

    /**
     * Determines the widget's place holder displayed when the widget's value is null.
     *
     * @return
     */
    public String getPlaceHolder()
    {
        return placeHolder;
    }

    /**
     * Determines the widget's place holder displayed when the widget's value is null.
     *
     * @param placeHolder
     */
    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    /**
     * Sets or gets the prompt char displayed when an editable char is empty.
     * Possible Values:
     * <p>
     * '_'
     * <p>
     * '?'
     * <p>
     * ';'
     * <p>
     * '#'
     *
     * @return
     */
    public Character getPromptChar()
    {
        return promptChar;
    }

    /**
     * Sets or gets the prompt char displayed when an editable char is empty.
     * Possible Values:
     * <p>
     * '_'
     * <p>
     * '?'
     * <p>
     * ';'
     * <p>
     * '#'
     *
     * @param promptChar
     */
    public void setPromptChar(Character promptChar)
    {
        this.promptChar = promptChar;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @return
     */
    public Boolean getRtl()
    {
        return rtl;
    }

    /**
     * Sets or gets a value indicating whether widget's elements are aligned to support locales using right-to-left fonts.
     *
     * @param rtl
     */
    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    /**
     * Sets or gets the readOnly state of the input.
     *
     * @return
     */
    public Boolean getReadOnly()
    {
        return readOnly;
    }

    /**
     * Sets or gets the readOnly state of the input.
     *
     * @param readOnly
     */
    public void setReadOnly(Boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    /**
     * Sets or gets the spin mode.
     * Possible Values:
     * <p>
     * 'advanced'- the value is increased depending on the caret's position
     * <p>
     * 'simple'-pecifies that the spin behavior is disabled
     *
     * @return
     */
    public String getSpinMode()
    {
        return spinMode;
    }

    /**
     * Sets or gets the spin mode.
     * Possible Values:
     * <p>
     * 'advanced'- the value is increased depending on the caret's position
     * <p>
     * 'simple'-pecifies that the spin behavior is disabled
     *
     * @param spinMode
     */
    public void setSpinMode(String spinMode)
    {
        this.spinMode = spinMode;
    }

    /**
     * Shows or hides the spin buttons.
     *
     * @return
     */
    public Boolean getSpinButtons()
    {
        return spinButtons;
    }

    /**
     * Shows or hides the spin buttons.
     *
     * @param spinButtons
     */
    public void setSpinButtons(Boolean spinButtons)
    {
        this.spinButtons = spinButtons;
    }

    /**
     * Sets or gets the width of the spin buttons.
     *
     * @return
     */
    public Integer getSpinButtonsWidth()
    {
        return spinButtonsWidth;
    }

    /**
     * Sets or gets the width of the spin buttons.
     *
     * @param spinButtonsWidth
     */
    public void setSpinButtonsWidth(Integer spinButtonsWidth)
    {
        this.spinButtonsWidth = spinButtonsWidth;
    }

    /**
     * Sets or gets the increase/decrease step.
     *
     * @return
     */
    public Integer getSpinButtonsStep()
    {
        return spinButtonsStep;
    }

    /**
     * Sets or gets the increase/decrease step.
     *
     * @param spinButtonsStep
     */
    public void setSpinButtonsStep(Integer spinButtonsStep)
    {
        this.spinButtonsStep = spinButtonsStep;
    }

    /**
     * Sets or gets the string to use as currency or percentage symbol.
     *
     * @return
     */
    public String getSymbol()
    {
        return symbol;
    }

    /**
     * Sets or gets the string to use as currency or percentage symbol.
     *
     * @param symbol
     */
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    /**
     * Sets or gets the position of the symbol in the input.
     *
     * @return
     */
    public JQXNumberInputTextAlignments getSymbolPosition()
    {
        return symbolPosition;
    }

    /**
     * Sets or gets the position of the symbol in the input.
     *
     * @param symbolPosition
     */
    public void setSymbolPosition(JQXNumberInputTextAlignments symbolPosition)
    {
        this.symbolPosition = symbolPosition;
    }

    /**
     * Sets or gets the alignment.
     *
     * @return
     */
    public JQXNumberInputTextAlignments getTextAlign()
    {
        return textAlign;
    }

    /**
     * Sets or gets the alignment.
     *
     * @param textAlign
     */
    public void setTextAlign(JQXNumberInputTextAlignments textAlign)
    {
        this.textAlign = textAlign;
    }

    /**
     * Determines the template as an alternative of the default styles.
     * Possible Values:
     * <p>
     * 'default' - the default template. The style depends only on the "theme" property value.
     * <p>
     * 'primary' - dark blue style for extra visual weight.
     * <p>
     * 'success' - green style for successful or positive action.
     * <p>
     * 'warning' - orange style which indicates caution.
     * <p>
     * 'danger' - red style which indicates a dangerous or negative action.
     * <p>
     * 'info' - blue button, not tied to a semantic action or use.
     *
     * @return
     */
    public JQXButtonTemplates getTemplate()
    {
        return template;
    }

    /**
     * Determines the template as an alternative of the default styles.
     * Possible Values:
     * <p>
     * 'default' - the default template. The style depends only on the "theme" property value.
     * <p>
     * 'primary' - dark blue style for extra visual weight.
     * <p>
     * 'success' - green style for successful or positive action.
     * <p>
     * 'warning' - orange style which indicates caution.
     * <p>
     * 'danger' - red style which indicates a dangerous or negative action.
     * <p>
     * 'info' - blue button, not tied to a semantic action or use.
     *
     * @param template
     */
    public void setTemplate(JQXButtonTemplates template)
    {
        this.template = template;
    }

}
