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
import za.co.mmagon.jwebswing.base.html.attributes.BiDirectionalOverrideAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BiDirectionalOverrideChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari
 * <p>
 * The b tag is supported in all major browsers. Definition and Usage
 * <p>
 * The b tag specifies bold text. Differences Between HTML 4.01 and HTML5
 * <p>
 * NONE. Tips and Notes
 * <p>
 * Note: According to the HTML 5 specification, the b tag should be used as a LAST resort when no other tag is more appropriate. The HTML 5 specification states that headings should be denoted with
 * the h1 to h6 tags, emphasized text should be denoted with the em tag, important text should be denoted with the strong tag, and marked/highlighted text should use the mark tag.
 * <p>
 * Tip: You can also use the CSS "font-weight" property to set bold text.
 * <p>
 * @author Marc Magon
 * @param <J>
 */
public class BiDirectionalOverride<J extends BiDirectionalOverride>
        extends Component<BiDirectionalOverrideChildren, BiDirectionalOverrideAttributes, GlobalFeatures, GlobalEvents, J>
        implements ParagraphChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a bold section of text
     */
    public BiDirectionalOverride()
    {
        this(null);
    }

    /**
     * Specifies the text as bold
     * <p>
     * @param text
     */
    public BiDirectionalOverride(String text)
    {
        super(ComponentTypes.BiDirectionalOverride.getComponentTag(), ComponentTypes.BiDirectionalOverride);
        setText(text);
    }
}
