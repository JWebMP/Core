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
import java.util.Map.Entry;
import java.util.*;
import java.util.logging.Level;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.ComponentHTMLBase;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHTMLAttributeBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.generics.Pair;
import za.co.mmagon.logger.LogFactory;

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
public class ComponentHTMLAttributeBase<A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLAttributeBase>
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
     * The SORTED global attribute collection of this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TreeMap<GlobalAttributes, String> attributesGlobal;
    /**
     * The generic list of the attributes that are local to this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TreeMap<A, String> attributesLocal;
    /**
     * The custom list of the attributes that are local to this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TreeMap<String, String> attributesCustom;

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
     * Returns the list of global attributes currently assigned
     *
     * @return
     */
    protected Map<GlobalAttributes, String> getAttributesGlobal()
    {
        if (attributesGlobal == null)
        {
            attributesGlobal = new TreeMap<>();
        }
        return attributesGlobal;
    }

    /**
     * Returns the local set of attributes currently assigned
     *
     * @return
     */
    protected Map<A, String> getAttributes()
    {
        if (attributesLocal == null)
        {
            attributesLocal = new TreeMap<>();
        }
        return attributesLocal;
    }

    /**
     * Returns the list of global attributes currently assigned
     *
     * @return
     */
    protected Map<String, String> getAttributesCustom()
    {
        if (attributesCustom == null)
        {
            attributesCustom = new TreeMap<>();
        }
        return attributesCustom;
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
                getAttributesGlobal().remove(GlobalAttributes.ID);
            }
        }
        super.preConfigure();
    }

    /**
     * Returns a complete collection of attributes
     *
     * @return
     */
    @Override
    public Map<Enum, String> getAttributesAll()
    {
        HashMap<Enum, String> allAttributes = new HashMap<>();

        for (Entry<GlobalAttributes, String> entry : getAttributesGlobal().entrySet())
        {
            GlobalAttributes key = entry.getKey();
            String value = entry.getValue();
            allAttributes.put(key, value);
        }
        allAttributes.putAll(getAttributes());

        return allAttributes;
    }

    /**
     * Renders all the Attribute HTML. The All Custom attributes can contain any value=parameter pair
     * <p>
     * @see GlobalAttributes
     * @return The attribute HTML
     */
    @Override
    protected StringBuilder renderAttributes(StringBuilder sb)
    {
        StringBuilder sbClasses = renderClasses();
        if (sbClasses.length() > 0 && !(this instanceof NoClassAttribute))
        {
            getAttributesGlobal().put(GlobalAttributes.Class, sbClasses.toString());
        }

        Map<Pair<String, Boolean>, String> attributeMap = new TreeMap<>();

        Map<Enum, String> allDefinedAttributes = getAttributesAll();

        for (Entry<Enum, String> entry : allDefinedAttributes.entrySet())
        {
            Enum key = entry.getKey();
            String value = entry.getValue();
            if (AttributeDefinitions.class.isAssignableFrom(key.getClass()))
            {
                AttributeDefinitions ad = AttributeDefinitions.class.cast(key);
                Pair p = new Pair(key.toString(), ad.isKeyword());
                attributeMap.put(p, value);
            }
            else
            {
                String keyValue = key.toString();
                if (value != null && !value.isEmpty())
                {
                    attributeMap.put(new Pair(keyValue, false), value);
                }
                else
                {
                    attributeMap.put(new Pair(keyValue, true), value);
                }
            }
        }

        for (Entry<String, String> entry : getAttributesCustom().entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            boolean isKeyword = value == null || value.trim().isEmpty();

            Pair p = new Pair(key, isKeyword);
            attributeMap.put(p, value);
        }

        if (!attributeMap.isEmpty())
        {
            sb.append(" ");
        }

        attributeMap.entrySet().forEach(entry ->
        {
            Pair<String, Boolean> key = entry.getKey();
            String value = entry.getValue();

            sb.append(key.getLeft().toLowerCase());
            if (!key.getRight())
            {
                sb.append("=\"").append(value).append("\" ");
            }
            else
            {
                sb.append(" ");
            }
        });
        if (!attributeMap.isEmpty())
        {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }

        return sb;
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     * @param attribute The Global Attribute to apply
     * @param bop       Place Holder for return type boolean
     * <p>
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final Boolean getAttribute(GlobalAttributes attribute, Boolean bop)
    {
        return Boolean.parseBoolean(getAttributesGlobal().get(attribute));
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     * @param attribute The Global Attribute to apply
     * @param bop       Place Holder for return type integer
     * <p>
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final Integer getAttribute(GlobalAttributes attribute, Integer bop)
    {
        try
        {
            return Integer.parseInt(getAttributesGlobal().get(attribute));
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
     * @param attribute The Global Attribute to apply
     * <p>
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final String getAttribute(GlobalAttributes attribute)
    {
        if (getAttributesGlobal().get(attribute) == null)
        {
            getAttributesGlobal().put(attribute, "");
        }

        return getAttributesGlobal().get(attribute);
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
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
            getAttributesGlobal().put(attribute, getAttributesGlobal().get(attribute) + "" + value);
        }
        getAttributesGlobal().put(attribute, value);

        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     *
     * @return
     */
    @Override
    public final J addAttribute(A attribute, String value)
    {
        getAttributes().put(attribute, value);
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     *
     * @return
     */
    @Override
    public final J addAttribute(A attribute, Integer value)
    {
        getAttributes().put(attribute, value.toString());
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The valid Local Attribute to add
     * @param value     The value of the attribute
     *
     * @return
     */
    @Override
    public final J addAttribute(A attribute, Boolean value)
    {
        getAttributes().put(attribute, value.toString());
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The valid Local Attribute to add
     * @param value     The value of the attribute
     *
     * @return
     */
    public final J addAttribute(String attribute, String value)
    {
        getAttributesCustom().put(attribute, value);
        return (J) this;
    }

    /**
     * Gets this list of local attribute values
     * <p>
     * @param attributeValue The Valid Local Attribute to Return
     * <p>
     * @return A String of the attribute value currently set
     */
    @Override
    public String getAttribute(A attributeValue)
    {
        String s = getAttributes().get(attributeValue);
        if (s == null)
        {
            s = "";
        }
        return s;
    }

    /**
     * Gets this list of local attribute values
     * <p>
     * @param attributeValue The Valid Local Attribute to Return
     * @param uselessInt     A useless parameter purely to return the type integer
     * <p>
     * @return A HashMap if this components local attributes. Never null
     */
    @Override
    public Integer getAttribute(A attributeValue, Integer uselessInt)
    {
        String s = getAttributes().get(attributeValue);
        if (s == null)
        {
            s = "0";
        }
        return new Integer(s);
    }

    /**
     * Gets this list of local attribute values
     * <p>
     * @param attributeValue The Valid Local Attribute to Return
     * @param uselessInt     A useless parameter purely to return the type Boolean
     * <p>
     * @return A HashMap if this components local attributes. Never null
     */
    @Override
    public Boolean getAttribute(A attributeValue, Boolean uselessInt)
    {
        String s = getAttributes().get(attributeValue);
        if (s == null)
        {
            s = "false";
        }
        return Boolean.valueOf(s);
    }

    /**
     * Sets if this component should render an ID attribute
     * <p>
     * @param renderIDAttibute
     *
     * @return
     */
    protected J setRenderIDAttibute(boolean renderIDAttibute)
    {
        this.renderIDAttibute = renderIDAttibute;
        if (!renderIDAttibute)
        {
            getAttributesGlobal().remove(GlobalAttributes.ID);
        }
        return (J) this;
    }

    /**
     * Returns if this component should render for the ID attribute
     * <p>
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
        getAttributesGlobal().put(GlobalAttributes.ID, id);
        return super.setID(id);
    }

    @Override
    public J cloneComponent()
    {
        ComponentHTMLAttributeBase cloned = (ComponentHTMLAttributeBase) super.cloneComponent();

        cloned.attributesGlobal = new TreeMap();
        cloned.attributesLocal = new TreeMap();
        cloned.attributesGlobal.putAll(getAttributesGlobal());
        cloned.attributesLocal.putAll(getAttributes());

        return (J) cloned;
    }

}
