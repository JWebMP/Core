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
package za.co.mmagon.jwebswing.components.radialsvgslider;

import za.co.mmagon.jwebswing.base.html.List;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListChildren;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.padding.PaddingCSS;

/**
 * The data attributes for the radial
 *
 * @author GedMarc
 * @since Oct 24, 2016
 * @version 1.0
 *
 */
@PaddingCSS(PaddingLeft = @MeasurementCSS(0))
public class RadialSVGSliderList extends List<ListChildren, RadialSVGSliderListAttributes, RadialSVGSliderEvents, RadialSVGSliderList> implements RadialSVGSliderChildren
{

    private static final long serialVersionUID = 1L;

    public RadialSVGSliderList()
    {

    }
}
