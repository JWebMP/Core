/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.htmlbuilder.javascript;

/**
 *
 * @author Marc Magon
 * @since 31 Aug 2015
 * @version 1.0
 * /**
 * Determines how to display the key to the object
 */
public enum JavascriptPartType
{

    /**
     * Don't use quotes around the key
     */
    Javascript,
    /**
     * Use quotes around the key
     */
    JSON,
    /**
     * As a Function
     */
    Function;

}
