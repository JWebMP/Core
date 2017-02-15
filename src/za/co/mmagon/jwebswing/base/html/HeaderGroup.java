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
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeaderGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The hgroup tag is used to group heading elements.<p>
 * <p>
 * The &lt;hgroup&gt; element is used to group a set of h1 to h6 elements, when a heading has multiple levels (subheadings). Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element<p>
 * &lt;hgroup&gt; 5.0 9.0 4.0 4.1 11.1
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;hgroup&gt; tag is new in HTML5.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since 2014/12/21
 */
public class HeaderGroup<J extends HeaderGroup>
        extends Component<HeaderGroupChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Definition and Usage<p>
     * <p>
     * The hgroup tag is used to group heading elements.<p>
     * <p>
     * The &lt;hgroup&gt; element is used to group a set of h1 to h6 elements, when a heading has multiple levels (subheadings). Browser Support<p>
     * <p>
     * The numbers in the table specify the first browser version that fully supports the element. Element<p>
     * &lt;hgroup&gt; 5.0 9.0 4.0 4.1 11.1
     * <p>
     * <p>
     * Differences Between HTML 4.01 and HTML5<p>
     * <p>
     * The &lt;hgroup&gt; tag is new in HTML5.<p>
     * <p>
     * @author GedMarc
     *
     * @since 2014/12/21
     */
    public HeaderGroup()
    {
        super(ComponentTypes.HeaderGroup);
    }
}
