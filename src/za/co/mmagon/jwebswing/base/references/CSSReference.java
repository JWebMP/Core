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
package za.co.mmagon.jwebswing.base.references;

import za.co.mmagon.jwebswing.generics.WebReference;

/**
 * This class is a CSS Reference
 *
 *
 * @since 2014/12/09
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class CSSReference extends WebReference<CSSReference>
{

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new CSS File Reference
     * <p>
     * @param name            The name of the reference
     * @param version         The version of the reference
     * @param localReference  The local reference
     * @param remoteReference The remote reference
     * @param sortOrder       The sort order for the reference
     */
    public CSSReference(String name, Double version, String localReference, String remoteReference, int sortOrder)
    {
        super(name, version, localReference, remoteReference, sortOrder);
    }

    /**
     * Construct a new CSS File Reference
     * <p>
     * @param name            The name of the reference
     * @param version         The version of the reference
     * @param localReference  The local reference
     * @param remoteReference The remote reference
     */
    public CSSReference(String name, Double version, String localReference, String remoteReference)
    {
        super(name, version, localReference, remoteReference);
    }

    /**
     * Construct a new CSS File Reference
     * <p>
     * @param name           The name of the reference
     * @param version        The version of the reference
     * @param localReference The local reference
     */
    public CSSReference(String name, Double version, String localReference)
    {
        super(name, version, localReference, localReference);
    }

    /**
     * Construct a new CSS File Reference
     * <p>
     * @param name           The name of the reference
     * @param version        The version of the reference
     * @param localReference The local reference
     * @param sortOrder      The sort order for the reference
     */
    public CSSReference(String name, Double version, String localReference, int sortOrder)
    {
        super(name, version, localReference, localReference, sortOrder);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof CSSReference)
        {
            if (o.toString().equals(toString()))
            {
                return true;
            }
            return getName().equalsIgnoreCase(CSSReference.class.cast(o).getName());
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        return hash;
    }

}
