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

package za.co.mmagon.jwebswing.components.bootstrap.columnlayout;

/**
 * A list of all the column width settings from bootstrap
 * @author GedMarc
 * @since Oct 10, 2016
 * @version 1.0
 * 
 */
public enum BSColumnWidths implements IBSColumnOptions
{
    /**
     * From size XS the size should be 1
     */
    col_xs_1,
    /**
     * From size XS the size should be 1
     */
    col_xs_2,
    /**
     * From size XS the size should be 1
     */
    col_xs_3,
    /**
     * From size XS the size should be 1
     */
    col_xs_4,
    /**
     * From size XS the size should be 1
     */
    col_xs_5,
    /**
     * From size XS the size should be 1
     */
    col_xs_6,
    /**
     * From size XS the size should be 1
     */
    col_xs_7,
    /**
     * From size XS the size should be 1
     */
    col_xs_8,
    /**
     * From size XS the size should be 1
     */
    col_xs_9,
    /**
     * From size XS the size should be 1
     */
    col_xs_10,
    /**
     * From size XS the size should be 1
     */
    col_xs_11,
    /**
     * From size XS the size should be 1
     */
    col_xs_12,
    
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_1,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_2,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_3,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_4,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_5,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_6,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_7,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_8,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_9,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_10,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_11,
    /**
     * From size SM (small) the size should be 1
     */
    col_sm_12,
    
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_1,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_2,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_3,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_4,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_5,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_6,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_7,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_8,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_9,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_10,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_11,
    /**
     * From size MD (medium) the size should be 1
     */
    col_md_12,
    
    /**
     * For large LG only the size should be 1
     */
    col_lg_1,
    /**
     * For large LG only the size should be 1
     */
    col_lg_2,
    /**
     * For large LG only the size should be 1
     */
    col_lg_3,
    /**
     * For large LG only the size should be 1
     */
    col_lg_4,
    /**
     * For large LG only the size should be 1
     */
    col_lg_5,
    /**
     * For large LG only the size should be 1
     */
    col_lg_6,
    /**
     * For large LG only the size should be 1
     */
    col_lg_7,
    /**
     * For large LG only the size should be 1
     */
    col_lg_8,
    /**
     * For large LG only the size should be 1
     */
    col_lg_9,
    /**
     * For large LG only the size should be 1
     */
    col_lg_10,
    /**
     * For large LG only the size should be 1
     */
    col_lg_11,
    /**
     * For large LG only the size should be 1
     */
    col_lg_12,

    ;
    private BSColumnWidths ()
    {
        
    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
    
    
}
