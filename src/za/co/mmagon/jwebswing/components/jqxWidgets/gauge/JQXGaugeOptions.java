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
package za.co.mmagon.jwebswing.components.jqxWidgets.gauge;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
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
public class JQXGaugeOptions extends JavaScriptPart
{

    private Integer animationDuration;// 	Number 	400
    private JQXGaugeBorder border;// 	Object 	{ size: '10%', style: { stroke: '#cccccc'}, visible: true, showGradient: true }
    private JQXGaugeCaption caption;// 	Object 	{ value: '', position: 'bottom', offset: [0, 0], visible: true }
    private JQXGaugeCap cap;// 	Object 	{ size: '4%', style: { fill: 'theme-specific-color', stroke: 'theme-specific-color' } , visible: true }
    private String colorScheme;// 	String 	'scheme01'
    private Boolean disabled;// 	Boolean 	false
    private EasingEffects easing;// 	String 	linear
    private Integer endAngle;// 	Number 	270
    private Integer height;// 	Number 	350
    private Boolean int64;// 	Boolean 	false
    private JQXGaugeLabels labels;// labels 	Object 	{ distance: '38%', position: 'none', interval: 20, offset: [0, -10], visible: true, formatValue: function (value) { return value; }}
    private Integer min;// 	Number 	0
    private Integer max;// 	Number 	220
    private JQXGaugePointer pointer;// 	Object 	{ pointerType: 'default', style: { fill: 'theme-specific-color', stroke: 'theme-specific-color' }, length: '70%', width: '2%', visible: true }
    private MeasurementCSSImpl radius;// 	Number 	'50%'
    private ArrayList<JQXGaugeRange> ranges;// 	Array 	[]
    private Integer startAngle;// 	Number 	30
    private Boolean showRanges;// 	Boolean 	true
    private String style;// 	Object 	{ fill: '#ffffff', stroke: '#ffffff' }
    private JQXGaugeTick ticksMajor;// 	Object 	{ size: '10%', interval: 5, style: { stroke: '#898989'}, visible: true }
    private JQXGaugeTick ticksMinor;// 	Object 	{ size: '10%', interval: 5, style: { stroke: '#898989'}, visible: true }
    private MeasurementCSSImpl ticksDistance;// 	Number 	'20%"
    private Integer value;// 	Number 	0
    private Integer width;// 	Number 	350

    public JQXGaugeOptions()
    {

    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

    public Integer getAnimationDuration()
    {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration)
    {
        this.animationDuration = animationDuration;
    }

    public JQXGaugeBorder getBorder()
    {
        return border;
    }

    public void setBorder(JQXGaugeBorder border)
    {
        this.border = border;
    }

    public JQXGaugeCaption getCaption()
    {
        return caption;
    }

    public void setCaption(JQXGaugeCaption caption)
    {
        this.caption = caption;
    }

    public JQXGaugeCap getCap()
    {
        return cap;
    }

    public void setCap(JQXGaugeCap cap)
    {
        this.cap = cap;
    }

    public String getColorScheme()
    {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme)
    {
        this.colorScheme = colorScheme;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public EasingEffects getEasing()
    {
        return easing;
    }

    public void setEasing(EasingEffects easing)
    {
        this.easing = easing;
    }

    public Integer getEndAngle()
    {
        return endAngle;
    }

    public void setEndAngle(Integer endAngle)
    {
        this.endAngle = endAngle;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Boolean getInt64()
    {
        return int64;
    }

    public void setInt64(Boolean int64)
    {
        this.int64 = int64;
    }

    public JQXGaugeLabels getLabels()
    {
        return labels;
    }

    public void setLabels(JQXGaugeLabels labels)
    {
        this.labels = labels;
    }

    public Integer getMin()
    {
        return min;
    }

    public void setMin(Integer min)
    {
        this.min = min;
    }

    public Integer getMax()
    {
        return max;
    }

    public void setMax(Integer max)
    {
        this.max = max;
    }

    public JQXGaugePointer getPointer()
    {
        return pointer;
    }

    public void setPointer(JQXGaugePointer pointer)
    {
        this.pointer = pointer;
    }

    public MeasurementCSSImpl getRadius()
    {
        return radius;
    }

    public void setRadius(MeasurementCSSImpl radius)
    {
        this.radius = radius;
    }

    public ArrayList<JQXGaugeRange> getRanges()
    {
        return ranges;
    }

    public void setRanges(ArrayList<JQXGaugeRange> ranges)
    {
        this.ranges = ranges;
    }

    public Integer getStartAngle()
    {
        return startAngle;
    }

    public void setStartAngle(Integer startAngle)
    {
        this.startAngle = startAngle;
    }

    public Boolean getShowRanges()
    {
        return showRanges;
    }

    public void setShowRanges(Boolean showRanges)
    {
        this.showRanges = showRanges;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public JQXGaugeTick getTicksMajor()
    {
        return ticksMajor;
    }

    public void setTicksMajor(JQXGaugeTick ticksMajor)
    {
        this.ticksMajor = ticksMajor;
    }

    public JQXGaugeTick getTicksMinor()
    {
        return ticksMinor;
    }

    public void setTicksMinor(JQXGaugeTick ticksMinor)
    {
        this.ticksMinor = ticksMinor;
    }

    public MeasurementCSSImpl getTicksDistance()
    {
        return ticksDistance;
    }

    public void setTicksDistance(MeasurementCSSImpl ticksDistance)
    {
        this.ticksDistance = ticksDistance;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

}
