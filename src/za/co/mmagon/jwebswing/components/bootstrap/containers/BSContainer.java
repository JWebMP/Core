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
package za.co.mmagon.jwebswing.components.bootstrap.containers;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.components.bootstrap.forms.BSFormChildren;
import za.co.mmagon.jwebswing.components.bootstrap.forms.groups.BSFormGroupChildren;
import za.co.mmagon.jwebswing.components.bootstrap.navbar.BSNavBarChildren;

/**
 * Containers
 * <p>
 * Containers are the most basic layout element in Bootstrap and are required when using our grid system. Choose from a responsive, fixed-width container (meaning its max-width changes at each
 * breakpoint) or fluid-width (meaning it’s 100% wide all the time).
 * <p>
 * While containers can be nested, most layouts do not require a nested container.
 *
 * @author GedMarc
 * @since Oct 11, 2016
 * @version 1.0
 *
 */
public class BSContainer extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, Component>
        implements BSNavBarChildren, BSFormChildren, BSFormGroupChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs as a container-fluid full page
     */
    public BSContainer()
    {
        this(BSContainerType.Container_Fluid);
    }

    /**
     * Constructs a new container
     *
     * @param type
     */
    public BSContainer(BSContainerType type)
    {
        addClass(type.toString());
    }

    /**
     * Returns a new instance
     *
     * @param type The type of container.
     *
     * @return
     */
    public static BSContainer newInstance(BSContainerType type)
    {
        return new BSContainer(type);
    }

    /**
     * Sets the container type on this container
     *
     * @param type
     */
    public void setContainerType(BSContainerType type)
    {
        for (BSContainerType value : BSContainerType.values())
        {
            removeClass(value.toString());
        }
        addClass(type.toString());
    }
}
