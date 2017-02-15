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
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeaderChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;header&gt; element represents a container for introductory content or a set of navigational links.<p>
 * <p>
 * A &lt;header&gt; element typically contains:
 * <p>
 * <p>
 * one or more heading elements (h1 - h6 and hgroup) logo or icon authorship information<p>
 * <p>
 * You can have several &lt;header&gt; elements in one document.<p>
 * <p>
 * Note: A &lt;header&gt; tag cannot be placed within a footer, address or another &lt;header&gt; element. Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element<p>
 * &lt;header&gt; 6.0 9.0 4.0 5.0 11.1
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;header&gt; tag is new in HTML5.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since 2014/12/21
 */
public class Header<J extends Header>
        extends Component<HeaderChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements NoIDTag, GlobalChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new instance of a footer
     */
    public Header()
    {
        super(ComponentTypes.Header);
    }
}
