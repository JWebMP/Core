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
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.NoClassAttribute;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import lombok.extern.java.Log;

import java.util.logging.Level;

/**
 * Definition and Usage
 * <p>
 * The &lt;hr&gt; tag defines a thematic break in an HTML page (e.g. a shift of topic)
 * .<p>
 * <p>
 * The &lt;hr&gt; element is used to separate content (or define a change) in an HTML page. Browser Support Element<p>
 * &lt;hr&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * In HTML5, the &lt;hr&gt; tag defines a thematic break.<p>
 * <p>
 * In HTML 4.01, the &lt;hr&gt; tag represents a horizontal rule.<p>
 * <p>
 * However, the &lt;hr&gt; tag may still be displayed as a horizontal rule in visual browsers, but is now defined in semantic terms, rather
 * than presentational terms.<p>
 * <p>
 * All the layout attributes are removed in HTML5. Use CSS instead. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML, the &lt;hr&gt; tag has no end tag.<p>
 * <p>
 * In XHTML, the &lt;hr&gt; tag must be properly closed.<p>
 * <p>
 *
 * @param <J>
 * @author GedMarc
 */
@Log
public class HorizontalRule<J extends HorizontalRule<J>>
        extends Component<IComponentHierarchyBase<?, ?>, NoAttributes, NoFeatures, NoEvents, J>
        implements NoIDTag, NoClassAttribute
{
    private static final HorizontalRule hr = new HorizontalRule();


    public HorizontalRule()
    {
        super("hr", ComponentTypes.HorizontalRule);
        setInlineClosingTag(true);
    }

    /**
     * Return the Horizontal Rule Instance
     *
     * @return
     */
    public static HorizontalRule<?> getInstance()
    {
        return HorizontalRule.hr;
    }

    /**
     * Return a new instance of the Horizontal Rule
     *
     * @return
     */
    public static HorizontalRule<?> getNewInstance()
    {
        return new HorizontalRule<>();
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return false;
    }

    /**
     * Differences Between HTML and XHTML
     * <p>
     * In HTML the base tag has no end tag.
     * <p>
     * In XHTML the base tag must be properly closed.
     */
    @Override
    protected void preConfigure()
    {
        super.preConfigure();
        try
        {
            if (getPage().getBrowser()
                         .getHtmlVersion()
                         .name()
                         .startsWith("X"))
            {
                setInlineClosingTag(true);
            }
        }
        catch (Exception e)
        {
            HorizontalRule.log.log(Level.FINE, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
        }
    }
}
