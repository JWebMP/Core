/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.TableColumnAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.TableColumnGroupChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import lombok.extern.java.Log;

import java.util.logging.Level;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;col&gt; tag specifies column properties for each column within a colgroup element.<p>
 * <p>
 * The &lt;col&gt; tag is useful for applying styles to entire columns, instead of repeating the styles for each cell, for each row.<p>
 * <p>
 * Browser Support Element &lt;col&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Most of the attributes in HTML 4.01 are not supported in HTML5. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML the &lt;col&gt; tag has no end tag.<p>
 * <p>
 * In XHTML, the &lt;col&gt; tag must be properly closed.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @since 2014/12/20
 */
@Log
public class TableColumn<J extends TableColumn<J>>
		extends Component<IComponentHierarchyBase<?,?>, TableColumnAttributes, GlobalFeatures, GlobalEvents, J>
		implements TableColumnGroupChildren
{
	/**
	 * Constructs a new table column
	 */
	public TableColumn()
	{
		super(ComponentTypes.TableColumn);
	}

	/**
	 * Differences Between HTML and XHTML
	 * <p>
	 * In HTML the base tag has no end tag.
	 * <p>
	 * In XHTML the base tag must be properly closed.
	 */
	@Override
	public void preConfigure()
	{
		super.preConfigure();
		try
		{
			if (getPage().getHtmlVersion()
			             .name()
			             .startsWith("X"))
			{
				setInlineClosingTag(true);
			}
		}
		catch (Exception e)
		{
			TableColumn.log.log(Level.FINE, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
		}
	}

}
