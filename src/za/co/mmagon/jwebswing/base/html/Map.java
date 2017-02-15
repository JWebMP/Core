/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.MapChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The map tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The map tag is used to define a client-side image-map. An image-map is an image with clickable areas.<p>
 * <p>
 * The required name attribute of the map element is associated with the img's usemap attribute and creates a relationship between the image and the map.<p>
 * <p>
 * The map element contains a number of area elements, that defines the clickable areas in the image map. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Note: In HTML5, if the id attribute of the map tag is also specified, it must have the same value as the name attribute. Differences Between HTML and XHTML<p>
 * <p>
 * In XHTML, the name attribute is deprecated, and will be removed. Use the id attribute instead.<p>
 *
 * @param <J>
 *
 * @since 2013/11/22
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class Map<J extends Map>
        extends Component<MapChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements ImageMapChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Map for use with the Image Map Useless really without
     */
    public Map()
    {
        super(ComponentTypes.Map);
    }

    /**
     * Adds the absolute CSS Configuration, and sets the name to the ID of the Map
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        addAttribute(GlobalAttributes.Name, getID());
    }
}
