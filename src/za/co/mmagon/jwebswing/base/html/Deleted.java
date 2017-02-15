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
import za.co.mmagon.jwebswing.base.html.attributes.DeletedAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;del&gt; tag defines text that has been deleted from a document. Browser Support Element &lt;del&gt; Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: Also look at the &lt;ins&gt; tag to markup inserted text.
 * <p>
 * Tip: Use &lt;del&gt; and &lt;ins&gt; to markup updates and modifications in a document.
 * <p>
 * Browsers will normally strike a line through deleted text and underline inserted text.
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * NONE.
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since 2014/12/21
 */
public class Deleted<J extends Deleted>
        extends Component<NoChildren, DeletedAttributes, NoFeatures, NoEvents, J>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag, ParagraphChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * The text marked as deleted
     * <p>
     * @param text
     */
    public Deleted(String text)
    {
        super(ComponentTypes.Deleted);
        setText(text);
    }
}
