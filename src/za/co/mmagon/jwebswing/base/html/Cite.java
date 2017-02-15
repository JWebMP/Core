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

/**
 * Definition and Usage
 * <p>
 * The &lt;cite&gt; tag defines the title of a work (e.g. a book, a song, a movie, a TV show, a painting, a sculpture, etc.).
 * <p>
 * Note: A person's name is not the title of a work. Browser Support Element &lt;cite&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * In HTML5, the &lt;cite&gt; tag defines the title of a work.
 * <p>
 * In HTML 4.01, the &lt;cite&gt; tag defines a citation.
 * <p>
 * @author GedMarc
 */
public class Cite
        extends Component<NoChildren, NoAttributes, GlobalFeatures, GlobalEvents, Cite>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    private static final long serialVersionUID = 1L;

    /**
     * The cite tag defines the title of a work (e.g. a book, a song, a movie, a TV show, a painting, a sculpture, etc.).
     */
    public Cite()
    {
        this(null);
    }

    /**
     * The cite tag defines the title of a work (e.g. a book, a song, a movie, a TV show, a painting, a sculpture, etc.).
     *
     * @param citeText The reference of the work
     */
    public Cite(String citeText)
    {
        super(ComponentTypes.Cite);
        setText(citeText);
    }

}
