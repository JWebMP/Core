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
import java.util.HashMap;
import java.util.Map;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHTMLAngularBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Enables Angular
 *
 * @param <A> The allowed local attributes (Separate from Global Attributes)
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
public class ComponentHTMLAngularBase<A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLAngularBase>
        extends ComponentHTMLAttributeBase<A, F, E, J> implements IComponentHTMLAngularBase<J>
{

    private static final long serialVersionUID = 1L;

    /**
     * All the angular attributes for this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<AngularAttributes, String> attributesAngular;
    /**
     * All the angular DTO objects for this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, JavaScriptPart> angularObjects;

    /**
     * Constructs a new component with the angular features enabled
     *
     * @param componentType
     */
    public ComponentHTMLAngularBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns an Angular Base interface of this component
     *
     * @return
     */
    public IComponentHTMLAngularBase asAngularBase()
    {
        return (ComponentHTMLAngularBase) this;
    }

    /**
     * Sets an Angular Attribute
     *
     * @param attribute
     * @param value
     *
     * @return
     */
    @Override
    public J addAttribute(AngularAttributes attribute, String value)
    {
        getAttributesAngular().put(attribute, value);
        return (J) this;
    }

    /**
     * Gets an angular attribute
     *
     * @param attribute
     *
     * @return
     */
    @Override
    public String getAttribute(AngularAttributes attribute)
    {
        return getAttributesAngular().get(attribute);
    }

    /**
     * Returns all the angular attributes on this component
     *
     * @return
     */
    private Map<AngularAttributes, String> getAttributesAngular()
    {
        if (attributesAngular == null)
        {
            attributesAngular = new HashMap<>();
            AngularPageConfigurator.setRequired(this, true);
        }
        return attributesAngular;
    }

    /**
     * Adds an object for watching across an application
     *
     * @param name       The variable name to use
     * @param dataObject The data object to map
     *
     * @return This for chain setting
     */
    @Override
    public J addDto(String name, JavaScriptPart dataObject)
    {
        dataObject.setOwnerId(getID());
        getAngularObjects().put(name, dataObject);
        return (J) this;
    }

    /**
     * Returns the DTO currently mapped
     *
     * @param <T>       The type to return
     * @param name      The name of the DTO to map
     * @param classType The class type
     *
     * @return Null if not available
     */
    @Override
    public <T extends JavaScriptPart> T getDto(String name, Class<T> classType)
    {
        T jp = (T) getAngularObjects().get(name);
        return jp;
    }

    /**
     * Returns the angular objects mapped to this component
     *
     * @return
     */
    @Override
    public Map<String, JavaScriptPart> getAngularObjects()
    {
        if (angularObjects == null)
        {
            angularObjects = new HashMap<>();
            AngularPageConfigurator.setRequired(this, true);
        }
        return angularObjects;
    }

    /**
     * Adds all the attributes associated with angular
     *
     * @return
     */
    @Override
    public Map<Enum, String> getAttributesAll()
    {
        HashMap<Enum, String> allAttributes = (HashMap<Enum, String>) super.getAttributesAll();
        getAttributesAngular().entrySet().stream().filter(a -> a != null).forEach((entry)
                ->
        {
            AngularAttributes key = entry.getKey();
            String value = entry.getValue();
            allAttributes.put(key, value);
        });
        return allAttributes;
    }

    /**
     * Binds this component to an angular variable. If it is an input is it bound directly, otherwise the text is set to what the variable contains
     * <p>
     * Over-ride this to apply more functionality such as calendar binding
     *
     * @param variableName
     *
     * @return
     */
    public J bind(String variableName)
    {
        addAttribute(AngularAttributes.ngBind, variableName);
        AngularPageConfigurator.setRequired(this, true);
        return (J) this;
    }

    /**
     * Instructs Angular to not show items that are bound until after the digest sequence
     *
     * @return
     */
    public J cloak()
    {
        addAttribute(AngularAttributes.ngCloak, null);
        AngularPageConfigurator.setRequired(this, true);
        return (J) this;
    }

}
