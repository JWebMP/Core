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
package za.co.mmagon.jwebswing.components.jqueryUI.accordion;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Default: "auto"
 * <p>
 * Controls the height of the accordion and each panel. Possible values:
 * <p>
 * <p>
 * "auto": All panels will be set to the height of the tallest panel.<p>
 * "fill": Expand to the available height based on the accordion's parent height.<p>
 * "content": Each panel will be only as tall as its content.<p>
 * <p>
 * <p>
 */
public enum JQUIAccordionHeightStyle
{

    /**
     * All panels will be set to the height of the tallest panel.
     */
    Auto,
    /**
     * Expand to the available height based on the accordion's parent height.
     */
    Fill,
    /**
     * Each panel will be only as tall as its content.
     */
    Content;

    /**
     * Returns the height style in lowercase
     *
     * @return
     */
    @JsonValue
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
