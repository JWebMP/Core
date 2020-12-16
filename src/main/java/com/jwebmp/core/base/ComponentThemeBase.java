/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentThemeBase;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.css.themes.Theme;

import jakarta.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A Theme-Able Component. Only requirement is a tag, keeping it separate for the many different ways that other developers have done their
 * themes
 *
 * @param <A>
 * 		Set of attributes
 * @param <F>
 * 		Any features attached
 * @param <E>
 * 		Any events
 * @param <J>
 * 		This class
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
public class ComponentThemeBase<A extends Enum<?> & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents,
		J extends ComponentThemeBase<A, F, E, J>>
		extends ComponentDataBindingBase<A, F, E, J>
		implements IComponentThemeBase<J>
{
	/**
	 * The associated theme
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<Theme> themes;

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
	@SuppressWarnings("unused")
	public IComponentThemeBase<J> asThemeBase()
	{
		return this;
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<CSSReference> getCssReferencesAll()
	{
		Set<CSSReference> allCss = super.getCssReferencesAll();
		getThemes().forEach((Theme feature) ->
		                    {
			                    for (CSSReference next : feature.getCssReferences())
			                    {
				                    if (allCss.contains(next))
				                    {
					                    continue;
				                    }
				                    allCss.add(next);
			                    }
		                    });
		return allCss;
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<JavascriptReference> getJavascriptReferencesAll()
	{
		Set<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getThemes().forEach((Theme feature) -> allJs.addAll(feature
				                                                    .getJavascriptReferences()));
		return allJs;
	}

	/**
	 * Returns the parents theme or the applied theme
	 * <p>
	 *
	 * @return The theme
	 */
	@Override
	@NotNull
	public Set<Theme> getThemes()
	{
		if (themes == null)
		{
			themes = new LinkedHashSet<>();
		}
		return themes;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public void destroy()
	{
		if (themes != null)
		{
			themes.clear();
			themes = null;
		}
		super.destroy();
	}
}
