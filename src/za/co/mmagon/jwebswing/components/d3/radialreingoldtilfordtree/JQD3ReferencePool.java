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
package za.co.mmagon.jwebswing.components.d3.radialreingoldtilfordtree;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 * Default reference pool structure
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum JQD3ReferencePool implements ReferencePool
{
    RadialReingoldTilfodTree(new JavascriptReference("RadialReingoldTilfordTree", 1.0, "bower_components/jqd3/radial-reingold-tilford-tree/radialReingoldTilfordTree.js"),
            new CSSReference("RadialReingoldTilfordTreeCSS", 4.6, "bower_components/jqd3/radial-reingold-tilford-tree/radialReingoldTilfordTree.css")),
    ReingoldTilfodTree(new JavascriptReference("ReingoldTilfordTree", 1.0, "bower_components/jqd3/reingold-tilford-tree/reingoldTilfordTree.js"),
            new CSSReference("ReingoldTilfordTreeCSS", 4.6, "bower_components/jqd3/reingold-tilford-tree/reingoldTilfordTree.css")),;

    ;
    private JQD3ReferencePool()
    {
    }

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private JQD3ReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
    {
        this.cssReference = cssReference;
        this.cssReference.setPriority(RequirementsPriority.First);
    }

    @Override
    public JavascriptReference getJavaScriptReference()
    {
        return javaScriptReference;
    }

    @Override
    public void setJavaScriptReference(JavascriptReference javaScriptReference)
    {
        this.javaScriptReference = javaScriptReference;
    }

    @Override
    public CSSReference getCssReference()
    {
        return cssReference;
    }

    @Override
    public void setCssReference(CSSReference cssReference)
    {
        this.cssReference = cssReference;
    }
}
