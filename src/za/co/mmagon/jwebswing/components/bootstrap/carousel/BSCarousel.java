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
package za.co.mmagon.jwebswing.components.bootstrap.carousel;

import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDefaultOptions;

/**
 * Carousel
 * <p>
 * A slideshow component for cycling through elements—images or slides of text—like a carousel.
 * <p>
 * In browsers where the Page Visibility API is supported, the carousel will avoid sliding when the webpage is not visible to the user (such as when the browser tab is inactive, the browser window is
 * minimized, etc.). Nested carousels are not supported.
 * <p>
 * @author Marc Magon
 * @since 01 Jan 2017
 * @version 1.0
 */
public class BSCarousel extends Div<BSCarouselChildren, BSCarouselAttributes, BSCarouselFeatures, BSCarouselEvents, BSCarousel>
{

    private static final long serialVersionUID = 1L;
    private BSCarouselFeature feature;

    /**
     * Determines the active slide
     */
    private int activeSlide;
    /**
     * The list of slides that gets rendered
     */
    private List<BSCarouselItem> slides;
    /**
     * The actual carousel slides displaying div
     */
    private Div carouselSlides;

    /**
     * The previous link
     */
    private Link previousLink;
    /**
     * The next link
     */
    private Link nextLink;

    /**
     * Carousel
     * <p>
     * A slideshow component for cycling through elements—images or slides of text—like a carousel.
     * <p>
     * In browsers where the Page Visibility API is supported, the carousel will avoid sliding when the webpage is not visible to the user (such as when the browser tab is inactive, the browser window
     * is minimized, etc.). Nested carousels are not supported.
     */
    public BSCarousel()
    {
        addFeature(getFeature());
    }

    /**
     * Returns the java script feature associated
     *
     * @return
     */
    public final BSCarouselFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSCarouselFeature(this);
        }
        return feature;
    }

    /**
     * Returns any javascript options available
     *
     * @return
     */
    @Override
    public BSCarouselOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * The active slide
     *
     * @return
     */
    public int getActiveSlide()
    {
        return activeSlide;
    }

    /**
     * Sets the active slide
     *
     * @param activeSlide
     *
     * @return
     */
    public BSCarousel setActiveSlide(int activeSlide)
    {
        this.activeSlide = activeSlide;
        return this;
    }

    /**
     * Returns the list of slides currently associated
     *
     * @return
     */
    public List<BSCarouselItem> getSlides()
    {
        if (slides == null)
        {
            setSlides(new ArrayList<>());
        }
        return slides;
    }

    /**
     * Sets the list of slides currently associated
     *
     * @param slides
     *
     * @return
     */
    public BSCarousel setSlides(List<BSCarouselItem> slides)
    {
        this.slides = slides;
        if (slides != null)
        {

        }
        return this;
    }

    /**
     * Returns the carousel slides
     *
     * @return
     */
    public Div getCarouselSlides()
    {
        if (carouselSlides == null)
        {
            setCarouselSlides(new Div());
        }
        return carouselSlides;
    }

    /**
     * Sets the carousel slides
     *
     * @param carouselSlides
     */
    public void setCarouselSlides(Div carouselSlides)
    {
        this.carouselSlides = carouselSlides;
        carouselSlides.addClass(BSComponentCarouselOptions.Carousel_Inner);
        carouselSlides.addAttribute("role", "listbox");
    }

    /**
     * Returns the previous link
     *
     * @return
     */
    public Link getPreviousLink()
    {
        if (previousLink == null)
        {
            setPreviousLink(new BSCarouselControl(this, true));
        }
        return previousLink;
    }

    /**
     * Set's the previous link
     *
     * @param previousLink
     */
    public void setPreviousLink(Link previousLink)
    {
        getChildren().remove(this.previousLink);
        this.previousLink = previousLink;
        if (this.previousLink != null)
        {

            previousLink.addClass("left");
            previousLink.addClass(BSComponentCarouselOptions.Carousel_Control);

            previousLink.addAttribute("role", "button");
            previousLink.addAttribute("data-slide", "prev");

            Span iconSpan = new Span();
            iconSpan.addAttribute(GlobalAttributes.Aria_Hidden, "true");
            iconSpan.addClass("icon-next");

            Span readerFriendly = new Span("Previous");
            readerFriendly.addClass("sr-only");

            previousLink.add(iconSpan);
            previousLink.add(readerFriendly);
        }
    }

    /**
     * Returns the next link
     *
     * @return
     */
    public Link getNextLink()
    {
        if (nextLink == null)
        {
            setNextLink(new BSCarouselControl(this, false));
        }
        return nextLink;
    }

    /**
     * Sets the next link
     *
     * @param nextLink
     */
    public void setNextLink(Link nextLink)
    {
        getChildren().remove(this.nextLink);
        this.nextLink = nextLink;
        if (this.nextLink != null)
        {
            nextLink.addClass("right");
            nextLink.addClass(BSComponentCarouselOptions.Carousel_Control);

            nextLink.addAttribute("role", "button");
            nextLink.addAttribute("data-slide", "next");

            Span iconSpan = new Span();
            iconSpan.addAttribute(GlobalAttributes.Aria_Hidden, "true");
            iconSpan.addClass("icon-next");

            Span readerFriendly = new Span("Next");
            readerFriendly.addClass("sr-only");

            nextLink.add(iconSpan);
            nextLink.add(readerFriendly);
        }
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            BSCarouselIndicators indications = new BSCarouselIndicators(this);
            indications.init();
            add(indications);
            add(getCarouselSlides());

            BSCarouselItem activeItem;
            if (!getSlides().isEmpty())

            {
                activeItem = getSlides().get(getActiveSlide());
                activeItem.addClass(BSComponentDefaultOptions.Active);
            }

            add(getPreviousLink());
            add(getNextLink());

        }
        super.init();
    }
}
