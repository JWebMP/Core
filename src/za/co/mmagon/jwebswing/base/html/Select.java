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
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.SelectChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 *
 * Definition and Usage<p>
 * <p>
 * The &lt;select&gt; element is used to create a drop-down list.<p>
 * <p>
 * The &lt;option&gt; tags inside the &lt;select&gt; element define the available options in the list.<p>
 * <p>
 * Browser Support<p>
 * <p>
 * Element
 * <p>
 * &lt;select&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Tips and Notes
 * <p>
 * Tip: The &lt;select&gt; element is a form control and can be used in a form to collect user input.<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 has added some new attributes.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class Select<J extends Select>
        extends Component<SelectChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements GlobalChildren
{

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Select()
    {
        super(ComponentTypes.Select);
    }
}
