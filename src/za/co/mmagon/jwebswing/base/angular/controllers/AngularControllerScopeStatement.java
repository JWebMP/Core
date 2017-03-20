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
package za.co.mmagon.jwebswing.base.angular.controllers;

import java.util.Comparator;

/**
 * A StringBuilder that gets inserted into the angular controller with access to $scope
 *
 * @author Marc Magon
 * @since 19 Mar 2017
 */
public abstract class AngularControllerScopeStatement implements Comparator<AngularControllerScopeStatement>
{

    private int sortOrder = 100;

    /*
     * Constructs a new AngularControllerScopeStatement
     */
    public AngularControllerScopeStatement()
    {
        //Nothing needed
    }

    @Override
    public int compare(AngularControllerScopeStatement o1, AngularControllerScopeStatement o2)
    {
        return o1.getSortOrder().compareTo(o2.getSortOrder());
    }

    public abstract StringBuilder getStatement();

    /**
     * Gets the sort order
     *
     * @return
     */
    public Integer getSortOrder()
    {
        return sortOrder;
    }

    /*
     * Sets the sort order
     */
    public void setSortOrder(int sortOrder)
    {
        this.sortOrder = sortOrder;
    }

}
