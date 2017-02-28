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
package za.co.mmagon.jwebswing.plugins;

import java.lang.annotation.*;

/**
 * Any specific component
 *
 * @author GedMarc
 * @since 19 Feb 2017
 *
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
        })
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentInformation
{

    /**
     * The name of the component
     *
     * @return
     */
    public String name();

    /**
     * The description of the component
     *
     * @return
     */
    public String description();

    /**
     * The URL of the component
     *
     * @return
     */
    public String url();

    /**
     * The wiki url of the component
     *
     * @return
     */
    public String wikiUrl() default "";

    /**
     * The icon of the component
     *
     * @return
     */
    public String icon() default "";

}
