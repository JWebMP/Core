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
package za.co.mmagon.jwebswing.base.servlets.enumarations;

/**
 * Configures the global generation type
 *
 * @since 2013/11/20
 * @version 1.0
 * @author mmagon
 *
 *
 */
public enum DevelopmentEnvironments
{
    /**
     * Forces tiny HTML to be rendered
     */
    Production,
    /**
     * PreProduction Environment
     */
    PreProduction,
    /**
     * UI Test Environment
     */
    UITest,
    /**
     * Allows for pretty print of HTML
     */
    QA,
    /**
     * Always pretty print HTML
     */
    Development,
    /**
     * Lots of commenting
     */
    Sandbox,
    /**
     * All commenting and everything
     */
    Local
}
