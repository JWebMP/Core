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
package za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import java.util.logging.*;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.DataAdapter;
import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.options.JQXDataAdapterOptions;
import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.options.JQXDataAdapterSourceData;
import za.co.mmagon.jwebswing.components.pools.jqxwidgets.JQXReferencePool;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A Data Adapter Component
 * <p>
 * @author Marc Magon
 * @param <A> The attribute
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXDataAdapter<A extends JQXDataAdapterSourceData> 
        extends DataAdapter<JQXDataAdapterChildren, JQXDataAdapterAttributes, JQXDataAdapterFeature, JQXDataAdapterEvents, JQXDataAdapter> implements IJQXDataAdapter<A>
{

    private static final long serialVersionUID = 1L;
    private JQXDataAdapterFeature<A> feature;

    /**
     * Constructs a new Data Adapter 
     * @param component 
     */
    public JQXDataAdapter(Component component)
    {
        super(component);
        addFeature(getFeature());
        if (component != null)
        {
            component.getJavascriptReferences().add(JQXReferencePool.Data.getJavaScriptReference());
        }
    }
    
    /**
     * Returns a cleaner version of me
     * @return 
     */
    public IJQXDataAdapter asMe()
    {
        return this;
    }

    /**
     * Returns the JS feature for this data adapter
     * @return 
     */
    @Override
    public final JQXDataAdapterFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXDataAdapterFeature(this);
        }
        return feature;
    }

    /**
     * Returns all the options associated with the given feature
     * @return 
     */
    @Override
    public JQXDataAdapterOptions<A> getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Renders the given JavaScript for the given component
     * @return 
     */
    @Override
    public StringBuilder renderJavascript()
    {
        JQXDataAdapterSourceData dataPacket = getOptions().getLocaldata();
        try
        {
            //if (dataPacket == null)
            //{
            //    log.log(Level.SEVERE,"No Data Packet", new ServletException("There Is No Data Packet To Send"));
            //}
            return new StringBuilder(JavaScriptPart.getJsonObjectMapper().writeValueAsString(dataPacket));
        }
        catch (JsonProcessingException ex)
        {
            Logger.getLogger(JQXDataAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new StringBuilder();
    }

    @Override
    protected StringBuilder renderHTML(int tabCount)
    {
        return new StringBuilder();
    }
    
}
