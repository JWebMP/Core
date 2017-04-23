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
package za.co.mmagon.jwebswing.base.ajax;

import com.fasterxml.jackson.annotation.*;
import com.google.inject.servlet.RequestScoped;
import java.util.*;
import java.util.Map.Entry;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A response sent back to the client
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
@RequestScoped
public class AjaxResponse extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * Whether or not the response is a success or not
     */
    @JsonProperty("success")
    private boolean success = true;

    /**
     * All angular variable updates to be performed
     */
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<AngularJsonVariable> angularVariables;

    /**
     * All relevant client reactions to perform
     */
    @JsonProperty("reactions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<AjaxResponseReaction> reactions;

    /**
     * All components that must be updated
     */
    @JsonIgnore
    private List<ComponentHierarchyBase> components;

    /**
     * A complete list of the component update objects
     */
    @JsonIgnore
    private List<AjaxComponentUpdates> componentUpdates;

    /**
     * An additional list of events that can fire, not stored in memory
     */
    @JsonIgnore
    private List<Event> events;

    /**
     * An additional list of features that can fire
     */
    @JsonIgnore
    private List<Feature> features;

    /**
     * A list of local storage items and their keys
     */
    private Map<String, JavaScriptPart> localStorage;
    /**
     * A list of local storage items and their keys
     */
    private Map<String, JavaScriptPart> sessionStorage;

    /**
     * Returns all the feature queries for the given response
     *
     * @return
     */
    @JsonProperty("features")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<String> getFeatureQueries()
    {
        ArrayList<String> list = new ArrayList<>();
        getFeatures().forEach(feature ->
        {
            list.add(feature.renderJavascript().toString());
        });
        return list;
    }

    /**
     * Returns all the event queries from the components
     *
     * @return
     */
    @JsonProperty("events")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<String> getEventQueries()
    {
        ArrayList<String> list = new ArrayList<>();
        getEvents().forEach(event ->
        {
            list.add(event.renderJavascript().toString());
        });
        return list;
    }

    /**
     * Adds a DTO to the response call
     *
     * @param name   The name of the variable
     * @param object The DTO to pass through
     */
    public void addDto(String name, JavaScriptPart object)
    {
        AngularJsonVariable variable = new AngularJsonVariable(name, object);
        getAngularVariables().add(variable);
    }

    /**
     * Adds a DTO to the response call
     *
     * @param name   The name of the variable
     * @param object The DTO to pass through
     */
    public void addDto(String name, String object)
    {
        AngularJsonVariable variable = new AngularJsonVariable(name, object);
        getAngularVariables().add(variable);
    }

    /**
     * If the server action was a success
     *
     * @return
     */
    public boolean isSuccess()
    {
        return success;
    }

    /**
     * If the server action was a success, default is no
     *
     * @param success
     */
    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    /**
     * Adds a component to be returned to the client
     *
     * @param component
     *
     * @return
     */
    public AjaxComponentUpdates addComponent(ComponentHierarchyBase component)
    {
        getComponents().add(component);
        AjaxComponentUpdates newComponent;
        getComponentUpdates().add(newComponent = new AjaxComponentUpdates(component));
        return newComponent;
    }

    /**
     * Returns a list of the needed component updates
     *
     * @return
     */
    public List<AjaxComponentUpdates> getComponentUpdates()
    {
        if (componentUpdates == null)
        {
            componentUpdates = new ArrayList<>();
        }
        return componentUpdates;
    }

    /**
     * Adds a client reaction to be performed
     *
     * @param reaction
     */
    public void addReaction(AjaxResponseReaction reaction)
    {
        getReactions().add(reaction);
    }

    /**
     * Gets all the CSS References
     *
     * @return
     */
    @JsonProperty("cssLinks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected ArrayList<String> getAllCssReferences()
    {
        ArrayList<String> output = new ArrayList<>();
        getComponents().stream().forEach(next
                ->
        {
            if (ComponentDependancyBase.class.isAssignableFrom(next.getClass()))
            {
                output.addAll(getCssReferences((ComponentDependancyBase) next));
            }
        });
        return output;
    }

    /**
     * Gets all the JavaScript References
     *
     * @return
     */
    @JsonProperty("jsReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected ArrayList<String> getAllJsReferences()
    {
        ArrayList<String> output = new ArrayList<>();
        getComponents().stream().forEach(next
                ->
        {
            if (ComponentDependancyBase.class.isAssignableFrom(next.getClass()))
            {
                getJsReferences((ComponentDependancyBase) next).stream().forEachOrdered(a ->
                {
                    output.add(a);
                });
            }
        });
        return output;
    }

    /**
     * Gets all the JavaScript and inserts it into the JSON response
     *
     * @return
     */
    @JsonProperty("jsScripts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected ArrayList<String> getAllJsScripts()
    {
        ArrayList<String> output = new ArrayList<>();
        getComponents().stream().forEach(next
                ->
        {
            if (ComponentHierarchyBase.class.isAssignableFrom(next.getClass()))
            {
                getJsRenders((ComponentHierarchyBase) next).stream().filter(next1 -> (next1 != null && !next1.isEmpty())).forEach(next1 ->
                {
                    if (!next1.equalsIgnoreCase("\n"))
                    {
                        output.add(next1);
                    }
                });
            }

            //Load on demand scripts
            if (Event.class.isAssignableFrom(next.getClass()))
            {
                for (Iterator iterator = Event.class.cast(next).getRunEvents().iterator(); iterator.hasNext();)
                {
                    Event next1 = (Event) iterator.next();
                    next1.preConfigure();
                    for (Iterator iterator1 = next1.getQueriesAll().iterator(); iterator1.hasNext();)
                    {
                        StringBuilder query = (StringBuilder) iterator1.next();
                        if (!query.toString().equalsIgnoreCase("\n"))
                        {
                            output.add(query.toString());
                        }
                    }
                }
            }
        });
        return output;
    }

    /**
     * Gets all the CSS Renders
     *
     * @return
     */
    @JsonProperty("css")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String getAllCss()
    {
        StringBuilder sb = new StringBuilder();
        getComponents().stream().filter(next -> (next instanceof ComponentStyleBase)).forEach(next
                ->
        {
            sb.append(getCssRenders(ComponentStyleBase.class.cast(next)));
        });
        return sb.toString();
    }

    /**
     * Returns all the CSS references for all the components
     *
     * @param component
     *
     * @return
     */
    protected ArrayList<String> getCssReferences(ComponentDependancyBase component)
    {
        ArrayList<String> cssRender = new ArrayList<>();
        for (Iterator iterator = component.getCssReferencesAll().iterator(); iterator.hasNext();)
        {
            CSSReference next = (CSSReference) iterator.next();
            if (!cssRender.contains(next.toString()))
            {
                cssRender.add(next.toString());
            }
        }
        return cssRender;
    }

    /**
     * Gets all JavaScript references for a component and it's children
     *
     * @param component
     *
     * @return
     */
    protected ArrayList<String> getJsReferences(ComponentDependancyBase component)
    {
        ArrayList<String> cssRender = new ArrayList<>();
        for (Iterator iterator = component.getJavascriptReferencesAll().iterator(); iterator.hasNext();)
        {
            JavascriptReference next = (JavascriptReference) iterator.next();
            if (!cssRender.contains(next.toString()))
            {
                cssRender.add(next.toString());
            }
        }
        return cssRender;
    }

    /**
     * Gets all the CSS renders for a component and its children
     *
     * @param component
     *
     * @return
     */
    protected StringBuilder getCssRenders(ComponentStyleBase component)
    {
        StringBuilder cssRender = new StringBuilder();
        cssRender.append(component.renderCss(0).toString());
        return cssRender;
    }

    /**
     * Gets all the JavaScript to render for a component and its children
     *
     * @param component
     *
     * @return
     */
    protected List<String> getJsRenders(ComponentHierarchyBase component)
    {
        ArrayList<String> jsRenders = new ArrayList<>();
        jsRenders.add(component.renderJavascriptAll().toString());
        return jsRenders;
    }

    /**
     * Returns the list of client reactions available
     *
     * @return
     */
    public List<AjaxResponseReaction> getReactions()
    {
        if (reactions == null)
        {
            reactions = new ArrayList<>();
        }
        return reactions;
    }

    /**
     * Returns the list of components sending back
     *
     * @return
     */
    public List<ComponentHierarchyBase> getComponents()
    {
        if (components == null)
        {
            components = new ArrayList<>();
        }
        return components;
    }

    /**
     * Returns the updates
     *
     * @return
     */
    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<AjaxComponentUpdates> getUpdates()
    {
        return getComponentUpdates();
    }

    /**
     * Returns the list of angular variables from the server
     *
     * @return
     */
    public ArrayList<AngularJsonVariable> getAngularVariables()
    {
        if (angularVariables == null)
        {
            angularVariables = new ArrayList<>();
        }
        return angularVariables;
    }

    /**
     * Sets the list of angular variables
     *
     * @param angularVariables
     */
    public void setAngularVariables(ArrayList<AngularJsonVariable> angularVariables)
    {
        this.angularVariables = angularVariables;
    }

    /**
     * Removes the registered variable from the client. Use to clean up memory or assigned variables on the client
     *
     * @param variable
     */
    public void clearVariable(AngularJsonVariable variable)
    {
        if (variable != null)
        {
            variable.setVariableText(null);
            variable.setVariable(null);
            getAngularVariables().add(variable);
        }
    }

    /**
     * Removes the registered variable from the client. Use to clean up memory or assigned variables on the client
     *
     * @param variableName
     */
    public void clearVariable(String variableName)
    {
        AngularJsonVariable var = new AngularJsonVariable(variableName, (JavaScriptPart) null);
        getAngularVariables().add(var);
    }

    /**
     * Gets events assigned to the response
     *
     * @return
     */
    public List<Event> getEvents()
    {
        if (events == null)
        {
            events = new ArrayList<>();
        }
        return events;
    }

    /**
     * Sets events assigned to the response
     *
     * @param events
     */
    public void setEvents(List<Event> events)
    {
        this.events = events;
    }

    /**
     * Gets features assigned to the response
     *
     * @return
     */
    public List<Feature> getFeatures()
    {
        if (features == null)
        {
            features = new ArrayList<>();
        }
        return features;
    }

    /**
     * Sets features assigned to the response
     *
     * @param features
     */
    public void setFeatures(List<Feature> features)
    {
        this.features = features;
    }

    @Override
    public String toString()
    {
        for (ComponentHierarchyBase component : getComponents())
        {
            for (Iterator it = component.getAngularObjectsAll().entrySet().iterator(); it.hasNext();)
            {
                Entry<String, JavaScriptPart> object = (Entry<String, JavaScriptPart>) it.next();
                String key = object.getKey();
                JavaScriptPart value = object.getValue();
                addDto(key, value);
            }
        }
        return super.toString();
    }

    /**
     * Returns the map going back for the local storage
     *
     * @return
     */
    public Map<String, JavaScriptPart> getLocalStorage()
    {
        if (localStorage == null)
        {
            localStorage = new HashMap<>();
        }
        return localStorage;
    }

    /**
     * Sets the map for the local storage going back
     *
     * @param localStorage
     */
    public void setLocalStorage(Map<String, JavaScriptPart> localStorage)
    {
        this.localStorage = localStorage;
    }

    /**
     * Gets the local session going back
     *
     * @return
     */
    public Map<String, JavaScriptPart> getSessionStorage()
    {
        if (sessionStorage == null)
        {
            sessionStorage = new HashMap<>();
        }
        return sessionStorage;
    }

    /**
     * The session storage going back
     *
     * @param sessionStorage
     */
    public void setSessionStorage(Map<String, JavaScriptPart> sessionStorage)
    {
        this.sessionStorage = sessionStorage;
    }

}
