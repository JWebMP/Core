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
 * @author GedMarc
 * @since 22 Apr 2017
 */
public enum AjaxComponentInsertType
{
	Replace,
	Append,
	Prepend,
	Insert,
	Remove,
	Insert_Last("InsertLast");
	/**
	 * Any sub data
	 */
	private String data;

	/**
	 * A new AjaxComponentInsertType
	 */
	AjaxComponentInsertType()
	{

	}

	/**
	 * A new AjaxComponentInsertType with data
	 */
	AjaxComponentInsertType(String data)
	{

	}

	/**
	 * Returns the name or the data contained within
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		if (data != null && !data.isEmpty())
		{
			return data;
		}
		else
		{
			return name();
		}
	}
}
