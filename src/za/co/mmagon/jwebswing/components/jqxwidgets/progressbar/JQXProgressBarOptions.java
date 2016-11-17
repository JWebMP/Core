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
package za.co.mmagon.jwebswing.components.jqxwidgets.progressbar;

import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the Progress Bar library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXProgressBarOptions extends JQXDefaultJavaScriptPart
{

    private Integer animationDuration;// 	Number 	300
    private Boolean disabled;// 	Boolean 	false
    private JQXProgressBarLayouts layout;// 	String 	"normal"
    private Integer max;// 	Number 	100
    private Integer min;// 	Number 	0
    private Orientation orientation;// 	String 	'horizontal'
    private Boolean rtl;// 	Boolean 	false
    private Boolean showText;// 	Boolean 	false
    private Integer value;// 	Number 	0

    public JQXProgressBarOptions()
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

    public JQXProgressBarLayouts getLayout()
    {
        return layout;
    }

    public void setLayout(JQXProgressBarLayouts layout)
    {
        this.layout = layout;
    }

    public Integer getMax()
    {
        return max;
    }

    public void setMax(Integer max)
    {
        this.max = max;
    }

    public Integer getMin()
    {
        return min;
    }

    public void setMin(Integer min)
    {
        this.min = min;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getShowText()
    {
        return showText;
    }

    public void setShowText(Boolean showText)
    {
        this.showText = showText;
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
