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
package com.jwebmp.core.plugins.jquery;

import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;

/**
 * @since @version @author MMagon
 */
public enum JQueryReferencePool
{
	PersistJS(new JavascriptReference("PersistJS", 1.0, "persist-js/persist-all-min.js", -10).setPriority(RequirementsPriority.Top_Shelf)),

	JQuery(new JQueryReference()),
	JQueryV2(new JavascriptReference("JQuery", 3.31, "bower_components/jquery/dist/jquery.min.js", "https://code.jquery.com/jquery-3.3.1.js").setPriority(
			RequirementsPriority.First)),

	JQueryV3(new JavascriptReference("Jquery3", 3.31, "bower_components/jquery/dist/jquery.min.js", "https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js", 0,
	                                 RequirementsPriority.First).setCordovaRequired(true)),

	JQueryMigrate(new JQueryMigrateReference()),

	JQXWidgetFixes(new JavascriptReference("JQXWidgetFix", 1.0, "javascript/jwebswing/jqxfixes.js", 8));

	/*
	 * JQueryCrossDomain(new JQueryCrossDomainReference()), JQueryMigrate(new JQueryMigrateReference()), JQueryCookieHandler(new JQueryCookieHandlerReference()),
	 *
	 * JQueryRightClickHandler(new JQueryRightClickHandlerReference()), JQueryScrollBars(new JWDataTablesJavaScriptReference()),
	 *
	 */

	private final JavascriptReference reference;

	JQueryReferencePool(JavascriptReference reference)
	{
		this.reference = reference;
	}

	public JavascriptReference getJavaScriptReference()
	{
		return reference;
	}

}
