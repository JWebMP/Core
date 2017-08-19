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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoClassAttribute;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHTMLAttributeBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;

/**
 * Denotes a component that has a tag. By default these can add events, features, variables etc
 *
 * @param <A> The allowed local attributes (Separate from Global Attributes)
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
public class ComponentHTMLAttributeBase<A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLAttributeBase<A, F, E, J>>
        extends ComponentHTMLBase<F, E, J> implements IComponentHTMLAttributeBase<A, J>
{

    /**
     * Serial Version for all Components and their compatibility
     *
     * @version 2 Version 2 - Updated CSS Library and References
     */
    @JsonIgnore
    private static final long serialVersionUID = 1l;

    /**
     * Logger for the Component
     */
    @JsonIgnore
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("ComponentAttributes");

    /**
     * The current stored attribute lists
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> attributes;

    /**
     * Specifies if this component should render an ID attribute
     */
    @JsonIgnore
    private boolean renderIDAttibute = true;

    /**
     * Construct a new component that will render a tag
     *
     * @param componentType
     */
    public ComponentHTMLAttributeBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns an Attribute Base interface of this component
     *
     * @return
     */
    public IComponentHTMLAttributeBase asAttributeBase()
    {
        return (ComponentHTMLAttributeBase) this;
    }

    /**
     * Adds the ID attribute to the component
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            if (isRenderIDAttibute())
            {
                addAttribute(GlobalAttributes.ID, getID());
            }
            else
            {
                removeAttribute(GlobalAttributes.ID);
            }
        }
        super.preConfigure();
    }

    /**
     * Returns the current raw attribute map
     *
     * @return
     */
    protected Map<String, String> getAttributes()
    {
        if (attributes == null)
        {
            attributes = new TreeMap<>();
        }
        return attributes;
    }

    /**
     * Renders all the Attribute HTML. The All Custom attributes can contain any value=parameter pair
     * <p>
     *
     * @return The attribute HTML
     *
     * @see GlobalAttributes
     */
    @Override
    protected StringBuilder renderAttributes(StringBuilder sb)
    {
        StringBuilder sbClasses = renderClasses();
        if (sbClasses.length() > 0 && !(this instanceof NoClassAttribute))
        {
            addAttribute(GlobalAttributes.Class, sbClasses.toString());
        }

        //Build up the string builder
        if (!getAttributes().isEmpty())
        {
            sb.append(" ");
        }
        for (Entry<String, String> entry : getAttributes().entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null)
            {
                continue;
            }
            boolean isKeyword = value.isEmpty();
            if (!isKeyword)
            {
                sb.append(key.toLowerCase()).append("=\"").append(value).append("\" ");
            }
            else
            {
                sb.append(key.toLowerCase()).append(" ");
            }
        }
        if (!getAttributes().isEmpty())
        {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }
        return sb;
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     *
     * @param attribute The Global Attribute to apply
     * @param bop       Place Holder for return type boolean
     * <p>
     *
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final Boolean getAttribute(GlobalAttributes attribute, Boolean bop)
    {
        return Boolean.parseBoolean(getAttributes().get(attribute.toString()));
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     *
     * @param attribute The Global Attribute to apply
     * @param bop       Place Holder for return type integer
     * <p>
     *
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final Integer getAttribute(GlobalAttributes attribute, Integer bop)
    {
        try
        {
            return Integer.parseInt(getAttributes().get(attribute.toString()));
        }
        catch (NumberFormatException | NullPointerException nfe)
        {
            LOG.log(Level.FINE, "Invalid Global Attribute Reference [" + getClass().getSimpleName() + "] - [" + attribute + "]. Ignoring.", nfe);
            return null;
        }
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     *
     * @param attribute The Global Attribute to apply
     * <p>
     *
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final String getAttribute(GlobalAttributes attribute)
    {
        if (getAttributes().get(attribute.toString()) == null)
        {
            getAttributes().put(attribute.toString(), "");
        }

        return getAttributes().get(attribute.toString());
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     *
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     *
     * @return
     */
    @Override
    public final J addAttribute(GlobalAttributes attribute, String value)
    {
        if (attribute == GlobalAttributes.Style)
        {
            getAttributes().put(attribute.toString(), getAttributes().get(attribute) + "" + value);
        }
        getAttributes().put(attribute.toString(), value);

        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     *
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     *
     * @return
     */
    @Override
    public final J addAttribute(A attribute, String value)
    {
        getAttributes().put(attribute.toString(), value);
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     *
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     *
     * @return
     */
    @Override
    public final J addAttribute(A attribute, Integer value)
    {
        getAttributes().put(attribute.toString(), value.toString());
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     *
     * @param attribute The valid Local Attribute to add
     * @param value     The value of the attribute
     *
     * @return
     */
    @Override
    public final J addAttribute(A attribute, Boolean value)
    {
        getAttributes().put(attribute.toString(), value.toString());
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     *
     * @param attribute The valid Local Attribute to add
     * @param value     The value of the attribute
     *
     * @return
     */
    public final J addAttribute(String attribute, String value)
    {
        getAttributes().put(attribute, value);
        return (J) this;
    }

    /**
     * Gets this list of local attribute values
     * <p>
     *
     * @param attributeValue The Valid Local Attribute to Return
     * <p>
     *
     * @return A String of the attribute value currently set
     */
    @Override
    public String getAttribute(A attributeValue)
    {
        String s = getAttributes().get(attributeValue.toString());
        if (s == null)
        {
            s = "";
        }
        return s;
    }

    /**
     * Gets this list of local attribute values
     * <p>
     *
     * @param attributeValue The Valid Local Attribute to Return
     * @param uselessInt     A useless parameter purely to return the type integer
     * <p>
     *
     * @return A HashMap if this components local attributes. Never null
     */
    @Override
    public Integer getAttribute(A attributeValue, Integer uselessInt)
    {
        String s = getAttributes().get(attributeValue.toString());
        if (s == null)
        {
            s = "0";
        }
        return new Integer(s);
    }

    /**
     * Gets this list of local attribute values
     * <p>
     *
     * @param attributeValue The Valid Local Attribute to Return
     * @param uselessInt     A useless parameter purely to return the type Boolean
     * <p>
     *
     * @return A HashMap if this components local attributes. Never null
     */
    @Override
    public Boolean getAttribute(A attributeValue, Boolean uselessInt)
    {
        String s = getAttributes().get(attributeValue.toString());
        if (s == null)
        {
            s = "false";
        }
        return Boolean.valueOf(s);
    }

    /**
     * Returns if this component should render for the ID attribute
     * <p>
     *
     * @return
     */
    protected boolean isRenderIDAttibute()
    {
        if (!renderIDAttibute || (this instanceof NoIDTag))
        {
            return false;
        }
        else
        {
            return renderIDAttibute;
        }
    }

    /**
     * Sets if this component should render an ID attribute
     * <p>
     *
     * @param renderIDAttibute
     *
     * @return
     */
    protected J setRenderIDAttibute(boolean renderIDAttibute)
    {
        this.renderIDAttibute = renderIDAttibute;
        if (!renderIDAttibute)
        {
            getAttributes().remove(GlobalAttributes.ID);
        }
        return (J) this;
    }

    /**
     * Renders the classes array as an in-line class string
     *
     * @return
     */
    protected StringBuilder renderClasses()
    {
        return new StringBuilder();
    }

    /**
     * Sets the ID and adds the attribute to the global set
     *
     * @param id
     *
     * @return
     */
    @Override
    public J setID(String id)
    {
        addAttribute(GlobalAttributes.ID, id);
        return super.setID(id);
    }

    @Override
    public J cloneComponent()
    {
        ComponentHTMLAttributeBase cloned = (ComponentHTMLAttributeBase) super.cloneComponent();

        cloned.attributes = new TreeMap();
        cloned.attributes.putAll(getAttributes());

        return (J) cloned;
    }

    /**
     * Shortcut to adding a style attribute
     *
     * @param style
     *
     * @return
     */
    public J addStyle(String style)
    {
        if (!style.endsWith(";"))
        {
            style += ";";
        }
        if (getAttributes().get("style") == null)
        {
            addAttribute("style", style);
        }
        else
        {
            addAttribute("style", getAttributes().get("style") + style);
        }
        return (J) this;
    }
    
    /**
     * Removes an attribute
     * @param key
     * @return
     */
    public J removeAttribute(String key)
    {
        getAttributes().remove(key);
        return (J)this;
    }
    
    /**
     * Removes a key from the attribute set
     * @param key
     * @return
     */
    public J removeAttribute(GlobalAttributes key)
    {
        getAttributes().remove(key.toString());
        return (J)this;
    }
    
    /**
     * Removes a key from the attribute set
     * @param key
     * @return
     */
    public J removeAttribute(A key)
    {
        getAttributes().remove(key.toString());
        return (J)this;
    }
    
    @Override
    public void destroy()
    {
        if (this.attributes != null)
        {
            this.attributes.clear();
            attributes = null;
        }
        super.destroy();
    }

}
