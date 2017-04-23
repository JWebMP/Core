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
package za.co.mmagon.jwebswing.base.ajax;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A JSON Class for component updates
 */
public class AjaxComponentUpdates extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The stored HTML
     */
    @JsonProperty("html")
    private String html;
    /**
     * An assigned ID for a component action
     */
    @JsonProperty("id")
    private String id;
    /**
     * The type for an action, defaulted to Replace
     */
    @JsonProperty("insertType")
    private AjaxComponentInsertType insertType;

    /**
     * Constructs an update class from a given component
     *
     * @param component
     */
    public AjaxComponentUpdates(ComponentHierarchyBase component)
    {
        component.setTiny(true);
        this.html = component.toString(true);
        this.id = component.getID();
        this.insertType = AjaxComponentInsertType.Replace;
    }

    /**
     * Returns the HTML of the component
     *
     * @return
     */
    public String getHtml()
    {
        return html;
    }

    /**
     * Returns which component ID is getting replaced
     *
     * @return
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets the type of insert that should occur on component ID
     *
     * @return
     */
    public AjaxComponentInsertType getInsertType()
    {
        return insertType;
    }

    /**
     * Sets the type of insert that should occur on component ID
     *
     * @param insertType
     */
    public void setInsertType(AjaxComponentInsertType insertType)
    {
        this.insertType = insertType;
    }

    /**
     * Sets the HTML
     *
     * @param html
     */
    public void setHtml(String html)
    {
        this.html = html;
    }

    /**
     * Sets the ID being used for the insert type
     *
     * @param id
     */
    public void setId(String id)
    {
        this.id = id;
    }

}
