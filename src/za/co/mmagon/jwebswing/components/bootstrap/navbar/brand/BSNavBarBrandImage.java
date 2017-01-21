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
package za.co.mmagon.jwebswing.components.bootstrap.navbar.brand;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Image;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDisplayOptions;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentVerticalAlignmentOptions;
import za.co.mmagon.jwebswing.components.bootstrap.navbar.BSNavBarChildren;

/**
 * Adding images to the .navbar-brand will likely always require custom styles or utilities to properly size. Here are some examples to demonstrate.
 *
 * @author GedMarc
 * @since 21 Jan 2017
 *
 */
public class BSNavBarBrandImage extends Div implements BSNavBarChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Adding images to the .navbar-brand will likely always require custom styles or utilities to properly size. Here are some examples to demonstrate.
     *
     * @param image
     */
    public BSNavBarBrandImage(Image image)
    {
        addClass(BSComponentDisplayOptions.Inline_Block);
        addClass(BSComponentVerticalAlignmentOptions.Align_Top);
        addAttribute("alt", "...");
        add(image);
    }

}
