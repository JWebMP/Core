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
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;div&gt; tag defines a division or a section in an HTML document.
 * <p>
 * The &lt;div&gt; tag is used to group block-elements to format them with CSS.<p>
 * Browser Support Element<p>
 * &lt;div&gt;
 * <p>
 * Yes<p>
 * Yes<p>
 * Yes<p>
 * Yes<p>
 * Yes<p>
 * <p>
 * Tips and Notes
 * <p>
 * Tip: The &lt;div&gt; element is very often used together with CSS, to layout a web page.
 * <p>
 * Note: By default, browsers always place a line break before and after the &lt;div&gt; element. However, this can be changed with CSS. Differences Between HTML 4.01 and HTML5
 * <p>
 * The align attribute not supported in HTML5.
 * <p>
 * @author Marc Magon
 * @param <C> The Children Allowed
 * @param <A> The allowed attributes for the component
 * @param <F> The allowed features on the div type
 * @param <E> The allowed events
 * @param <J> The Clonable object
 */
public class Div<C extends GlobalChildren, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends Div>
        extends Component<C, A, F, E, J>
        implements BodyChildren, ImageMapChildren, AreaChildren, LayoutHandler,
        ListItemChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Div Object
     */
    public Div()
    {
        super(ComponentTypes.Div);
    }

    /**
     * Use a different tag for this div
     * <p>
     * @param myComponent
     */
    public Div(ComponentTypes myComponent)
    {
        super(myComponent);
    }

    /**
     * Div with in-line text
     *
     * @param text
     */
    public Div(String text)
    {
        super(ComponentTypes.Div);
        setText(text);

    }
}
