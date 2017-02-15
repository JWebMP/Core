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
import za.co.mmagon.jwebswing.base.html.attributes.BlockQuoteAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;blockquote&gt; tag specifies a section that is quoted from another source.
 * <p>
 * Browsers usually indent &lt;blockquote&gt; elements. Browser Support Element &lt;blockquote&gt; Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: Use &lt;q&gt; for inline (short) quotations. Differences Between HTML 4.01 and HTML5
 * <p>
 * In HTML 4.01, the &lt;blockquote&gt; tag defines a long quotation.
 * <p>
 * In HTML5, the &lt;blockquote&gt; tag specifies a section that is quoted from another source. Differences Between HTML and XHTML
 * <p>
 * Note: To validate a &lt;blockquote&gt; element as XHTML, it must contain only other block-level elements, like this:
 * <p>
 * &lt;blockquote&gt;
 * <p>
 * Here is a long quotation here is a long quotation.
 * <p>
 * &lt;/blockquote&gt;
 * <p>
 * @author GedMarc
 * @param <J>
 */
public class BlockQuote<J extends BlockQuote>
        extends Component<ParagraphChildren, BlockQuoteAttributes, GlobalFeatures, GlobalEvents, J>

{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Block Quote Item
     */
    public BlockQuote()
    {
        super(ComponentTypes.BlockQuotes);
    }

    /**
     * Constructs a new block quote with the given text
     *
     * @param text
     */
    public BlockQuote(String text)
    {
        this();
        setText(text);
    }

    /**
     * Constructs a new block quote with the given text and footer
     *
     * @param text
     * @param footer
     */
    public BlockQuote(String text, String footer)
    {
        this();
        add(text);
        Div d = new Div();
        d.setTag("footer");
        d.setText(footer);
    }
}
