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
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;figure&gt; tag specifies self-contained content, like illustrations, diagrams, photos, code listings, etc.
 * <p>
 * While the content of the &lt;figure&gt; element is related to the main flow, its position is independent of the main flow, and if removed it should not affect the flow of the document. Browser
 * Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element &lt;figure&gt; 6.0 9.0 4.0 5.0 11.1
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;figure&gt; tag is new in HTML5.
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since 2014/12/21
 */
public class Figure<J extends Figure>
        extends Component<FigureChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements NoIDTag
{

    private static final long serialVersionUID = 1L;

    public Figure()
    {
        super(ComponentTypes.Figure);
    }

}
