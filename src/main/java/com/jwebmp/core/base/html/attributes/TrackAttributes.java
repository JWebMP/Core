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
package com.jwebmp.core.base.html.attributes;

import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;

/**
 * @author GedMarc
 * @version 1.0
 * @since Mar 1, 2015
 */
public enum TrackAttributes
		implements AttributeDefinitions
{

	/**
	 * Sets or returns the default state of the track
	 */
	Default,
	/**
	 * Sets or returns the value of the kind attribute of the track
	 */
	Kind,
	/**
	 * Sets or returns the value of the label attribute of the track
	 */
	Label,
	/**
	 * Returns the current state of the track resource
	 */
	ReadyState,
	/**
	 * Sets or returns the value of the src attribute of the track
	 */
	Src,
	/**
	 * Sets or returns the value of the srclang attribute of the track
	 */
	Srclang,
	/**
	 * Returns a TextTrack object representing the track element's text track data
	 */
	Track;

	@Override
	public boolean isKeyword()
	{
		return false;
	}
	
	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
