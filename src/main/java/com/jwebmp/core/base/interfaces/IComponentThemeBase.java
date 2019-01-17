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
package com.jwebmp.core.base.interfaces;

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.htmlbuilder.css.themes.Theme;

import java.util.Set;

/**
 * @author GedMarc
 * @since Sep 26, 2016
 */
public interface IComponentThemeBase
{

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	Set<CSSReference> getCssReferencesAll();

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	Set<JavascriptReference> getJavascriptReferencesAll();

	/**
	 * Returns the parents theme or the applied theme
	 * <p>
	 *
	 * @return The theme
	 */
	Set<Theme> getThemes();

}
