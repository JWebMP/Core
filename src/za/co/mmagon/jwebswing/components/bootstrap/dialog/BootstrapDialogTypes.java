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

package za.co.mmagon.jwebswing.components.bootstrap.dialog;

import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since Oct 3, 2016
 * @version 1.0
 * 
 */
public enum BootstrapDialogTypes 
{
    TYPE_DEFAULT,
    TYPE_INFO,
    TYPE_PRIMARY,
    TYPE_SUCCESS,
    TYPE_WARNING,
    TYPE_DANGER;
    
    @JsonValue
    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
    
    
}
