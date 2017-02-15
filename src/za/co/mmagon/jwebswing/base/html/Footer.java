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
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.AddressChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * The &lt;footer&gt; tag defines a footer for a document or section.
 * <p>
 * A &lt;footer&gt; element should contain information about its containing element.
 * <p>
 * A &lt;footer&gt; element typically contains:
 * <p>
 * <p>
 * You can have several &lt;footer&gt; elements in one document.
 * <p>
 * Browser Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element &lt;footer&gt; 6.0 9.0 4.0 5.0 11.1
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;footer&gt; tag is new in HTML5.
 * <p>
 * @author GedMarc
 * @param <J>
 */
public class Footer<J extends Footer>
        extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements AddressChildren, NoIDTag
{

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new instance of a footer
     */
    public Footer()
    {
        super(ComponentTypes.Footer);
    }
}
