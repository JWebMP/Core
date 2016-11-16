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

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * The default container (or fluid) for bootstrap
 * @author GedMarc
 * @since Oct 11, 2016
 * @version 1.0
 * 
 */
public class BSContainer extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, Component>
{
    private static final long serialVersionUID = 1L;

    /**
     * Constructs as a container-fluid full page)
     */
    public BSContainer()
    {
        this(BSContainerType.Container_Fluid);
    }
    
    /**
     * Constructs a new container
     * @param type 
     */
    public BSContainer (BSContainerType type)
    {
        addClass(type.toString());
    }   
    /**
     * Returns a new instance
     * @param type The type of container.
     * @return 
     */
    public static BSContainer newInstance(BSContainerType type)
    {
        return new BSContainer(type);
    }
    
}
