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

import za.co.mmagon.jwebswing.base.references.JavascriptReference;

/**
 * References for all the graphing Java Scripts
 * <p>
 * @author Marc Magon
 * @since 08 Aug 2015
 * @version 1.0
 */
public enum C3JavascriptReferencePool
{

    /**
     * The basic core for the graphing system
     */
    C3GraphCore(new JavascriptReference("C3", 0.410, "bower_components/c3/c3.js", "https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.js", 15)), /**
     * If the ie is less than version 9 this is required
     */
    //ExCanvas(new JavascriptReference("excanvas", 0.410, "javascript/jquery.plot/excanvas.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/excanvas.js", 16)),;
    ;
    private final JavascriptReference reference;

    private C3JavascriptReferencePool(JavascriptReference reference)
    {
        this.reference = reference;

    }

    public JavascriptReference getReference()
    {
        return reference;
    }

}
