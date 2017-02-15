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
import za.co.mmagon.jwebswing.base.html.interfaces.children.RubyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;ruby&gt; tag specifies a ruby annotation.<p>
 * <p>
 * Ruby annotations are used for East Asian typography, to show the pronunciation of East Asian characters.<p>
 * <p>
 * Use the &lt;ruby&gt; tag together with the &lt;rt&gt; and/or the &lt;rp&gt; tags: The &lt;ruby&gt; element consists of one or more characters that needs an explanation/pronunciation, and an<p>
 * &lt;rt&gt; element that gives that information, and an optional &lt;rp&gt; element that defines what to show for browsers that not support ruby annotations. Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.<p>
 * <p>
 * Element<p>
 * <p>
 * &lt;ruby&gt; 5.0 5.5 Not supported 5.0 15.0
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;ruby&gt; tag is new in HTML5.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class Ruby<J extends Ruby>
        extends Component<RubyChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Ruby process
     */
    public Ruby()
    {
        super(ComponentTypes.Ruby);
    }
}
