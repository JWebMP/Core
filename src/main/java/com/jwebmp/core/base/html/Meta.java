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
package com.jwebmp.core.base.html;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.attributes.MetaAttributes;
import com.jwebmp.core.base.html.interfaces.*;
import com.jwebmp.core.base.html.interfaces.children.HeadChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.guicedee.logger.LogFactory;
import jakarta.validation.constraints.NotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Meta Component.
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The base tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The base tag specifies the base URL/target for all relative URLs in a<p>
 * document.<p>
 * <p>
 * There can be at maximum one base element in a document, and it must be<p>
 * inside the head element. Tips and Notes<p>
 * <p>
 * Tip: Put the base tag as the first element inside the head element, so<p>
 * that other elements in the head section uses the information from the base<p>
 * element.<p>
 * <p>
 * Note: If the base tag is present, it must have either an href attribute or<p>
 * a target attribute, or both.<p>
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/11/12
 */
public class Meta<C extends IComponentHierarchyBase & GlobalChildren>
		extends ComponentHierarchyBase<C, MetaAttributes, NoFeatures, NoEvents, Meta<C>>
		implements NoIDTag, NoClosingTag, HeadChildren<C, Meta<C>>, NoClassAttribute, NoNewLineBeforeClosingTag
{


	private static Logger log = LogFactory.getInstance()
	                                      .getLogger("<META>");

	/**
	 * Constructs an empty Meta tag
	 */
	public Meta()
	{
		super(ComponentTypes.Metadata);
	}

	/**
	 * Creates a Meta tag of HTTP Equiv with the custom name
	 *
	 * @param httpEquivName
	 */
	public Meta(String httpEquivName)
	{
		super(ComponentTypes.Metadata);
		addAttribute(MetaAttributes.Http_Equiv, httpEquivName);
	}

	/**
	 * Constructs a Meta tag
	 *
	 * @param field
	 * 		The MetaData tag to generate
	 * @param value
	 * 		doh
	 */
	public Meta(MetadataFields field, String value)
	{
		super(ComponentTypes.Metadata);
		switch (field)
		{
			case http_equiv:
			{
				addAttribute(MetaAttributes.Http_Equiv, MetadataFields.http_equiv.getDataNameField());
				addAttribute(MetaAttributes.Http_Equiv, value);
				break;
			}
			case Author:
			{

				addAttribute(MetaAttributes.Content, value);
				addAttribute(MetaAttributes.Name, MetadataFields.Author.getDataNameField());
				break;
			}
			case Description:
			{

				addAttribute(MetaAttributes.Content, value);
				addAttribute(MetaAttributes.Name, MetadataFields.Description.getDataNameField());
				break;
			}
			case ViewPort:
			{

				addAttribute(MetaAttributes.Content, value);
				addAttribute(MetaAttributes.Name, MetadataFields.ViewPort.getDataNameField());
				break;
			}
			case Keywords:
			{
				addAttribute(MetaAttributes.Content, value);
				addAttribute(MetaAttributes.Name, MetadataFields.Keywords.getDataNameField());
				break;
			}
			default:
			{
				break;
			}
		}
		if (field == MetadataFields.http_equiv)
		{
			addAttribute(MetaAttributes.Http_Equiv, field.getDataNameField());
		}
		else
		{
			addAttribute(MetaAttributes.Name, field.getDataNameField());
		}
		addAttribute(MetaAttributes.Content, value);
		setTiny(true);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Meta)
		{
			Meta<?> m = (Meta<?>) o;
			return getAttributes().entrySet()
			                      .equals(m.getAttributes()
			                               .entrySet());
		}
		return false;
	}

	/**
	 * Differences Between HTML and XHTML
	 * <p>
	 * In HTML the base tag has no end tag.
	 * <p>
	 * In XHTML the base tag must be properly closed.
	 */
	@Override
	public void preConfigure()
	{
		try
		{
			if (getPage().getHtmlVersion()
			             .name()
			             .startsWith("X"))
			{
				setInlineClosingTag(true);
			}
		}
		catch (Exception e)
		{
			Meta.log.log(Level.FINE, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
		}
	}

	/**
	 * A set list of fields available to the Meta tag
	 */
	public enum MetadataFields
	{

		Application_Name("application-name"),
		Generator("generator"),
		Author("author"),
		Keywords("keywords"),
		Description("description"),
		ViewPort("viewport"),
		http_equiv("X-UA-Compatible"),
		Name("name");

		private String dataNameField;

		/**
		 * Doh
		 *
		 * @param dataNameField
		 */
		MetadataFields(String dataNameField)
		{
			this.dataNameField = dataNameField;
		}

		/**
		 * Returns this tags data name field
		 *
		 * @return
		 */
		public String getDataNameField()
		{
			return dataNameField;
		}

		/**
		 * Sets this fields dataset name Useful.
		 *
		 * @param dataNameField
		 * 		The name to set the field
		 */
		public void setDataNameField(String dataNameField)
		{
			this.dataNameField = dataNameField;
		}
	}

	@Override
	public @NotNull Integer getSortOrder()
	{
		if(getAttributes().containsKey("charset"))
			return 0;

		if(getAttributes().containsValue("viewport"))
		{
			return 3;
		}

		if(getAttributes().containsValue("Content-Security-Policy"))
		{
			return Integer.MAX_VALUE - 2;
		}

		return super.getSortOrder();
	}
}
