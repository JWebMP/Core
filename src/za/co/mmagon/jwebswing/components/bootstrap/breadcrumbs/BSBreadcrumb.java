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
package za.co.mmagon.jwebswing.components.bootstrap.breadcrumbs;

import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.ListItem;

/**
 * A particular crumb
 *
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public class BSBreadcrumb extends ListItem implements BSBreadcrumbsChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * The actual link for the crumb
     */
    private Link crumbLink;

    /**
     * Constructs a particular crumb
     */
    public BSBreadcrumb()
    {
        addClass(BSComponentBreadcrumbOptions.Breadcrumb_Item);
    }

    /**
     * Construct with a link and text to show
     *
     * @param crumbLink
     */
    public BSBreadcrumb(Link crumbLink)
    {
        this();
        this.crumbLink = crumbLink;
    }

    /**
     * Returns the crumb link, never null
     *
     * @return
     */
    public Link getCrumbLink()
    {
        if (crumbLink == null)
        {
            setCrumbLink(new Link("#"));
        }
        return crumbLink;
    }

    /**
     * Sets the given crumb link
     *
     * @param crumbLink
     */
    public void setCrumbLink(Link crumbLink)
    {
        if (this.crumbLink != null)
        {
            remove(this.crumbLink);
            this.crumbLink = null;
        }
        this.crumbLink = crumbLink;
        if (this.crumbLink != null)
        {
            add(this.crumbLink);
        }
    }
}
