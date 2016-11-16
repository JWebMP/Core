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
 * The valid attributes for the flip tile
 * @author GedMarc
 * @since Aug 30, 2016
 * @version 1.0
 * 
 */
public enum FlipTileAttributes implements JQMetroTileAttributes, AttributeDefinitions 
{
    /**
     * appendBack
     * Data Attribute data-appendback
     * Type boolean
     * Description
     * appends the .last tile if one doesnt exist (slide and flip only)
     * Supported modes fade,flip,flip-list,slide
     * Default Value true
     */
    appendBack("appendback"),
    /**
     * bounce
     * Data Attribute data-bounce
     * Type boolean
     * Description
     * should the tile tilt or shrink when tapped. You can use bounceDirections to choose which directions a tile will tilt or shrink.
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value false
     */
    bounce("bounce"),
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
     * delay
     * Data Attribute data-delay
     * Type number
     * Description
     * how long to wait between animations (in milliseconds).
     * Setting the delay value to -1 will use a random delay value between 3500 and 8000 milliseconds (3.5 - 8 seconds).
     * Setting the delay value to anything lower than -1 (e.g. -2) will call the triggerDelay method (see below) one time to get the delay value.
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value 5000
     */
    delay("delay"),
    /**
     * initDelay
     * Data Attribute data-initdelay
     * Type number
     * Description
     * how long to wait before starting (in milliseconds). If the value is '-1' the delay property is used
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value -1
     * Options -1 = use delay, any number greater than or equal to zero is used
     */
    
    
    initDelay("initdelay"),
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
     * onHoverDelay
     * Data Attribute data-hover-delay
     * Type number
     * Description
     * a delay that occurs before playOnHover and pauseOnHover is called. Setting this to a value of 200 or greater will reduce accidental flips when a user quickly passes by a tile
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value 0
     */
    onHoverDelay("hover-delay"),
    /**
     * onHoverOutDelay
     * Data Attribute data-hoverout-delay
     * Type number
     * Description
     * a delay that occurs before playOnHover and pauseOnHover call their out action. The default value lets the user move their mouse or finger away and come back before flipping back. This value is
     * added to the value speed property when used. To reduce the speed further you can use a negative value.
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value 200
     */
    onHoverOutDelay("hoverout-delay"),
    /**
     * pauseOnHover
     * Data Attribute data-pause-onhover
     * Type boolean
     * Description
     * should tile animations be paused on hover in and restarted on hover out
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value false
     */
    pauseOnHover("pause-onhover"),
    /**
     * playOnHover
     * Data Attribute data-play-onhover
     * Type boolean
     * Description
     * should "play" be called when the tile is hovered or touched
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value false
     */
    playOnHover("play-onhover"),
    /**
     * repeatCount
     * Data Attribute data-repeat
     * Type number
     * Description
     * how many times should the animation be performed. If the value is '-1' the animations will loop until stopped or paused
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value -1
     */
    repeatCount("repeat"),
    /**
     * speed
     * Data Attribute data-speed
     * Type number
     * Description
     * how fast should animations be performed (in milliseconds).
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value 500
     */
    speed("speed"),
    /**
     * startNow
     * Data Attribute data-start-now
     * Type boolean
     * Description
     * should the tile immediately start or wait util play or restart has been called
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value true
     */
    startNow("start-now"),
    /**
     * swap
     * Data Attribute data-swap
     * Type string or array
     * Description
     * which swap modules are active for this tile
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value [ ]
     * Options html, image
     */
    swap("swap"),
    /**
     * swapBack
     * Data Attribute data-swap-back
     * Type string or array
     * Description
     * override the available swap modules for the back face
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value [ ]
     * Options html, image
     */
    swapBack("swap-back"),
    /**
     * swapFront
     * Data Attribute data-swap-front
     * Type string or array
     * Description
     * override the available swap modules for the front face
     * Supported modes carousel,fade,flip,flip-list,slide
     * Default Value [ ]
     * Options html, image
     */
    swapFront("swap=front"),
    /**
     * tileFaceSelector
     * Data Attribute data-face-selector
     * Type string selector
     * Description
     * the selector used to choose the front and back container ( face ) for the tile
     * Supported modes fade, flip, flip-list, slide
     * Default Value div,li,p,img,a
     */
    tileFaceSelector("face-selector"),
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
    
    private String keyTag;
    
    private FlipTileAttributes (String keyTag)
    {
        this.keyTag = keyTag;
    }
    
    @Override
    public String toString()
    {
        return "data-" + this.keyTag;
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
