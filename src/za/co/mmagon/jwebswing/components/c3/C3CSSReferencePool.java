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
package za.co.mmagon.jwebswing.components.c3;

import za.co.mmagon.jwebswing.base.references.CSSReference;

/**
 * References for all the graphing Java Scripts
 * <p>
 * @author Marc Magon
 * @since 08 Aug 2015
 * @version 1.0
 */
public enum C3CSSReferencePool
{

    C3GraphCore(new CSSReference("c3Graph", 1.08, "bower_components/c3/c3.css", "https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.css"));

    private final CSSReference reference;

    private C3CSSReferencePool(CSSReference reference)
    {
        this.reference = reference;

    }

    public CSSReference getReference()
    {
        return reference;
    }

}
