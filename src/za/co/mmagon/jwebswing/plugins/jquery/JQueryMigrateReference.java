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
 *
 * @author MMagon
 * <p>
 * I have moved these from the features to make it easier to specify remote or local references.
 * @version 1.0
 * @since 2014/12/09
 */
public class JQueryMigrateReference extends JavascriptReference
{

	private static final long serialVersionUID = 1L;

	public JQueryMigrateReference()
	{
		super("JQueryMigrate", 1.21, "bower_components/jquery-migrate/jquery-migrate.min.js", "http://code.jquery.com/jquery-migrate-1.4.1.js");
		setSortOrder(2);
		setPriority(RequirementsPriority.Second);
	}

}
