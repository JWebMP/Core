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
import za.co.mmagon.jwebswing.base.html.attributes.CanvasAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;canvas&gt; tag is used to draw graphics, on the fly, via scripting (usually JavaScript).
 * <p>
 * The &lt;canvas&gt; tag is only a container for graphics, you must use a script to actually draw the graphics. Browser Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.
 * <p>
 * <p>
 * Element &lt;canvas&gt; 4.0 9.0 2.0 3.1 9.0
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;canvas&gt; tag is new in HTML5. Tips and Notes
 * <p>
 * Note: Any text inside the &lt;canvas&gt; element will be displayed in browsers that does not support &lt;canvas&gt;.
 * <p>
 * Tip: Learn more about the &lt;canvas&gt; element in our HTML Canvas Tutorial.
 * <p>
 * Tip: For a complete reference of all the properties and methods that can be used with the canvas object, go to our HTML Canvas Reference.
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since forever, was created for the jwimagemap
 * @version 1.0
 */
public class Canvas<J extends Canvas>
        extends Component<NoChildren, CanvasAttributes, GlobalFeatures, GlobalEvents, J>
        implements NoNewLineBeforeClosingTag
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new canvas
     */
    public Canvas()
    {
        super(ComponentTypes.Canvas);
    }
}
