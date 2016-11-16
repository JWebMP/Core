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
package za.co.mmagon.jwebswing.components.jqxWidgets.rangeselector;

import java.util.Date;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the range selector library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXRangeSelectorOptions extends JQXDefaultJavaScriptPart
{

    private Integer animationDuration;// 	Number 	100
    private Boolean disabled;// 	Boolean 	false
    private String labelFormat;// 	String 	null
    private Integer labelPrecision;// 	Number 	0
    private JavascriptFunction labelRenderer;// 	callback function 	null
    private Boolean moveOnClick;// 	Boolean 	true
    private JavascriptFunction markerRenderer;// 	callback function 	null
    private Integer markerPrecision;// 	Number 	2
    private JavascriptFunction majorLabelRenderer;// 	callback function 	null
    private String markerFormat;// 	String 	null
    private Integer majorTicksInterval;// 	Number/Object/String 	10
    private Integer minorTicksInterval;// 	Number/Object/String 	5
    private Date max;// 	Number/Date object/Date string 	100
    private Date min;// 	Number/Date object/Date string 	0
    private Integer padding;// 	Number/String 	"auto"
    private JQXRanges range;// 	Object 	{ from: 0, to: Infinity, min: 0, max: Infinity }
    private Boolean resizable;// 	Boolean 	true
    private Boolean rtl;// 	Boolean 	false
    private Boolean showMinorTicks;// 	Boolean 	false
    private Boolean snapToTicks;// 	Boolean 	true
    private Boolean showMajorLabels;// 	Boolean 	false
    private Boolean showMarkers;// 	Boolean 	true

    public JQXRangeSelectorOptions()
    {

    }

    public Integer getAnimationDuration()
    {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration)
    {
        this.animationDuration = animationDuration;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getLabelFormat()
    {
        return labelFormat;
    }

    public void setLabelFormat(String labelFormat)
    {
        this.labelFormat = labelFormat;
    }

    public Integer getLabelPrecision()
    {
        return labelPrecision;
    }

    public void setLabelPrecision(Integer labelPrecision)
    {
        this.labelPrecision = labelPrecision;
    }

    public JavascriptFunction getLabelRenderer()
    {
        return labelRenderer;
    }

    public void setLabelRenderer(JavascriptFunction labelRenderer)
    {
        this.labelRenderer = labelRenderer;
    }

    public Boolean getMoveOnClick()
    {
        return moveOnClick;
    }

    public void setMoveOnClick(Boolean moveOnClick)
    {
        this.moveOnClick = moveOnClick;
    }

    public JavascriptFunction getMarkerRenderer()
    {
        return markerRenderer;
    }

    public void setMarkerRenderer(JavascriptFunction markerRenderer)
    {
        this.markerRenderer = markerRenderer;
    }

    public Integer getMarkerPrecision()
    {
        return markerPrecision;
    }

    public void setMarkerPrecision(Integer markerPrecision)
    {
        this.markerPrecision = markerPrecision;
    }

    public JavascriptFunction getMajorLabelRenderer()
    {
        return majorLabelRenderer;
    }

    public void setMajorLabelRenderer(JavascriptFunction majorLabelRenderer)
    {
        this.majorLabelRenderer = majorLabelRenderer;
    }

    public String getMarkerFormat()
    {
        return markerFormat;
    }

    /**
     * Sets or gets the format of the markers.
     * Possible number formats:
     * <p>
     * 'd' - decimal numbers;
     * 'f'- floating-point numbers;
     * 'n' - integer numbers;
     * 'c' - currency numbers;
     * 'p' - percentage numbers.
     * <p>
     * Possible date formats:
     * <p>
     * Note: When the data type is date, the markerFormat property must always be set.
     * <p>
     * 'd' - the day of the month;
     * 'dd' - the day of the month;
     * 'ddd' - the abbreviated name of the day of the week;
     * 'dddd' - the full name of the day of the week;
     * 'h' - the hour, using a 12-hour clock from 1 to 12;
     * 'hh' - the hour, using a 12-hour clock from 01 to 12;
     * 'H' - the hour, using a 24-hour clock from 0 to 23;
     * 'HH' - the hour, using a 24-hour clock from 00 to 23;
     * 'm' - the minute, from 0 through 59;
     * 'mm' - the minutes,from 00 though 59;
     * 'M' - the month, from 1 through 12;
     * 'MM' - the month, from 01 through 12;
     * 'MMM' - the abbreviated name of the month;
     * 'MMMM' - the full name of the month;
     * 's' - the second, from 0 through 59;
     * 'ss' - the second, from 00 through 59;
     * 't' - the first character of the AM/PM designator;
     * 'tt' - the AM/PM designator;
     * 'y' - the year, from 0 to 99;
     * 'yy' - the year, from 00 to 99;
     * 'yyy' - the year, with a minimum of three digits;
     * 'yyyy' - the year as a four-digit number.
     *
     * @param markerFormat
     */
    public void setMarkerFormat(String markerFormat)
    {
        this.markerFormat = markerFormat;
    }

    public Integer getMajorTicksInterval()
    {
        return majorTicksInterval;
    }

    public void setMajorTicksInterval(Integer majorTicksInterval)
    {
        this.majorTicksInterval = majorTicksInterval;
    }

    public Integer getMinorTicksInterval()
    {
        return minorTicksInterval;
    }

    public void setMinorTicksInterval(Integer minorTicksInterval)
    {
        this.minorTicksInterval = minorTicksInterval;
    }

    public Date getMax()
    {
        return max;
    }

    public void setMax(Date max)
    {
        this.max = max;
    }

    public Date getMin()
    {
        return min;
    }

    public void setMin(Date min)
    {
        this.min = min;
    }

    public Integer getPadding()
    {
        return padding;
    }

    public void setPadding(Integer padding)
    {
        this.padding = padding;
    }

    public JQXRanges getRange()
    {
        return range;
    }

    public void setRange(JQXRanges range)
    {
        this.range = range;
    }

    public Boolean getResizable()
    {
        return resizable;
    }

    public void setResizable(Boolean resizable)
    {
        this.resizable = resizable;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getShowMinorTicks()
    {
        return showMinorTicks;
    }

    public void setShowMinorTicks(Boolean showMinorTicks)
    {
        this.showMinorTicks = showMinorTicks;
    }

    public Boolean getSnapToTicks()
    {
        return snapToTicks;
    }

    public void setSnapToTicks(Boolean snapToTicks)
    {
        this.snapToTicks = snapToTicks;
    }

    public Boolean getShowMajorLabels()
    {
        return showMajorLabels;
    }

    public void setShowMajorLabels(Boolean showMajorLabels)
    {
        this.showMajorLabels = showMajorLabels;
    }

    public Boolean getShowMarkers()
    {
        return showMarkers;
    }

    public void setShowMarkers(Boolean showMarkers)
    {
        this.showMarkers = showMarkers;
    }

}
