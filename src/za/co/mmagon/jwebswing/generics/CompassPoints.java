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
package za.co.mmagon.jwebswing.generics;

/**
 * Specifies all the 8 point Compass Points
 * 
 * @since 2014/05/16
 * @version 1.0
 * @author MMagon
 *  
 * History : Previously Resize Handler Points
 * 
 */

public enum CompassPoints 
{
    /**
     * North
     */
    N, 
    /**
     * East
     */
    E, 
    /**
     * South
     */
    S, 
    /**
     * West
     */
    W, 
    /**
     * North-East
     */
    NE, 
    /**
     * South-East
     */
    SE, 
    /**
     * South West
     */
    SW, 
    /**
     * North West
     */
    NW, 
    /**
     * All Handles
     */
    ALL;
    
    /**
     * Returns the name of this Resize Handler
     * @return Lowercase Name
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
        
    }
}
