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
package za.co.mmagon.jwebswing.components.jqxWidgets.navigationbar;

import java.util.ArrayList;
import java.util.Objects;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.utilities.ComponentUtils;

/**
 * jqxNavigationBar represents a jQuery widget that has header and content sections(like tabs). Click headers to expand or collapse the content.
 * Optionally you can change the default toggle mode to double-click or mouse-over.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXNavigationBar extends Div<GlobalChildren, JQXNavigationBarAttributes, JQXNavigationBarFeature, JQXNavigationBarEvents, JQXNavigationBar>
{

    private static final long serialVersionUID = 1L;
    private JQXNavigationBarFeature feature;
    private ArrayList<NavigationBarGroup> groups;

    public JQXNavigationBar()
    {
        addFeature(getFeature());
    }

    public final JQXNavigationBarFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXNavigationBarFeature(this);
        }
        return feature;
    }

    @Override
    public JQXNavigationBarOptions getOptions()
    {
        return getFeature().getOptions();
    }

    public void addGroup(NavigationBarGroup group)
    {
        getGroups().add(group);
        add(group.getHeader());
        add(group.getContent());
    }

    public ArrayList<NavigationBarGroup> getGroups()
    {
        if (groups == null)
        {
            groups = new ArrayList<>();
        }
        return groups;
    }

    public void setGroups(ArrayList<NavigationBarGroup> groups)
    {
        this.groups = groups;
    }

    public static class NavigationBarGroup
    {

        private Div header;
        private Div content;
        private String name;

        public NavigationBarGroup()
        {
            this("No Header");
        }

        public NavigationBarGroup(String header)
        {
            this(header, new Div());
        }

        public NavigationBarGroup(String header, Div content)
        {
            this.header = new Div();
            ComponentUtils.removeAllMargins(this.header);
            ComponentUtils.removeAllMargins(content);
            Paragraph p = new Paragraph(header);
            ComponentUtils.removeAllMargins(p);
            this.header.add(p);
            setName(header);
            this.content = content;
        }

        public Div getHeader()
        {
            return header;
        }

        public Div getContent()
        {
            return content;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 67 * hash + Objects.hashCode(this.name);
            return hash;
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
            final NavigationBarGroup other = (NavigationBarGroup) obj;
            if (!Objects.equals(this.name, other.name))
            {
                return false;
            }
            return true;
        }

    }

}
