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
package za.co.mmagon.jwebswing.htmlbuilder.css.annotations;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import java.lang.annotation.*;

/**
 * Defines a class as a CSS Implementation Class
 *
 * @author GedMarc
 * @param <A> From Annotation Type
 * @param <I> To Implementation Type, usually this
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface CSSImplementationClass<A extends Annotation, I extends CSSImplementationClass> extends Serializable
{

    /**
     * Returns this implementation from a given annotation
     *
     * @param annotation The annotation to read from
     *
     * @return
     */
    public I fromAnnotation(A annotation);
}
