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
package za.co.mmagon.jwebswing.components.moment;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 * Default reference pool structure
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum MomentReferencePool implements ReferencePool
{
    MomentReference(new JavascriptReference("MomentJS", 2.151, "bower_components/moment/min/moment-with-locales.js", "https://cdnjs.com/libraries/moment.js/2.15.1/moment-with-locales.js", 10),null),
    MomentAngularReference(new JavascriptReference("MomentAngularJS", 0.103, "bower_components/angular-moment/angular-moment.js", "https://cdnjs.cloudflare.com/ajax/libs/angular-moment/1.0.0-beta.6/angular-moment.min.js", 11),null)
    ;
    ;
    private MomentReferencePool()
    {
    }

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private MomentReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
    {
        this.javaScriptReference = javaScriptReference;
        this.cssReference = cssReference;
    }

    @Override
    public JavascriptReference getJavaScriptReference()
    {
        return javaScriptReference;
    }

    @Override
    public void setJavaScriptReference(JavascriptReference javaScriptReference)
    {
        this.javaScriptReference = javaScriptReference;
    }

    @Override
    public CSSReference getCssReference()
    {
        return cssReference;
    }

    @Override
    public void setCssReference(CSSReference cssReference)
    {
        this.cssReference = cssReference;
    }
}
