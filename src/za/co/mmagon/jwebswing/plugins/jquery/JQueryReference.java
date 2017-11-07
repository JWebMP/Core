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
package za.co.mmagon.jwebswing.plugins.jquery;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 * The JQuery JavaScript Reference
 * <p>
 *
 * @author MMagon
 * <p>
 * I have moved these from the features to make it easier to specify remote or local references.
 * <p>
 * @version 1.0
 * @since 2014/12/09
 */
class JQueryReference extends JavascriptReference
{
	
	private static final long serialVersionUID = 1L;
	
	public JQueryReference()
	{
		super("JQuery3.0", 3.0, "bower_components/jquery/dist/jquery.min.js", "https://code.jquery.com/jquery-3.0.0.min.js");
		setSortOrder(0);
		setPriority(RequirementsPriority.Second);
	}
}
