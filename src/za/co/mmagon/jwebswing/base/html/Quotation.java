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
import za.co.mmagon.jwebswing.base.html.attributes.QuotationAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;q&gt; tag defines a short quotation.<p>
 * <p>
 * Browsers normally insert quotation marks around the quotation.<p>
 * <p>
 * Browser Support<p>
 * &lt;q&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: Use blockquote to mark up a section that is quoted from another source.<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE.
 *
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class Quotation<J extends Quotation>
        extends Component<NoChildren, QuotationAttributes, GlobalFeatures, GlobalEvents, J>
        implements ParagraphChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Quotation
     *
     * @param text Specifies the quotation text
     */
    public Quotation(String text)
    {
        super(ComponentTypes.Quotation);
    }
}
