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
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;dfn&gt; tag represents the defining instance of a term in HTML.
 * <p>
 * The defining instance is often the first use of a term in a document.
 * <p>
 * The nearest parent of the &lt;dfn&gt; tag must also contain the definition/explanation for the term inside &lt;dfn&gt;.
 * <p>
 * The term inside the &lt;dfn&gt; tag can be any of the following:
 * <p>
 * Browser Support Element &lt;dfn&gt; Yes Yes Yes Yes Yes
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
public class Definition<J extends Definition>
        extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText, ParagraphChildren, NoIDTag
{

    private static final long serialVersionUID = 1L;

    /**
     * Specifies text that is defined as a definition
     * <p>
     * @param text
     */
    public Definition(String text)
    {
        super(ComponentTypes.Definition);
        setText(text);
    }
}
