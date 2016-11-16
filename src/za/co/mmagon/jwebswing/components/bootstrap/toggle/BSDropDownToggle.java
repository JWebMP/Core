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
package za.co.mmagon.jwebswing.components.bootstrap.toggle;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.List;
import za.co.mmagon.jwebswing.base.html.attributes.ButtonAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.LinkAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2ThemeClasses;

/**
 * An implementation of the Bootstrap Toggle Feature
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSDropDownToggle extends Div<BSToggleChildren, BSToggleAttributes, BSToggleFeatures, BSToggleEvents, BSDropDownToggle>
{

    private static final long serialVersionUID = 1L;
    private BSToggleFeature feature;
    private Component title;
    private List contents;

    /**
     * Construct a new toggle item with the given items
     *
     * @param titleItem Displays by default, clickable to show the contents
     * @param contents
     */
    public BSDropDownToggle(Link titleItem, List contents)
    {
        addFeature(getFeature());
        setTag(titleItem.getTag());
        setTitle(titleItem);
        setContents(contents);
    }

    /**
     * Construct a new toggle item with the given items
     *
     * @param titleItem Displays by default, clickable to show the contents
     * @param contents
     */
    public BSDropDownToggle(Button titleItem, List contents)
    {
        addFeature(getFeature());
        setTag(titleItem.getTag());
        setTitle(titleItem);
        setContents(contents);
    }

    /**
     * Returns the title component
     *
     * @return
     */
    public ComponentHierarchyBase getTitle()
    {
        return title;
    }

    /**
     * Sets the title
     *
     * @param title
     */
    public final void setTitle(Button title)
    {
        getChildren().remove(this.title);

        this.title = title;
        if (title != null)
        {
            getChildren().add(0, this.title);
            this.title.addClass(SB2ThemeClasses.DropDown_Toggle);
            title.addAttribute(ButtonAttributes.Data_Toggle, "dropdown");
            if (contents != null)
            {
                title.addAttribute(ButtonAttributes.Data_Target, contents.getID(true));
            }
        }
    }

    /**
     * Sets the title
     *
     * @param title
     */
    public final void setTitle(Link title)
    {
        getChildren().remove(this.title);
        this.title = title;
        if (title != null)
        {
            getChildren().add(0, this.title);
            this.title.addClass(SB2ThemeClasses.DropDown_Toggle);
            title.addAttribute(LinkAttributes.Data_Toggle, "dropdown");
            if (contents != null)
            {
                title.addAttribute(LinkAttributes.Data_Target, contents.getID(true));
            }
        }
    }

    /**
     * Returns the contents
     *
     * @return
     */
    public List getContents()
    {
        return contents;
    }

    /**
     * Sets the contents
     *
     * @param contents
     */
    public final void setContents(List contents)
    {
        this.contents = contents;

        if (contents != null)
        {
            contents.addClass(SB2ThemeClasses.DropDown_Menu);
            title.addAttribute(ButtonAttributes.Data_Toggle, "dropdown");
            title.addAttribute(ButtonAttributes.Data_Target, contents.getID(true));
        }
    }

    /**
     * Doesn't return anything
     *
     * @return
     */
    public final BSToggleFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSToggleFeature(this);
        }
        return feature;
    }

    /**
     * Doesn't return anything
     *
     * @return
     */
    @Override
    public BSToggleOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
