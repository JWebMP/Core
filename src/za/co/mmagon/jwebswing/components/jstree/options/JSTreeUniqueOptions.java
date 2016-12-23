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
package za.co.mmagon.jwebswing.components.jstree.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Enforces that no nodes with the same name can coexist as siblings. This plugin has no options, it just prevents renaming and moving nodes to a parent, which already contains a node with the same
 * name.
 *
 * @author GedMarc
 * @since 23 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeUniqueOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    
    /**
     * Indicates if the comparison should be case sensitive. Default is false.
     */
    private Boolean caseSensitive;

    public JSTreeUniqueOptions()
    {

    }

    /**
     * Indicates if the comparison should be case sensitive. Default is false.
     * @return 
     */
    public Boolean getCaseSensitive()
    {
        return caseSensitive;
    }

    /**
     * Indicates if the comparison should be case sensitive. Default is false.
     * @param caseSensitive 
     */
    public void setCaseSensitive(Boolean caseSensitive)
    {
        this.caseSensitive = caseSensitive;
    }
    
    
}
