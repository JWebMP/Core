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
package za.co.mmagon.jwebswing.components.d3;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;

/**
 * References for all the graphing Java Scripts
 * <p>
 * @author Marc Magon
 * @since 08 Aug 2015
 * @version 1.0
 */
public enum D3JavascriptReferencePool
{

    /**
     * The basic core for the graphing system
     */
    D3DrawingLibrary(new JavascriptReference("d3", 3.55, "bower_components/d3/d3.js", "https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.js")),;
    private final JavascriptReference reference;

    private D3JavascriptReferencePool(JavascriptReference reference)
    {
        this.reference = reference;

    }

    public JavascriptReference getReference()
    {
        return reference;
    }

}
