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

import java.util.*;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;

/**
 *
 * @author GedMarc
 * @param <J> Returns this class
 * @since Sep 26, 2016
 * 
 */
public interface IComponentStyleBase<J extends ComponentBase> 
{

    /**
     * Adds a CSS object to the component with the given type
     *
     * @param cssItem
     */
    void addCSSEntry(CSSTypes type,CSSImpl cssItem);

    /**
     * Gets the active CSS
     *
     * @return
     */
    CSSImpl getActiveCss();

    /**
     * Gets the CSS Object used for styling
     *
     * @return
     */
    CSSImpl getCss();

    /**
     * Returns the currently assigned CSS Name
     *
     * @return
     */
    String getCssName();

    /**
     * Returns the current HashMap of all CSS Entries for the component
     *
     * @return
     */
    HashMap<CSSTypes, CSSImpl> getCssTypeHashMap();

    /**
     * Gets the hover format CSS
     *
     * @return
     */
    CSSImpl getHoverCss();

    /**
     * Gets the link CSS
     *
     * @return
     */
    CSSImpl getLinkCss();

    /**
     * Gets the Visited CSS
     *
     * @return
     */
    CSSImpl getVisitedCss();

    /**
     * Removes a CSS item for the component
     *
     * @param cssType
     */
    void removeCSSEntry(CSSTypes cssType);

    /**
     * Renders the component CSS at the specified tab count with the
     * &lt;style&gt; tag
     * <p>
     * @param tabCount Tab indentation for the SQL
     * <p>
     * @return The Component CSS
     */
    StringBuilder renderCss(int tabCount);

    /**
     * Renders the component CSS at the specified tab count with the
     * &lt;style&gt; tag This includes everything from this classes CSS, to the
     * CSS for each field. It will also populate the lower level
     * child CSS for fields in this class
     * <p>
     * @param tabCount           Tab indentation for the SQL
     * @param renderOpening      Whether or not to render the opening XML tag
     *                           for a CSS style
     * @param renderInQuotations Sets whether to render the CSS Fields in
     *                           Quotations
     * @param isAjaxCall         Sets whether the CSS is being called from an
     *                           AJAX call
     * <p>
     * @return The Component CSS
     */
    StringBuilder renderCss(int tabCount, boolean renderOpening, boolean renderInQuotations, boolean isAjaxCall);

    /**
     * Sets the active CSS
     *
     * @param activeCss
     */
    void setActiveCss(CSSImpl activeCss);

    /**
     * Sets the CSS Object used for styling
     *
     * @param css
     */
    void setCss(CSSImpl css);

    /**
     * Sets the currently assigned CSS Name
     *
     * @param cssName
     */
    void setCssName(String cssName);

    /**
     * Sets the hover format CSS
     *
     * @param hoverCss
     */
    void setHoverCss(CSSImpl hoverCss);

    /**
     * Updates the ID of all the CSS Objects
     *
     * @param id The ID to update with
     * @return Me
     */
    J setID(String id);

    /**
     * Sets the Link CSS
     *
     * @param linkCss
     */
    void setLinkCss(CSSImpl linkCss);

    /**
     * Sets the Visited CSS
     *
     * @param visitedCss
     */
    void setVisitedCss(CSSImpl visitedCss);

}
