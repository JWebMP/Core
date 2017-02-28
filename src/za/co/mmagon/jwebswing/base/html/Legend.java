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
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.FieldSetChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The legend tag defines a caption for the field set element. Browser Support<p>
 * Element<p>
 * legend Yes Yes Yes Yes Yes Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "align" attribute is not supported in HTML5.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since Feb 9, 2015
 * @version 1.0
 * <p>
 *
 */
public class Legend<J extends Legend>
        extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements FieldSetChildren, NoNewLineBeforeClosingTag
{

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Legend()
    {
        super(ComponentTypes.Legend);
    }
}
