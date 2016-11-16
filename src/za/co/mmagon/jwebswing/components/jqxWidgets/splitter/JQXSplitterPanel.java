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
package za.co.mmagon.jwebswing.components.jqxWidgets.splitter;

/**
 * This Class
 *
 * @author GedMarc
 * @since 24 Dec 2015
 */
public class JQXSplitterPanel
{

    private Integer size;// - sets the panel's size.
    private Integer min;// - sets the panel's minimum size.
    private Boolean collapsible;// - sets whether the panel is collapsible.
    private Boolean collapsed;// - sets whether the panel is collapsed.

    public JQXSplitterPanel()
    {
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }

    public Integer getMin()
    {
        return min;
    }

    public void setMin(Integer min)
    {
        this.min = min;
    }

    public Boolean getCollapsible()
    {
        return collapsible;
    }

    public void setCollapsible(Boolean collapsible)
    {
        this.collapsible = collapsible;
    }

    public Boolean getCollapsed()
    {
        return collapsed;
    }

    public void setCollapsed(Boolean collapsed)
    {
        this.collapsed = collapsed;
    }

}
