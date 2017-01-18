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
package za.co.mmagon.jwebswing.components.newcomponents;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 * Default reference pool structure
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum BlankComponentReferencePool implements ReferencePool
{
    NoReference(null, null);
    /**
     * The actual javascript
     */
    private JavascriptReference javaScriptReference;
    /**
     * The actual css reference
     */
    private CSSReference cssReference;

    /**
     * Constructs a reference pool
     */
    private BlankComponentReferencePool()
    {
    }

    /**
     * Constructs a new reference pool
     *
     * @param javaScriptReference
     * @param cssReference
     */
    private BlankComponentReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
    {
        this.javaScriptReference = javaScriptReference;
        this.cssReference = cssReference;
    }

    /**
     * Returns the javascript reference
     *
     * @return
     */
    @Override
    public JavascriptReference getJavaScriptReference()
    {
        return javaScriptReference;
    }

    /**
     * Sets the javascript reference
     *
     * @param javaScriptReference
     */
    @Override
    public void setJavaScriptReference(JavascriptReference javaScriptReference)
    {
        this.javaScriptReference = javaScriptReference;
    }

    /**
     * Gets the cSS reference
     *
     * @return
     */
    @Override
    public CSSReference getCssReference()
    {
        return cssReference;
    }

    /**
     * Sets the CSS Reference
     *
     * @param cssReference
     */
    @Override
    public void setCssReference(CSSReference cssReference)
    {
        this.cssReference = cssReference;
    }
}
