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
package za.co.mmagon.jwebswing.components.jqxWidgets.complexinput;

/**
 *
 * @author GedMarc
 */
public enum JQXDecimalNotations
{
    Default,// - decimal notation, e.g. '330000 - 200i'

    Exponential,//', e.g. '3.3e+5 - 2e+2i'

    Scientific,//', e.g. '3.3×10⁵ - 2×10²i'

    Engineering,//', e.g. '330×10³ - 200×10⁰i'
}
