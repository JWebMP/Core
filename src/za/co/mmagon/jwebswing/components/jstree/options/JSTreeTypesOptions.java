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
import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.components.bootstrap.Glyphicons;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.
 * <p>
 * To set a node's type you can use set_type or supply a type property with the node's data.
 * <p>
 * There are two predefined types:
 * <p>
 * # - represents the root of the tree, for example max_children would control the maximum number of root nodes.
 * <p>
 * default - represents the default node - any settings here
 * <p>
 * will be applied to all nodes that do not have a type specified.
 *
 * @author GedMarc
 * @since 23 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeTypesOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use the default icon
     * from your theme.
     */
    private String icon;

    /**
     * the maximum number of immediate children this node type can have. Do not specify or set to -1 for unlimited.
     */
    @JsonProperty(value = "max_children")
    private Integer maxChildren;
    /**
     * the maximum number of nesting this node type can have. A value of 1 would mean that the node can have children, but no grandchildren. Do not specify or set to -1 for unlimited.
     */
    @JsonProperty(value = "max_depth")
    private Integer maxDepth;
    /**
     * an array of node type strings, that nodes of this type can have as children. Do not specify or set to -1 for no limits.
     */
    @JsonProperty(value = "valid_children")
    private List<String> validChildren;

    /**
     * an object of values which will be used to add HTML attributes on the resulting LI DOM node (merged with the node's own data)
     */
    @JsonProperty("li_atr")
    private String listItemAttributes;
    /**
     * an object of values which will be used to add HTML attributes on the resulting A DOM node (merged with the node's own data)
     */
    @JsonProperty("a_attr")
    private String linkAttributes;

    public JSTreeTypesOptions()
    {

    }

    /**
     * Sets the icon 
     * @param icon 
     */
    public JSTreeTypesOptions(String icon)
    {
        this.icon = icon;
    }
    
    /**
     * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use the default icon
     * from your theme.
     *
     * @return
     */
    public String getIcon()
    {
        return icon;
    }

    /**
     * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use the default icon
     * from your theme.
     *
     * @param icon
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    /**
     * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use the default icon
     * from your theme.
     *
     * @param icon
     */
    public void setIcon(FontAwesomeIcons icon)
    {
        this.icon = icon.toString();
    }

    /**
     * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use the default icon
     * from your theme.
     *
     * @param icon
     */
    public void setIcon(Glyphicons icon)
    {
        this.icon = icon.toString();
    }

    /**
     * the maximum number of immediate children this node type can have. Do not specify or set to -1 for unlimited.
     *
     * @return
     */
    public Integer getMaxChildren()
    {
        return maxChildren;
    }

    /**
     * the maximum number of immediate children this node type can have. Do not specify or set to -1 for unlimited.
     *
     * @param maxChildren
     */
    public void setMaxChildren(Integer maxChildren)
    {
        this.maxChildren = maxChildren;
    }

    /**
     * the maximum number of nesting this node type can have. A value of 1 would mean that the node can have children, but no grandchildren. Do not specify or set to -1 for unlimited.
     *
     * @return
     */
    public Integer getMaxDepth()
    {
        return maxDepth;
    }

    /**
     * the maximum number of nesting this node type can have. A value of 1 would mean that the node can have children, but no grandchildren. Do not specify or set to -1 for unlimited.
     *
     * @param maxDepth
     */
    public void setMaxDepth(Integer maxDepth)
    {
        this.maxDepth = maxDepth;
    }

    /**
     * an array of node type strings, that nodes of this type can have as children. Do not specify or set to -1 for no limits.
     *
     * @return
     */
    public List<String> getValidChildren()
    {
        if (validChildren == null)
        {
            validChildren = new ArrayList<>();
        }
        return validChildren;
    }

    /**
     * an array of node type strings, that nodes of this type can have as children. Do not specify or set to -1 for no limits.
     *
     * @param validChildren
     */
    public void setValidChildren(List<String> validChildren)
    {
        this.validChildren = validChildren;
    }

    /**
     * an object of values which will be used to add HTML attributes on the resulting LI DOM node (merged with the node's own data)
     *
     * @return
     */
    public String getListItemAttributes()
    {
        return listItemAttributes;
    }

    /**
     * an object of values which will be used to add HTML attributes on the resulting LI DOM node (merged with the node's own data)
     *
     * @param listItemAttributes
     */
    public void setListItemAttributes(String listItemAttributes)
    {
        this.listItemAttributes = listItemAttributes;
    }

    /**
     * an object of values which will be used to add HTML attributes on the resulting A DOM node (merged with the node's own data)
     *
     * @return
     */
    public String getLinkAttributes()
    {
        return linkAttributes;
    }

    /**
     * an object of values which will be used to add HTML attributes on the resulting A DOM node (merged with the node's own data)
     *
     * @param linkAttributes
     */
    public void setLinkAttributes(String linkAttributes)
    {
        this.linkAttributes = linkAttributes;
    }

}
