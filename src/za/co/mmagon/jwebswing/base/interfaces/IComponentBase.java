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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import za.co.mmagon.jwebswing.base.ComponentBase;

/**
 * Neater way of accessing the component methods
 *
 * @author GedMarc
 * @param <J> Always this component
 *
 * @since 2016/09/26
 */
public interface IComponentBase<J extends ComponentBase> extends Cloneable, Serializable
{

    /**
     * Clones this component and assigns a new ID
     * <p>
     * @return The cloned component
     */
    J cloneComponent();

    /**
     * Gets the ID of this component
     * <p>
     * @return The ID of this component
     */
    String getID();

    /**
     * Returns the ID with the # in the front of it
     * <p>
     * @param jQueryHolder Anything
     * <p>
     * @return An ID starting with #
     */
    String getID(boolean jQueryHolder);

    /**
     * Returns the component rendering for JQuery string Requires the rendering for component is set
     * <p>
     * @return $('#x').
     */
    String getJQueryID();

    /**
     * Returns the new line character according to Running Environment
     * <p>
     * @return A new line if is in development mode
     */
    String getNewLine();

    /**
     * Returns a map of user defined properties for this component
     *
     * @return
     */
    Map<String, Object> getProperties();

    /**
     * returns a new StringSuilder of the raw text with the specific tab counts
     * <p>
     * @param tabCounts <p>
     * @return
     */
    StringBuilder getText(int tabCounts);

    /**
     * If this component is already configured
     *
     * @return
     */
    boolean isConfigured();

    /**
     * Specifies whether or not to render this component in a Production/QA fashion
     * <p>
     * @return If this component will render in production mode
     */
    boolean isTiny();

    /**
     * Run-Once on creation Executes a piece of code before running any rendering. Marks the component as configured
     */
    void preConfigure();

    /**
     * If this component is already configured
     *
     * @param configured
     *
     * @return
     */
    J setConfigured(boolean configured);

    /**
     * Sets the ID of this component
     * <p>
     * @param id The ID
     *
     * @return
     */
    J setID(String id);

    /**
     * Sets this components user defined properties
     *
     * @param properties
     *
     * @return
     */
    J setProperties(HashMap<String, Object> properties);

    /**
     * Sets this components Raw Text
     * <p>
     * @param text The text to display as Raw Text
     *
     * @return
     */
    J setText(String text);

    /**
     * Sets this components Raw Text
     * <p>
     * @param text The text to display as Raw Text
     *
     * @return
     */
    J setText(StringBuilder text);

    /**
     * If this component will render as tiny HTML. Global override value
     * <p>
     * @param tiny Set if this component must render as tiny HTML. Does not affect CSS or JavaScript rendering
     *
     * @return
     */
    J setTiny(boolean tiny);

    /**
     * Returns if this component is needing refresh on next Ajax call
     * <p>
     * @return true if going to be touched
     */
    boolean isTouched();

    /**
     * Mark this component as needing refresh to the Ajax Controller
     * <p>
     * @param touched Whether or not to update on next ajax call
     *
     * @return
     */
    J setTouched(boolean touched);

}
