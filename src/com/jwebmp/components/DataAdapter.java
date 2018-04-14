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
package com.jwebmp.components;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.Component;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.base.html.interfaces.GlobalChildren;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;

/**
 * This Class is a data adapter
 *
 * @param <C>
 * 		The specified global children
 * @param <A>
 * 		The given component data adapaters
 * @param <F>
 * 		The given features
 * @param <E>
 * 		The given events
 * @param <J>
 * 		This component
 *
 * @author GedMarc
 * @since 01 Jan 2016
 */
public class DataAdapter<C extends GlobalChildren, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends DataAdapter<C, A, F, E, J>>
		extends Div<C, A, F, E, J>
{

	private static final long serialVersionUID = 1L;
	private Component linkedComponent;
	private String dataAdapterID;

	/**
	 * The component this data adapter should render on
	 *
	 * @param linkedComponent
	 */
	public DataAdapter(Component linkedComponent)
	{
		setLinkedComponent(linkedComponent);
	}

	@JsonRawValue
	@JsonValue
	public String getDAID()
	{
		return dataAdapterID;
	}

	/**
	 * Returns only this data adapters ID for the JSON rendering
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return getDAID();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof DataAdapter))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		DataAdapter<?, ?, ?, ?, ?> that = (DataAdapter<?, ?, ?, ?, ?>) o;

		if (!getLinkedComponent().equals(that.getLinkedComponent()))
		{
			return false;
		}
		return getDataAdapterID() != null ? getDataAdapterID().equals(that.getDataAdapterID()) : that.getDataAdapterID() == null;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + getLinkedComponent().hashCode();
		result = 31 * result + (getDataAdapterID() != null ? getDataAdapterID().hashCode() : 0);
		return result;
	}

	/**
	 * Gets the component this adapter is added to
	 *
	 * @return
	 */
	public Component getLinkedComponent()
	{
		return linkedComponent;
	}

	public String getDataAdapterID()
	{
		return dataAdapterID;
	}

	public final void setDataAdapterID(String dataAdapterID)
	{
		this.dataAdapterID = dataAdapterID;
	}

	/**
	 * Sets the component this data adapter is linked to
	 *
	 * @param linkedComponent
	 */
	public final void setLinkedComponent(Component linkedComponent)
	{
		if (this.linkedComponent != null)
		{
			this.linkedComponent.removeVariable(getDAID());
		}
		this.linkedComponent = linkedComponent;
		if (linkedComponent != null)
		{
			setDataAdapterID("da" + linkedComponent.getID());
			linkedComponent.addVariable(getDAID());
		}
	}
}
