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
package com.jwebmp.base.html;

import com.jwebmp.Component;
import com.jwebmp.base.html.attributes.NoAttributes;
import com.jwebmp.base.html.interfaces.NoFeatures;
import com.jwebmp.base.html.interfaces.children.DataListChildren;
import com.jwebmp.base.html.interfaces.events.NoEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;datalist&gt; tag specifies a list of pre-defined options for an input element.
 * <p>
 * The &lt;datalist&gt; tag is used to provide an "autocomplete" feature on input elements.
 * <p>
 * Users will see a drop-down list of pre-defined options as they input data.
 * <p>
 * Use the &lt;input&gt; element's list attribute to bind it together with a &lt;datalist&gt; element. Browser Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element &lt;datalist&gt; 20.0 10.0 4.0 Not supported 9.0
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;datalist&gt; tag is new in HTML5.
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @since 2014/12/21
 */
public class DataList<J extends DataList<J>>
		extends Component<DataListChildren, NoAttributes, NoFeatures, NoEvents, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new DataList with the given.
	 * <p>
	 *
	 * @param id
	 * 		The ID of the data list to be linked with the Input Tag
	 */
	public DataList(String id)
	{
		super(ComponentTypes.DataList);
		setID(id);
	}
}
