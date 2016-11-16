/*
 * Copyright (C) 2016 ged_m
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
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import za.co.mmagon.jwebswing.CSSComponent;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Provides the Hierarchy for any component. Manages children and parent relationships
 *
 * @author GedMarc
 * @param <C> All allowed children
 * @param <A> All attributes for this component
 * @param <F> All features allowed for this component
 * @param <E> All events allowed for this component
 * @param <J> Always this class
 * @since 24 Apr 2016
 */
public class ComponentHierarchyBase<C, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentBase>
        extends ComponentThemeBase<A, F, E, J> implements IComponentHierarchyBase<C, J>, GlobalChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * The list of children of this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<ComponentHierarchyBase> children;
    /**
     * My Parent
     */
    @JsonIgnore
    private ComponentHierarchyBase parent;
    /**
     * My Page
     */
    @JsonIgnore
    private Page page;

    /**
     * Constructs a new component that can be part of a tree
     *
     * @param componentType
     */
    public ComponentHierarchyBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns a Hierarchy Base interface of this component
     *
     * @return
     */
    public IComponentHierarchyBase asHierarchyBase()
    {
        return (ComponentHierarchyBase) this;
    }

    /**
     * Add a new child to this component
     * <p>
     * @param position The position to add the child to
     * @param newChild The child to be added
     * <p>
     * @return The new child added
     */
    @Override
    public C add(int position, C newChild)
    {
        if (newChild == null)
        {
            return newChild;
        }
        ComponentHierarchyBase comp = ComponentHierarchyBase.class.cast(newChild);
        if (comp != null)
        {
            comp.setParent(this);
            comp.setTiny(isTiny());
            comp.setPage(getPage());
            getChildren().add(position, comp);
        }
        return newChild;
    }

    /**
     * Add a new child to this component
     * <p>
     * @param newChild The child to be added
     * <p>
     * @return The new child added
     */
    @Override
    public C add(C newChild)
    {
        if (newChild == null)
        {
            return newChild;
        }
        ComponentHierarchyBase comp = ComponentHierarchyBase.class.cast(newChild);
        if (comp != null)
        {
            comp.setParent(this);
            comp.setTiny(isTiny());
            comp.setPage(getPage());
            getChildren().add(comp);
        }
        return newChild;
    }

    /**
     * Returns null sets the text
     *
     * @param text
     * @return
     */
    @Override
    public C add(String text)
    {
        setText(text);
        return null;
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            ArrayList<ComponentHierarchyBase> clonedBase = (ArrayList<ComponentHierarchyBase>) getChildren();
            clonedBase.stream().filter(a -> a != null).forEach(comp
                    ->
            {
                ComponentHierarchyBase cfb = comp;
                cfb.init();
            });
        }
        super.init();
    }

    @Override
    public void preConfigure()
    {
        if (!isInitialized())
        {
            init();
        }

        if (!isConfigured())
        {
            ArrayList<ComponentHierarchyBase> clonedBase = (ArrayList<ComponentHierarchyBase>) getChildren();
            clonedBase = (ArrayList<ComponentHierarchyBase>) clonedBase.clone();

            clonedBase.stream().filter(a -> a != null).forEach(feature
                    ->
            {
                ComponentHierarchyBase cfb = feature;
                if (!cfb.isConfigured() && cfb != null)
                {
                    cfb.preConfigure();
                }
            });

            if (hasChildren())
            {
                setNewLineForClosingTag(true);
            }
            else
            {
                setNewLineForClosingTag(false);
            }
        }
        super.preConfigure();
    }

    /**
     * Returns the children ArrayList of type Component
     * <p>
     * @return An array list of components
     */
    @Override
    public final List<ComponentHierarchyBase> getChildren()
    {
        if (children == null)
        {
            children = new ArrayList<>();
        }
        return children;
    }

    /**
     * Get an array list of all children and their children recursively Includes this object
     * <p>
     * @return A complete array list of all children at time of call
     */
    @Override
    public List<ComponentHierarchyBase> getChildrenHierarchy()
    {
        return getChildrenHierarchy(true);
    }

    /**
     * Get an array list of all children and their children recursively Excludes this object
     * <p>
     * @param trues Whether or not to include this component
     * <p>
     * @return A complete array list of all children at time of call
     */
    @Override
    public List<ComponentHierarchyBase> getChildrenHierarchy(boolean trues)
    {
        ArrayList<ComponentHierarchyBase> components = new ArrayList();
        if (trues)
        {
            components.add(this);
        }
        getChildrenHierarchy(components);

        return components;
    }

    /**
     * Adds the children of this component onto the array list coming in
     * <p>
     * <p>
     * <p>
     * @param componentsToAddTo The component Array List to add to
     * <p>
     * @return original components added with
     */
    @Override
    public List<ComponentHierarchyBase> getChildrenHierarchy(List<ComponentHierarchyBase> componentsToAddTo)
    {
        getChildren().stream().filter((child) -> !(child == null)).map(child
                ->
        {
            if (!componentsToAddTo.contains(child))
            {
                componentsToAddTo.add(child);
            }
            return child;
        }).forEach(child
                ->
        {
            if (child != null)
            {
                child.getChildrenHierarchy(componentsToAddTo);
            }
        });
        return componentsToAddTo;
    }

    /**
     * Renders each child
     *
     * @return
     */
    @Override
    protected StringBuilder renderChildren()
    {
        StringBuilder sb = new StringBuilder();
        if (renderBeforeChildren() != null)
        {
            sb.append(renderBeforeChildren());
        }
        getChildren().stream().filter(a -> a != null).forEach(child
                ->
        {
            sb.append(getNewLine()).append(child.toString(isTiny() ? 0 : getCurrentTabIndents() + 1));
        });
        if (renderAfterChildren() != null)
        {
            sb.append(renderAfterChildren());
        }
        return sb;
    }

    /**
     * Sets the page this component belongs on.
     * <p>
     * @param page A Page
     */
    @Override
    public J setPage(Page page)
    {
        this.page = page;
        getChildren().stream().filter(a -> a != null).forEach(child
                ->
        {

            child.setPage(page);
        });
        return (J) this;
    }

    /**
     * Get the page this component exists on
     * <p>
     * @return A Page
     */
    @Override
    public Page getPage()
    {
        if (page == null)
        {
            setPage(new Page());
        }
        return page;
    }

    /**
     * Gets the parent of this hierarchy item
     *
     * @return
     */
    @Override
    public ComponentHierarchyBase getParent()
    {
        return parent;
    }

    /**
     * Returns the parent id for the parent property so JSON doesn't go circular
     *
     * @return
     */
    @JsonProperty("parent")
    private String getParentJSON()
    {
        if (getParent() != null)
        {
            return getParent().getID();
        }
        return null;
    }

    /**
     * Sets the parent of this item
     *
     * @param parent
     */
    @Override
    public J setParent(ComponentHierarchyBase parent)
    {
        this.parent = parent;
        return (J) this;
    }

    /**
     * Returns if this object has children or not
     * <p>
     * @return true if there are children attached
     */
    @Override
    public boolean hasChildren()
    {
        return !getChildren().isEmpty();
    }

    /**
     * Adds in the JavaScript References for all the children
     *
     * @return
     */
    @Override
    public List<JavascriptReference> getJavascriptReferencesAll()
    {
        List<JavascriptReference> allJs = super.getJavascriptReferencesAll();
        getChildren().stream().filter(a -> a != null).forEach(child
                ->
        {
            for (Iterator<JavascriptReference> iterator1 = child.getJavascriptReferencesAll().iterator(); iterator1.hasNext();)
            {
                JavascriptReference jScript = iterator1.next();
                if (!allJs.contains(jScript))
                {
                    allJs.add(jScript);
                }
            }
        });
        return allJs;
    }

    /**
     * Returns a complete list of events
     *
     * @return
     */
    @Override
    public List<Event> getEventsAll()
    {
        ArrayList<Event> allEvents = new ArrayList<>();
        getChildrenHierarchy().stream().filter(a -> a != null).forEach(child
                ->
        {
            for (Iterator<Event> iterator1 = child.getEvents().iterator(); iterator1.hasNext();)
            {
                Event event = iterator1.next();
                if (event != null)
                {
                    allEvents.add(event);
                }
            }
        });
        return allEvents;
    }

    /**
     * Adds in the JavaScript References for all the children
     *
     * @return
     */
    @Override
    public List<CSSReference> getCssReferencesAll()
    {
        List<CSSReference> allCss = super.getCssReferencesAll();
        getChildren().stream().filter(a -> a != null).forEach(child
                ->
        {
            for (Iterator<CSSReference> iterator1 = child.getCssReferencesAll().iterator(); iterator1.hasNext();)
            {
                CSSReference jScript = iterator1.next();
                if (!allCss.contains(jScript))
                {
                    allCss.add(jScript);
                }
            }
        });
        return allCss;
    }

    /**
     * Finds the event in all this components and child components
     *
     * @param eventId
     * @return
     */
    @Override
    public ComponentEventBase getEvent(String eventId)
    {
        for (ComponentHierarchyBase child : getChildren())
        {
            for (Iterator<ComponentEventBase> iterator1 = child.getEventsAll().iterator(); iterator1.hasNext();)
            {
                ComponentEventBase jScript = iterator1.next();
                if (jScript.getID().equals(eventId))
                {
                    return jScript;
                }
            }
        }
        return null;
    }

    /**
     * *
     * Returns all the variables for all the components
     *
     * @return
     */
    @Override
    public List<String> getVariablesAll()
    {
        ArrayList<String> allVariables = new ArrayList<>();
        getChildrenHierarchy().stream().filter(a -> a != null).forEach((child)
                ->
        {
            for (Iterator it = child.getVariables().iterator(); it.hasNext();)
            {
                String variable = (String) it.next();
                if (!allVariables.contains(variable))
                {
                    allVariables.add(variable);
                }
            }
        });
        return allVariables;
    }

    /**
     * Returns all the feature queries associated to this component and all its children
     *
     * @return
     */
    @Override
    public List<StringBuilder> getQueriesAll()
    {
        ArrayList<StringBuilder> reallyAllQueries = new ArrayList<>();
        List<ComponentHierarchyBase> allComponents = getChildrenHierarchy(true);
        allComponents.stream().filter((currentComponent) -> currentComponent != null).map((component) ->
        {
            List<ComponentFeatureBase> features = component.getFeatures();
            features.stream().map(feature ->
            {
                if (!feature.isConfigured())
                {
                    feature.preConfigure();
                    feature.setConfigured(true);
                }
                return feature;
            }).forEachOrdered(feature ->
            {
                reallyAllQueries.add(feature.renderJavascript());
            });
            List<ComponentFeatureBase> events = component.getFeatures();
            return events;
        }).map((events) ->
        {
            events.stream().map(event ->
            {
                if (!event.isConfigured())
                {
                    event.preConfigure();
                    event.setConfigured(true);
                }
                return event;
            }).forEachOrdered(event ->
            {
                reallyAllQueries.add(event.renderJavascript());
            });
            return events;
        }).map(_item -> new ArrayList<>()).forEachOrdered((componentQueries) ->
        {
            for (Iterator<Object> it = componentQueries.iterator(); it.hasNext();)
            {
                reallyAllQueries.add((StringBuilder) it.next());
            }
        });

        return reallyAllQueries;
    }

    /**
     * *
     * Returns all the JavaScript for all the components
     *
     * @return
     */
    @Override
    public StringBuilder renderJavascriptAll()
    {
        preConfigure();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> allScripts = new ArrayList<>();

        for (Iterator it = getQueriesAll().iterator(); it.hasNext();)
        {
            String script = it.next().toString();
            if (!allScripts.contains(script))
            {
                allScripts.add(script);
            }
        }

        allScripts.stream().forEach(sb.append(getNewLine())::append);
        return sb;
    }

    /**
     * Overrides this and all below components to set tiny false
     *
     * @param tiny
     * @return super.tiny
     */
    @Override
    public J setTiny(boolean tiny)
    {
        getChildren().stream().filter(a -> a != null).forEach((child)
                ->
        {
            child.setTiny(tiny);
        });
        return super.setTiny(tiny);
    }

    /**
     * Adds the given CSS Class Name with the given references
     * <p>
     * @param classComponent
     * @return
     */
    @Override
    public boolean addClass(CSSComponent classComponent)
    {
        String className = classComponent.getID();
        getPage().getBody().add((C) classComponent);
        if (!getClasses().contains(className))
        {
            getClasses().add(className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Takes a component off this components child list
     * <p>
     * @param childToRemove The child object to remove from this list
     * <p>
     * @return True if the child was part of this components children's list
     */
    @Override
    public boolean remove(C childToRemove)
    {
        ComponentHierarchyBase comp = (ComponentHierarchyBase) childToRemove;
        getChildren().remove(comp);
        return true;
    }

    /**
     * Renders String content before the children tags are rendered
     * <p>
     * @return Custom HTML String to be inserted before Children tags
     */
    protected StringBuilder renderBeforeChildren()
    {
        return null;
    }

    /**
     * Renders String content after the children tags are rendered
     * <p>
     * @return Custom HTML String to be inserted after Children tags
     */
    protected StringBuilder renderAfterChildren()
    {
        return null;
    }

    /**
     * Convenience method for checking if a tag has already been added as a child
     * <p>
     * @param classType The Tag type to check for
     * <p>
     * @return The Obvious
     */
    protected boolean containsClass(Class classType)
    {
        return getChildren().stream().anyMatch((child) -> (child.getClass().equals(classType)));
    }

    /**
     * Returns All the angular objects mapped to this component and its children
     *
     * @return
     */
    @Override
    public HashMap<String, JavaScriptPart> getAngularObjectsAll()
    {
        HashMap<String, JavaScriptPart> map = getAngularObjects();
        getChildrenHierarchy(true).stream().map((child) -> child.getAngularObjects()).forEach((ang)
                ->
        {
            map.putAll(ang);
        });
        return map;
    }

    /**
     * Pre-Configure the children tree
     *
     * @return
     */
    @Override
    public String toString()
    {
        getChildren().stream().forEach((next)
                ->
        {
            if (!next.isConfigured())
            {
                next.preConfigure();
            }
        });
        return super.toString();
    }

    /**
     * Returns the HTML with the specified tab count
     *
     * @param tabCount
     * @return Indented HTML
     */
    @Override
    public String toString(Integer tabCount)
    {
//        preConfigure();
        return super.toString(tabCount);
    }

    /**
     * Takes an instance and wraps around the component
     * <p>
     * e.g. BSRow.Wrap(div) = iv class="row"myComponent//div
     *
     * @param component
     * @return
     */
    public J Wrap(ComponentHierarchyBase component)
    {
        ComponentHierarchyBase existingParent = component.getParent();
        if (component.getParent() != null)
        {
            existingParent.remove(component);
            existingParent.add(this);
        }
        getChildren().add(component);
        return (J) this;
    }
}
