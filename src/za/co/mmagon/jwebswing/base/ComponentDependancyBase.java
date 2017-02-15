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
import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.base.interfaces.IComponentDependancyBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 * This class marks a component as a web component.
 * <p>
 * Allows for JavaScript and CSS References to Exist
 *
 * @author GedMarc
 * @param <J>
 *
 * @since 23 Apr 2016
 */
public class ComponentDependancyBase<J extends ComponentDependancyBase>
        extends ComponentBase<J>
        implements IComponentDependancyBase<J>
{

    private static final long serialVersionUID = 1L;

    /**
     * The CSS String List of this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CSSReference> cssReferences;
    /**
     * The JavaSript String list for this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JavascriptReference> javascriptReferences;

    /**
     * Instantiates a Component with the ability to have CSS and JavaScript references
     *
     * @param componentType
     */
    public ComponentDependancyBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns an Attribute Base interface of this component
     *
     * @return
     */
    public IComponentDependancyBase asDependancyBase()
    {
        return (ComponentDependancyBase) this;
    }

    /**
     * Returns the strings of the CSS Links this will use
     * <p>
     * @return ArrayList of all CSS File Links in String format
     */
    @Override
    public List<CSSReference> getCssReferences()
    {
        if (this.cssReferences == null)
        {
            this.cssReferences = new ArrayList<>();
        }
        return this.cssReferences;
    }

    /**
     * Returns the JavaScript links attached to this component
     * <p>
     * @return
     */
    @Override
    public List<JavascriptReference> getJavascriptReferences()
    {
        if (javascriptReferences == null)
        {
            javascriptReferences = new ArrayList<>();
        }
        return javascriptReferences;
    }

    /**
     * Return all the CSS References associated with this component. Override and add the references required for the functionality
     *
     * @return
     */
    @Override
    public List<JavascriptReference> getJavascriptReferencesAll()
    {
        return getJavascriptReferences();
    }

    /**
     * Returns all the CSS references with the given priority Override and add the references required for the functionality
     *
     * @param priority The priority of the references to retrieve
     *
     * @return A new array list of all the requested for references
     */
    @Override
    public List<JavascriptReference> getJavascriptReferencesAll(RequirementsPriority priority)
    {
        ArrayList<JavascriptReference> arr = new ArrayList<>();
        getJavascriptReferencesAll().stream()
                .filter(css -> (css.getPriority().equals(priority)))
                .filter((JavascriptReference css) -> (!arr.contains(css)))
                .forEach(css
                        ->
                {
                    arr.add(css);
                });
        return arr;
    }

    /**
     * Return all the CSS References associated with this component
     *
     * @return
     */
    @Override
    public List<CSSReference> getCssReferencesAll()
    {
        return getCssReferences();
    }

    /**
     * Returns all the CSS references with the given priority
     *
     * @param priority The priority of the references to retrieve
     *
     * @return A new array list of all the requested for references
     */
    @Override
    public List<CSSReference> getCssReferencesAll(RequirementsPriority priority)
    {
        ArrayList<CSSReference> arr = new ArrayList<>();
        getCssReferencesAll().stream()
                .filter(css -> (css != null))
                .filter(css -> (css.getPriority().equals(priority)))
                .filter((CSSReference css) -> (!arr.contains(css)))
                .forEach(css
                        ->
                {
                    arr.add(css);
                });

        return arr;
    }

    /**
     * Adds a CSS Reference to the collection
     *
     * @param cssReference
     *
     * @return This Class
     */
    @Override
    public J addCssReference(CSSReference cssReference)
    {
        if (!getCssReferences().contains(cssReference))
        {
            getCssReferences().add(cssReference);
        }
        return (J) this;
    }

    /**
     * Adds a JavaScript Reference to the collection
     *
     * @param jsReference
     *
     * @return This Class
     */
    @Override
    public J addJavaScriptReference(JavascriptReference jsReference)
    {
        if (!getJavascriptReferences().contains(jsReference))
        {
            getJavascriptReferences().add(jsReference);
        }
        return (J) this;
    }

    /**
     * Removes the CSS Reference from the Component
     *
     * @param cssReference
     *
     * @return This Class
     */
    @Override
    public J removeCssReference(CSSReference cssReference)
    {
        getCssReferences().remove(cssReference);
        return (J) this;
    }

    /**
     * Removes the CSS Reference from the Component
     *
     * @param jsReference
     *
     * @return This Class
     */
    @Override
    public J removeJavaScriptReference(JavascriptReference jsReference)
    {
        getJavascriptReferences().remove(jsReference);
        return (J) this;
    }

    @Override
    public void preConfigure()
    {
        super.preConfigure();
    }

    /**
     * Clones this component with all the CSS and JavaScript references
     *
     * @return
     */
    @Override
    public J cloneComponent()
    {
        ComponentDependancyBase cloned = (ComponentDependancyBase) super.cloneComponent();

        cloned.cssReferences = new ArrayList();
        cloned.javascriptReferences = new ArrayList();
        cloned.cssReferences.addAll(getCssReferences());
        cloned.javascriptReferences.addAll(getJavascriptReferences());

        return (J) cloned;
    }
}
