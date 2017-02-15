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
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.DetailsChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.PhraseChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;details&gt; tag specifies additional details that the user can view or hide on demand.
 * <p>
 * The &lt;details&gt; tag can be used to create an interactive widget that the user can open and close. Any sort of content can be put inside the &lt;details&gt; tag.
 * <p>
 * The content of a &lt;details&gt; element should not be visible unless the open attribute is set. Browser Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element &lt;details&gt; 12.0 Not supported Not supported 6.0 15.0
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;details&gt; tag is new in HTML5. Tips and Notes
 * <p>
 * Tip: The &lt;summary&gt; tag is used to specify a visible heading for the details. The heading can be clicked to view/hide the details.
 * <p>
 * @author GedMarc
 * @param <J>
 */
public class Details<J extends Details>
        extends Component<DetailsChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements GlobalChildren, ParagraphChildren, PhraseChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Details section.
     */
    public Details()
    {
        super(ComponentTypes.Details);
    }
}
