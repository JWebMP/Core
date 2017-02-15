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
import za.co.mmagon.jwebswing.base.html.interfaces.children.DescriptionListChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;dd&gt; tag is used to describe a term/name in a description list.
 * <p>
 * The &lt;dd&gt; tag is used in conjunction with dl (defines a description list) and dt (defines terms/names).
 * <p>
 * Inside a &lt;dd&gt; tag you can put paragraphs, line breaks, images, links, lists, etc. Browser Support Element &lt;dd&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * In HTML 4.01, the &lt;dd&gt; tag was used to describe an item in a definition list.
 * <p>
 * In HTML5, the &lt;dd&gt; tag is used to describe a term/name in a description list.
 * <p>
 * @author GedMarc
 * @param <J>
 */
public class DataDescription<J extends DataDescription>
        extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText, DescriptionListChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Data Description object
     * <p>
     * @param description The description
     */
    public DataDescription(String description)
    {
        super(ComponentTypes.DataDescription);
        setText(description);
    }
}
