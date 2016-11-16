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
package za.co.mmagon.jwebswing.components.jqxWidgets.ribbon;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.List;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.components.jqxWidgets.panel.JQXPanel;

/**
 * jqxRibbon represents a jQuery widget which can be used as a tabbed toolbar or mega menu.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXRibbon extends Div<JQXRibbonChildren, NoAttributes, JQXRibbonFeature, JQXRibbonEvents, JQXRibbon>
{

    private static final long serialVersionUID = 1L;
    private JQXRibbonFeature feature;

    private List unorderedList;
    private Div itemDivs;
    private ArrayList<JQXRibbonItem> ribbonItems;

    public JQXRibbon()
    {
        addFeature(getFeature());
        unorderedList = new List(false);
        itemDivs = new Div();
        add(unorderedList);
        add(itemDivs);
    }

    private JQXRibbonItem addRibbonItem(ListItem item, JQXPanel componentToDisplay)
    {
        JQXRibbonItem rib = new JQXRibbonItem(item, componentToDisplay);
        return addRibbonItem(rib);
    }

    public JQXRibbonItem addRibbonItem(JQXRibbonItem ribbon)
    {
        unorderedList.add(ribbon.getHeader());
        itemDivs.add(ribbon.getContent());
        getRibbonItems().add(ribbon);
        return ribbon;
    }

    public JQXRibbonItem addRibbonItem(String itemHeader, JQXPanel componentToDisplay)
    {
        return addRibbonItem(new ListItem(itemHeader), componentToDisplay);
    }

    public JQXRibbonFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXRibbonFeature(this);
        }
        return feature;
    }

    @Override
    public JQXRibbonOptions getOptions()
    {
        return getFeature().getOptions();
    }

    public ArrayList<JQXRibbonItem> getRibbonItems()
    {
        if (ribbonItems == null)
        {
            ribbonItems = new ArrayList<>();
        }
        return ribbonItems;
    }

    public void setRibbonItems(ArrayList<JQXRibbonItem> ribbonItems)
    {
        if (this.ribbonItems == null)
        {
            this.ribbonItems = new ArrayList<>();
        }
        this.ribbonItems = ribbonItems;
    }

    public static class JQXRibbonItem
    {

        private ListItem header;
        private Div content;

        public JQXRibbonItem(ListItem header, Div content)
        {
            this.header = header;
            this.content = content;
        }

        public JQXRibbonItem(ListItem header)
        {
            this(header, null);
        }

        public ListItem getHeader()
        {
            return header;
        }

        public void setHeader(ListItem header)
        {
            this.header = header;
        }

        public Div getContent()
        {
            return content;
        }

        public void setContent(Div content)
        {
            this.content = content;
        }
    }
}
