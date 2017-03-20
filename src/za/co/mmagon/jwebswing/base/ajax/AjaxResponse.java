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
import java.util.ArrayList;
import java.util.Iterator;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * A response sent back to the client
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
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
    private ArrayList<ComponentHierarchyBase> components;

    /**
     * Format as JSON
     *
     * @return
     */
    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.JSON;
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
     */
    public void addComponent(ComponentHierarchyBase component)
    {
        getComponents().add(component);
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
    public StringBuilder getCssRenders(ComponentStyleBase component)
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
    public ArrayList<String> getJsRenders(ComponentHierarchyBase component)
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
    public ArrayList<AjaxResponseReaction> getReactions()
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
    public ArrayList<ComponentHierarchyBase> getComponents()
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
    protected ArrayList<ComponentUpdates> getUpdates()
    {
        ArrayList<ComponentUpdates> updates = new ArrayList<>();
        getComponents().stream().filter(next -> (ComponentHierarchyBase.class.isAssignableFrom(next.getClass())))
                .forEachOrdered(next ->
                {
                    updates.add(new ComponentUpdates((ComponentHierarchyBase) next));
                });
        return updates;
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
     * A JSON Class for component updates
     */
    public class ComponentUpdates extends JavaScriptPart
    {

        private static final long serialVersionUID = 1L;

        @JsonProperty("html")
        private final String html;
        @JsonProperty("id")
        private final String replaceID;

        /**
         * Constructs an update class from a given component
         *
         * @param component
         */
        public ComponentUpdates(ComponentHierarchyBase component)
        {
            component.setTiny(true);
            this.html = component.toString(true);
            this.replaceID = component.getID();
        }

        /**
         * Returns the HTML of the component
         *
         * @return
         */
        public String getHtml()
        {
            return html;
        }

        /**
         * Returns which component ID is getting replaced
         *
         * @return
         */
        public String getReplaceID()
        {
            return replaceID;
        }
    }
}
