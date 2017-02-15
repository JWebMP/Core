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
package za.co.mmagon.jwebswing.utilities;

import java.util.*;

/**
 * Utilities for Enumerations
 *
 * @author GedMarc
 * @since 28 Apr 2016
 */
public class EnumerationUtils
{
    public static final EnumerationNameSorter enumNameSorter = new EnumerationNameSorter();
    
    /**
     * Instance only construction
     */
    private EnumerationUtils()
    {
        //No construction
    }

    
    /**
     * A sorter for an enumeration name by name
     */
    public static class EnumerationNameSorter implements Comparator<Enum>
    {

        @Override
        public int compare(Enum o1, Enum o2)
        {
            return o1.name().compareTo(o2.name());
        }

    }
}
