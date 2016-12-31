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
package za.co.mmagon.jwebswing.components.bootstrap.componentoptions;

/**
 * Use .d-block, .d-inline, or .d-inline-block to simply set an element’s display property to block, inline, or inline-block (respectively).
 *
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public enum BSComponentDisplayOptions implements IBSComponentOptions
{
    /**
     * Sets the display property to block
     */
    Block,
    /**
     * Sets the display property to inline
     */
    Inline,
    /**
     * Sets the display property to inline block
     */
    Inline_Block;

    ;
    @Override
    public String toString()
    {
        return "d-" + name().toLowerCase().replace('_', '-');
    }
}
