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
 *
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public enum D3ReferencePool
{

    RadialReingoldTilfordTree(new JavascriptReference("radialReingold", 1.0, "javascript/jquery/tree/radialReingoldTilfordTree.js", "javascript/jquery/tree/radialReingoldTilfordTree.js")),
    ReingoldTilfordTree(new JavascriptReference("reingold", 1.0, "javascript/jquery/tree/reingoldTilfordTree.js", "javascript/jquery/tree/reingoldTilfordTree.js")),;

    private final JavascriptReference reference;

    private D3ReferencePool(JavascriptReference reference)
    {
        this.reference = reference;

    }

    /**
     * Returns the reference for this tree
     * <p>
     * @return
     */
    public JavascriptReference getReference()
    {
        return reference;
    }

}
