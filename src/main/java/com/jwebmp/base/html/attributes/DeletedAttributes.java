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
package com.jwebmp.base.html.attributes;

import com.jwebmp.base.html.interfaces.AttributeDefinitions;

/**
 * @author GedMarc
 */
public enum DeletedAttributes
		implements AttributeDefinitions
{

	/**
	 * Specifies a URL to a document that explains the reason why the text was deleted
	 */
	Cite,
	/**
	 * Specifies the date and time of when the text was deleted
	 * <p>
	 * YYYY-MM-DDThh:mm:ssTZD
	 */
	DateTime;

	@Override
	public boolean isKeyword()
	{
		return false;
	}
}