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
package com.jwebmp.core;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * A list of page options available to the page
 *
 * @author GedMarc
 * @since Nov 21, 2016
 */
public class PageOptions
		extends JavaScriptPart
{


	/**
	 * Whether or not to dynamic render the requirements
	 */
	private boolean dynamicRender = true;

	/**
	 * If the scripts should be rendered in the head section (like for cordova rendering)
	 */
	private boolean scriptsInHead;
	/**
	 * The local storage
	 */
	private boolean localStorage;

	/**
	 * Construct directly with the page
	 */
	protected PageOptions()
	{
		//No config required
	}

	/**
	 * Whether or not to dynamic render the requirements
	 *
	 * @return
	 */
	public boolean isDynamicRender()
	{
		return dynamicRender;
	}

	/**
	 * Whether or not to dynamic render the requirements
	 *
	 * @param dynamicRender
	 */
	public void setDynamicRender(boolean dynamicRender)
	{
		this.dynamicRender = dynamicRender;
	}

	/**
	 * Whether or not to place the scripts in the head
	 *
	 * @return
	 */
	public boolean isScriptsInHead()
	{
		return scriptsInHead;
	}

	/**
	 * Sets if scripts must be rendered in the head
	 *
	 * @param scriptsInHead
	 */
	public void setScriptsInHead(boolean scriptsInHead)
	{
		this.scriptsInHead = scriptsInHead;
	}

	/**
	 * If this page should be rendered with dynamic local storage support
	 *
	 * @return
	 */
	public boolean isLocalStorage()
	{
		return localStorage;
	}

	/**
	 * If the page should be rendered with dynamic local storage support. This renders a default page that is then fetched from the server to support cordova applications
	 *
	 * @param localStorage
	 */
	public void setLocalStorage(boolean localStorage)
	{
		this.localStorage = localStorage;
	}
}
