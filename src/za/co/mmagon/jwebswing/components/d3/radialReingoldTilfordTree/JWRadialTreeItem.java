/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.d3.radialReingoldTilfordTree;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * A unique item in the radial tree
 * <p>
 * @author Marc Magon
 * @since 30 Aug 2015
 * @version 1.0
 */
public class JWRadialTreeItem extends JavaScriptPart
{

    private String name;
    private ArrayList<JWRadialTreeItem> children;

    public JWRadialTreeItem()
    {
        this("");
    }

    /**
     * Sets a header with a children item
     * <p>
     * @param name
     */
    public JWRadialTreeItem(String name)
    {
        this.name = name;
    }

    /**
     * Returns the items name
     * <p>
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the items name
     * <p>
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the tree's children items
     * <p>
     * @return
     */
    public ArrayList<JWRadialTreeItem> getChildren()
    {
        if (children == null)
        {
            children = new ArrayList<>();
        }
        return children;
    }

    /**
     * Sets this items children
     * <p>
     * @param children
     */
    public void setChildren(ArrayList<JWRadialTreeItem> children)
    {
        this.children = children;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.JSON;
    }

    public JWRadialTreeItem add(String item)
    {
        JWRadialTreeItem newItem = new JWRadialTreeItem(name);
        getChildren().add(newItem);
        return newItem;
    }

    public JWRadialTreeItem add(JWRadialTreeItem item)
    {
        getChildren().add(item);
        return item;
    }

}
