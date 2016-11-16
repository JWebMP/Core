/*
 * Copyright (C) 2015 Marc Magon
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

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyFeatures;
import za.co.mmagon.jwebswing.base.servlets.interfaces.Loader;
import za.co.mmagon.jwebswing.components.pace.preloadedThemes.PaceTheme;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * An implementation of the jsTree project.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class PaceLoader extends Feature<JavaScriptPart, PaceLoader> implements Loader, BodyFeatures
{

    private static final long serialVersionUID = 1L;

    /**
     * Creates a Pace Loader with a theme
     *
     * @param theme
     */
    public PaceLoader(PaceTheme theme)
    {
        super("PaceLoader");
        addJavaScriptReference(PaceLoaderReferencePool.PaceLoader.getJavaScriptReference());
        addCssReference(theme.getCSSReference());
    }

    public void setTheme(PaceTheme theme)
    {
        getCssReferences().add(theme.getCSSReference());
    }
}
