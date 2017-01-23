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
package za.co.mmagon.jwebswing.components.jqueryui.slider;

import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since Mar 9, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUISliderOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * Determines the animation speed Whether to slide the handle smoothly when the user clicks on the slider track. Also accepts any valid animation duration.
     * <p>
     * Multiple types supported:
     * <p>
     * Boolean: When set to true, the handle will animate with the default duration.
     * <p>
     * String: The name of a speed, such as "fast" or "slow".
     * <p>
     * Number: The duration of the animation, in milliseconds.
     */
    private Integer animate;
    /**
     * Disables the slider if set to true.
     */
    private Boolean disabled;
    /**
     * The maximum value of the slider.
     */
    private Integer max;
    /**
     * The minimum value of the slider.
     */
    private Integer min;
    /**
     * Determines whether the slider handles move horizontally (min on left, max on right) or vertically (min on bottom, max on top)
     * .<p>
     * Possible values: "horizontal", "vertical".
     */
    private Orientation orientation;
    /**
     * Whether the slider represents a range.
     * <p>
     * Multiple types supported:
     * <p>
     * Boolean: If set to true, the slider will detect if you have two handles and create a styleable range element between these two.
     * <p>
     * String: Either "min" or "max". A min range goes from the slider min to one handle. A max range goes from one handle to the slider max.
     */
    private SliderRanges range;
    /**
     * Determines the size or amount of each interval or step the slider takes between the min and max. The full specified value range of the slider (max - min) should be evenly divisible by the step.
     */
    private Integer step;
    /**
     * Determines the value of the slider, if there's only one handle. If there is more than one handle, determines the value of the first handle.
     */
    private Integer value;
    /**
     * This option can be used to specify multiple handles. If the range option is set to true, the length of values should be 2.
     */
    private List<Integer> values;

    /**
     * Constructs new slider instances
     */
    public JQUISliderOptions()
    {
        //Nothing needed here
    }

    /**
     * Whether to slide the handle smoothly when the user clicks on the slider track. Also accepts any valid animation duration.
     * <p>
     * Multiple types supported:
     * <p>
     * Boolean: When set to true, the handle will animate with the default duration.
     * <p>
     * String: The name of a speed, such as "fast" or "slow".
     * <p>
     * Number: The duration of the animation, in milliseconds.
     *
     * @return
     */
    public Integer getAnimate()
    {
        return animate;
    }

    /**
     * Whether to slide the handle smoothly when the user clicks on the slider track. Also accepts any valid animation duration.
     * <p>
     * Multiple types supported:
     * <p>
     * Boolean: When set to true, the handle will animate with the default duration.
     * <p>
     * String: The name of a speed, such as "fast" or "slow".
     * <p>
     * Number: The duration of the animation, in milliseconds.
     *
     * @param animate
     */
    public void setAnimate(Integer animate)
    {
        this.animate = animate;
    }

    /**
     * Disables the slider if set to true.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Disables the slider if set to true.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * The maximum value of the slider.
     *
     * @return
     */
    public Integer getMax()
    {
        return max;
    }

    /**
     * The maximum value of the slider.
     *
     * @param max
     */
    public void setMax(Integer max)
    {
        this.max = max;
    }

    /**
     * The minimum value of the slider.
     *
     * @return
     */
    public Integer getMin()
    {
        return min;
    }

    /**
     * The minimum value of the slider.
     *
     * @param min
     */
    public void setMin(Integer min)
    {
        this.min = min;
    }

    /**
     * Determines whether the slider handles move horizontally (min on left, max on right) or vertically (min on bottom, max on top)
     * .<p>
     * Possible values: "horizontal", "vertical".
     *
     * @return
     */
    public Orientation getOrientation()
    {
        return orientation;
    }

    /**
     * Determines whether the slider handles move horizontally (min on left, max on right) or vertically (min on bottom, max on top)
     * .<p>
     * Possible values: "horizontal", "vertical".
     *
     * @param orientation
     */
    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }

    /**
     * Whether the slider represents a range.
     * <p>
     * Multiple types supported:
     * <p>
     * Boolean: If set to true, the slider will detect if you have two handles and create a styleable range element between these two.
     * <p>
     * String: Either "min" or "max". A min range goes from the slider min to one handle. A max range goes from one handle to the slider max.
     *
     * @return
     */
    public SliderRanges getRange()
    {
        return range;
    }

    /**
     * Whether the slider represents a range.
     * <p>
     * Multiple types supported:
     * <p>
     * Boolean: If set to true, the slider will detect if you have two handles and create a styleable range element between these two.
     * <p>
     * String: Either "min" or "max". A min range goes from the slider min to one handle. A max range goes from one handle to the slider max.
     *
     * @param range
     */
    public void setRange(SliderRanges range)
    {
        this.range = range;
    }

    /**
     * Determines the size or amount of each interval or step the slider takes between the min and max.
     * <p>
     * The full specified value range of the slider (max - min) should be evenly divisible by the step.
     * <p>
     * @return
     */
    public Integer getStep()
    {
        return step;
    }

    /**
     * Determines the size or amount of each interval or step the slider takes between the min and max.
     * <p>
     * The full specified value range of the slider (max - min) should be evenly divisible by the step.
     * <p>
     * @param step
     */
    public void setStep(Integer step)
    {
        this.step = step;
    }

    /**
     * Determines the value of the slider, if there's only one handle. If there is more than one handle, determines the value of the first handle.
     * <p>
     * @return
     */
    public Integer getValue()
    {
        return value;
    }

    /**
     * Determines the value of the slider, if there's only one handle. If there is more than one handle, determines the value of the first handle.
     * <p>
     * @param value
     */
    public void setValue(Integer value)
    {
        this.value = value;
    }

    /**
     * This option can be used to specify multiple handles. If the range option is set to true, the length of values should be 2.
     * <p>
     * @return
     */
    public List<Integer> getValues()
    {
        if (values == null)
        {
            values = new ArrayList<>();
        }
        return values;
    }

    /**
     * This option can be used to specify multiple handles. If the range option is set to true, the length of values should be 2.
     * <p>
     * @param values
     */
    public void setValues(List<Integer> values)
    {
        this.values = values;
    }
}
