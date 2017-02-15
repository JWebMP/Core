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

import java.io.Serializable;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Definition and Usage
 * <p>
 * <p>
 * The article tag specifies independent, self-contained content.<p>
 * <p>
 * An article should make sense on its own and it should be possible to distribute it independently from the rest of the site.<p>
 * <p>
 * Potential sources for the article element:
 * <p>
 * <p>
 * Forum post Blog post News story Comment<p>
 * <p>
 * Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.
 * <p>
 * Element<p>
 * article 6.0 9.0 4.0 5.0 11.1
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The article tag is new in HTML5. Global Attributes<p>
 * <p>
 * The article tag also supports the Global Attributes in HTML. Event Attributes<p>
 * <p>
 * The article tag also supports the Event Attributes in HTML.<p>
 * <p>
 * @param <J>
 *
 * @since 2014/10/26
 * @version 1.0
 * @author MMagon
 * <p>
 *
 */
public class Article<J extends Article>
        extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements GlobalChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, Serializable
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("Article");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     * Constructs a new article instance
     *
     * @param text
     */
    public Article(String text)
    {
        super(ComponentTypes.Article.getComponentTag(), ComponentTypes.Article);
        setText(text);
    }

    /**
     * Constructs a new instance of article
     */
    public Article()
    {
        this(null);
    }

}
