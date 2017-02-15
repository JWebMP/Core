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

import java.util.Objects;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.HeaderTypes;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeaderGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * HTML Headings<p>
 * <p>
 * Headings are defined with the h1 to h6 tags.<p>
 * <p>
 * h1 defines the most important heading. h6 defines the least important heading.<p>
 * <p>
 * Note: Browsers automatically add some empty space (a margin) before and after each heading. Headings Are Important<p>
 * <p>
 * Use HTML headings for headings only. Don't use headings to make text BIG or bold.<p>
 * <p>
 * Search engines use your headings to index the structure and content of your web pages.<p>
 * <p>
 * Since users may skim your pages by its headings, it is important to use headings to show the document structure.<p>
 * <p>
 * H1 headings should be used as main headings, followed by H2 headings, then the less important H3 headings, and so on.<p>
 * <p>
 * Browser Support
 * <p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The &lt;h1&gt; to &lt;h6&gt; tags are supported in all major browsers. Definition and Usage<p>
 * <p>
 * The &lt;h1&gt; to &lt;h6&gt; tags are used to define HTML headings.<p>
 * <p>
 * &lt;h1&gt; defines the most important heading. &lt;h6&gt; defines the least important heading. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "align" attribute is deprecated in HTML 4.01, and is not supported in HTML5. Use CSS to align elements.<p>
 * <p>
 * @author Marc Magon
 * @param <J>
 *
 * @since forever
 */
public class HeaderText<J extends HeaderText>
        extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren, HeaderGroupChildren, GlobalChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText

{

    private static final long serialVersionUID = 1L;

    private HeaderTypes headerType;

    /**
     * Constructs a new blank header of type H1
     */
    public HeaderText()
    {
        this(HeaderTypes.H1, "");
    }

    /**
     * Constructs a new header of specified type with the text
     *
     * @param headerType The type of header
     * @param text       The text for the header
     */
    public HeaderText(final HeaderTypes headerType, String text)
    {
        super(headerType.name(), headerType.getLinkedComponent());
        setText(text == null ? "" : text);
        this.headerType = headerType;
    }

    /**
     * Returns the current header text
     *
     * @return The header text
     */
    public String getHeaderText()
    {
        return getText(0).toString();
    }

    /**
     * Sets the current text
     *
     * @param headerText The text for the header
     *
     * @return
     */
    public final J setHeaderText(String headerText)
    {
        setText(headerText);
        return (J) this;
    }

    /**
     * Returns the current header type
     *
     * @return The header type
     */
    public HeaderTypes getHeaderType()
    {
        return headerType;
    }

    /**
     * Sets this headers type
     *
     * @param headerType The type of header this is
     *
     * @return
     */
    public J setHeaderType(HeaderTypes headerType)
    {
        this.headerType = headerType;
        super.setTag(headerType.name());
        super.setComponentType(headerType.getLinkedComponent());
        return (J) this;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.headerType);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final HeaderText other = (HeaderText) obj;
        if ((this.headerType == other.headerType))
        {
            if (this.getText(0).toString().equals(other.getText(0).toString()))
            {
                return true;
            }
        }
        return false;
    }
}
