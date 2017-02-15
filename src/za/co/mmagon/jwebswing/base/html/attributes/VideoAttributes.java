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
package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 *
 * @author GedMarc
 * @since Mar 1, 2015
 * @version 1.0
 */
public enum VideoAttributes implements AttributeDefinitions
{

    /**
     * Specifies that the video will start playing as soon as it is ready
     */
    AutoPlay,
    /**
     * Specifies that video controls should be displayed (such as a play/pause button etc).
     */
    Controls,
    /**
     * Sets the height of the video player
     */
    Height,
    /**
     * Specifies that the video will start over again, every time it is finished
     */
    Loop,
    /**
     * Specifies that the audio output of the video should be muted
     */
    Muted,
    /**
     * Specifies an image to be shown while the video is downloading, or until the user hits the play button
     */
    Poster,
    /**
     * Specifies if and how the author thinks the video should be loaded when the page loads
     */
    Preload,
    /**
     * Specifies the URL of the video file
     */
    Src,
    /**
     * Sets the width of the video player
     */
    Width,
    /**
     * The specific volume
     */
    Volume;

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
