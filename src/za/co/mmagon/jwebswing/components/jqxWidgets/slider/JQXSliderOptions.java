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
package za.co.mmagon.jwebswing.components.jqxWidgets.slider;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxWidgets.buttons.JQXButtonTemplates;
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
public class JQXSliderOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private JQXSliderButtonPositions buttonsPosition;// 	String 	both
    private Boolean disabled;// 	Boolean 	false
    private JQXSliderLayouts layout;// 	String 	"normal"
    private JQXSliderModes mode;// 	String 	default
    private Integer minorTicksFrequency;// 	Number 	1
    private Integer minorTickSize;// 	Number 	4
    private Integer max;// 	Number 	10
    private Integer min;// 	Number 	0
    private Boolean rangeSlider;// 	Bool 	false
    private Boolean rtl;// 	Boolean 	false
    private Integer step;// 	Number 	1
    private Boolean showTicks;// 	Boolean 	true
    private Boolean showMinorTicks;// 	Boolean 	false
    private Boolean showTickLabels;// 	Boolean 	false
    private Boolean showButtons;// 	Bool 	true
    private Boolean showRange;// 	Bool 	true
    private JQXSliderTickPositions ticksPosition;// 	String 	both
    private Integer ticksFrequency;// 	Number 	2
    private Integer tickSize;// 	Number 	7
    private JavascriptFunction tickLabelFormatFunction;// 	Function 	null
    private Boolean tooltip;// 	Boolean 	false
    private Integer tooltipHideDelay;// 	Numer 	500
    private JQXSliderPositions tooltipPosition;// 	String 	"near"
    private JavascriptFunction tooltipFormatFunction;// 	Function 	null
    private Integer value;// 	Number/Object 	0
    private ArrayList<Integer> values;// 	Array 	[0, 10]
    private JQXButtonTemplates template;

    public JQXSliderOptions()
    {

    }

    /**
     * Sets or gets scroll buttons position.
     * Possible Values:
     * <p>
     * 'both'
     * <p>
     * 'left'
     * <p>
     * 'right'
     *
     * @return
     */
    public JQXSliderButtonPositions getButtonsPosition()
    {
        return buttonsPosition;
    }

    /**
     * Sets or gets scroll buttons position.
     * Possible Values:
     * <p>
     * 'both'
     * <p>
     * 'left'
     * <p>
     * 'right'
     *
     * @param buttonsPosition
     */
    public void setButtonsPosition(JQXSliderButtonPositions buttonsPosition)
    {
        this.buttonsPosition = buttonsPosition;
    }

    /**
     * Sets or gets whether the slider is disabled.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Sets or gets whether the slider is disabled.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Sets or gets the slider's layout.
     *
     * @return
     */
    public JQXSliderLayouts getLayout()
    {
        return layout;
    }

    /**
     * Sets or gets the slider's layout.
     *
     * @param layout
     */
    public void setLayout(JQXSliderLayouts layout)
    {
        this.layout = layout;
    }

    /**
     * Sets or gets slider's mode.
     * Possible Values:
     * <p>
     * 'default'- the slider's thumb can be dragged smoothly ( like a scrollbar )
     * <p>
     * 'fixed'- the thumb is dragged with a 'step' specified by the 'step' property.
     *
     * @return
     */
    public JQXSliderModes getMode()
    {
        return mode;
    }

    /**
     * Sets or gets slider's mode.
     * Possible Values:
     * <p>
     * 'default'- the slider's thumb can be dragged smoothly ( like a scrollbar )
     * <p>
     * 'fixed'- the thumb is dragged with a 'step' specified by the 'step' property.
     *
     * @param mode
     */
    public void setMode(JQXSliderModes mode)
    {
        this.mode = mode;
    }

    /**
     * Set the minorTicksFrequency property.
     *
     * @return
     */
    public Integer getMinorTicksFrequency()
    {
        return minorTicksFrequency;
    }

    /**
     * Set the minorTicksFrequency property.
     *
     * @param minorTicksFrequency
     */
    public void setMinorTicksFrequency(Integer minorTicksFrequency)
    {
        this.minorTicksFrequency = minorTicksFrequency;
    }

    /**
     * Sets or gets slider's minor ticks size.
     *
     * @return
     */
    public Integer getMinorTickSize()
    {
        return minorTickSize;
    }

    /**
     * Sets or gets slider's minor ticks size.
     *
     * @param minorTickSize
     */
    public void setMinorTickSize(Integer minorTickSize)
    {
        this.minorTickSize = minorTickSize;
    }

    /**
     * Sets or gets slider's maximum value.
     *
     * @return
     */
    public Integer getMax()
    {
        return max;
    }

    /**
     * Sets or gets slider's maximum value.
     *
     * @param max
     */
    public void setMax(Integer max)
    {
        this.max = max;
    }

    /**
     * Sets or gets slider's minimum value.
     *
     * @return
     */
    public Integer getMin()
    {
        return min;
    }

    /**
     * Sets or gets slider's minimum value.
     *
     * @param min
     */
    public void setMin(Integer min)
    {
        this.min = min;
    }

    /**
     * Sets or gets whether the slider is displayed as a range slider and has 2 thumbs. This allows the user to select a range of values. By default, end-users can select only a single value.
     *
     * @return
     */
    public Boolean getRangeSlider()
    {
        return rangeSlider;
    }

    /**
     * Sets or gets whether the slider is displayed as a range slider and has 2 thumbs. This allows the user to select a range of values. By default, end-users can select only a single value.
     *
     * @param rangeSlider
     */
    public void setRangeSlider(Boolean rangeSlider)
    {
        this.rangeSlider = rangeSlider;
    }

    /**
     * Gets RTL
     *
     * @return
     */
    public Boolean getRtl()
    {
        return rtl;
    }

    /**
     * Sets RTL
     *
     * @param rtl
     */
    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    /**
     * Sets or gets the slider's step when the user is using the keyboard arrows, slider increment and decrement buttons or the mouse wheel for changing the slider's value.
     *
     * @return
     */
    public Integer getStep()
    {
        return step;
    }

    /**
     * Sets or gets the slider's step when the user is using the keyboard arrows, slider increment and decrement buttons or the mouse wheel for changing the slider's value.
     *
     * @param step
     */
    public void setStep(Integer step)
    {
        this.step = step;
    }

    /**
     * Sets or gets whether ticks will be shown.
     *
     * @return
     */
    public Boolean getShowTicks()
    {
        return showTicks;
    }

    /**
     * Sets or gets whether ticks will be shown.
     *
     * @param showTicks
     */
    public void setShowTicks(Boolean showTicks)
    {
        this.showTicks = showTicks;
    }

    /**
     * Sets or gets whether minor ticks will be shown.
     *
     * @return
     */
    public Boolean getShowMinorTicks()
    {
        return showMinorTicks;
    }

    /**
     * Sets or gets whether minor ticks will be shown.
     *
     * @param showMinorTicks
     */
    public void setShowMinorTicks(Boolean showMinorTicks)
    {
        this.showMinorTicks = showMinorTicks;
    }

    /**
     * Sets or gets whether major tick labels will be shown.
     *
     * @return
     */
    public Boolean getShowTickLabels()
    {
        return showTickLabels;
    }

    /**
     * Sets or gets whether major tick labels will be shown.
     *
     * @param showTickLabels
     */
    public void setShowTickLabels(Boolean showTickLabels)
    {
        this.showTickLabels = showTickLabels;
    }

    /**
     * Sets or gets whether the scroll buttons will be shown.
     *
     * @return
     */
    public Boolean getShowButtons()
    {
        return showButtons;
    }

    /**
     * Sets or gets whether the scroll buttons will be shown.
     *
     * @param showButtons
     */
    public void setShowButtons(Boolean showButtons)
    {
        this.showButtons = showButtons;
    }

    /**
     * Sets or gets whether the slider range background is displayed. This is the fill between the slider's left button and the slider's thumb to indicate the selected value. In range slider mode, the
     * space between the handles is filled to indicate the selected values.
     *
     * @return
     */
    public Boolean getShowRange()
    {
        return showRange;
    }

    /**
     * Sets or gets whether the slider range background is displayed. This is the fill between the slider's left button and the slider's thumb to indicate the selected value. In range slider mode, the
     * space between the handles is filled to indicate the selected values.
     *
     * @param showRange
     */
    public void setShowRange(Boolean showRange)
    {
        this.showRange = showRange;
    }

    /**
     * Sets or gets slider's ticks position.
     *
     * @return
     */
    public JQXSliderTickPositions getTicksPosition()
    {
        return ticksPosition;
    }

    /**
     * Sets or gets slider's ticks position.
     *
     * @param ticksPosition
     */
    public void setTicksPosition(JQXSliderTickPositions ticksPosition)
    {
        this.ticksPosition = ticksPosition;
    }

    /**
     * Sets or gets slider's major ticks frequency.
     *
     * @return
     */
    public Integer getTicksFrequency()
    {
        return ticksFrequency;
    }

    /**
     * Sets or gets slider's major ticks frequency.
     *
     * @param ticksFrequency
     */
    public void setTicksFrequency(Integer ticksFrequency)
    {
        this.ticksFrequency = ticksFrequency;
    }

    /**
     * Sets or gets slider's major ticks size.
     *
     * @return
     */
    public Integer getTickSize()
    {
        return tickSize;
    }

    /**
     * Sets or gets slider's major ticks size.
     *
     * @param tickSize
     */
    public void setTickSize(Integer tickSize)
    {
        this.tickSize = tickSize;
    }

    /**
     * Sets or gets the major ticks labels formatting function.
     *
     * @return
     */
    public JavascriptFunction getTickLabelFormatFunction()
    {
        return tickLabelFormatFunction;
    }

    /**
     * Sets or gets the major ticks labels formatting function.
     *
     * @param tickLabelFormatFunction
     */
    public void setTickLabelFormatFunction(JavascriptFunction tickLabelFormatFunction)
    {
        this.tickLabelFormatFunction = tickLabelFormatFunction;
    }

    /**
     * Sets or gets whether the slider tooltip will be shown.
     *
     * @return
     */
    public Boolean getTooltip()
    {
        return tooltip;
    }

    /**
     * Sets or gets whether the slider tooltip will be shown.
     *
     * @param tooltip
     */
    public void setTooltip(Boolean tooltip)
    {
        this.tooltip = tooltip;
    }

    /**
     * Sets or gets the tooltip's hide delay.
     *
     * @return
     */
    public Integer getTooltipHideDelay()
    {
        return tooltipHideDelay;
    }

    /**
     * Sets or gets the tooltip's hide delay.
     *
     * @param tooltipHideDelay
     */
    public void setTooltipHideDelay(Integer tooltipHideDelay)
    {
        this.tooltipHideDelay = tooltipHideDelay;
    }

    /**
     * Sets or gets the tooltip's position. Possible values: "near", "far"
     *
     * @return
     */
    public JQXSliderPositions getTooltipPosition()
    {
        return tooltipPosition;
    }

    /**
     * Sets or gets the tooltip's position. Possible values: "near", "far"
     *
     * @param tooltipPosition
     */
    public void setTooltipPosition(JQXSliderPositions tooltipPosition)
    {
        this.tooltipPosition = tooltipPosition;
    }

    public JavascriptFunction getTooltipFormatFunction()
    {
        return tooltipFormatFunction;
    }

    public void setTooltipFormatFunction(JavascriptFunction tooltipFormatFunction)
    {
        this.tooltipFormatFunction = tooltipFormatFunction;
    }

    /**
     * Sets or gets slider's value. This poperty will be an object with the following structure { rangeStart: range_start, rangeEnd: range_end } if the slider is range slider otherwise it's going to
     * be a number.
     *
     * @return
     */
    public Integer getValue()
    {
        return value;
    }

    /**
     * Sets or gets slider's value. This poperty will be an object with the following structure { rangeStart: range_start, rangeEnd: range_end } if the slider is range slider otherwise it's going to
     * be a number.
     *
     * @param value
     */
    public void setValue(Integer value)
    {
        this.value = value;
    }

    /**
     * Sets or gets range slider's values.The 'rangeSlider' property should be set to true.
     *
     * @return
     */
    public ArrayList<Integer> getValues()
    {
        if (values == null)
        {
            values = new ArrayList<>();
        }
        return values;
    }

    /**
     * Sets or gets range slider's values.The 'rangeSlider' property should be set to true.
     *
     * @param values
     */
    public void setValues(ArrayList<Integer> values)
    {
        this.values = values;
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
