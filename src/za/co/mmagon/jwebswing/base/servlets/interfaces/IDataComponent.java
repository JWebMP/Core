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
package za.co.mmagon.jwebswing.base.servlets.interfaces;

import java.util.Map;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Marks a component as one with Data that is available as either AJAX or direct
 *
 * @author GedMarc
 * @param <J> The data DTO class
 *
 * @since Nov 9, 2016
 *
 */
public interface IDataComponent<J extends JavaScriptPart>
{

    /**
     * Returns the data object associated with this component.
     * Gets called from a separate Servlet in Asynchronous format. Sometimes the fields are set
     *
     *
     * @param params The request parameters received
     * @return
     */
    J getData(Map<String, String[]> params);
}
