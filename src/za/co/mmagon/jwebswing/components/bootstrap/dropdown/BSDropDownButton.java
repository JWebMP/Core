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

import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.buttons.BSButton;
import za.co.mmagon.jwebswing.components.bootstrap.buttons.BSButtonAttributes;

/**
 *
 * @author GedMarc
 * @since 13 Jan 2017
 *
 */
public class BSDropDownButton extends BSButton implements BSDropDownChildren
{

    private static final long serialVersionUID = 1L;

    public BSDropDownButton()
    {
        addAttribute(BSButtonAttributes.Data_Toggle, "dropdown");
        addAttribute(GlobalAttributes.Aria_HasPopup, "true");
        addAttribute(GlobalAttributes.Aria_Expanded, "false");
        addClass(BSComponentDropDownOptions.Dropdown_Toggle);
    }
}
