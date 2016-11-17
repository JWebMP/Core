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
package za.co.mmagon.jwebswing.components.jqxwidgets.bulletchart;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the JQX Bullet Chart library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXBulletChartOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Integer animationDuration;// 	Function 	null
    private Integer barSize;// 	Array 	50%
    private String description;// 	String 	'Description'
    private Boolean disabled;// 	Boolean 	false
    private String labelsFormat;// 	String 	null
    private JavascriptFunction labelsFormatFunction;/// 	Function 	null
    private Orientation orientation;// 	String 	"horizontal"
    private JQXBulletChartPointer pointer;// 	Object 	{ value: 65, label: "Value", size: "25%", color: "" }
    private Boolean rtl;// 	Boolean 	false
    private ArrayList<JQXBulletChartRange> ranges;// 	Array 	[{ startValue: 0, endValue: 50, color: "#000000", opacity: 0.7 }, { startValue: 50, endValue: 80, color: "#000000", opacity: 0.5 }, { startValue: 80, endValue: 100, color: "#000000", opacity: 0.3}]
    private Boolean showTooltip;// 	Boolean 	true
    private JQXBulletChartTarget target;// 	Object 	{ value: 85, label: "Target", size: 4, color: "" };
    private JQXBulletChartTicks ticks;// 	Object 	{ position: "far", interval: 20, size: 10 }
    private String title;// 	String 	'Title'
    private JavascriptFunction tooltipFormatFunction;// 	Function 	null

    public JQXBulletChartOptions()
    {

    }

    /**
     * Sets ot gets the bulletcharts's animationDuration.
     * Possible values
     * <p>
     * number
     * <p>
     * 'slow'
     * <p>
     * 'fast'
     *
     * @return
     */
    public Integer getAnimationDuration()
    {
        return animationDuration;
    }

    /**
     * Sets ot gets the bulletcharts's animationDuration.
     * Possible values
     * <p>
     * number
     * <p>
     * 'slow'
     * <p>
     * 'fast'
     *
     * @param animationDuration
     */
    public void setAnimationDuration(Integer animationDuration)
    {
        this.animationDuration = animationDuration;
    }

    /**
     * Sets ot gets the bulletcharts's bar size.
     *
     * @return
     */
    public Integer getBarSize()
    {
        return barSize;
    }

    /**
     * Sets ot gets the bulletcharts's bar size.
     *
     * @param barSize
     */
    public void setBarSize(Integer barSize)
    {
        this.barSize = barSize;
    }

    /**
     * Sets ot gets the bulletcharts's description.
     *
     * @return
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets ot gets the bulletcharts's description.
     *
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Disables the bullet chart.
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Disables the bullet chart.
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Sets ot gets the bulletcharts's labelsFormat.
     * Possible values:
     * <p>
     * "null"
     * <p>
     * "d"-decimal numbers
     * <p>
     * "f"- floating-point numbers
     * <p>
     * "n"- integer numbers
     * <p>
     * "c" - currency numbers
     * <p>
     * "p"- percentage numbers
     *
     * @return
     */
    public String getLabelsFormat()
    {
        return labelsFormat;
    }

    /**
     * Sets ot gets the bulletcharts's labelsFormat.
     * Possible values:
     * <p>
     * "null"
     * <p>
     * "d"-decimal numbers
     * <p>
     * "f"- floating-point numbers
     * <p>
     * "n"- integer numbers
     * <p>
     * "c" - currency numbers
     * <p>
     * "p"- percentage numbers
     *
     * @param labelsFormat
     */
    public void setLabelsFormat(String labelsFormat)
    {
        this.labelsFormat = labelsFormat;
    }

    /**
     * Set the labelsFormatFunction property.
     *
     * @return
     */
    public JavascriptFunction getLabelsFormatFunction()
    {
        return labelsFormatFunction;
    }

    /**
     * Set the labelsFormatFunction property.
     *
     * @param labelsFormatFunction
     */
    public void setLabelsFormatFunction(JavascriptFunction labelsFormatFunction)
    {
        this.labelsFormatFunction = labelsFormatFunction;
    }

    /**
     * Sets ot gets the bulletcharts's orientation.
     * Possible values:
     * <p>
     * "horizontal"
     * <p>
     * "vertical"
     *
     * @return
     */
    public Orientation getOrientation()
    {
        return orientation;
    }

    /**
     * Sets ot gets the bulletcharts's orientation.
     * Possible values:
     * <p>
     * "horizontal"
     * <p>
     * "vertical"
     *
     * @param orientation
     */
    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }

    /**
     * Sets ot gets the bulletcharts's pointer.
     *
     * @return
     */
    public JQXBulletChartPointer getPointer()
    {
        if (pointer == null)
        {
            pointer = new JQXBulletChartPointer();
        }
        return pointer;
    }

    /**
     * Sets ot gets the bulletcharts's pointer.
     *
     * @param pointer
     */
    public void setPointer(JQXBulletChartPointer pointer)
    {
        this.pointer = pointer;
    }

    /**
     * Gets or sets right to left display
     *
     * @return
     */
    public Boolean getRtl()
    {
        return rtl;
    }

    /**
     * Gets or sets right to left display
     *
     * @param rtl
     */
    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    /**
     * Sets ot gets the bulletcharts's range.
     * Possible values
     * <p>
     * 'startValue'-the value from which the range will start
     * <p>
     * 'endValue'-the value where the current range will end
     * <p>
     * 'color'- the colour of the range
     * <p>
     * 'opacity'- the opacity of the range
     *
     * @return
     */
    public ArrayList<JQXBulletChartRange> getRanges()
    {
        if (ranges == null)
        {
            ranges = new ArrayList<>();
        }
        return ranges;
    }

    /**
     * Sets ot gets the bulletcharts's range.
     * Possible values
     * <p>
     * 'startValue'-the value from which the range will start
     * <p>
     * 'endValue'-the value where the current range will end
     * <p>
     * 'color'- the colour of the range
     * <p>
     * 'opacity'- the opacity of the range
     *
     * @param ranges
     */
    public void setRanges(ArrayList<JQXBulletChartRange> ranges)
    {
        this.ranges = ranges;
    }

    /**
     * Sets ot gets the bulletcharts's showTooltip.Requires jqxtooltip.js
     *
     * @return
     */
    public Boolean getShowTooltip()
    {
        return showTooltip;
    }

    /**
     * Sets ot gets the bulletcharts's showTooltip.Requires jqxtooltip.js
     *
     * @param showTooltip
     */
    public void setShowTooltip(Boolean showTooltip)
    {
        this.showTooltip = showTooltip;
    }

    /**
     * Sets ot gets the bulletcharts's target.
     *
     * @return
     */
    public JQXBulletChartTarget getTarget()
    {
        if (target == null)
        {
            target = new JQXBulletChartTarget();
        }
        return target;
    }

    /**
     * Sets ot gets the bulletcharts's target.
     *
     * @param target
     */
    public void setTarget(JQXBulletChartTarget target)
    {
        this.target = target;
    }

    /**
     * Sets ot gets the bulletcharts's ticks.
     * Possible values for ticks.position
     * <p>
     * "near"- positions the ticks at the top of the ranges bar if the orientation is set to "horizontal" and at the left if the orientation is set to "vertical";
     * <p>
     * "far" - positions the ticks at the bottom of the ranges bar if the orientation is set to "horizontal" and at the right if the orientation is set to "vertical";
     * <p>
     * "both"
     * <p>
     * "none"
     *
     * @return
     */
    public JQXBulletChartTicks getTicks()
    {
        if (ticks == null)
        {
            ticks = new JQXBulletChartTicks();
        }
        return ticks;
    }

    /**
     * Sets ot gets the bulletcharts's ticks.
     * Possible values for ticks.position
     * <p>
     * "near"- positions the ticks at the top of the ranges bar if the orientation is set to "horizontal" and at the left if the orientation is set to "vertical";
     * <p>
     * "far" - positions the ticks at the bottom of the ranges bar if the orientation is set to "horizontal" and at the right if the orientation is set to "vertical";
     * <p>
     * "both"
     * <p>
     * "none"
     *
     * @param ticks
     */
    public void setTicks(JQXBulletChartTicks ticks)
    {
        this.ticks = ticks;
    }

    /**
     * Sets ot gets the bulletcharts's title.
     *
     * @return
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets ot gets the bulletcharts's title.
     *
     * @param title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Sets the tooltip format function
     *
     * @return
     */
    public JavascriptFunction getTooltipFormatFunction()
    {
        return tooltipFormatFunction;
    }

    /**
     * Gets the tooltip format function
     *
     * @param tooltipFormatFunction
     */
    public void setTooltipFormatFunction(JavascriptFunction tooltipFormatFunction)
    {
        this.tooltipFormatFunction = tooltipFormatFunction;
    }

}
