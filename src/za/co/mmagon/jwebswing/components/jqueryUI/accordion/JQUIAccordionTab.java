/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryUI.accordion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.HeaderText;
import za.co.mmagon.jwebswing.base.html.attributes.HeaderTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * An Accordion Tab.
 * <p>
 * Split out from inner to class to object
 *
 * @author GedMarc
 * @since 22 Feb 2016
 */
public class JQUIAccordionTab extends JavaScriptPart implements JQUIAccordionChildren
{

    /**
     * The header for the accordion
     */
    @JsonIgnore
    private HeaderText header;
    /**
     * The component to display in the accordion
     */
    @JsonIgnore
    private Div component;

    /**
     * Constructs a new accordion tab
     * <p>
     * @param header    The header to use
     * @param component The component to use
     */
    public JQUIAccordionTab(HeaderText header, Div component)
    {
        this.header = header;
        this.component = component;
    }

    /**
     * Constructs a new accordion tab
     * <p>
     * @param header    The header to use
     * @param component The component to use
     */
    public JQUIAccordionTab(String header, Div component)
    {
        this.header = new HeaderText(HeaderTypes.H3, header);
        this.component = component;
    }

    /**
     * Returns the header of this tab
     * <p>
     * @return
     */
    public HeaderText getHeader()
    {
        return header;
    }

    /**
     * Sets the header of this tab
     * <p>
     * @param header
     */
    public void setHeader(HeaderText header)
    {
        this.header = header;
    }

    /**
     * Gets the component of this tab
     * <p>
     * @return
     */
    public Div getComponent()
    {
        return component;
    }

    /**
     * Sets the component of this tab
     * <p>
     * @param component
     */
    public void setComponent(Div component)
    {
        this.component = component;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + (this.header != null ? this.header.hashCode() : 0);
        hash = 31 * hash + (this.component != null ? this.component.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final JQUIAccordionTab other = (JQUIAccordionTab) obj;
        if (this.header != other.header && (this.header == null || !this.header.equals(other.header)))
        {
            return false;
        }
        return !(this.component != other.component && (this.component == null || !this.component.equals(other.component)));
    }

}
