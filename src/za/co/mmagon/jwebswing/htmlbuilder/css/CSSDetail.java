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

package za.co.mmagon.jwebswing.htmlbuilder.css;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;

/**
 * Defines CSS Details. 
 * Marks for copy between objects
 * 
 * @author GedMarc
 * @since Nov 18, 2016
 * @version 1.0
 * 
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface CSSDetail
{
    /**
     * The CSS Version this field applies to. Default 2.1
     * @return 
     */
    public CSSVersions cssVersion() default CSSVersions.CSS21;
    /**
     * The name of this CSS class
     * @return 
     */
    public String cssName() default "";
    /**
     * The JSon name
     * @return 
     */
    public String jsonName() default "";
    /**
     * The JavaScript name
     * @return 
     */
    public String jsName() default "";
    /**
     * Tooltip if any
     * @return 
     */
    public String tooltip() default "";
    /**
     * What to do display when falling back
     * @return 
     */
    public String fallback() default "";
    /**
     * Referenced Field Name
     * @return 
     */
    public String field() default "";
    /**
     * Whether or not this tag is flagged as important
     * @return 
     */
    public boolean isImportant() default false;
}
