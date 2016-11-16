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
package za.co.mmagon.jwebswing.components.jqPlot.references;

import za.co.mmagon.jwebswing.base.references.CSSReference;

/**
 * References for all the graphing Java Scripts
 * <p>
 * @author Marc Magon
 * @since 08 Aug 2015
 * @version 1.0
 */
public enum JQPlotCSSReferencePool
{

    GraphCore(new CSSReference("jqPlot", 1.08, "javascript/jquery.plot/jquery.jqplot.css", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.8/jquery.jqplot.css"));

    private final CSSReference reference;

    private JQPlotCSSReferencePool(CSSReference reference)
    {
        this.reference = reference;

    }

    public CSSReference getReference()
    {
        return reference;
    }

}
