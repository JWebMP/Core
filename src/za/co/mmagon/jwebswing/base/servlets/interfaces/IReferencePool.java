/* 
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.servlets.interfaces;

import java.io.Serializable;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;

/**
 *
 * @author GedMarc
 * @since Oct 24, 2016
 * 
 */
public interface IReferencePool extends Serializable
{
    
    /**
     * Gets the CSS Reference
     * <p>
     * @return
     */
    CSSReference getCssReference();

    /**
     * Gets the JavaScript reference
     * <p>
     * @return
     */
    JavascriptReference getJavaScriptReference();

    /**
     * Sets the CSS Reference
     * <p>
     * @param cssReference
     */
    void setCssReference(CSSReference cssReference);

    /**
     * Sets the JavaScript reference
     * <p>
     * @param javaScriptReference
     */
    void setJavaScriptReference(JavascriptReference javaScriptReference);

}
