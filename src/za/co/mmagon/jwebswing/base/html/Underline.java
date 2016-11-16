/*
 * Copyright (C) 2015 GedMarc
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
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * <p>
 * The &lt;u&gt; tag represents some text that should be stylistically different from normal text, such as misspelled words or proper nouns in Chinese.
 * <p>
 * Browser Support
 * <p>
 * Element
 * <p>
 * &lt;u&gt; Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * <p>
 * Tip: Avoid using the &lt;u&gt; element where it could be confused for a hyperlink.
 * <p>
 * <p>
 * Note: The HTML 5 specification reminds developers that other elements are almost always more appropriate than &lt;u&gt;.
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * <p>
 * The &lt;u&gt; element was deprecated in HTML 4.01. (the &lt;u&gt; element was used to define underlined text).
 * <p>
 * <p>
 * The &lt;u&gt; element is redefined in HTML5, to represent text that should be stylistically different from normal text, such as misspelled words or proper nouns in Chinese.
 * <p>
 * @author GedMarc
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class Underline extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, Underline> implements GlobalChildren,NoNewLineForRawText,NoNewLineBeforeClosingTag
{

    /**
     * Constructs new Underlined Text
     */
    public Underline()
    {
        super(ComponentTypes.Underline);
    }
}
