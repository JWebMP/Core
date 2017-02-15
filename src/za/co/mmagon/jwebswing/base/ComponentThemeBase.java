/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.IComponentThemeBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * A Theme-Able Component. Only requirement is a tag, keeping it separate for the many different ways that other developers have done their themes
 *
 * @author GedMarc
 * @param <A> Set of attributes
 * @param <F> Any features attached
 * @param <E> Any events
 * @param <J> This class
 *
 * @since 23 Apr 2016
 */
public class ComponentThemeBase<A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentThemeBase>
        extends ComponentHTMLAngularBase<A, F, E, J> implements IComponentThemeBase<J>
{

    private static final long serialVersionUID = 1L;

    /**
     * The associated theme
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<Theme> themes;

    /**
     * Constructs a theme controller for a component
     *
     * @param componentType
     */
    public ComponentThemeBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns a Theme Base interface of this component
     *
     * @return
     */
    public IComponentThemeBase asThemeBase()
    {
        return (ComponentThemeBase) this;
    }

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    @Override
    public List<JavascriptReference> getJavascriptReferencesAll()
    {
        List<JavascriptReference> allJs = super.getJavascriptReferencesAll();
        getThemes().stream().forEach((Theme feature)
                ->
        {
            Theme.class.cast(feature).getJavascriptReferences().stream().filter((js) -> (!allJs.contains(js))).forEach((js)
                    ->
            {
                allJs.add(js);
            });
        });
        return allJs;
    }

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    @Override
    public List<CSSReference> getCssReferencesAll()
    {
        List<CSSReference> allCss = super.getCssReferencesAll();
        getThemes().stream().forEach((Theme feature)
                ->
        {
            Theme.class.cast(feature).getCssReferences().stream().filter((css) -> (!allCss.contains(css))).forEach((css)
                    ->
            {
                allCss.add(css);
            });
        });
        return allCss;
    }

    /**
     * Returns the parents theme or the applied theme
     * <p>
     * @return The theme
     */
    @Override
    public List<Theme> getThemes()
    {
        if (this.themes == null)
        {
            this.themes = new ArrayList<>();
        }
        return this.themes;
    }
}
