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

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import java.util.logging.Level;
import za.co.mmagon.jwebswing.base.interfaces.IComponentBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.utilities.GUIDGenerator;
import za.co.mmagon.logger.LogFactory;

/**
 * Defines the raw necessities for a component to exist
 *
 * @param <J> Component output for cloning. Always make it this class to make life easy
 *
 * @author GedMarc
 * @since 22 Apr 2016
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComponentBase<J extends ComponentBase>
        implements IComponentBase<J>
{

    /**
     * Logger for the Component
     */
    @JsonIgnore
    protected static final java.util.logging.Logger logShell = LogFactory.getLog("ComponentBase");

    /**
     * Serial Version for all Components and their compatibility
     *
     * @version 2 Version 2 - Updated CSS Library and References
     */
    @JsonIgnore
    private static final long serialVersionUID = 1l;

    /**
     * The ID of the component rendering for
     */
    private String id;

    /**
     * The enumeration component type associated with this class to escape the use of "instance of" statements. performance thing
     */
    private ComponentTypes componentType;

    /**
     * Any raw text that should be built into this component. Rendered before children
     */
    private String text;

    /**
     * Specifies if this component should render as small as possible
     */
    private boolean tiny;
    /**
     * Whether this component has been configured or not
     */
    private boolean configured;
    /**
     * Initialized flag
     */
    private boolean initialized;
    /**
     * Sets if this component should be sent on the next call back
     */
    private boolean touched = false;
    /**
     * A set of properties for this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private HashMap<String, Object> properties;

    /**
     * Constructs a new Component Shell
     *
     * @param componentType
     */
    public ComponentBase(ComponentTypes componentType)
    {
        this.id = GUIDGenerator.generateGuid();
        this.componentType = componentType;
    }

    /**
     * Returns an Attribute Base interface of this component
     *
     * @return
     */
    public IComponentBase asBase()
    {
        return (ComponentBase) this;
    }

    /**
     * Gets the ID of this component
     * <p>
     * @return The ID of this component
     */
    @Override
    public String getID()
    {
        return this.id;
    }

    /**
     * Returns the ID with the # in the front of it
     * <p>
     * @param jQueryHolder Anything
     * <p>
     * @return An ID starting with #
     */
    @Override
    public String getID(boolean jQueryHolder)
    {
        return "#" + this.id;
    }

    /**
     * Returns the component rendering for JQuery string Requires the rendering for component is set
     * <p>
     * @return $('#x').
     */
    @Override
    public String getJQueryID()
    {
        return "$(\'" + getID(true) + "\').";
    }

    /**
     * Sets the ID of this component
     * <p>
     * @param id The ID
     */
    @Override
    public J setID(String id)
    {
        this.id = id;
        return (J) this;
    }

    /**
     * Gets this components enumeration
     * <p>
     * @return The Component Enumeration of this component
     */
    protected ComponentTypes getComponentType()
    {
        return componentType;
    }

    /**
     * Sets this components enumeration. Currently little more than an easy to compare Enum
     * <p>
     * @param componentType The component to mimic
     *
     * @return
     */
    protected J setComponentType(ComponentTypes componentType)
    {
        this.componentType = componentType;
        return (J) this;
    }

    /**
     * Appends the text used as raw text outside the tags to the incoming StringBuilder
     * <p>
     * @param sb The StringBuilder to append to
     * <p>
     * @return The current set Raw Text
     */
    protected StringBuilder getText(StringBuilder sb)
    {
        if (text == null)
        {
            return new StringBuilder();
        }
        else
        {
            sb.append(text);
            return sb;
        }
    }

    /**
     * returns a new StringSuilder of the raw text with the specific tab counts
     * <p>
     * @param tabCounts <p>
     * @return
     */
    @Override
    public StringBuilder getText(int tabCounts)
    {
        StringBuilder sb = new StringBuilder();
        getText(sb);
        return sb;
    }

    /**
     * Sets this components Raw Text
     * <p>
     * @param text The text to display as Raw Text
     */
    @Override
    public J setText(String text)
    {
        this.text = text;
        return (J) this;
    }

    /**
     * Sets this components Raw Text
     * <p>
     * @param text The text to display as Raw Text
     */
    @Override
    public J setText(StringBuilder text)
    {
        this.text = text.toString();
        return (J) this;
    }

    /**
     * Clones this component and assigns a new ID
     * <p>
     * @return The cloned component
     */
    @Override
    public J cloneComponent()
    {
        J component = null;
        try
        {
            component = (J) this.clone();
            component.setID(GUIDGenerator.generateGuid());
        }
        catch (CloneNotSupportedException ex)
        {
            logShell.log(Level.SEVERE, "Cloning Error in Shell", ex);
        }
        return component;
    }

    /**
     * Specifies whether or not to render this component in a Production/QA fashion
     * <p>
     * @return If this component will render in production mode
     */
    @Override
    public boolean isTiny()
    {
        return this.tiny;
    }

    /**
     * If this component will render as tiny HTML. Global override value
     * <p>
     * @param tiny Set if this component must render as tiny HTML. Does not affect CSS or JavaScript rendering
     */
    @Override
    public J setTiny(boolean tiny)
    {
        this.tiny = tiny;
        return (J) this;
    }

    /**
     * Returns the new line character according to Running Environment
     * <p>
     * @return A new line if is in development mode
     */
    @Override
    public String getNewLine()
    {
        if (!isTiny())
        {
            return "\n";
        }
        else
        {
            return "";
        }
    }

    /**
     * Run-Once on creation Executes a piece of code before running any rendering. Call super after your changes Marks the component as configured
     */
    @Override
    public void preConfigure()
    {
        setConfigured(true);
    }

    /**
     * If this component is already configured
     *
     * @return
     */
    @Override
    public boolean isConfigured()
    {
        return configured;
    }

    /**
     * If this component is already configured
     *
     * @param configured
     */
    @Override
    public J setConfigured(boolean configured)
    {
        this.configured = configured;
        return (J) this;
    }

    /**
     * Returns a map of user defined properties for this component
     *
     * @return
     */
    @Override
    public Map<String, Object> getProperties()
    {
        if (properties == null)
        {
            properties = new HashMap<>();
        }
        return properties;
    }

    /**
     * Sets this components user defined properties
     *
     * @param properties
     */
    @Override
    public J setProperties(HashMap<String, Object> properties)
    {
        this.properties = properties;
        return (J) this;
    }

    /**
     * Default HashCode over-ride
     *
     * @return
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.componentType);
        hash = 23 * hash + Objects.hashCode(this.text);
        return hash;
    }

    /**
     * Default equals for a component
     *
     * @param obj The incoming object
     *
     * @return True if the ID, Type and Text are the same
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final ComponentBase<?> other = (ComponentBase<?>) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        if (!Objects.equals(this.text, other.text))
        {
            return false;
        }
        return this.componentType == other.componentType;
    }

    /**
     * Renders the component as a JSON Object
     *
     * @return
     */
    @Override
    public String toString()
    {
        if (!isConfigured())
        {
            init();
            preConfigure();
        }
        return JavaScriptPart.objectAsString(this);
    }

    /**
     * Runs before anything Can be used as constructor intializations.
     */
    public void init()
    {
        setInitialized(true);
    }

    /**
     * If this component has been initialized
     *
     * @return
     */
    public boolean isInitialized()
    {
        return initialized;
    }

    /**
     * If this component has been initialized
     *
     * @param initialized
     *
     * @return
     */
    public J setInitialized(boolean initialized)
    {
        this.initialized = initialized;
        return (J) this;
    }

    /**
     * Returns if this component is needing refresh on next Ajax call
     * <p>
     * @return true if going to be touched
     */
    @Override
    public boolean isTouched()
    {
        return touched;
    }

    /**
     * Mark this component as needing refresh to the Ajax Controller
     * <p>
     * @param touched Whether or not to update on next ajax call
     *
     * @return
     */
    @Override
    public J setTouched(boolean touched)
    {
        this.touched = touched;
        return (J) this;
    }

    /**
     * For JSON Reconstruction
     *
     * @return
     */
    @JsonProperty("componentClass")
    protected String getComponentClass()
    {
        return getClass().getCanonicalName();
    }

    /**
     * If the component has a property attached
     *
     * @param propertyName
     *
     * @return
     */
    public boolean hasProperty(String propertyName)
    {
        return getProperties().containsKey(propertyName);
    }

    /**
     * Returns a specific property in toString form
     *
     * @param propertyName
     *
     * @return
     */
    public String getProperty(String propertyName)
    {
        return getProperties().get(propertyName).toString();
    }
}
