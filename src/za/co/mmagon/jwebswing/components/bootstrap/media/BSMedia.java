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
package za.co.mmagon.jwebswing.components.bootstrap.media;

import za.co.mmagon.jwebswing.base.ComponentHTMLBootstrapBase;
import za.co.mmagon.jwebswing.base.html.*;

/**
 * Media object
 * <p>
 * The media object is an abstract element used as the basis for building more complex and repetitive components (like blog comments, Tweets, etc).
 * <p>
 * Included is support for left and right aligned content, content alignment options, nesting, and more.
 *
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSMedia extends Div<BSMediaChildren, BSMediaAttributes, BSMediaFeatures, BSMediaEvents, BSMedia> implements IBSMedia
{

    private static final long serialVersionUID = 1L;
    /**
     * The feature of the media object
     */
    private BSMediaFeature feature;
    /**
     * The link for the media object
     */
    private Link mediaLink;
    /**
     * The body for the media object
     */
    private Div mediaBody;
    /**
     * The header for the media object
     */
    private HeaderText mediaHeader;
    /**
     * The media object being displayed (usually image or something)
     */
    private ComponentHTMLBootstrapBase mediaComponent;

    /**
     * The media object is an abstract element used as the basis for building more complex and repetitive components (like blog comments, Tweets, etc).
     * <p>
     * Included is support for left and right aligned content, content alignment options, nesting, and more.
     */
    public BSMedia()
    {
        addFeature(getFeature());
        addClass(BSComponentMediaOptions.Media);
    }

    /**
     * Cleaner interface for the BS Media object
     *
     * @return
     */
    public IBSMedia asMe()
    {
        return this;
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPage().getOptions().setBootstrapEnabled(true);
        }
        super.init();
    }

    /**
     * Returns the feature associated (doesn't do anything for media)
     *
     * @return
     */
    public final BSMediaFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSMediaFeature(this);
        }
        return feature;
    }

    /**
     * Doesn't do anything
     *
     * @return
     */
    @Override
    public BSMediaOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Returns the associated media link, never null
     *
     * @return
     */
    @Override
    public Link getMediaLink()
    {
        if (mediaLink == null)
        {
            setMediaLink(new Link("#"), true);
        }
        return mediaLink;
    }

    /**
     * Sets the media link, and moves the media object into the new link if necessary
     *
     * @param mediaLink
     * @param left
     *
     * @return
     */
    @Override
    public BSMedia setMediaLink(Link mediaLink, boolean left)
    {
        if (this.mediaLink != null)
        {
            mediaLink.add(getMediaComponent());
            remove(this.mediaLink);
            this.mediaLink = null;
        }
        this.mediaLink = mediaLink;
        if (this.mediaLink != null)
        {
            if (left)
            {
                this.mediaLink.addClass(BSComponentMediaOptions.Media_Left);
            }
            else
            {
                this.mediaLink.addClass(BSComponentMediaOptions.Media_Right);
            }
            add(0, this.mediaLink);
        }
        return this;
    }

    /**
     * Returns the body portion of this media object
     *
     * @return
     */
    @Override
    public Div getMediaBody()
    {
        if (mediaBody == null)
        {
            setMediaBody(new Div());
        }
        return mediaBody;
    }

    /**
     * Sets the media body and adds it to this object
     *
     * @param mediaBody
     *
     * @return
     */
    @Override
    public BSMedia setMediaBody(Div mediaBody)
    {
        if (this.mediaBody != null)
        {
            remove(this.mediaBody);
            this.mediaBody = null;
        }
        this.mediaBody = mediaBody;
        if (this.mediaBody != null)
        {
            this.mediaBody.addClass(BSComponentMediaOptions.Media_Body);
        }
        add(mediaBody);
        return this;
    }

    /**
     * Returns a new H4 header
     *
     * @return
     */
    @Override
    public HeaderText getMediaHeader()
    {
        if (this.mediaHeader == null)
        {
            setMediaHeader(new H4(""));
        }
        return mediaHeader;
    }

    /**
     * Sets the header to the required object
     *
     * @param mediaHeader
     *
     * @return
     */
    @Override
    public BSMedia setMediaHeader(HeaderText mediaHeader)
    {
        if (this.mediaHeader != null)
        {
            getMediaBody().remove(this.mediaHeader);
            this.mediaHeader = null;
        }
        this.mediaHeader = mediaHeader;
        if (this.mediaHeader != null)
        {
            this.mediaHeader.addClass(BSComponentMediaOptions.Media_Heading);
            getMediaBody().add(0, this.mediaHeader);
        }
        return this;
    }

    /**
     * Returns the component displayed inside the link that is used for display
     *
     * @return
     */
    @Override
    public ComponentHTMLBootstrapBase getMediaComponent()
    {
        if (this.mediaComponent == null)
        {
            setMediaComponent(new Div());
        }
        return mediaComponent;
    }

    /**
     * Sets the component displayed to the left or right (set that in the link)
     *
     * @param mediaComponent
     *
     * @return
     */
    @Override
    public BSMedia setMediaComponent(ComponentHTMLBootstrapBase mediaComponent)
    {
        if (this.mediaComponent != null)
        {
            getMediaLink().remove(this.mediaComponent);
            this.mediaComponent = null;
        }
        this.mediaComponent = mediaComponent;
        if (this.mediaComponent != null)
        {
            this.mediaComponent.addClass(BSComponentMediaOptions.Media_Object);
            getMediaLink().add(this.mediaComponent);
        }
        return this;
    }

}
