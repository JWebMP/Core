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
package za.co.mmagon.jwebswing.components.d3.reingoldTilfordTree;

import za.co.mmagon.jwebswing.components.d3.radialReingoldTilfordTree.JWRadialTreeItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * The JavaScript part for the radial Reingold-Tilford tree
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWReingoldTilfordTreeOptions extends JavaScriptPart
{

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;
    /**
     * The diameter
     */
    private Integer diameter;
    /**
     * The root node of the tree
     */
    private JWRadialTreeItem data;
    private Integer marginLeft;
    private Integer marginRight;
    private Integer marginTop;
    private Integer marginBottom;
    /**
     * The animation speed
     */
    private Integer animationSpeed;
    /**
     * The maximum amount of degrees
     */
    private Integer maximumDegrees;

    private JWReingoldTilfordTreeNodeOptions nodeMarker;
    private JWReingoldTilfordTreeNodeOptions nodeWithChildrenMarker;
    private JWReingoldTilfordTreeNodeOptions nodeEnterMarker;
    private JWReingoldTilfordTreeNodeOptions nodeExitMarker;
    private JWReingoldTilfordTreeTextOptions nodeText;
    private JWReingoldTilfordTreeTextOptions nodeEnterText;
    private JWReingoldTilfordTreeTextOptions nodeExitText;
    private JWReingoldTilfordTreeLinkOptions nodeLink;
    private JWReingoldTilfordTreeLinkOptions nodeEnterLink;
    private JWReingoldTilfordTreeLinkOptions nodeExitLink;

    public JWReingoldTilfordTreeOptions()
    {

    }

    /**
     * Get the diameter of the tree
     * <p>
     * @return
     */
    public Integer getDiameter()
    {
        return diameter;
    }

    /**
     * Set the diameter of the tree
     * <p>
     * @param diameter
     */
    public void setDiameter(Integer diameter)
    {
        this.diameter = diameter;
    }

    /**
     * Gets the root node with all the children.
     * Never null for data
     * <p>
     * @return
     */
    public JWRadialTreeItem getData()
    {
        if (data == null)
        {
            data = new JWRadialTreeItem();
        }
        return data;
    }

    /**
     * Sets the data associated with this tree
     * <p>
     * @param data
     */
    public void setData(JWRadialTreeItem data)
    {
        this.data = data;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

    /**
     * Gets the left margin specified
     * <p>
     * @return
     */
    public Integer getMarginLeft()
    {
        return marginLeft;
    }

    /**
     * Sets the left margin
     * <p>
     * @param marginLeft
     */
    public void setMarginLeft(Integer marginLeft)
    {
        this.marginLeft = marginLeft;
    }

    /**
     * Gets the right margin
     * <p>
     * @return
     */
    public Integer getMarginRight()
    {
        return marginRight;
    }

    /**
     * Sets the right margin
     * <p>
     * @param marginRight
     */
    public void setMarginRight(Integer marginRight)
    {
        this.marginRight = marginRight;
    }

    /**
     * Gets the margin top
     * <p>
     * @return
     */
    public Integer getMarginTop()
    {
        return marginTop;
    }

    /**
     * Sets the margin top
     * <p>
     * @param marginTop
     */
    public void setMarginTop(Integer marginTop)
    {
        this.marginTop = marginTop;
    }

    /**
     * Gets the margin bottom
     * <p>
     * @return
     */
    public Integer getMarginBottom()
    {
        return marginBottom;
    }

    /**
     * Sets the margin bottom
     * <p>
     * @param marginBottom
     */
    public void setMarginBottom(Integer marginBottom)
    {
        this.marginBottom = marginBottom;
    }

    /**
     * Gets the animation speed
     * <p>
     * @return
     */
    public Integer getAnimationSpeed()
    {
        return animationSpeed;
    }

    /**
     * Sets the animation speed
     * <p>
     * @param animationSpeed
     */
    public void setAnimationSpeed(Integer animationSpeed)
    {
        this.animationSpeed = animationSpeed;
    }

    /**
     * Return the available amount of degrees to render in
     * <p>
     * @return
     */
    public Integer getMaximumDegrees()
    {
        return maximumDegrees;
    }

    /**
     * Sets the maximum amount of degrees to render in
     * <p>
     * @param maximumDegrees
     */
    public void setMaximumDegrees(Integer maximumDegrees)
    {
        this.maximumDegrees = maximumDegrees;
    }

    public JWReingoldTilfordTreeNodeOptions getNodeMarker()
    {
        if (nodeMarker == null)
        {
            nodeMarker = new JWReingoldTilfordTreeNodeOptions();
        }
        return nodeMarker;
    }

    public void setNodeMarker(JWReingoldTilfordTreeNodeOptions nodeMarker)
    {
        this.nodeMarker = nodeMarker;
    }

    public JWReingoldTilfordTreeNodeOptions getNodeWithChildrenMarker()
    {
        if (nodeWithChildrenMarker == null)
        {
            nodeWithChildrenMarker = new JWReingoldTilfordTreeNodeOptions();
        }
        return nodeWithChildrenMarker;
    }

    public void setNodeWithChildrenMarker(JWReingoldTilfordTreeNodeOptions nodeWithChildrenMarker)
    {
        this.nodeWithChildrenMarker = nodeWithChildrenMarker;
    }

    public JWReingoldTilfordTreeNodeOptions getNodeEnterMarker()
    {
        if (nodeEnterMarker == null)
        {
            nodeEnterMarker = new JWReingoldTilfordTreeNodeOptions();
        }
        return nodeEnterMarker;
    }

    public void setNodeEnterMarker(JWReingoldTilfordTreeNodeOptions nodeEnterMarker)
    {
        this.nodeEnterMarker = nodeEnterMarker;
    }

    public JWReingoldTilfordTreeNodeOptions getNodeExitMarker()
    {
        if (nodeExitMarker == null)
        {
            nodeExitMarker = new JWReingoldTilfordTreeNodeOptions();
        }
        return nodeExitMarker;
    }

    public void setNodeExitMarker(JWReingoldTilfordTreeNodeOptions nodeExitMarker)
    {
        this.nodeExitMarker = nodeExitMarker;
    }

    public JWReingoldTilfordTreeTextOptions getNodeText()
    {
        if (nodeText == null)
        {
            nodeText = new JWReingoldTilfordTreeTextOptions();
        }
        return nodeText;
    }

    public void setNodeText(JWReingoldTilfordTreeTextOptions nodeText)
    {
        this.nodeText = nodeText;
    }

    public JWReingoldTilfordTreeTextOptions getNodeEnterText()
    {
        if (nodeEnterText == null)
        {
            nodeEnterText = new JWReingoldTilfordTreeTextOptions();
        }
        return nodeEnterText;
    }

    public void setNodeEnterText(JWReingoldTilfordTreeTextOptions nodeEnterText)
    {
        this.nodeEnterText = nodeEnterText;
    }

    public JWReingoldTilfordTreeTextOptions getNodeExitText()
    {
        if (nodeExitText == null)
        {
            nodeExitText = new JWReingoldTilfordTreeTextOptions();
        }
        return nodeExitText;
    }

    public void setNodeExitText(JWReingoldTilfordTreeTextOptions nodeExitText)
    {
        this.nodeExitText = nodeExitText;
    }

    public JWReingoldTilfordTreeLinkOptions getNodeLink()
    {
        if (nodeLink == null)
        {
            nodeLink = new JWReingoldTilfordTreeLinkOptions();
        }
        return nodeLink;
    }

    public void setNodeLink(JWReingoldTilfordTreeLinkOptions nodeLink)
    {
        this.nodeLink = nodeLink;
    }

    public JWReingoldTilfordTreeLinkOptions getNodeEnterLink()
    {
        if (nodeEnterLink == null)
        {
            nodeEnterLink = new JWReingoldTilfordTreeLinkOptions();
        }
        return nodeEnterLink;
    }

    public void setNodeEnterLink(JWReingoldTilfordTreeLinkOptions nodeEnterLink)
    {
        this.nodeEnterLink = nodeEnterLink;
    }

    public JWReingoldTilfordTreeLinkOptions getNodeExitLink()
    {
        if (nodeExitLink == null)
        {
            nodeExitLink = new JWReingoldTilfordTreeLinkOptions();
        }
        return nodeExitLink;
    }

    public void setNodeExitLink(JWReingoldTilfordTreeLinkOptions nodeExitLink)
    {
        this.nodeExitLink = nodeExitLink;
    }

}
