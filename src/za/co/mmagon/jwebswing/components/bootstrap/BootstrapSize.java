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
package za.co.mmagon.jwebswing.components.bootstrap;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A Size setting
 *
 * @author GedMarc
 * @since Oct 30, 2016
 * @version 1.0
 *
 */
public enum BootstrapSize
{
    /**
     *
     * Extra large devices (large desktops, 1200px and up)
     */
    ExtraLarge("lg", 1200),
    /**
     * Large devices (desktops, 992px and up)
     */
    Large("lg", 992),
    /**
     * Medium devices (tablets, 768px and up)
     */
    Medium("md", 768),
    /**
     * Small devices (landscape phones, 544px and up)
     */
    Small("sm", 544),
    /**
     * Starting at the bottom
     */
    XSmall("xs", 0);

    private String name;
    private Integer size;

    private BootstrapSize()
    {

    }

    private BootstrapSize(String name)
    {
        this.name = name;
    }

    private BootstrapSize(String name, Integer size)
    {
        this.name = name;
        this.size = size;
    }

    @JsonValue
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * The actual pixel size setting
     *
     * @return
     */
    public Integer getSize()
    {
        return size;
    }

    /**
     * The actual pixel size setting
     *
     * @param size
     */
    public void setSize(Integer size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
