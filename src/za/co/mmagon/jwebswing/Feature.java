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
package za.co.mmagon.jwebswing;

import za.co.mmagon.jwebswing.base.ComponentFeatureBase;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.exceptions.NullComponentException;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Container Class for Features.
 * Splits from the hierarchy
 *
 * @author GedMarc
 * @param <O> Any options associated with this feature
 * @param <J> This Class
 * @since 23 Apr 2016
 */
public class Feature<O extends JavaScriptPart, J extends Feature>
        extends ComponentFeatureBase<NoFeatures, J>
        implements GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    /**
     * The options object associated with this feature
     */
    private O options;

    /**
     * Constructs a feature that can be used with all components
     *
     * @param name
     */
    public Feature(String name)
    {
        super(ComponentTypes.Feature);
        setName(name);
    }

    /**
     * Constructs a feature that can be used with all components
     *
     * @param name
     */
    public Feature(String name, ComponentHierarchyBase component)
    {
        super(ComponentTypes.Feature);
        setName(name);
        setComponent(component);
    }

    /**
     * Returns any client side options available with this component
     *
     * @return
     */
    @Override
    public O getOptions()
    {
        return options;
    }

    /**
     * Sets the options object
     *
     * @param options
     */
    public void setOptions(O options)
    {
        this.options = options;
    }

    /**
     * Adds a query to builder
     *
     * @param query
     */
    public J addQuery(StringBuilder query)
    {
        if (!getQueries().contains(query))
        {
            getQueries().add(query);
        }
        return (J) this;
    }

    /**
     * Adds a query to builder
     *
     * @param query
     * @return 
     */
    public J addQuery(String query)
    {
        StringBuilder sb = new StringBuilder(query);
        if (!getQueries().contains(sb))
        {
            getQueries().add(new StringBuilder(query));
        }
        return (J) this;
    }

    /**
     * Any work that needs to get done pre render
     */
    @Override
    protected void assignFunctionsToComponent()
    {

    }

    /**
     * Returns the linked component if required
     *
     * @return
     */
    public ComponentHierarchyBase getComponent()
    {
        return component;
    }

    /**
     * Sets the linked component if required
     *
     * @param component
     */
    public void setComponent(ComponentHierarchyBase component)
    {
        if (component == null)
        {
            throw new NullComponentException("A Feature cannot be configured on a null component");
        }
        this.component = component;
    }
}
