/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.buttons.groups;

/**
 * Vertical variation
 * <p>
 * Make a set of buttons appear vertically stacked rather than horizontally. Split button dropdowns are not supported here.
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
public class BSButtonGroupVertical extends BSButtonGroup
{

    private static final long serialVersionUID = 1L;

    /**
     * Vertical variation
     * <p>
     * Make a set of buttons appear vertically stacked rather than horizontally. Split button dropdowns are not supported here.
     */
    public BSButtonGroupVertical()
    {
        addClass(BSComponentButtonGroupOptions.Btn_Group_Vertical);
        removeClass(BSComponentButtonGroupOptions.Btn_Group.toString());
    }
}
