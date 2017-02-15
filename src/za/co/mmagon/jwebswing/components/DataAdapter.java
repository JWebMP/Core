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
package za.co.mmagon.jwebswing.components;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 * This Class is a data adapter
 *
 * @author GedMarc
 * @param <C> The specified global children
 * @param <A> The given component data adapaters
 * @param <F> The given features
 * @param <E> The given events
 * @param <J> This component
 *
 * @since 01 Jan 2016
 */
public class DataAdapter<C extends GlobalChildren, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends DataAdapter>
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
        //this.linkedComponent = linkedComponent;
        setLinkedComponent(linkedComponent);
    }

    public String getDataAdapterID()
    {
        return dataAdapterID;
    }

    public final void setDataAdapterID(String dataAdapterID)
    {
        this.dataAdapterID = dataAdapterID;
    }

    @JsonRawValue
    @JsonValue
    public String getDAID()
    {
        return dataAdapterID;
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
}
