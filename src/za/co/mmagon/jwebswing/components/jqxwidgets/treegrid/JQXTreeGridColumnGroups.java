/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxwidgets.treegrid;

/**
 * This Class
 *
 * @author GedMarc
 * @since 25 Dec 2015
 */
public class JQXTreeGridColumnGroups
{

    /**
     * string property which determines the parent group's name.
     */
    private String parentGroup;
    /**
     * string property which determines the group's name.
     */
    private String name;
    /**
     * string property which determines the column header's alignment. Possible values: 'left', 'center' or 'right'.
     */
    private String align;

    public JQXTreeGridColumnGroups()
    {
    }

    public String getParentGroup()
    {
        return parentGroup;
    }

    public void setParentGroup(String parentGroup)
    {
        this.parentGroup = parentGroup;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAlign()
    {
        return align;
    }

    public void setAlign(String align)
    {
        this.align = align;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}
