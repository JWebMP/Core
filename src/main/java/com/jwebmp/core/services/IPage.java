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
package com.jwebmp.core.services;

import com.jwebmp.core.PageOptions;
import com.jwebmp.core.base.html.DocumentType;
import net.sf.uadetector.ReadableUserAgent;

/**
 * Defines a page for use with IPage
 *
 * @author GedMarc
 * @since Nov 21, 2016
 */
public interface IPage<J extends IPage<J>>
{
	/**
	 * Returns the document type that will be rendered with this HTML page real-time
	 * <p>
	 *
	 * @return Document Type
	 */
	@SuppressWarnings("unused")
	DocumentType getDocumentType();

	/**
	 * Returns the fields available for entry on this page
	 *
	 * @return The Page Fields object
	 */
	PageOptions getOptions();


	/**
	 * If the page is currently in mobile or smart tablet
	 *
	 * @return If the page is mobile or smart tablet
	 */
	boolean isMobileOrSmartTablet();

	/**
	 * Renders the pages HTML
	 *
	 * @param renderHtml
	 * 		If to render the html, just a place holder, must always render
	 *
	 * @return The output HTML for this page
	 */
	String toString(boolean renderHtml);

	/**
	 * Sets the readable user agent to identify browser and device
	 *
	 * @param agent
	 * 		The new agent to read from
	 *
	 * @return This object
	 */
	J setUserAgent(ReadableUserAgent agent);
}
