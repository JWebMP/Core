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
package za.co.mmagon.jwebswing.components.jqxwidgets.tree;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.JQXDataAdapter;

/**
 * The JQX Tree Source Data Adapter
 *
 * @author GedMarc
 * @since 30 Jan 2016
 */
public class JQXTreeSourceDataAdapter extends JQXDataAdapter<JQXTreeItem>
{

    public JQXTreeSourceDataAdapter(Component componentAddingTo)
    {
        super(componentAddingTo);
    }

    @Override
    public String toString()
    {
        return "";
    }
}
