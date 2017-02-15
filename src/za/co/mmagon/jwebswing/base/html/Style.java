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

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.StyleAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoClassAttribute;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * The Style Tag
 * <p>
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer FireFox Opera Google Chrome Safari<p>
 * <p>
 * The style tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The style tag is used to define style information for an HTML document.<p>
 * <p>
 * Inside the style element you specify how HTML elements should render in a<p>
 * browser.<p>
 * <p>
 * Each HTML document can contain multiple style tags.<p>
 * <p>
 * <p>
 * @param <J>
 *
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class Style<J extends Style>
        extends ComponentHierarchyBase<NoChildren, StyleAttributes, NoFeatures, NoEvents, J>
        implements NoIDTag, HeadChildren, NoClassAttribute
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new blank Style tag
     */
    public Style()
    {
        super(ComponentTypes.Style);
        addAttribute(StyleAttributes.Type, "text/css");
    }

    /**
     * Sets the raw CSS Data
     * <p>
     * @param cssString
     */
    public void setCSS(String cssString)
    {
        setText(cssString);
    }

    /**
     * Returns the raw CSS Data
     * <p>
     * @return
     */
    public String getCSS()
    {
        return getText(0).toString();
    }

}
