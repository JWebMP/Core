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
package za.co.mmagon.jwebswing.components.google.sourceprettify;

import za.co.mmagon.jwebswing.utilities.TextUtilities;

/**
 * /**
 * The themes available to the source code engine
 * <p>
 * @author GedMarc
 * @since 18 Dec 2014
 * <p>
 *
 */
public enum SourceCodePrettifyThemes
{

    Default("bower_components/google-code-prettify/bin/prettify.min.css"),
    Desert("bower_components/google-code-prettify/styles/desert.css"),
    Doxy("bower_components/google-code-prettify/styles/doxy.css"),
    Sons_Of_Obsidian("bower_components/google-code-prettify/styles/sons-of-obsidian.css"),
    Sunburst("bower_components/google-code-prettify/styles/sunburst.css");

    private final String cssReference;

    private SourceCodePrettifyThemes(String cssReference)
    {
        this.cssReference = cssReference;
    }

    /**
     * Returns the location of the theme CSS File
     *
     * @return The CSS Reference
     */
    public String getCssReference()
    {
        return cssReference;
    }

    @Override
    public String toString()
    {
        return TextUtilities.cleanAttributeName(name());
    }

}
