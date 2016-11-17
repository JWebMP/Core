/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jquerylayout.layout;

import java.util.List;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.HeaderText;

/**
 *
 * @author GedMarc
 * @since Oct 30, 2016
 * @version 1.0
 *
 */
public interface IJQLayoutDiv
{
    /**
     * Adds the open event to a component
     * <p>
     * @param button The component to add the open event to
     */
    void addToggleButton(Component button);
            
    /**
     * Adds the close event to the component
     * <p>
     * @param button The button to add a close event to
     */
    void addCloseButton(Component button);

    /**
     * Adds the footer to the component
     * <p>
     * @param footerDiv
     */
    void addFooter(Component footerDiv);

    /**
     * Adds the footer
     * <p>
     * @param footerDivString
     */
    void addFooter(String footerDivString);

    /**
     * Adds the footer header
     * <p>
     * @param footerDivString
     */
    void addFooter(HeaderText footerDivString);

    /**
     * Adds the Div as a header and applies the class Widget Header
     * <p>
     * @param headerDiv
     */
    void addHeader(Div headerDiv);

    /**
     * Adds the header to the layout div
     * <p>
     * @param headerDivString
     */
    void addHeader(HeaderText headerDivString);

    /**
     * Adds the open event to a component
     * <p>
     * @param button The component to add the open event to
     */
    void addOpenButton(Component button);

    /**
     * Adds a Pin for this Div
     * <p>
     * @param component
     * @return The Span
     */
    Component addPin(Component component);

    /**
     * Sets the current assigned area
     * <p>
     * @param area
     */
    void setArea(JQLayoutArea area);

    /**
     * Returns the current content div
     * <p>
     * @return
     */
    Div getContentDiv();

    /**
     * Returns the footers listing
     *
     * @return
     */
    List<Component> getFooters();

    /**
     * Returns the layout attached to this layout div
     * <p>
     * @return
     */
    JQLayout getLayout();

    /**
     * Sets the layout for this div
     * <p>
     * @param layout
     */
    void setLayout(JQLayout layout);

    //    @Override
    JQLayoutDefaultOptions getOptions();

    /**
     * Removes the footer
     * <p>
     * @param footerDiv
     */
    void removeFooter(Div footerDiv);

    /**
     * Removes the header
     * <p>
     * @param headerDiv
     */
    void removeHeader(Div headerDiv);
    
}
