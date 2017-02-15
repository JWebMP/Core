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
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * bdi stands for Bi-directional Isolation.<p>
 * <p>
 * The &gt;bdi&lt; tag isolates a part of text that might be formatted in a<p>
 * different direction from other text outside it.<p>
 * <p>
 * This element is useful when embedding user-generated content with an unknown<p>
 * directionality. Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully<p>
 * supports the element. Element &gt;bdi&lt; 16.0 Not supported 10.0 Not<p>
 * supported Not supported<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &gt;bdi&lt; tag is new in HTML5.<p>
 *
 * @author Marc Magon
 * @param <J>
 */
public class BiDirectionalIsolation<J extends BiDirectionalIsolation>
        extends Component<Component, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements GlobalChildren, ParagraphChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a bold section of text
     */
    public BiDirectionalIsolation()
    {
        this("");
    }

    /**
     * Specifies the text as bold
     *
     * @param text
     */
    public BiDirectionalIsolation(String text)
    {
        super(ComponentTypes.BiDirectionalIsolation);
        setText(text);
    }
}
