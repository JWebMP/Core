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

import java.util.logging.Level;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.LinkAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The a tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The a tag defines a hyperlink, which is used to link from one page to another.<p>
 * <p>
 * The most important attribute of the a element is the href attribute, which indicates the link’s destination.<p>
 * <p>
 * By default, links will appear as follows in all browsers:
 * <p>
 * <p>
 * An unvisited link is underlined and blue A visited link is underlined and purple An active link is underlined and red<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: The following attributes: hreflang, media, rel, target, and type cannot be present if the href attribute is not present.<p>
 * <p>
 * Tip: A linked page is normally displayed in the current browser window, unless you specify another target.<p>
 * <p>
 * Tip: Use CSS to style links. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * In HTML 4.01, the a tag could be either a hyperlink or an anchor. In HTML5, the a tag is always a hyperlink, but if it has no href attribute, it is only a placeholder for a hyperlink.<p>
 * <p>
 * HTML5 has some new attributes, and some HTML 4.01 attributes are no longer supported.<p>
 *
 * @author Marc Magon
 * @param <J>
 */
public class Link<J extends Link>
        extends Component<ComponentHierarchyBase, LinkAttributes, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren, NoNewLineForRawText, ListItemChildren
{

    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("ALink");
    private static final long serialVersionUID = 1L;
    /**
     * The address directing to
     */
    private String directToAddress;
    /**
     * The target frame
     */
    private String targetFrameName;

    /**
     * Constructs a new A tag
     */
    public Link()
    {
        super("a", ComponentTypes.Link);
    }

    /**
     * Creates a link directly to the address in the current window
     * <p>
     * @param directToAddress The address to redirect to
     */
    public Link(String directToAddress)
    {
        this(directToAddress, null);
        if (directToAddress == null || directToAddress.isEmpty())
        {
            log.log(Level.FINE, "Invalid Link Address.");
        }
    }

    /**
     * Creates a link directly to the address in the specified target frame
     * <p>
     * @param directToAddress The address to redirect to
     * @param targetFrameName The frame to redirect
     */
    public Link(String directToAddress, String targetFrameName)
    {
        this(directToAddress, targetFrameName, (String) null);
    }

    /**
     * Creates a link directly to the address in the specified target frame
     * <p>
     * @param directToAddress The address to redirect to
     * @param targetFrameName The frame to redirect
     * @param text            Includes raw text in the link
     */
    public Link(String directToAddress, String targetFrameName, String text)
    {
        super("a", ComponentTypes.Link);
        this.directToAddress = directToAddress;
        this.targetFrameName = targetFrameName;
        if (directToAddress != null)
        {
            addAttribute(LinkAttributes.HRef, directToAddress);
        }
        if (targetFrameName != null)
        {
            addAttribute(LinkAttributes.Target, targetFrameName);
        }
        setText(text);
    }

    /**
     * Creates a link directly to the address in the specified target frame
     * <p>
     * @param directToAddress The address to redirect to
     * @param targetFrameName The frame to redirect
     * @param component       Includes raw text in the link
     */
    public Link(String directToAddress, String targetFrameName, ComponentHierarchyBase component)
    {
        super("a", ComponentTypes.Link);
        this.directToAddress = directToAddress;
        this.targetFrameName = targetFrameName;
        if (directToAddress != null)
        {
            addAttribute(LinkAttributes.HRef, directToAddress);
        }
        if (targetFrameName != null)
        {
            addAttribute(LinkAttributes.Target, targetFrameName);
        }
        add(component);
    }

    /**
     * Returns the direct to address
     * <p>
     * @return The address redirecting to
     */
    public String getDirectToAddress()
    {
        return directToAddress;
    }

    /**
     * Sets the address to direct to
     * <p>
     * @param directToAddress
     */
    public void setDirectToAddress(String directToAddress)
    {
        this.directToAddress = directToAddress;
        addAttribute(LinkAttributes.HRef, directToAddress);
    }

    /**
     * Returns the current target frame name
     * <p>
     * @return The current target frame. Can be Null
     */
    public String getTargetFrameName()
    {
        return targetFrameName;
    }

    /**
     * Sets the target frame
     * <p>
     * @param targetFrameName The target frame
     */
    public void setTargetFrameName(String targetFrameName)
    {
        this.targetFrameName = targetFrameName;
        addAttribute(LinkAttributes.Target, targetFrameName);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 53 * hash + (this.directToAddress != null ? this.directToAddress.hashCode() : 0);
        hash = 53 * hash + (this.targetFrameName != null ? this.targetFrameName.hashCode() : 0);
        return hash;
    }

    /**
     * A valid equals
     * <p>
     * @param obj Anything
     *
     * @return True only if the attributes specified are identical
     */
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
        final Link other = (Link) obj;
        if ((this.directToAddress == null) ? (other.directToAddress != null) : !this.directToAddress.equals(other.directToAddress))
        {
            return false;
        }

        return !((this.targetFrameName == null) ? (other.targetFrameName != null) : !this.targetFrameName.equals(other.targetFrameName));
    }
}
