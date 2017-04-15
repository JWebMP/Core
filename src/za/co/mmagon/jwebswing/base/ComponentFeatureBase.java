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
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.interfaces.IComponentFeatureBase;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

/**
 * Allows a component to have features and events
 *
 * @param <F> The allowed feature JavaScripts
 * @param <J> Component output for cloning. Returned on CloneComponent
 *
 * @since 23 Apr 2016
 */
public class ComponentFeatureBase<F extends GlobalFeatures, J extends ComponentFeatureBase>
        extends ComponentDependancyBase<J>
        implements IComponentFeatureBase<F, J>
{

    /**
     * Logger for the Component
     */
    @JsonIgnore
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("Component");
    /**
     * Serial Version for all Components and their compatibility
     *
     * @version 2 Version 2 - Updated CSS Library and References
     */
    @JsonIgnore
    private static final long serialVersionUID = 2l;
    /**
     * The features of this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<F> features;
    /**
     * The list of queries in this feature
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StringBuilder> queries;
    /**
     * The sort order for this feature
     */
    private int sortOrder = 1000;
    /**
     * The variables associated with this feature
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> variables;
    /**
     * Name of this feature, not yet used anywhere.. Wondering on it's usefulness
     */
    private String name;
    /**
     * A linked component if required
     */
    @JsonIgnore
    protected ComponentHierarchyBase component;
    /**
     * Whether this feature is rendered after load
     */
    private boolean renderAfterLoad;
    /**
     * The assigned priority for the given application
     */
    private RequirementsPriority priority;

    /**
     * Specifies if this components JavaScript is rendered somewhere else
     */
    private boolean javascriptRenderedElsewhere;

    /**
     * Constructs a new feature with the given name
     *
     * @param name
     */
    public ComponentFeatureBase(String name)
    {
        super(ComponentTypes.Feature);
        this.name = name;
        variables = new ArrayList<>();
    }

    /**
     * Constructs a new component that can have features
     *
     * @param componentType
     */
    public ComponentFeatureBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns an Attribute Base interface of this component
     *
     * @return
     */
    public IComponentFeatureBase asFeatureBase()
    {
        return (ComponentFeatureBase) this;
    }

    /**
     * Returns a list of all the features associated with this component
     * <p>
     * @return An ArrayList of features
     */
    public List<F> getFeatures()
    {
        if (features == null)
        {
            features = new ArrayList<>();
        }
        return features;
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getFeatures().stream().forEach(feature
                    ->
            {
                ComponentFeatureBase cfb = (ComponentFeatureBase) feature;
                if (cfb != null && !cfb.isConfigured())
                {
                    cfb.preConfigure();
                    cfb.assignFunctionsToComponent();
                }
            });
        }
        super.preConfigure();
    }

    /**
     * Initialize all the features
     */
    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getFeatures().stream().forEach(feature
                    ->
            {
                ComponentFeatureBase cfb = (ComponentFeatureBase) feature;
                if (cfb != null && !cfb.isConfigured())
                {
                    cfb.init();
                }
            });
        }
        super.init();
    }

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    @Override
    public List<JavascriptReference> getJavascriptReferencesAll()
    {
        List<JavascriptReference> allJs = super.getJavascriptReferencesAll();
        getFeatures().stream().forEach(feature
                ->
        {
            ComponentFeatureBase cfb = (ComponentFeatureBase) feature;
            for (Iterator<JavascriptReference> it = cfb.getJavascriptReferencesAll().iterator(); it.hasNext();)
            {
                JavascriptReference js = it.next();
                if (!allJs.contains(js))
                {
                    allJs.add(js);
                }
            }
        });
        return allJs;
    }

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    @Override
    public List<CSSReference> getCssReferencesAll()
    {
        List<CSSReference> allCss = super.getCssReferencesAll();
        getFeatures().stream().forEach((feature)
                ->
        {
            ComponentFeatureBase cfb = (ComponentFeatureBase) feature;
            for (Iterator<CSSReference> it = cfb.getCssReferencesAll().iterator(); it.hasNext();)
            {
                CSSReference css = it.next();
                if (!allCss.contains(css))
                {
                    allCss.add(css);
                }
            }
        });
        return allCss;
    }

    /**
     * Renders the JavaScript for this Builder
     *
     * @return
     */
    @Override
    public StringBuilder renderJavascript()
    {
        if (!isConfigured())
        {
            preConfigure();
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> allQueries = new ArrayList<>();
        getQueriesAll().stream().forEach(query
                ->
        {
            if (!allQueries.contains(query.toString()) || !query.toString().isEmpty())
            {
                allQueries.add(query.toString());
            }
        });
        allQueries.stream().forEach(query ->
        {
            if (!query.trim().equals("\n"))
            {
                sb.append(query);
            }
        });
        return sb;
    }

    /**
     * Returns the queries
     *
     * @return
     */
    @JsonProperty("queries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<StringBuilder> getQueries()
    {
        if (queries == null)
        {
            queries = new ArrayList<>();
        }
        return queries;
    }

    /**
     * Returns all Queries Associated with a component
     *
     * @return
     */
    @Override
    public List<StringBuilder> getQueriesAll()
    {
        return getQueries();
    }

    /**
     * Specifies whether or not this feature actually contains some JavaScript lines or is just a link
     *
     * @return True if a script is located inside the feature
     */
    @Override
    public boolean scriptAvailable()
    {
        return !getQueries().isEmpty();
    }

    /**
     * Use Add Query to add a query to the container
     */
    protected void assignFunctionsToComponent()
    {
    }

    /**
     * Returns the name of this feature
     *
     * @return the name of this feature
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the feature
     *
     * @param name Sets the name of the feature
     *
     * @return
     */
    public J setName(String name)
    {
        this.name = name;
        return (J) this;
    }

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
        final ComponentFeatureBase<?, ?> other = (ComponentFeatureBase<?, ?>) obj;
        if (this.sortOrder != other.sortOrder)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.features, other.features))
        {
            return false;
        }
        return Objects.equals(this.queries, other.queries);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.features);
        hash = 97 * hash + Objects.hashCode(this.queries);
        hash = 97 * hash + this.sortOrder;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * Sets the sort order for this feature. Default 10000
     *
     * @return
     */
    @Override
    public Integer getSortOrder()
    {
        return sortOrder;
    }

    /**
     * Gets the sort order for this feature Default 10000
     *
     * @param sortOrder
     *
     * @return
     */
    public final J setSortOrder(int sortOrder)
    {
        this.sortOrder = sortOrder;
        return (J) this;
    }

    /**
     * Adds a feature to the collection
     *
     * @param feature
     * @param position
     *
     * @return
     */
    @Override
    public J addFeature(ComponentFeatureBase feature, int position)
    {
        if (!feature.getComponentType().equals(ComponentTypes.Feature))
        {
            LOG.log(Level.WARNING, "Tried to add a non-feature to the feature collection");
        }
        else if (!getFeatures().contains((F) feature))
        {
            getFeatures().add(position, (F) feature);
        }
        return (J) this;
    }

    /**
     * Adds a feature to the collection
     *
     * @param feature
     *
     * @return
     */
    @Override
    public J addFeature(ComponentFeatureBase feature)
    {
        if (feature != null)
        {
            if (!feature.getComponentType().equals(ComponentTypes.Feature))
            {
                LOG.log(Level.WARNING, "Tried to add a non-feature to the feature collection");
            }
            else if (!getFeatures().contains((F) feature))
            {
                getFeatures().add((F) feature);
            }
        }
        return (J) this;
    }

    /**
     * Removes a feature from the components collection
     * <p>
     * @param feature The feature to be removed
     * <p>
     * @return True or false on whether it could be removed, e.g. if it ever existed.
     */
    @Override
    public boolean removeFeature(F feature)
    {
        return getFeatures().remove(feature);
    }

    /**
     * Adds a variable to the collection
     *
     * @param variable
     */
    @Override
    public void addVariable(String variable)
    {
        getVariables().add(variable);
    }

    /**
     * Removes a variable from the collection
     *
     * @param variable
     */
    @Override
    public void removeVariable(String variable)
    {
        getVariables().remove(variable);
    }

    /**
     * Returns the list of variables
     *
     * @return
     */
    @Override
    public List<String> getVariables()
    {
        if (variables == null)
        {
            variables = new ArrayList<>();
        }
        return variables;
    }

    /**
     * Returns any client side options available with this component
     *
     * @return
     */
    @Override
    public JavaScriptPart getOptions()
    {
        return null;
    }

    /**
     * Sets all features beneath to tiny
     *
     * @param tiny
     *
     * @return
     */
    @Override
    public J setTiny(boolean tiny)
    {
        for (Iterator<F> iterator = getFeatures().iterator(); iterator.hasNext();)
        {
            ComponentFeatureBase next = (ComponentFeatureBase) iterator.next();
            next.setTiny(tiny);
        }
        return super.setTiny(tiny);
    }

    /**
     * Sets if this feature must be rendered in an $(document).ready statement
     *
     * @return
     */
    @Override
    public boolean isRenderAfterLoad()
    {
        return renderAfterLoad;
    }

    /**
     * Sets if this feature must be rendered in an $(document).ready statement
     *
     * @param renderAfterLoad
     */
    public void setRenderAfterLoad(boolean renderAfterLoad)
    {
        this.renderAfterLoad = renderAfterLoad;
    }

    /**
     * Gets the render priority of this feature
     *
     * @return
     */
    @Override
    public RequirementsPriority getPriority()
    {
        return priority;
    }

    /**
     * Sets the render priority of this feature
     *
     * @param priority
     */
    public void setPriority(RequirementsPriority priority)
    {
        this.priority = priority;
    }

    /**
     * Returns if the JavaScript for this component is rendered elsewhere
     *
     * @return
     */
    public boolean isJavascriptRenderedElsewhere()
    {
        return javascriptRenderedElsewhere;
    }

    /**
     * Returns if the JavaScript for this component is rendered elsewhere
     *
     * @param javascriptRenderedElsewhere
     */
    public void setJavascriptRenderedElsewhere(boolean javascriptRenderedElsewhere)
    {
        this.javascriptRenderedElsewhere = javascriptRenderedElsewhere;
    }

}
