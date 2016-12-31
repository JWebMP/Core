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
package za.co.mmagon.jwebswing.components.bootstrap.media;

import za.co.mmagon.jwebswing.base.ComponentHTMLBootstrapBase;
import za.co.mmagon.jwebswing.base.html.*;

/**
 * Shortcut interface for the BS Media
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public interface IBSMedia
{

    /**
     * Returns the body portion of this media object
     *
     * @return
     */
    Div getMediaBody();

    /**
     * Returns the component displayed inside the link that is used for display
     *
     * @return
     */
    ComponentHTMLBootstrapBase getMediaComponent();

    /**
     * Returns a new H4 header
     *
     * @return
     */
    HeaderText getMediaHeader();

    /**
     * Returns the associated media link, never null
     *
     * @return
     */
    Link getMediaLink();

    /**
     * Sets the media body and adds it to this object
     *
     * @param mediaBody
     *
     * @return
     */
    BSMedia setMediaBody(Div mediaBody);

    /**
     * Sets the component displayed to the left or right (set that in the link)
     *
     * @param mediaComponent
     *
     * @return
     */
    BSMedia setMediaComponent(ComponentHTMLBootstrapBase mediaComponent);

    /**
     * Sets the header to the required object
     *
     * @param mediaHeader
     *
     * @return
     */
    BSMedia setMediaHeader(HeaderText mediaHeader);

    /**
     * Sets the media link, and moves the media object into the new link if necessary
     *
     * @param mediaLink
     * @param left
     *
     * @return
     */
    BSMedia setMediaLink(Link mediaLink, boolean left);
    
}
