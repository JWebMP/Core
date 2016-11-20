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
package za.co.mmagon.jwebswing.htmlbuilder.css.lists;

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.image.*;

/**
 * In HTML, there are two main types of lists:
 * <p>
 * unordered lists (ul) - the list items are marked with bullets ordered lists (ol) - the list items are marked with numbers or letters
 * <p>
 * The CSS list properties allow you to:
 * <p>
 * Set different list item markers for ordered lists Set different list item markers for unordered lists Set an image as the list item marker Add background colors to lists and list items
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class ListCSSImpl extends CSSImplementationAdapter<ListCSS, ListCSSImpl> implements CSSImplementationClass<ListCSS, ListCSSImpl>
{

    private static final long serialVersionUID = 1L;

    @CSSDetail(cssName = "list-style-image", cssVersion = CSSVersions.CSS21)
    private ImageCSSImpl listStyleImage;
    @CSSDetail(cssName = "list-style-position", cssVersion = CSSVersions.CSS21)
    private ListStylePosition listStylePosition;
    @CSSDetail(cssName = "list-style-type", cssVersion = CSSVersions.CSS21)
    private ListStyleType listStyleType;

    /**
     * Construct a new List
     */
    public ListCSSImpl()
    {
        //Nothing needed
    }

    /**
     * Returns the Image associated with the list style item
     *
     * @return
     */
    public ImageCSSImpl getListStyleImage()
    {
        return listStyleImage;
    }

    /**
     * Returns the position for the list bullet
     *
     * @return
     */
    public ListStylePosition getListStylePosition()
    {
        return listStylePosition;
    }

    /**
     * Defines the bullet type for a list
     *
     * @return
     */
    public ListStyleType getListStyleType()
    {
        return listStyleType;
    }

    /**
     * Sets the list style image
     *
     * @param listStyleImage
     */
    public void setListStyleImage(ImageCSSImpl listStyleImage)
    {
        this.listStyleImage = listStyleImage;
    }

    /**
     * Sets the list style position
     *
     * @param listStylePosition
     */
    public void setListStylePosition(za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListStylePosition listStylePosition)
    {
        this.listStylePosition = listStylePosition;
    }

    /**
     * Sets the list style type
     *
     * @param listStyleType
     */
    public void setListStyleType(za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListStyleType listStyleType)
    {
        this.listStyleType = listStyleType;
    }

}
