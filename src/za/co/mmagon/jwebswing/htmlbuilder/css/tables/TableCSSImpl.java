/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.htmlbuilder.css.tables;

import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 * The look of an HTML table can be greatly improved with CSS:
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class TableCSSImpl implements TableCSS
{

    public TableCSSImpl()
    {
    }
    public TableBorderCollapse Border_Collapse;
    public TableCaptionSides Table_Caption_Side;
    public MeasurementCSS Border_Spacing;

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return TableCSS.class;
    }

    /**
     * Specifies whether or not table borders should be collapsed
     *
     * @return
     */
    @Override
    public TableBorderCollapse Border_Collapse()
    {
        return Border_Collapse;
    }

    /**
     * Where to place the caption
     *
     * @return
     */
    @Override
    public TableCaptionSides Table_Caption_Side()
    {
        return Table_Caption_Side;
    }

    /**
     * What the border spacing should be
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Spacing()
    {
        return Border_Spacing;
    }

    /**
     * Specifies whether or not table borders should be collapsed
     *
     * @param Border_Collapse
     */
    public void setBorder_Collapse(TableBorderCollapse Border_Collapse)
    {
        this.Border_Collapse = Border_Collapse;
    }

    /**
     * Sets which side the caption must be on
     *
     * @param Table_Caption_Side
     */
    public void setTable_Caption_Side(TableCaptionSides Table_Caption_Side)
    {
        this.Table_Caption_Side = Table_Caption_Side;
    }

    /**
     * Specifies whether or not table borders should be collapsed
     *
     * @param Border_Spacing
     */
    public void setBorder_Spacing(MeasurementCSS Border_Spacing)
    {
        this.Border_Spacing = Border_Spacing;
    }

}
