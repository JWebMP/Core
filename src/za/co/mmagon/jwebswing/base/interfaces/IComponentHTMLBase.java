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
package za.co.mmagon.jwebswing.base.interfaces;

import za.co.mmagon.jwebswing.base.ComponentBase;

/**
 *
 * @author GedMarc
 * @param <J> This Type
 * @since Sep 26, 2016
 * 
 */
public interface IComponentHTMLBase<J extends ComponentBase> 
{

    /**
     * Returns this tag
     * <p>
     * @return The tag this component will render
     */
    String getTag();

    /**
     * Whether or not this component should render a closing tag
     * <p>
     * @return
     */
    boolean isClosingTag();

    /**
     * If a new line for the closing tag is required.
     * Also sets new line for raw text to false
     *
     * @return
     */
    boolean isNewLineForClosingTag();

    /**
     * Sets if there must be a new line before the raw text starts
     *
     * @return
     */
    boolean isNewLineForRawText();

    /**
     * Whether or not this component should render a closing tag
     * <p>
     * @param noCloseTag Whether or not to render the closing tag
     * @return This Class
     */
    J setClosingTag(boolean noCloseTag);

    /**
     * Sets the number of tab indents for this component
     *
     * @param currentTabIndents
     * @return This Class
     */
    J setCurrentTabIndents(int currentTabIndents);

    /**
     * If a new line for the closing tag is required.
     * Also sets new line for raw text to false
     *
     * @param newLineForClosingTag
     */
    void setNewLineForClosingTag(boolean newLineForClosingTag);

    /**
     * Sets if this component must place a new line before the raw text
     *
     * @param newLineForRawText
     * @return This Class
     */
    J setNewLineForRawText(boolean newLineForRawText);

    /**
     * Overrides this tag name
     * <p>
     * @param tag The tag to use instead of the default
     * @return This Class
     */
    J setTag(String tag);

    /**
     * Returns the HTML for the given object
     * <p>
     * @param outputHtml Dummy holder for specifying HTML output
     * <p>
     * @return The class and the associated ID and children count
     */
    String toString(boolean outputHtml);

    /**
     * Returns this components HTML after configuration and pre-rendering
     *
     * @param tabCount The number of tabs to indent by
     * @return
     */
    String toString(Integer tabCount);

}
