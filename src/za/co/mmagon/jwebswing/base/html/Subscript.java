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
 * Definition and Usage
 * <p>
 * The &lt;sub&gt; tag defines subscript text.<p>
 * Subscript text appears half a character below the normal line, and is sometimes rendered in a smaller font.<p>
 * Subscript text can be used for chemical formulas, like H2O.
 * <p>
 * <p>
 * Tip: Use the &lt;sup&gt; tag to define superscripted text.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &lt;sub&gt; Yes Yes Yes Yes Yes<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE.<p>
 * @author Marc Magon
 * @param <J>
 *
 * @since forever
 * @version 1.0
 */
public class Subscript<J extends Subscript>
        extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs an empty sub script
     */
    public Subscript()
    {
        this(null);
    }

    /**
     * Constructs a new subscript section with the relevant text as raw text
     *
     * @param text
     */
    public Subscript(String text)
    {
        super("sub", ComponentTypes.Subscript);
        setText(text);
    }

}
