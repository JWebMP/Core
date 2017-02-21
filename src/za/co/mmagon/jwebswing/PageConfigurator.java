/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Allows plugin components to register themselves as page configuration objects, and apply custom logic to when they are used
 *
 * @author GedMarc
 * @since 13 Feb 2017
 *
 */
public abstract class PageConfigurator implements Comparator<PageConfigurator>, Serializable
{

    private static final long serialVersionUID = 1L;
    /**
     * The loading sort order for this page configurator. Default 100;
     */
    private int sortOrder = 100;

    /**
     * Method that is called during the page configuration setup
     *
     * @param page
     *
     * @return
     */
    public abstract Page configure(Page page);

    /**
     * Returns the default sort order
     *
     * @return
     */
    public Integer getSortOrder()
    {
        return sortOrder;
    }

    /**
     * Sets the default sort order
     *
     * @param sortOrder
     */
    public void setSortOrder(int sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(PageConfigurator o1, PageConfigurator o2)
    {
        return o1.getSortOrder().compareTo(o2.getSortOrder());
    }

}
