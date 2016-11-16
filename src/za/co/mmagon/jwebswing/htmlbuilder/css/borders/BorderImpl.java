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
package za.co.mmagon.jwebswing.htmlbuilder.css.borders;

import java.lang.annotation.Annotation;

/**
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BorderImpl implements Border
{

    private BorderLeftCSS Border;

    @Override
    public String toString()
    {
        if (Border != null)
        {
            return Border.toString();
        }
        else
        {
            return "";
        }
    }

    @Override
    public BorderLeftCSS Border()
    {
        return Border;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return Border.class;
    }

}
