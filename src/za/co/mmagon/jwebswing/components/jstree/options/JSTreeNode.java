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
package za.co.mmagon.jwebswing.components.jstree.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 22 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeNode extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The ID of the node
     */
    private String id;
    /**
     * The text to display for the node
     */
    private String text;
    /**
     * The type for the node
     */
    @JsonProperty("type")
    private String typeName;

    public JSTreeNode()
    {

    }

    /**
     * The ID of the node
     *
     * @return
     */
    public String getId()
    {
        return id;
    }

    /**
     * The ID of the node
     *
     * @param id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * The text to display for the node
     *
     * @return
     */
    public String getText()
    {
        return text;
    }

    /**
     * The text to display for the node
     *
     * @param text
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * The type name associated with the node
     *
     * @return
     */
    public String getTypeName()
    {
        return typeName;
    }

    /**
     * The type name associated with the node
     *
     * @param typeName
     */
    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.text);
        hash = 89 * hash + Objects.hashCode(this.typeName);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final JSTreeNode other = (JSTreeNode) obj;
        if (!Objects.equals(this.text, other.text))
        {
            return false;
        }
        if (!Objects.equals(this.typeName, other.typeName))
        {
            return false;
        }
        return true;
    }

}
