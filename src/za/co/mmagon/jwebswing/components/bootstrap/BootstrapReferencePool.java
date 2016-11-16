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
package za.co.mmagon.jwebswing.components.bootstrap;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum BootstrapReferencePool implements ReferencePool
{
    BootstrapCoreReference(new JavascriptReference("BSCore", 3.36, "bower_components/bootstrap/dist/js/bootstrap.js", "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js", 10),
            new CSSReference("BSCore", 3.36, "bower_components/bootstrap/dist/css/bootstrap.css", "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css", 10)),
    //BootstrapDefaultThemeReference(null, new CSSReference("BSTheme", 3.36, "css/bootstrap/bootstrap-theme.css", "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css", 11)),
    BootstrapSBAdmin2Reference(null, new CSSReference("BSAdmin2Theme", 3.36, "bower_components/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css")),
    BootstrapTimelineReference(null, new CSSReference("BSAdmin2TimelineTheme", 3.36, "bower_components/startbootstrap-sb-admin-2/dist/css/timeline.css")),
    BootstrapSocialThemeReference(null, new CSSReference("BSSocialTheme", 3.36, "bower_components/bootstrap-social/bootstrap-social.css")),
    Bootstrap4CoreReference(new JavascriptReference("BS4Core", 4.003, "bower_components/bootstrap4/dist/js/bootstrap.js", 10),
            new CSSReference("BS4Core", 4.003, "bower_components/bootstrap4/dist/css/bootstrap.css", 10)),
    Bootstrap4TetherReference(new JavascriptReference("BS4Tether", 4.003, "bower_components/tether/dist/js/tether.js", 9),
            new CSSReference("BS4Core", 4.003, "bower_components/tether/dist/css/tether.css", 9)),;

    private BootstrapReferencePool()
    {
    }

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private BootstrapReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
    {
        this.javaScriptReference = javaScriptReference;
        if (this.javaScriptReference != null)
        {
            this.javaScriptReference.setPriority(RequirementsPriority.Third);
        }
        this.cssReference = cssReference;
        if (this.cssReference != null)
        {
            this.cssReference.setPriority(RequirementsPriority.Third);
        }
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
