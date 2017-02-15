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
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The mark tag defines marked text.<p>
 * <p>
 * Use the mark tag if you want to highlight parts of your text. Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element<p>
 * mark 6.0 9.0 4.0 5.0 11.1 Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The mark tag is new in HTML5.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since Feb 9, 2015
 * @version 1.0
 * <p>
 *
 */
public class Marker<J extends Marker>
        extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements ParagraphChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    private static final long serialVersionUID = 1L;

    /**
     * Specifies text that is a marker
     */
    public Marker()
    {
        super(ComponentTypes.Marker);
    }
}
