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
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;s&gt; tag specifies text that is no longer correct, accurate or relevant.<p>
 * <p>
 * The &lt;s&gt; tag should not be used to define replaced or deleted text, use the &lt;del&gt; tag to define replaced or deleted text.<p>
 * <p>
 * Browser Support<p>
 * <p>
 * Element<p>
 * <p>
 * &lt;s&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * <p>
 * The &lt;s&gt; element was deprecated in HTML 4.01, and was used to define strikethrough text.<p>
 * <p>
 * The &lt;s&gt; element is redefined in HTML5, and is now used to define text that is no longer correct.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class S<J extends S>
        extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements ParagraphChildren, NoNewLineForRawText, NoNewLineBeforeClosingTag
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new instance of S
     */
    public S()
    {
        super(ComponentTypes.S);
    }
}
