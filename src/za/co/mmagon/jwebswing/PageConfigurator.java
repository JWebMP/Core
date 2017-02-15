/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing;

/**
 * Allows plugin components to register themselves as page configuration objects, and apply custom logic to when they are used
 *
 * @author GedMarc
 * @since 13 Feb 2017
 *
 */
public interface PageConfigurator
{

    /**
     * Method that is called during the page configuration setup
     *
     * @param page
     *
     * @return
     */
    Page configure(Page page);
}
