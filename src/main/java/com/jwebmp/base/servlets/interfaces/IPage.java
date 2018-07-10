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
package com.jwebmp.base.servlets.interfaces;

import com.jwebmp.Page;
import com.jwebmp.PageFields;
import com.jwebmp.PageOptions;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.html.DocumentType;

/**
 * Defines a page for use with IPage
 *
 * @author GedMarc
 * @since Nov 21, 2016
 */
public interface IPage
{

	/**
	 * Adds a variable into angular
	 *
	 * @param variableName
	 *
	 * @return
	 */
	Page addAngularVariable(String variableName);

	/**
	 * Returns the angular object
	 *
	 * @return
	 */
	AngularPageConfigurator getAngular();

	/**
	 * Returns the document type that will be rendered with this HTML page real-time
	 * <p>
	 *
	 * @return Document Type
	 */
	DocumentType getDocumentType();

	/**
	 * Returns the fields available for entry on this page
	 *
	 * @return
	 */
	PageFields getPageFields();

	/**
	 * Returns all the dynamic options for a page
	 *
	 * @return
	 */
	PageOptions getOptions();

	boolean isMobileOrSmartTablet();
}
