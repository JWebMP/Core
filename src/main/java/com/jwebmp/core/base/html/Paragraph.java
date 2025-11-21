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
import com.jwebmp.core.base.html.attributes.ParagraphAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.*;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.utilities.TextUtilities;
import jakarta.validation.constraints.NotNull;

/**
 * This class defines a paragraph as per<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The<p>
 * &lt;p&gt;
 * <p>
 * tag defines a paragraph.<p>
 * <p>
 * Browsers automatically add some space (m<p>
 * argin) before and after each<p>
 * &lt;p&gt;
 * <p>
 * element. The margins can be modified with CSS (with the margin properties). Browser Support Element<p>
 * &lt;p&gt;
 * <p>
 * Yes Yes Yes Yes Yes Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The align attribute is not supported in HTML5.<p>
 * <p>
 *
 * @param <J>
 * @author GedMarc
 * @version 1.0
 * @since forever, 2008 or 2007 sometime I think - will need to check on the original version named "radio on live".
 */
public class Paragraph<J extends Paragraph<J>>
        extends Component<ParagraphChildren, ParagraphAttributes, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren, NoNewLineForRawText, ParagraphChildren, DetailsChildren,
                   FormChildren, ListItemChildren, ListChildren, HeadChildren
{


    /**
     * Sets if this paragraph must render the text directly without a tag
     */
    private boolean textOnly;

    /**
     * Constructs a blank paragraph
     */
    public Paragraph()
    {
        this("");
    }

    /**
     * Constructs a new paragraph with the raw text set as the input text
     * <p>
     *
     * @param text
     */
    public Paragraph(String text)
    {
        super("p", ComponentTypes.Paragraph);
        setText(text);
    }

    @Override
    @NotNull
    protected StringBuilder renderHTML(int tabCount)
    {
        if (isTextOnly())
        {
            return TextUtilities.getTabString(tabCount)
                                .append(getText(tabCount));
        }
        else
        {
            return super.renderHTML(tabCount);
        }
    }

    /**
     * Sets if this paragraph must render the text directly without a tag
     *
     * @return
     */
    public boolean isTextOnly()
    {
        return textOnly;
    }

    /**
     * Sets if this paragraph must render the text directly without a tag
     *
     * @param textOnly
     * @return
     */
    @SuppressWarnings("unchecked")
    public @org.jspecify.annotations.NonNull J setTextOnly(boolean textOnly)
    {
        this.textOnly = textOnly;
        return (J) this;
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        return super.equals(o);
    }
}
