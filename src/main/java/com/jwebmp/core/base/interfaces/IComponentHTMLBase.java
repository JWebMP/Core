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
package com.jwebmp.core.base.interfaces;

import com.jwebmp.core.base.ComponentBase;

import javax.validation.constraints.NotNull;

/**
 * @param <J>
 * 		This Type
 *
 * @author GedMarc
 * @since Sep 26, 2016
 */
@SuppressWarnings({"UnusedReturnValue", "MissingClassJavaDoc"})
public interface IComponentHTMLBase<J extends ComponentBase>
{

	/**
	 * Returns this tag
	 * <p>
	 *
	 * @return The tag this component will render
	 */
	String getTag();

	/**
	 * Whether or not this component should render a closing tag
	 *
	 * @return if this tag has a closing tag
	 */
	Boolean isClosingTag();

	/**
	 * If a new line for the closing tag is required.
	 *
	 * @return If a new line is required
	 */
	Boolean isNewLineForClosingTag();

	/**
	 * If a new line for the closing tag is required.
	 *
	 * @param newLineForClosingTag
	 * 		A new line is required for this objects closing tag
	 *
	 * @return Always this object
	 */
	J setNewLineForClosingTag(boolean newLineForClosingTag);

	/**
	 * Sets if there must be a new line before the raw text starts
	 *
	 * @return If newline for raw text must be generated
	 */
	@SuppressWarnings("unused")
	Boolean isNewLineForRawText();

	/**
	 * Whether or not this component should render a closing tag
	 *
	 * @param noCloseTag
	 * 		Whether or not to render the closing tag
	 *
	 * @return Always this object
	 */
	J setClosingTag(boolean noCloseTag);

	/**
	 * Sets the number of tab indents for this component
	 *
	 * @param currentTabIndents
	 * 		the tab indentation count
	 *
	 * @return Always this object
	 */
	J setCurrentTabIndents(int currentTabIndents);

	/**
	 * Sets if this component must place a new line before the raw text
	 *
	 * @param newLineForRawText
	 * 		If there should be a new line for raw text
	 *
	 * @return Always this object
	 */
	@NotNull
	J setNewLineForRawText(boolean newLineForRawText);

	/**
	 * Overrides this tag name
	 * <p>
	 *
	 * @param tag
	 * 		The tag to use instead of the default
	 *
	 * @return This Class
	 */
	J setTag(String tag);

	/**
	 * Returns the HTML for the given object
	 * <p>
	 *
	 * @param outputHtml
	 * 		Dummy holder for specifying HTML output
	 *
	 * @return The class and the associated ID and children count
	 */
	String toString(boolean outputHtml);

	/**
	 * Returns this components HTML after configuration and pre-rendering
	 *
	 * @param tabCount
	 * 		The number of tabs to indent by
	 *
	 * @return The sting with the given tab counts
	 */
	String toString(Integer tabCount);

}
