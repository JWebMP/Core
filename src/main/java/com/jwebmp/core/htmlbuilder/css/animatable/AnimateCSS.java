/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.htmlbuilder.css.animatable;

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * Definition and Usage
 * <p>
 * Some CSS properties are animatable, meaning that they can be used in animations and transitions.
 * <p>
 * Animatable properties can change gradually from one value to another, like size, numbers, percentage and color. Browser Support
 * <p>
 * The numbers in the table specifies the first browser version that fully support CSS animations.
 * <p>
 * Numbers followed by -webkit-, -moz-, or -o- specify the first version that worked with a prefix.
 *
 * @author GedMarc
 * @since 2016/01/17
 */
@CSSAnnotationType
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AnimateCSS
{

}
