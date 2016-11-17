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
package za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter;

import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.options.JQXDataAdapterOptions;
import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.options.JQXDataAdapterSourceData;

/**
 *
 * @author GedMarc
 * @param <A>
 * @since Nov 4, 2016
 * @version 1.0
 *
 */
public interface IJQXDataAdapter<A extends JQXDataAdapterSourceData>
{

    /**
     * Returns the JS feature for this data adapter
     * @return
     */
    JQXDataAdapterFeature getFeature();

    /**
     * Returns all the options associated with the given feature
     * @return
     */
    JQXDataAdapterOptions<A> getOptions();

    /**
     * Renders the given JavaScript for the given component
     * @return
     */
    StringBuilder renderJavascript();
    
}
