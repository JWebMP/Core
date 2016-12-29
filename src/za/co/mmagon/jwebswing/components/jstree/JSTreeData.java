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
package za.co.mmagon.jwebswing.components.jstree;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since 22 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeData extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * The list of nodes
     */

    private List<JSTreeNode> nodes;

    /**
     * Constructs a new instance of tree data
     *
     * @throws RuntimeException If tree is null
     */
    public JSTreeData()
    {
    }

    /**
     * Returns all the nodes currently associated with this tree
     *
     * @return
     */
    @JsonRawValue
    @JsonValue
    public List<JSTreeNode> getNodes()
    {
        if (nodes == null)
        {
            setNodes(new ArrayList<>());
        }
        return nodes;
    }

    /**
     * Sets the nodes currently associated with this tree
     *
     * @param nodes
     */
    public void setNodes(List<JSTreeNode> nodes)
    {
        this.nodes = nodes;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.JSON;
    }

    public JSTreeNode findNode(String id)
    {
        JSTreeNode found;
        found = findNode(getNodes(), id);
        return found;
    }

    private JSTreeNode findNode(List<JSTreeNode> nodes, String id)
    {
        JSTreeNode found;
        for (JSTreeNode next : nodes)
        {
            if (next.getId().equals(id))
            {
                return next;
            }
            if ((found = next.getChildNodes().findNode(id)) != null)
            {
                return found;
            }
        }
        return null;
    }
}
