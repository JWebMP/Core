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
package za.co.mmagon.jwebswing.base.servlets.enumarations;

/**
 * To prioritize sorted references into groups, very good for loading
 *
 * @author GedMarc
 * @since 16 Apr 2016
 */
public enum RequirementsPriority implements Comparable<RequirementsPriority>
{
    /**
     * Loads it at the top (in the head)
     */
    Top_Shelf,
    /**
     * Run in First Group
     */
    First,
    /**
     * Run in Second Group
     */
    Second,
    /**
     * Run in Third Group
     */
    Third,
    /**
     * Run in Fourth Group
     */
    Fourth,
    /**
     * Run in Fifth Group
     */
    Fifth,
    /**
     * Somewhere in the middle, sorted, but who cares
     */
    DontCare,
    /**
     * Somewhere after the don't care section
     */
    Last,
    /**
     * The very last section. Usually at the end of the page, before or at the scripts section of body
     */
    VeryLast,
    /**
     * After all the dynamic scripts, just before body close tag
     */
    StoneLast;

    private RequirementsPriority()
    {
    }

}
