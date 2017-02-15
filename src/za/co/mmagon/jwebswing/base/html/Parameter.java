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

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.ParameterAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ObjectTagChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;param&lt; tag is used to define parameters for plugins embedded with an &gt;object&lt; element.<p>
 * <p>
 * Tip: HTML 5 also includes two new elements for playing audio or video: The &gt;audio&lt; and &gt;video&lt; tags. Browser Support<p>
 * <p>
 * The &gt;param&lt; tag is supported in all major browsers. However, the file format defined in &gt;object&lt; may not be supported in all browsers. Element &gt;param&lt; Yes Yes Yes Yes Yes<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "type" and "valuetype" attributes are not supported in HTML5. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML the &gt;param&lt; tag has no end tag.<p>
 * <p>
 * In XHTML the &gt;param&lt; tag must be properly closed, like this &gt;param /&lt;
 * .<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class Parameter<J extends Parameter>
        extends Component<NoChildren, ParameterAttributes, GlobalFeatures, GlobalEvents, Parameter>
        implements ObjectTagChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("Parameter");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     *
     */
    public Parameter()
    {
        super(ComponentTypes.Parameter);
    }

    /**
     * Differences Between HTML and XHTML
     * <p>
     * In HTML the base tag has no end tag.
     * <p>
     * In XHTML the base tag must be properly closed.
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        try
        {
            if (getPage().getHtmlVersion().name().startsWith("X"))
            {
                setInlineClosingTag(true);
            }
        }
        catch (Exception e)
        {
            log.log(Level.FINE, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
        }
    }
}
