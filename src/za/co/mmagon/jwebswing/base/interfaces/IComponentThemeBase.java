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

package za.co.mmagon.jwebswing.base.interfaces;

import java.util.List;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.components.jqueryUI.themes.JQUIThemeBlocks;
import za.co.mmagon.jwebswing.components.jqueryUI.themes.JQUIThemes;
import za.co.mmagon.jwebswing.components.jqxWidgets.themes.JQXWidgetThemes;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 *
 * @author GedMarc
 * @param <J> This Class
 * @since Sep 26, 2016
 * 
 */
public interface IComponentThemeBase<J extends ComponentBase> 
{

    /**
     * Set the theme applied to this component
     * <p>
     * @param theme The JQuery UI theme to apply to the component
     * @return This Class
     */
    J addTheme(JQUIThemes theme);

    /**
     * Set the theme applied to this component
     * <p>
     * @param theme The JQuery UI theme to apply to the component
     * @return This Class
     */
    J addTheme(Theme theme);

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    List<CSSReference> getCssReferencesAll();

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    List<JavascriptReference> getJavascriptReferencesAll();

    /**
     * Returns the parents theme or the applied theme
     * <p>
     * @return The theme
     */
    List<Theme> getThemes();

    /**
     * Adds a class name to the class list
     * <p>
     * @param blockName The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    boolean addClass(JQUIThemeBlocks blockName);

/**
     * Set the theme applied to this component
     * <p>
     * @param theme The JQuery UI theme to apply to the component
     */
    J addTheme(JQXWidgetThemes theme);    
}
