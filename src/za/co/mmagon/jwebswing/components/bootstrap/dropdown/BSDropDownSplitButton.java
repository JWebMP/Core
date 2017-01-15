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
package za.co.mmagon.jwebswing.components.bootstrap.dropdown;

import za.co.mmagon.jwebswing.components.bootstrap.buttons.BSButton;

/**
 * Split button dropdowns
 * <p>
 * Similarly, create split button dropdowns with virtually the same markup as single button dropdowns, but with the addition of .dropdown-toggle-split for proper spacing around the dropdown caret.
 * <p>
 * We use this extra class to reduce the horizontal padding on either side of the caret by 25% and remove the margin-left that’s added for regular button dropdowns. Those extra changes keep the caret
 * centered in the split button and provide a more appropriately sized hit area next to the main button.
 *
 * @author GedMarc
 * @since 14 Jan 2017
 *
 */
public class BSDropDownSplitButton extends BSDropDown
{

    private static final long serialVersionUID = 1L;

    public BSDropDownSplitButton(BSButton actionButton)
    {
        add(actionButton);
        getDropdownButton().addClass(BSComponentDropDownOptions.Dropdown_Toggle_Split);
    }

}
