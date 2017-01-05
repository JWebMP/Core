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
package za.co.mmagon.jwebswing.components.bootstrap.carousel;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
 
/**
 * Optional captions
 * <p>
 * Add captions to your slides easily with the .carousel-caption element within any .carousel-item. Place just about any optional HTML within there and it will be automatically aligned and formatted.
 *
 * @author GedMarc
 * @since 4th Jan 2017
 */
public class BSCarouselCaption extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, BSCarouselCaption>
{

    /**
     * Optional captions
     * <p>
     * Add captions to your slides easily with the .carousel-caption element within any .carousel-item. Place just about any optional HTML within there and it will be automatically aligned and
     * formatted.
     */
    public BSCarouselCaption()
    {
    }

    /**
     * Optional captions
     * <p>
     * Add captions to your slides easily with the .carousel-caption element within any .carousel-item. Place just about any optional HTML within there and it will be automatically aligned and
     * formatted.
     *
     * @param text
     */
    public BSCarouselCaption(String text)
    {
        super(text);
    }

    
}
