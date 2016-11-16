/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.pools.jquerylayout;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 * The references for the JWColourPicker
 * <p>
 * @author GedMarc
 * @since 01 May 2015
 */
public enum JQLayoutReferencePool implements ReferencePool
{

    JQueryLayout(new JavascriptReference("JQUILayoutJS", 1.45, "bower_components/jquery-ui-latest-jwebswing/jquery.layout_and_plugins.js", "http://layout.jquery-dev.com/lib/js/jquery.layout-latest.js"),
            new CSSReference("JQUILayoutCSS", 1.45, "bower_components/jquery-ui-latest-jwebswing/layout-default.css"), 10),
    JQueryLayoutResizer(new JavascriptReference("layoutResizer", 1.0, "bower_components/jquery-ui-latest-jwebswing/jquery.layout_customresizer.js"), null, 9),;
    //JQueryLayoutCallbacks(new JWLayoutCallbacksJavascriptReference(), null, 10),;

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private JQLayoutReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference, int sortOrder)
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
