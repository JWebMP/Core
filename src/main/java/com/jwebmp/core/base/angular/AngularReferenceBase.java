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
package com.jwebmp.core.base.angular;

import com.jwebmp.core.htmlbuilder.javascript.JavascriptLiteralFunction;

import javax.validation.constraints.NotNull;

/**
 * Is an angular module
 *
 * @author GedMarc
 * @since 24 Jul 2016
 */
public abstract class AngularReferenceBase
		extends JavascriptLiteralFunction
{


	/**
	 * The name of this module
	 */
	private String referenceName;

	/**
	 * Constructs a module with this name that always sorts default
	 *
	 * @param referenceName
	 * 		This references name
	 */
	public AngularReferenceBase(@NotNull String referenceName)
	{
		this.referenceName = referenceName;
	}

	/**
	 * Returns this modules name
	 *
	 * @return This module name
	 */
	@NotNull
	public String getReferenceName()
	{
		return referenceName;
	}

	/**
	 * Sets this modules name
	 *
	 * @param referenceName
	 * 		Sets this reference name
	 */
	public void setReferenceName(String referenceName)
	{
		this.referenceName = referenceName;
	}

	/**
	 * Hash code identifier
	 *
	 * @return The integer
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Equals based on sort order and name
	 *
	 * @param obj
	 * 		object
	 *
	 * @return The assigned object
	 */
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	@Override
	public StringBuilder getLiteralFunction()
	{
		return new StringBuilder();
	}

	/**
	 * Overwrite the render function
	 *
	 * @return
	 */
	@Override
	public abstract String renderFunction();
}
