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
package com.jwebmp.core.base.angular.modules;

import com.jwebmp.core.base.angular.services.IAngularModule;

/**
 * Is an angular module
 *
 * @author GedMarc
 * @since 24 Jul 2016
 */
public class AngularMessagesModule
		extends AngularModuleBase
		implements IAngularModule<AngularMessagesModule>
{

	/**
	 * Field serialVersionUID
	 */

	/**
	 * Field messsgesModuleEnabled
	 */
	private static boolean messsgesModuleEnabled = false;

	/**
	 * Constructs a module with this name that always sorts default
	 */
	public AngularMessagesModule()
	{
		super("ngMessages");
	}

	/**
	 * Method isMesssgesModuleEnabled returns the messsgesModuleEnabled of this AngularMessagesModule object.
	 * <p>
	 * Field messsgesModuleEnabled
	 *
	 * @return the messsgesModuleEnabled (type boolean) of this AngularMessagesModule object.
	 */
	public static boolean isMesssgesModuleEnabled()
	{
		return AngularMessagesModule.messsgesModuleEnabled;
	}

	/**
	 * Method setMesssgesModuleEnabled sets the messsgesModuleEnabled of this AngularMessagesModule object.
	 * <p>
	 * Field messsgesModuleEnabled
	 *
	 * @param messsgesModuleEnabled
	 * 		the messsgesModuleEnabled of this AngularMessagesModule object.
	 */
	public static void setMesssgesModuleEnabled(boolean messsgesModuleEnabled)
	{
		AngularMessagesModule.messsgesModuleEnabled = messsgesModuleEnabled;
	}

	/**
	 * Overwrite the render function
	 *
	 * @return Null
	 *
	 * @see com.jwebmp.core.base.angular.AngularReferenceBase#renderFunction()
	 */
	@Override
	public String renderFunction()
	{
		return null;
	}

	/**
	 * If this module is enabled by default
	 *
	 * @return if the module is enabled
	 *
	 * @see com.jwebmp.core.base.angular.services.IAngularModule#enabled()
	 */
	@Override
	public boolean enabled()
	{
		return AngularMessagesModule.messsgesModuleEnabled;
	}
}
