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
 * Reaction Types?
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
public enum ReactionType
{
	/**
	 * Displays a normal message using the System variables messages
	 */
	MessageDisplay,
	/**
	 * Displays a dialogue using the bootstrap dialog
	 */
	DialogDisplay,
	/**
	 * Navigates to a new page
	 */
	RedirectUrl,
	/**
	 * Creates a new window with the URL
	 */
	PopoutUrl,
	/**
	 * Refreshes the current page
	 */
	RefreshPage,
	/**
	 * Signals an event listener on a data component to trigger a data refresh
	 */
	SignalDataTrigger,
	/**
	 * Send the user back home
	 */
	RedirectHome,
}
