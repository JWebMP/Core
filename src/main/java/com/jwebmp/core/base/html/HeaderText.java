/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.HeaderTypes;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.*;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

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
 *
 * @param <J>
 * @author GedMarc
 * @since forever
 */
public class HeaderText<J extends HeaderText<J>>
        extends Component<IComponentHierarchyBase<?, ?>, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren,
        HeaderGroupChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, FormChildren, ListItemChildren, ListChildren

{
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
    public HeaderText(HeaderTypes headerType, String text)
    {
        super(headerType.name().toLowerCase(), headerType.getLinkedComponent());
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
     * @return
     */
    @SuppressWarnings("unchecked")
    public final J setHeaderText(String headerText)
    {
        setText(headerText);
        return (J) this;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + getHeaderType().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof HeaderText))
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        HeaderText<?> that = (HeaderText<?>) o;

        return getHeaderType() == that.getHeaderType();
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
     * @return
     */
    @SuppressWarnings("unchecked")
    public J setHeaderType(HeaderTypes headerType)
    {
        this.headerType = headerType;
        super.setTag(headerType.name());
        super.setComponentType(headerType.getLinkedComponent());
        return (J) this;
    }
}
