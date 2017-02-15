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
package za.co.mmagon.jwebswing.base.html.sorters;

import java.util.Comparator;
import za.co.mmagon.jwebswing.base.html.TableCaption;
import za.co.mmagon.jwebswing.base.html.TableColumnGroup;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableChildren;

/**
 * Sorts the table children properly
 * <p>
 * First caption, then Table Column Groups then headers body then footer
 * <p>
 * @author GedMarc
 */
public class TableChildrenSorter implements Comparator<TableChildren>
{

    @Override
    public synchronized final int compare(TableChildren o1, TableChildren o2)
    {
        if (o1 instanceof TableCaption)
        {
            return -1;
        }
        else if (o1 instanceof TableColumnGroup)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
