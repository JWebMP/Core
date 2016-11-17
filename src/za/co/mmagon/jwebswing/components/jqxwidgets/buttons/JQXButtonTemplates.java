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
package za.co.mmagon.jwebswing.components.jqxwidgets.buttons;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author GedMarc
 */
public enum JQXButtonTemplates
{
    Default,// the default buttons template. The buttons style depends only on its "theme" property value.

    Primary,// dark blue button for extra visual weight.

    Success,// green button for successful or positive action.

    Warning,// orange button which indicates caution.

    Danger,// red button which indicates a dangerous or negative action.

    Inverse,// dark gray button, not tied to a semantic action or use.

    Info,// blue button, not tied to a semantic action or use.

    Link,// making it look like a link .
    ;

    @Override
    @JsonValue
    public String toString()
    {
        return name().toLowerCase();
    }

}
