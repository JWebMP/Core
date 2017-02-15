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
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The center tag is not supported in HTML5. Use CSS instead.
 * <p>
 * The center tag is used to center-align text.
 * <p>
 * Browser Support Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HT1ML5
 * <p>
 * The center tag is not supported in HTML5.
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @deprecated
 */
public class Center<J extends Center>
        extends Component<GlobalChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements NoIDTag, NoClassAttribute, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    private static final Center center = new Center();
    private static final long serialVersionUID = 1L;

    /**
     *
     * Constructs a new center placement. Better to use the static option
     */
    private Center()
    {
        super(ComponentTypes.Center);
    }

    /**
     * Return a center placement object
     * <p>
     * @return
     */
    public static Center getCenter()
    {
        return center;
    }

    /**
     * Returns a new instance of the center object. Better to reference the static field.
     * <p>
     * @return
     */
    public static Center getNewInstance()
    {
        return new Center();
    }
}
