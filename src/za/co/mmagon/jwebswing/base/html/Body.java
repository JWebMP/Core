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

import java.util.logging.Logger;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.attributes.BodyAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.modernizr.ModernizrFeature;
import za.co.mmagon.logger.LogFactory;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer FireFox Opera Google Chrome Safari<p>
 * <p>
 * The body tag is supported in all major browsers.<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The body tag defines the document's body.<p>
 * <p>
 * The body element contains all the contents of an HTML document, such as text,
 * <p>
 * hyperlinks, images, tables, lists, etc.<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * All layout attributes is removed from HTML5.<p>
 * <p>
 * All layout attributes is deprecated in HTML 4.01
 * .<p>
 * <p>
 * @param <C>
 * @param <F> Features Base
 * @param <J>
 *
 * @since 2013/11/20
 * @author Marc Magon
 * @version 1.0
 */
public class Body<C extends GlobalChildren, F extends BodyFeatures, J extends Body>
        extends Component<C, BodyAttributes, F, NoEvents, J>
        implements PageChildren, HtmlChildren, LayoutHandler, ContainerType, IBody
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("BODY");

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates an empty body
     */
    public Body()
    {
        this(null);
    }

    /**
     * Constructs a new Body with the given Page input
     *
     * @param page
     */
    public Body(Page page)
    {
        super(ComponentTypes.Body);
        if (page != null)
        {
            setPage(page);
        }
        setID("body");
    }

    /**
     * Returns the component in its smallest form
     *
     * @return
     */
    public IBody asMe()
    {
        return this;
    }

    @Override
    public void configureModernizr()
    {
        if (getPage().getOptions().isModernizrEnabled())
        {
            addFeature(new ModernizrFeature(this));
        }
    }
}
