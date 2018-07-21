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
package com.jwebmp.core.base.html.interfaces;

/**
 * Defines the general interface for components that is allowed on most components
 *
 * @author MMagon
 * @version 1.0
 * @since 2014/10/26
 */

public interface GlobalChildren
{
	void init();

	void preConfigure();

	boolean isConfigured();

	boolean isInitialized();

	void destroy();
}
