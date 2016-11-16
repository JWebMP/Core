/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryUI.autocomplete;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqueryUI.position.Position;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUIAutoCompleteOptions extends JavaScriptPart
{

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;

    /**
     * The available category selections
     */
    private ArrayList<AutoCompleteEntries> source;

    private Boolean autoFocus;
    private Integer delay;
    private Boolean disabled;
    private Integer minLength;
    private Position position;

    /**
     * Constructs a new Auto Complete Options Array
     * <p>
     */
    public JQUIAutoCompleteOptions()
    {

    }

    /**
     * Adds a label option that is grouped into a category
     *
     * @param label
     * @param category
     */
    public AutoCompleteEntries addOption(String label, String category)
    {
        return addOption(label, label, category);
    }

    /**
     * Adds a label only option
     *
     * @param label
     */
    public AutoCompleteEntries addOption(String label)
    {
        return addOption(label, null, null);
    }

    /**
     * Adds a label with a value and category
     *
     * @param label
     */
    public AutoCompleteEntries addOption(String label, String value, String category)
    {
        AutoCompleteEntries entry = new AutoCompleteEntries(label, value, category);
        getSource().add(entry);
        return entry;
    }

    /**
     * Returns the base source items
     *
     * @return
     */
    public ArrayList<AutoCompleteEntries> getSource()
    {
        if (source == null)
        {
            source = new ArrayList<>();
        }
        return source;
    }

    /**
     * Gets whether the first item should be highlighted on open
     *
     * @return
     */
    public Boolean getAutoFocus()
    {
        return autoFocus;
    }

    /**
     * Sets if the first item should be highlighted on opening
     *
     * @param autoFocus
     */
    public void setAutoFocus(Boolean autoFocus)
    {
        this.autoFocus = autoFocus;
    }

    /**
     * Gets the delay to open
     *
     * @return
     */
    public Integer getDelay()
    {
        return delay;
    }

    /**
     * Sets the delay to open
     *
     * @param delay
     */
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }

    /**
     * gets disabled or not
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Sets disabled or not
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * gets the minimum length
     *
     * @return
     */
    public Integer getMinLength()
    {
        return minLength;
    }

    /**
     * sets the minimum length
     *
     * @param minLength
     */
    public void setMinLength(Integer minLength)
    {
        this.minLength = minLength;
    }

    /**
     * Gets the position of the auto complete box
     *
     * @return
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * Sets the position of the auto complete box
     *
     * @param position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

}
