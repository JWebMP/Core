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
package za.co.mmagon.jwebswing.components.jqueryLayout.layout;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQLayoutOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private String name;
    private JQLayoutDefaultOptions defaults;
    private JQLayoutDefaultOptions west;
    private JQLayoutDefaultOptions north;
    private JQLayoutDefaultOptions east;
    private JQLayoutDefaultOptions south;
    private JQLayoutDefaultOptions center;

    /**
     * A blank options canvas
     */
    public JQLayoutOptions()
    {

    }

    /**
     * Gets the name of this layout
     * <p>
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this layout
     * <p>
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the default options for each layout
     * <p>
     * @return
     */
    public JQLayoutDefaultOptions getDefaults()
    {
        if (defaults == null)
        {
            defaults = new JQLayoutDefaultOptions();
        }
        defaults.setOnResize("$.layout.callbacks.resizeJQuery");
        return defaults;
    }

    /**
     * Returns the west options pane
     * <p>
     * @return
     */
    public JQLayoutDefaultOptions getWest()
    {
        if (west == null)
        {
            west = new JQLayoutDefaultOptions();
        }
        getDefaults().setOnResize("$.layout.callbacks.resizeJQuery");
        return west;
    }

    /**
     * Sets the west option pane
     * <p>
     * @param west
     */
    public void setWest(JQLayoutDefaultOptions west)
    {
        this.west = west;
    }

    /**
     * Returns the north options pane
     * <p>
     * @return
     */
    public JQLayoutDefaultOptions getNorth()
    {
        if (north == null)
        {
            north = new JQLayoutDefaultOptions();
        }
        getDefaults().setOnResize("$.layout.callbacks.resizeJQuery");
        return north;
    }

    /**
     * Sets the north options
     * <p>
     * @param north
     */
    public void setNorth(JQLayoutDefaultOptions north)
    {
        this.north = north;
    }

    /**
     * Returning the east
     * <p>
     * @return
     */
    public JQLayoutDefaultOptions getEast()
    {
        if (east == null)
        {
            east = new JQLayoutDefaultOptions();
        }
        getDefaults().setOnResize("$.layout.callbacks.resizeJQuery");
        return east;
    }

    /**
     * Sets the east
     * <p>
     * @param east
     */
    public void setEast(JQLayoutDefaultOptions east)
    {
        this.east = east;
    }

    /**
     * Returns the south
     * <p>
     * @return
     */
    public JQLayoutDefaultOptions getSouth()
    {
        if (south == null)
        {
            south = new JQLayoutDefaultOptions();
        }
        getDefaults().setOnResize("$.layout.callbacks.resizeJQuery");
        return south;
    }

    /**
     * Sets the south
     * <p>
     * @param south
     */
    public void setSouth(JQLayoutDefaultOptions south)
    {
        this.south = south;
    }

    /**
     * Returns the center
     * <p>
     * @return
     */
    public JQLayoutDefaultOptions getCenter()
    {
        if (center == null)
        {
            center = new JQLayoutDefaultOptions();
        }
        getDefaults().setOnResize("$.layout.callbacks.resizeJQuery");
        return center;
    }

    /**
     * Sets the center
     * <p>
     * @param center
     */
    public void setCenter(JQLayoutDefaultOptions center)
    {
        this.center = center;
    }

}
