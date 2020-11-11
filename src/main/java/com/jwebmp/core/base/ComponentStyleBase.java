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
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IComponentStyleBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.htmlbuilder.css.CSSImpl;
import com.jwebmp.core.htmlbuilder.css.composer.CSSComposer;
import com.jwebmp.core.htmlbuilder.css.enumarations.CSSTypes;

import jakarta.validation.constraints.NotNull;
import java.util.EnumMap;
import java.util.Map;

/**
 * The CSS Portion of the Component.
 *
 * @param <C>
 * 		All allowed children
 * @param <A>
 * 		All attributes for this component
 * @param <F>
 * 		All features allowed for this component
 * @param <E>
 * 		All events allowed for this component
 * @param <J>
 * 		Always this class
 *
 * @author GedMarc
 * @since 24 Apr 2016
 */
@SuppressWarnings("MissingClassJavaDoc")
public abstract class ComponentStyleBase<C extends IComponentHierarchyBase, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentStyleBase<C, A, F, E, J>>
		extends ComponentHierarchyBase<C, A, F, E, J>
		implements IComponentStyleBase<J>
{
	/**
	 * Field serialVersionUID
	 */


	/**
	 * The CSS Object for all styling
	 */
	private CSSImpl css;

	/**
	 * The CSS Class name if required
	 */
	private String cssName;

	/**
	 * Container for all the CSS Types
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<CSSTypes, CSSImpl> cssTypeHashMap;

	/**
	 * Constructs a tag with styling options enabled
	 *
	 * @param componentType
	 * 		The type of component this is
	 */
	public ComponentStyleBase(ComponentTypes componentType)
	{
		super(componentType);
	}

	/**
	 * Returns a ComponentStyleBase component of this
	 *
	 * @return This class with only the styling methods
	 */
	@SuppressWarnings("unused")
	@NotNull
	public IComponentStyleBase asStyleBase()
	{
		return this;
	}

	/**
	 * Adds a CSS object to the component with the given type
	 *
	 * @param type
	 * 		The CSS Type
	 * @param cssItem
	 * 		Thee CSS Item to add
	 *
	 * @return Always this object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addCSSEntry(CSSTypes type, CSSImpl cssItem)
	{
		getCssTypeHashMap().put(type, cssItem);
		return (J) this;
	}

	/**
	 * Removes a CSS item for the component
	 *
	 * @param cssType
	 * 		The CSS Type Entry to remove
	 *
	 * @return Always this object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeCSSEntry(CSSTypes cssType)
	{
		getCssTypeHashMap().remove(cssType);
		return (J) this;
	}

	/**
	 * Gets the CSS Object used for styling
	 *
	 * @return The CSS Implementation Object for default (CSSTypes.None)
	 */
	@Override
	@NotNull
	public CSSImpl getCss()
	{
		if (css == null)
		{
			css = new CSSImpl();
			getCssTypeHashMap().put(CSSTypes.None, css);
		}
		return css;
	}

	/**
	 * Sets the CSS Object used for styling
	 *
	 * @param css
	 * 		The CSS Implementation object to add
	 *
	 * @return Always this object
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setCss(CSSImpl css)
	{
		this.css = css;
		return (J) this;
	}

	/**
	 * Returns the currently assigned CSS Name
	 *
	 * @return The currently assigned css Name for this objects style
	 */
	@Override
	@NotNull
	public String getCssName()
	{
		return cssName;
	}

	/**
	 * Sets the currently assigned CSS Name
	 *
	 * @param cssName
	 * 		Sets the CSS Name to a valid value
	 *
	 * @return Always this object
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setCssName(@NotNull String cssName)
	{
		this.cssName = cssName;
		return (J) this;
	}

	/**
	 * Returns the current HashMap of all CSS Entries for the component
	 *
	 * @return The CSS Types and Implementations for each type for this object
	 */
	@Override
	@NotNull
	public Map<CSSTypes, CSSImpl> getCssTypeHashMap()
	{
		if (cssTypeHashMap == null)
		{
			cssTypeHashMap = new EnumMap<>(CSSTypes.class);
		}
		return cssTypeHashMap;
	}

	/**
	 * Renders the component CSS at the specified tab count with the &lt;style&gt; tag
	 * <p>
	 *
	 * @param tabCount
	 * 		Tab indentation for the SQL
	 *
	 * @return The Component CSS
	 */
	@Override
	@NotNull
	public StringBuilder renderCss(int tabCount)
	{
		return renderCss(tabCount, true, false, false);
	}

	/**
	 * Renders the component CSS at the specified tab count with the &lt;style&gt; tag This includes everything from this classes CSS, to
	 * the CSS for each field. It will also populate the lower level
	 * child CSS for fields in this class
	 * <p>
	 *
	 * @param tabCount
	 * 		Tab indentation for the SQL
	 * @param renderOpening
	 * 		Whether or not to render the opening XML tag for a CSS style
	 * @param renderInQuotations
	 * 		Sets whether to render the CSS Fields in Quotations
	 * @param isAjaxCall
	 * 		Sets whether the CSS is being called from an AJAX call
	 * 		<p>
	 *
	 * @return The Component CSS
	 */
	@Override
	@NotNull
	public StringBuilder renderCss(int tabCount, boolean renderOpening, boolean renderInQuotations, boolean isAjaxCall)
	{
		if (!isInitialized())
		{
			init();
		}
		if (!isConfigured())
		{
			preConfigure();
		}
		CSSComposer comp = new CSSComposer();
		comp.addComponent(this, true);
		return new StringBuilder(comp.toString());
	}

	/**
	 * @return hash-int
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param o
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	/**
	 * Method destroy ...
	 */
	@Override
	public void destroy()
	{
		if (cssTypeHashMap != null)
		{
			cssTypeHashMap.clear();
			cssTypeHashMap = null;
		}
		super.destroy();
	}
}
