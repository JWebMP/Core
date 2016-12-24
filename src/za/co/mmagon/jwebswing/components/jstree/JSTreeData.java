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

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import za.co.mmagon.JWebSwingSiteBinder;
import za.co.mmagon.jwebswing.components.jstree.options.functions.JSTreeCoreDataFunction;
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
     * The actual tree
     */
    @JsonIgnore
    private JSTree tree;

    /**
     * Constructs a new instance of tree data
     *
     * @param tree
     *
     * @throws RuntimeException If tree is null
     */
    public JSTreeData(JSTree tree)
    {
        this.tree = tree;
        if (tree == null)
        {
            throw new RuntimeException("Missing the tree for the JSTreeData");
        }
        tree.getOptions().getCore().getData().setUrl(JWebSwingSiteBinder.getDataLocation().replace("/", "") + "?component=" + tree.getID());
        tree.getOptions().getCore().getData().setData(new JSTreeCoreDataFunction());
        //tree.getOptions().getCore().getData().setCache(false);
        //tree.getOptions().getCore().getData().setDataType("json");
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

    /**
     * Returns the tree associated with this
     *
     * @return
     */
    public JSTree getTree()
    {
        return tree;
    }

    /**
     * Sets the tree associated with this (but rather do it at construction, you never know)
     *
     * @param tree
     */
    public void setTree(JSTree tree)
    {
        this.tree = tree;
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
        for (Iterator<JSTreeNode> iterator = nodes.iterator(); iterator.hasNext();)
        {
            JSTreeNode next = iterator.next();
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
