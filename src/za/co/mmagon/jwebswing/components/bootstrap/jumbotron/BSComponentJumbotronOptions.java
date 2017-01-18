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
package za.co.mmagon.jwebswing.components.bootstrap.jumbotron;

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Jumbotron
 * <p>
 * A lightweight, flexible component that can optionally extend the entire viewport to showcase key marketing messages on your site.
 *
 * @author GedMarc
 */
public enum BSComponentJumbotronOptions implements IBSComponentOptions
{
    /**
     * Jumbotron
     * <p>
     * A lightweight, flexible component that can optionally extend the entire viewport to showcase key marketing messages on your site.
     */
    Jumbotron,
    /**
     * To make the jumbotron full width, and without rounded corners, add the .jumbotron-fluid modifier class and add a .container or .container-fluid within.
     */
    Jumbotron_fluid,
    /**
     * Large display format 1
     */
    Display_1,
    /**
     * Large display format 2
     */
    Display_2,
    /**
     * Large display format 3
     */
    Display_3,
    /**
     * Large display format 4
     */
    Display_4,
    /**
     * applies a lead if necessary
     */
    Lead,
    /**
     * Horizontal rule
     */
    My_1,
    /**
     * Horizontal rule
     */
    My_2,
    /**
     * Horizontal rule
     */
    My_3,
    /**
     * Horizontal rule
     */
    My_4;

    private BSComponentJumbotronOptions()
    {

    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
