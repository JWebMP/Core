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
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;br&gt; tag inserts a single line break.<p>
 * <p>
 * The &lt;br&gt; tag is an empty tag which means that it has no end tag. Browser Support Element<p>
 * &lt;br&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: The &lt;br&gt; tag is useful for writing addresses or poems.<p>
 * <p>
 * Note: Use the &lt;br&gt; tag to enter line breaks, not to separate paragraphs. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML, the &lt;br&gt; tag has no end tag.<p>
 * <p>
 * In XHTML, the &lt;br&gt; tag must be properly closed, like this: br
 * <p>
 * @author GedMarc
 * @param <J>
 */
public class LineBreak<J extends LineBreak>
        extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements NoNewLineBeforeClosingTag, NoClosingTag, NoNewLineForRawText, GlobalChildren, NoIDTag
{

    private static final LineBreak br = new LineBreak();
    private static final long serialVersionUID = 1L;

    /**
     * Inserts a new object of a line break. Rather access this class statically.
     */
    private LineBreak()
    {
        super(ComponentTypes.LineBreak);
    }

    /**
     * Returns the instance of a line break
     * <p>
     * @return
     */
    public static LineBreak getLineBreak()
    {
        return br;
    }

    /**
     * Inserts a new object of a line break. Rather access this class statically if not applying custom styling.
     * <p>
     * @return A new instance of a line break
     */
    public static LineBreak getNewInstance()
    {
        return new LineBreak();
    }
}
