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

package za.co.mmagon.jwebswing.components.jstree.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 *
 * @author GedMarc
 * @since Aug 27, 2016
 * @version 1.0
 * 
 */
public class JSTreeDefaultTheme extends Theme implements JSTreeTheme
{

    private static final long serialVersionUID = 1L;

    public JSTreeDefaultTheme ()
    {
        super("JSTreeDefaulTheme", "");
        getCssReferences().add(new CSSReference("JSTreeDefaultTheme", 3.32, "bower_components/jstree/dist/themes/default/style.css"));
    }
}
