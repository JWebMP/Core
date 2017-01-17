/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.jstree;

import java.util.Map;
import za.co.mmagon.JWebSwingSiteBinder;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IDataComponent;
import za.co.mmagon.jwebswing.components.jstree.events.JSTreeRefreshEvent;
import za.co.mmagon.jwebswing.components.jstree.options.functions.JSTreeCoreDataFunction;
import za.co.mmagon.jwebswing.components.jstree.themes.JSTreeDefaultTheme;
import za.co.mmagon.jwebswing.components.jstree.themes.JSTreeTheme;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * An implementation of the jsTree project.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JSTree extends Div<JSTreeChildren, JSTreeAttributes, JSTreeFeatures, JSTreeEvents, JSTree> implements IDataComponent<JSTreeData>
{

    private static final long serialVersionUID = 1L;

    private JSTreeFeature feature;

    private JSTreeData data;

    /**
     * Constructs a new instance of the JS Tree
     */
    public JSTree()
    {
        addFeature(getFeature());
    }

    /**
     * Adds the AJAX mode
     */
    @Override
    public void preConfigure()
    {
        getPage().getOptions().setjQueryEnabled(true);
        getOptions().getCore().getData().setUrl(JWebSwingSiteBinder.getDataLocation().replace("/", "") + "?component=" + getID());
        getOptions().getCore().getData().setData(new JSTreeCoreDataFunction());
        super.preConfigure();
    }

    /**
     * Returns the data, and any parameters if supplied
     *
     * @param params
     *
     * @return
     */
    @Override
    public JSTreeData getData(Map<String, String[]> params)
    {
        onGetData(params);
        String[] ids = params.get("id");
        String id = ids[0];
        if ("#".equalsIgnoreCase(id))
        {
            return data;
        }
        else
        {
            return data.findNode(id).getChildNodes();
            //go through the nodes looking for the next id item
        }
    }

    /**
     * Execute something before get data is called
     *
     * @param params
     */
    protected void onGetData(Map<String, String[]> params)
    {

    }

    public void setData(JSTreeData data)
    {
        this.data = data;
    }

    public final JSTreeFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JSTreeFeature(this);
        }
        return feature;
    }

    @Override
    public JSTreeOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Set the tree theme
     *
     * @param <J>
     * @param theme
     */
    public <J extends Theme & JSTreeTheme> void setTheme(J theme)
    {
        theme.getCssReferences().forEach(this::addCssReference);
        if (!JSTreeDefaultTheme.class.isAssignableFrom(theme.getClass()))
        {
            getOptions().getCore().getThemes().setName(theme.getName());
        }
    }

    /**
     * Returns a new event that refreshes the tree
     *
     * @return
     */
    public JSTreeRefreshEvent getRefreshEvent()
    {
        return new JSTreeRefreshEvent(this);
    }
}
