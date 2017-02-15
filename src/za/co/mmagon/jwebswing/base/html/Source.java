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
import za.co.mmagon.jwebswing.base.html.attributes.SourceAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;source&gt; tag is used to specify multiple media resources for media elements, such as &lt;video&gt; and &lt;audio&gt;
 * <p>
 * .<p>
 * <p>
 * The &lt;source&gt; tag allows you to specify alternative video/audio files which the browser may choose from, based on its media type or codec support.<p>
 * <p>
 * Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.<p>
 * <p>
 * Element
 * <p>
 * &lt;source&gt; 4.0 9.0 3.5 4.0 10.5
 * <p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;source&gt; tag is new in HTML5.<p>
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class Source<J extends Source>
        extends Component<NoChildren, SourceAttributes, NoFeatures, NoEvents, J>
        implements AudioChildren, VideoChildren, NoClosingTag
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new source tag
     */
    public Source()
    {
        super(ComponentTypes.Source);
    }
}
