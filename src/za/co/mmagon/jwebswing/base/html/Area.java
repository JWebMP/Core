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

import java.io.Serializable;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.AreaAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.AreaChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.MapChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The area tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The area tag defines an area inside an image-map (an image-map is an image with clickable areas)
 * .<p>
 * <p>
 * The area element is always nested inside a map tag.<p>
 * <p>
 * Note: The usemap attribute in the img tag is associated with the map element's name attribute, and creates a relationship between the image and the map. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 has some new attributes, and some HTML 4.01 attributes are no longer supported. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML the area tag has no end tag.<p>
 * <p>
 * In XHTML the area tag must be properly closed.<p>
 *
 * @since 2013/11/22
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class Area extends ComponentHierarchyBase<AreaChildren, AreaAttributes, GlobalFeatures, GlobalEvents, Area>
        implements MapChildren, Serializable
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("Area");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    public Area()
    {
        super(ComponentTypes.Area);
    }

}
