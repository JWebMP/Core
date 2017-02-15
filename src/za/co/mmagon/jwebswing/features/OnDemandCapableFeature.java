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
package za.co.mmagon.jwebswing.features;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentFeatureBase;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Describes a client event feature
 * <p>
 * @since 2014/09/29
 * @version 1.0
 * @author MMagon
 * <p>
 */
public abstract class OnDemandCapableFeature extends Feature<JavaScriptPart, Feature>
{

    private ArrayList<ComponentFeatureBase> onDemandFeatures;
    private boolean serverActing = true;
    private boolean onDemandActing = true;

    /**
     * Constructs a new On-Demand Capable ComponentFeatureBase
     * <p>
     * @param name      The name of this feature
     * @param component The component rendering for (Client Side Event Triggering component)
     */
    public OnDemandCapableFeature(String name, Component component)
    {
        super(name);
        setComponent(component);
    }

    /**
     * A List of Of-Demand capable renderer
     * <p>
     * @return
     */
    protected ArrayList<ComponentFeatureBase> getOnDemandFeatures()
    {
        if (onDemandFeatures == null)
        {
            return onDemandFeatures = new ArrayList<>();
        }

        return onDemandFeatures;
    }

    /**
     * Adds the on-demand scripts to the functions being assigned
     * <p>
     */
    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> currentFunctionsToComponent = new ArrayList<>();
        getOnDemandFeatures().stream().forEach((next)
                ->
                {
                    addQuery(next.renderJavascript());
        });
    }

    /**
     * Sets if this event is on demand
     * <p>
     * @param isOnDemandActing
     */
    public void setIsOnDemandActing(boolean isOnDemandActing)
    {
        this.onDemandActing = isOnDemandActing;
    }

    /**
     * Sets if this event occurs on the server end. Default is true
     * <p>
     * @return
     */
    public boolean isServerActing()
    {
        return serverActing;
    }

    /**
     * Sets if this event occurs on the server end. Default is true
     * <p>
     * @param serverActing
     */
    public void setServerActing(boolean serverActing)
    {
        this.serverActing = serverActing;
    }

    /**
     * Sets if this event is on demand
     * <p>
     * @return
     */
    public boolean isOnDemandActing()
    {
        return onDemandActing;
    }

    /**
     * Sets if this event occurs on the client end. Default is false
     * <p>
     * @param onDemandActing
     */
    public void setOnDemandActing(boolean onDemandActing)
    {
        this.onDemandActing = onDemandActing;
    }

}
