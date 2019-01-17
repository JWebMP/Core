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
package com.jwebmp.core.base.ajax;

/**
 * The list of bootstrap dialogue message types, used globally because its a complete list
 *
 * @author GedMarc
 * @since 09 May 2016
 */
public enum AjaxResponseType
{
	Default("Default"),
	Primary("Primary"),
	Success("Success"),
	Info("Information"),
	Warning("Warning"),
	Danger("Danger");

	private String valueString;

	/**
	 * Constructs with the given value string
	 *
	 * @param valueString
	 */
	AjaxResponseType(String valueString)
	{
		this.valueString = valueString;
	}

	/**
	 * Returns the value string associated with this type
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return valueString;
	}
}
