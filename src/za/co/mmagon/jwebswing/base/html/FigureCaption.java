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
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;figcaption&gt; tag defines a caption for a figure element.
 * <p>
 * The &lt;figcaption&gt; element can be placed as the first or last child of the figure element. Browser Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element &lt;figcaption&gt; 6.0 9.0 4.0 5.0 11.1
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;figcaption&gt; tag is new in HTML5.
 * <p>
 * @author GedMarc
 * @param <J>
 */
public class FigureCaption<J extends FigureCaption>
        extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText, FigureChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Defines a new Figure Captions
     */
    public FigureCaption()
    {
        super(ComponentTypes.FigureCaption);
    }
}
