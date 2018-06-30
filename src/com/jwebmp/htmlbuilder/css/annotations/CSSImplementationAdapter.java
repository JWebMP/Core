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
package com.jwebmp.htmlbuilder.css.annotations;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.htmlbuilder.css.CSSPropertiesFactory;
import com.jwebmp.logger.LogFactory;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.logging.Level;

/**
 * @param <A>
 * 		The annotation type
 * @param <T>
 * 		The implementation class type
 *
 * @author GedMarc
 * @version 1.0
 * @since Nov 19, 2016
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
		getterVisibility = JsonAutoDetect.Visibility.NONE,
		setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CSSImplementationAdapter<A extends Annotation, T extends CSSImplementationClass>
		implements CSSImplementationClass<A, T>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The default adapter
	 */
	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("CSSImpAdapter");
	/**
	 * The properties factory
	 */
	private CSSPropertiesFactory<A> propertyFactory;

	/**
	 * For implementing generic methods on CSS
	 */
	public CSSImplementationAdapter()
	{
		//Nothing Needed
	}

	/**
	 * From annotation
	 *
	 * @param annotation
	 * 		The annotation to pull from
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T fromAnnotation(A annotation)
	{
		T newInstance = null;
		try
		{

			Map<StringBuilder, Object> fieldMapping = getPropertyFactory().getCSS(annotation);
			newInstance = (T) getPropertyFactory().getImplementationObject(annotation, fieldMapping);
			return newInstance;
		}
		catch (Exception ex)
		{
			log.log(Level.SEVERE, "[Field Populator]-[Failed];[Object]-[" + newInstance + "]", ex);
		}
		return null;
	}

	/**
	 * Returns the properties factory
	 *
	 * @return
	 */
	protected CSSPropertiesFactory<A> getPropertyFactory()
	{
		if (propertyFactory == null)
		{
			propertyFactory = new CSSPropertiesFactory<>();
		}
		return propertyFactory;
	}

	/**
	 * Sets the properties factory
	 *
	 * @param propertyFactory
	 */
	protected void setPropertyFactory(CSSPropertiesFactory propertyFactory)
	{
		this.propertyFactory = propertyFactory;
	}

	/**
	 * Returns the object map
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<StringBuilder, Object> getMap()
	{
		CSSPropertiesFactory props = new CSSPropertiesFactory();
		return props.getCSSProperties(this);
	}

	@Override
	public String toString()
	{
		try
		{
			return GuiceContext.getInstance(ObjectMapper.class)
			                   .writeValueAsString(this);
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Error in IMPL Object", e);
			return "Can't Render JSON!";
		}
	}

}
