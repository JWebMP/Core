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
package za.co.mmagon.jwebswing.components.jqMetro.metro.tiles;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.components.jqMetro.metro.interfaces.JQMetroTileAttributes;

/**
 *
 * @author GedMarc
 * @since Aug 30, 2016
 * @version 1.0
 *
 */
public enum StaticTileAttributes implements JQMetroTileAttributes, AttributeDefinitions
{
    /**
     * bounceDirections
     * Data Attribute data-bounce-dir
     * Type string or array
     * Description
     * Controls the direction that a tile will bounce or tilt in. A click or tap must fall within the region of the option chosen unless the previous region is an '*' as in the the example below
     * Supported modes carousel, fade, flip, slide, none
     * Default Value 'all'
     * Options 'all', 'edges', 'corners', '*', 'c', 'tl', 'tr', 'bl'. 'br'. 't', 'l', 'b', 'r'
     */
    bounceDirections("bounce-dir"),
    /**
     * Should the tile change the active bounce direction as the mouse or touch moves
     * Supported modes carousel, fade, flip, slide, none
     * Default Value true
     */
    bounceFollowsMove("bounce-follows"),
    /**
     * link
     * Data Attribute data-link
     * Type string
     * Description
     * a url to go to when clicked or tapped
     * Supported modes all
     * Default Value empty string
     */
    link("link"),
    /**
     * mode
     * Data Attribute data-mode
     * Type string
     * Description
     * carousel
     * slide any number of tile faces infinitely or slide to a specific tile face
     * fade
     * fade the front face in and out
     * slide
     * slide two tile faces at an arbitrary number of stopping points
     * flip
     * flip two tile faces in a vertical or horizontal direction
     * flip-list
     * trigger a list of tiles to flip between tile faces with custom delays
     * none
     * no animations are performed. This is useful if you just want to bind a bounce, click or link to the tile.
     * Supported modes all
     * Default Value slide
     * Options carousel, fade, flip, flip-list, slide, none
     */
    mode("mode"),
    /**
     * newWindow
     * Data Attribute data-new-window
     * Type boolean
     * Description
     * should the link option be opened in a new window
     * Supported modes all
     * Default Value false
     */
    newWindow("new-window"),
    /**
     * useHardwareAccel
     * Data Attribute data-ha
     * Type boolean
     * Description
     * should css animations, transitions and transforms be used when available
     * Supported modes all
     * Default Value true
     */
    useHardwareAccel("ha");

    ;
    private String tagKey;

    private StaticTileAttributes(String tagKey)
    {
        this.tagKey = tagKey;
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return "data-" + tagKey;
    }

}
