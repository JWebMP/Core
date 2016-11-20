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

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.image.*;

/**
 * In HTML, there are two main types of lists:
 * <p>
 * unordered lists (ul) - the list items are marked with bullets
 * ordered lists (ol) - the list items are marked with numbers or letters
 * <p>
 * The CSS list properties allow you to:
 * <p>
 * Set different list item markers for ordered lists
 * Set different list item markers for unordered lists
 * Set an image as the list item marker
 * Add background colors to lists and list items
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface ListCSS
{

    /**
     * Specifies an image as the list-item marker
     * @return 
     */
    public ImageCSS ListStyleImage() default @ImageCSS;

    /**
     * Specifies if the list-item markers should appear inside or outside the content flow
     * @return 
     */
    public ListStylePosition ListStylePosition() default ListStylePosition.Unset;

    /**
     * Specifies the type of list-item marker
     * @return 
     */
    public ListStyleType ListStyleType() default ListStyleType.Unset;
}
