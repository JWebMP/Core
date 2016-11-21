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
package za.co.mmagon.jwebswing.components.pace;

import za.co.mmagon.jwebswing.base.references.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.base.servlets.interfaces.*;

/**
 *
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 */
public enum PaceLoaderReferencePool implements ReferencePool
{

    /**
     * Put Pace Loader First
     */
    PaceLoader(new JavascriptReference("PACE", 1.02, "bower_components/PACE/pace.js", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/pace.js", 0), -1),
    PaceLoaderDisableWebSockets(new JavascriptReference("PACE_DisableWebSockets", 1.02, "javascript/pace_ws_disable.js", "javascript/pace_ws_disable.js", 1), 0);

    private JavascriptReference javaScriptReference;

    private PaceLoaderReferencePool(JavascriptReference javaScriptReference, int sortOrder)
    {
        this.javaScriptReference = javaScriptReference;
        this.javaScriptReference.setSortOrder(sortOrder);
        javaScriptReference.setPriority(RequirementsPriority.Top_Shelf);
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
        return null;
    }

    @Override
    public void setCssReference(CSSReference cssReference)
    {

    }
}
