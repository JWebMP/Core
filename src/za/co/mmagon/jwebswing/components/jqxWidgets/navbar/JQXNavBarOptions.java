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
package za.co.mmagon.jwebswing.components.jqxWidgets.navbar;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXNavBarOptions extends JQXDefaultJavaScriptPart
{

    /**
     * Defines the layout of the widget's elements. Each Array item should be a Percentage Value and the total should be "100%".
     */
    private ArrayList<MeasurementCSSImpl> columns;// 	Array 	[]
    private Boolean disabled;// 	Boolean 	false
    private Boolean minimized;// 	Boolean 	false
    private String minimizeButtonPosition;// 	String 	'left'
    private Integer minimizedHeight;// 	Number 	30
    private String minimizedTitle;// 	String/HTML Element 	""
    private Orientation orientation;// 	String 	"horizontal"
    private Integer popupAnimationDelay;// 	Number 	250
    private Boolean rtl;// 	Boolean 	false
    private Boolean selection;// 	Boolean 	true
    private Integer selectedItem;// 	Number 	0

    public JQXNavBarOptions()
    {

    }

    public ArrayList<MeasurementCSSImpl> getColumns()
    {
        if (columns == null)
        {
            columns = new ArrayList<>();
        }
        return columns;
    }

    public void setColumns(ArrayList<MeasurementCSSImpl> columns)
    {
        this.columns = columns;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getMinimized()
    {
        return minimized;
    }

    public void setMinimized(Boolean minimized)
    {
        this.minimized = minimized;
    }

    public String getMinimizeButtonPosition()
    {
        return minimizeButtonPosition;
    }

    public void setMinimizeButtonPosition(String minimizeButtonPosition)
    {
        this.minimizeButtonPosition = minimizeButtonPosition;
    }

    public Integer getMinimizedHeight()
    {
        return minimizedHeight;
    }

    public void setMinimizedHeight(Integer minimizedHeight)
    {
        this.minimizedHeight = minimizedHeight;
    }

    public String getMinimizedTitle()
    {
        return minimizedTitle;
    }

    public void setMinimizedTitle(String minimizedTitle)
    {
        this.minimizedTitle = minimizedTitle;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }

    public Integer getPopupAnimationDelay()
    {
        return popupAnimationDelay;
    }

    public void setPopupAnimationDelay(Integer popupAnimationDelay)
    {
        this.popupAnimationDelay = popupAnimationDelay;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public Boolean getSelection()
    {
        return selection;
    }

    public void setSelection(Boolean selection)
    {
        this.selection = selection;
    }

    public Integer getSelectedItem()
    {
        return selectedItem;
    }

    public void setSelectedItem(Integer selectedItem)
    {
        this.selectedItem = selectedItem;
    }

}
