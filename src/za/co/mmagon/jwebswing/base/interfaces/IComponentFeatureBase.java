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
package za.co.mmagon.jwebswing.base.interfaces;

import java.util.List;
import za.co.mmagon.jwebswing.base.ComponentBase;
import za.co.mmagon.jwebswing.base.ComponentFeatureBase;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @param <F>
 * @param <J>
 * @since 2016/09/26
 * 
 */
public interface IComponentFeatureBase<F extends GlobalFeatures, J extends ComponentBase> 
{

    /**
     * Adds a feature to the collection
     *
     * @param feature
     * @param position
     * @return 
     */
    J addFeature(ComponentFeatureBase feature, int position);

    /**
     * Adds a feature to the collection
     *
     * @param feature
     * @return 
     */
    J addFeature(ComponentFeatureBase feature);

    /**
     * Adds a variable to the collection
     *
     * @param variable
     */
    void addVariable(String variable);

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    List<CSSReference> getCssReferencesAll();

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    List<JavascriptReference> getJavascriptReferencesAll();

    /**
     * Returns the name of this feature
     *
     * @return the name of this feature
     */
    String getName();

    /**
     * Returns any client side options available with this component
     *
     * @return
     */
    JavaScriptPart getOptions();

    /**
     * Gets the render priority of this feature
     *
     * @return
     */
    RequirementsPriority getPriority();

    /**
     * Returns all Queries Associated with a component
     *
     * @return
     */
    List<StringBuilder> getQueriesAll();

    /**
     * Sets the sort order for this feature. Default 10000
     * 
     * @return
     */
    Integer getSortOrder();

    /**
     * Returns the list of variables
     *
     * @return
     */
    List<String> getVariables();

    /**
     * Sets if this feature must be rendered in an $(document).ready statement
     *
     * @return
     */
    boolean isRenderAfterLoad();

    /**
     * Removes a feature from the components collection
     * <p>
     * @param feature The feature to be removed
     * <p>
     * @return True or false on whether it could be removed, e.g. if it ever
     *         existed.
     */
    boolean removeFeature(F feature);

    /**
     * Removes a variable from the collection
     *
     * @param variable
     */
    void removeVariable(String variable);

    /**
     * Renders the JavaScript for this Builder
     *
     * @return
     */
    StringBuilder renderJavascript();

    /**
     * Specifies whether or not this feature actually contains some JavaScript lines or is just a link
     *
     * @return True if a script is located inside the feature
     */
    boolean scriptAvailable();

}
