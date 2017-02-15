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
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Definition and Usage<p>
 * <p>
 * The aside tag defines some content aside from the content it is placed in.<p>
 * <p>
 * The aside content should be related to the surrounding content. Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.
 * <p>
 * Element aside 6.0 9.0 4.0 5.0 11.1
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The aside tag is new in HTML5. Tips and Notes<p>
 * <p>
 * Tip: The aside content could be placed as a sidebar in an article. Global Attributes<p>
 * <p>
 * The aside tag also supports the Global Attributes in HTML. Event Attributes<p>
 * <p>
 * The aside tag also supports the Event Attributes in HTML.<p>
 *
 * @param <J>
 *
 * @since 2014/10/26
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class Aside<J extends Aside>
        extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements GlobalChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("Aside");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     * Constructs a new ASide with the given text set as Raw Text
     *
     * @param text The text for this ASide
     */
    public Aside(String text)
    {
        super(ComponentTypes.Aside.getComponentTag(), ComponentTypes.Aside);
        setText(text);
    }

    /**
     * Constructs a new instance of Aside
     */
    public Aside()
    {
        this(null);
    }

}
