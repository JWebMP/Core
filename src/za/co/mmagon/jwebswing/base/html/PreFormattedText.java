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
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Implements the PreFormattedText tag<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The<p>
 * &gt;pre&lt; tag defines preformatted text.<p>
 * <p>
 * Text in a &gt;pre&lt; element is displayed in a fixed-width font (usually Courier), and it preserves both spaces and line breaks.<p>
 * Browser Support<p>
 * Element<p>
 * &gt;pre&lt; Yes Yes Yes Yes Yes<p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use the &gt;pre&lt; element when displaying text with unusual formatting, or some sort of computer code.<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "width" attribute is not supported in HTML5.<p>
 *
 * @param <J>
 *
 * @since 2014/06/12
 * @author mmagon
 * @version 1.0
 */
public class PreFormattedText<J extends PreFormattedText>
        extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren, NoNewLineForRawText, NoNewLineBeforeClosingTag, ParagraphChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new Pre tag
     */
    public PreFormattedText()
    {
        this(null);
    }

    /**
     * Constructs a new Pre-formatted Text Object with the given text set as the raw text
     *
     * @param preFormattedText
     */
    public PreFormattedText(String preFormattedText)
    {
        super(ComponentTypes.PreFormatted);
        setText(preFormattedText);
    }
}
