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
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;span&lt; tag is used to group inline-elements in a document.<p>
 * <p>
 * The &gt;span&lt; tag provides no visual change by itself.<p>
 * <p>
 * The &gt;span&lt; tag provides a way to add a hook to a part of a text or a part of a document.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &gt;span&lt; Yes Yes Yes Yes Yes<p>
 * Tips and Notes<p>
 * <p>
 * Tip: When a text is hooked in a &gt;span&lt; element, you can style it with CSS, or manipulate it with JavaScript.<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE.<p>
 * <p>
 * @author Marc Magon
 * @since forever
 * @param <C> The children allowed
 * @param <A> The attributes allowed
 * @param <J> The component itself for cloning
 */
public class Span<C extends GlobalChildren, A extends Enum & AttributeDefinitions, J extends Span>
        extends Component<C, A, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren, MapChildren, AreaChildren, ContainerType, ParagraphChildren,
        ListItemChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new instance of a Span item
     */
    public Span()
    {
        super(ComponentTypes.Span);
    }

    /**
     * Constructs a new span with the given text
     *
     * @param text
     */
    public Span(String text)
    {
        super(ComponentTypes.Span);
        setText(text);
    }
}
