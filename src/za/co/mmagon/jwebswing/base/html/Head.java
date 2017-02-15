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

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HtmlChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * The head tag for HTML
 * <p>
 * Definition and Usage
 * <p>
 * The &lt;head&gt; element is a container for all the head elements.<p>
 * <p>
 * The &lt;head&gt; element can include a title for the document, scripts, styles, meta information, and more.<p>
 * <p>
 * The following elements can go inside the &lt;head&gt; element:
 * <p>
 * <p>
 * &lt;title&gt; (this element is required in an HTML document)
 * <p>
 * &lt;style&gt;
 * <p>
 * &lt;base&gt;
 * <p>
 * &lt;link&gt;
 * <p>
 * &lt;meta&gt;
 * <p>
 * &lt;script&gt;
 * <p>
 * &lt;noscript&gt;
 * <p>
 * <p>
 * Browser Support Element &lt;head&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * In HTML 4.01 the &lt;head&gt; element is required.<p>
 * <p>
 * In HTML5, the &lt;head&gt; element can be omitted. The following code will validate as HTML5:
 * <p>
 * <p>
 * @param <J>
 *
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 * <p>
 * <p>
 */
public class Head<J extends Head>
        extends ComponentHierarchyBase<HeadChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements NoIDTag, HtmlChildren, NoClassAttribute
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Head Tag
     */
    public Head()
    {
        super(ComponentTypes.Head);
    }
}
