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
import za.co.mmagon.jwebswing.base.html.attributes.TextAreaAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;textarea&gt; tag defines a multi-line text input control.<p>
 * <p>
 * A text area can hold an unlimited number of characters, and the text renders in a fixed-width font (usually Courier)
 * .<p>
 * <p>
 * The size of a text area can be specified by the cols and rows attributes, or even better; through CSS' height and width properties.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &lt;textarea&gt; Yes Yes Yes Yes Yes<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 has added several new attributes.<p>
 * @author GedMarc
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class TextArea extends Component<NoChildren, TextAreaAttributes, GlobalFeatures, GlobalEvents, TextArea> implements NoNewLineBeforeClosingTag,NoNewLineForRawText,GlobalChildren
{

    /**
     * Constructs a new Text Area
     * @param defaultText The raw text to display.
     */
    public TextArea(String defaultText)
    {
        super(ComponentTypes.TextArea);
        setText(defaultText);
    }
}
