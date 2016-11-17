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
package za.co.mmagon.jwebswing.components.jqxwidgets.scrollbar;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXScrollBarOptions extends JQXDefaultJavaScriptPart
{

    private Boolean disabled;// 	Boolean 	false
    private Integer largestep;// 	Number 	50
    private Integer min;// 	Number 	0
    private Integer max;// 	Number 	1000
    private Boolean rtl;// 	Boolean 	false
    private Integer step;// 	Number 	10
    private Boolean showButtons;// 	Boolean 	true
    private Integer thumbMinSize;// 	Number 	10
    private Boolean vertical;// 	Boolean 	false
    private Integer value;// 	Number

    public JQXScrollBarOptions()
    {

    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Integer getLargestep()
    {
        return largestep;
    }

    public void setLargestep(Integer largestep)
    {
        this.largestep = largestep;
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

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Integer getStep()
    {
        return step;
    }

    public void setStep(Integer step)
    {
        this.step = step;
    }

    public Boolean getShowButtons()
    {
        return showButtons;
    }

    public void setShowButtons(Boolean showButtons)
    {
        this.showButtons = showButtons;
    }

    public Integer getThumbMinSize()
    {
        return thumbMinSize;
    }

    public void setThumbMinSize(Integer thumbMinSize)
    {
        this.thumbMinSize = thumbMinSize;
    }

    public Boolean getVertical()
    {
        return vertical;
    }

    public void setVertical(Boolean vertical)
    {
        this.vertical = vertical;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

}
