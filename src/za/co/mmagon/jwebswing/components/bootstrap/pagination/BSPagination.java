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
package za.co.mmagon.jwebswing.components.bootstrap.pagination;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;

/**
 * Pagination
 * <p>
 * Pagination links indicate a series of related content exists across multiple pages. Typically these are used where a multi-page approach to long lists of content improves general performance, such
 * as in search results or inboxes.
 * <p>
 * @author Marc Magon
 * @since 17 Jan 2017
 * @version 1.0
 */
public class BSPagination extends Div<BSPaginationChildren, BSPaginationAttributes, BSPaginationFeatures, BSPaginationEvents, BSPagination>
{

    private static final long serialVersionUID = 1L;
    /**
     * The associated feature
     */
    private BSPaginationFeature feature;

    /**
     * The actual list for the pagination
     */
    private BSPaginationList pageList;

    /**
     * Pagination
     * <p>
     * Pagination links indicate a series of related content exists across multiple pages. Typically these are used where a multi-page approach to long lists of content improves general performance,
     * such as in search results or inboxes.
     * <p>
     */
    public BSPagination()
    {
        setTag("nav");
        addAttribute(GlobalAttributes.Aria_Label, "bootstrap pagination");
    }

    /**
     * Pagination
     * <p>
     * Pagination links indicate a series of related content exists across multiple pages. Typically these are used where a multi-page approach to long lists of content improves general performance,
     * such as in search results or inboxes.
     *
     * @param sizing Fancy larger or smaller pagination? Add .pagination-lg or .pagination-sm for additional sizes.
     */
    public BSPagination(BSComponentPaginationSizingOptions sizing)
    {
        this();
        getPageList().addClass(sizing);
    }

    /**
     * Pagination
     * <p>
     * Pagination links indicate a series of related content exists across multiple pages. Typically these are used where a multi-page approach to long lists of content improves general performance,
     * such as in search results or inboxes.
     *
     * @param alignment Change the alignment of pagination components with flexbox utilities.
     */
    public BSPagination(BSComponentPaginationAlignmentOptions alignment)
    {
        this();
        getPageList().addClass(alignment);
    }

    /**
     * Pagination
     * <p>
     * Pagination links indicate a series of related content exists across multiple pages. Typically these are used where a multi-page approach to long lists of content improves general performance,
     * such as in search results or inboxes.
     *
     * @param alignment Change the alignment of pagination components with flexbox utilities.
     * @param sizing    Fancy larger or smaller pagination? Add .pagination-lg or .pagination-sm for additional sizes.
     */
    public BSPagination(BSComponentPaginationSizingOptions sizing, BSComponentPaginationAlignmentOptions alignment)
    {
        this();
        getPageList().addClass(sizing);
        getPageList().addClass(alignment);
    }

    /**
     * Returns the feature if any is required
     *
     * @return
     */
    public final BSPaginationFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSPaginationFeature(this);
        }
        return feature;
    }

    /**
     * Returns the options if any is required
     *
     * @return
     */
    @Override
    public BSPaginationOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Creates a new pagination button link.
     * <p>
     * Use .getParent() to access the list item object
     *
     * @param ariaLabel
     *
     * @return
     */
    public BSPaginationLink createPageLink(String ariaLabel)
    {
        BSPageinationListItem listItem = new BSPageinationListItem();
        BSPaginationLink newLink = new BSPaginationLink(ariaLabel);

        listItem.add(newLink);
        getPageList().add(listItem);
        return newLink;

    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {

        }
        super.preConfigure();
    }

    /**
     * The actual list for the pagination
     *
     * @return
     */
    public final BSPaginationList getPageList()
    {
        if (this.pageList == null)
        {
            setPageList(new BSPaginationList());
        }
        return pageList;
    }

    /**
     * The actual list for the pagination
     *
     * @param pageList
     */
    public void setPageList(BSPaginationList pageList)
    {
        if (this.pageList != null)
        {
            getChildren().remove(this.pageList);
        }
        this.pageList = pageList;
        if (this.pageList != null)
        {
            add(this.pageList);
        }
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
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }

}
