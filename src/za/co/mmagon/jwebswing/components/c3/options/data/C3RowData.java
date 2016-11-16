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
package za.co.mmagon.jwebswing.components.c3.options.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 * An ArrayList of Specific Row Data.
 * Is an ArrayList of type Object
 *
 * @author GedMarc
 * @since 09 Mar 2016
 */
public class C3RowData<D> extends ArrayList<D> implements Comparable<C3RowData>, Comparator<C3RowData>
{

    private static final long serialVersionUID = 1L;
    private C3RowDataType type;

    public C3RowData()
    {
    }

    /**
     * Returns the type for the C3RowData
     *
     * @return
     */
    public C3RowDataType getType()
    {
        return type;
    }

    /**
     * Sets the type for the C3Row Data
     *
     * @param type
     */
    public void setType(C3RowDataType type)
    {
        this.type = type;
    }

    @Override
    public int compareTo(C3RowData o)
    {
        if (this.type == C3RowDataType.Header)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public int compare(C3RowData o1, C3RowData o2)
    {
        if (o1 != null && o2 != null)
        {
            if (o1.getType() == C3RowDataType.Header)
            {
                return -1;
            }
            else
            {
                return 0;
            }

        }

        return 0;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final C3RowData<?> other = (C3RowData<?>) obj;
        if (this.type != other.type)
        {
            return false;
        }
        return true;
    }
    
    

}
