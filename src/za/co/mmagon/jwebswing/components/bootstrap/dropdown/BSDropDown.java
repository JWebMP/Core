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
package za.co.mmagon.jwebswing.components.bootstrap.dropdown;

import za.co.mmagon.jwebswing.base.ComponentHTMLBootstrapBase;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHTMLBootstrapBase;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDefaultOptions;
import za.co.mmagon.jwebswing.components.bootstrap.dropdown.menu.BSDropDownMenu;

/**
 * Dropdowns
 * <p>
 * Dropdowns are toggleable, contextual overlays for displaying lists of links and more. They’re made interactive with the included Bootstrap dropdown JavaScript plugin. They’re toggled by clicking,
 * not by hovering; this is an intentional design decision.
 * <p>
 * @author Marc Magon
 * @since 13 Jan 2017
 * @version 1.0
 */
public class BSDropDown extends Div<BSDropDownChildren, BSDropDownAttributes, BSDropDownFeatures, BSDropDownEvents, BSDropDown>
{

    private static final long serialVersionUID = 1L;
    private BSDropDownFeature feature;

    /**
     * The button for the drop down,
     */
    private ComponentHTMLBootstrapBase dropdownButton;

    /**
     * The dropdownMenu for this drop down
     */
    private BSDropDownMenu dropdownMenu;

    /**
     * Construct a new bootstrap drop down
     */
    public BSDropDown()
    {
        addClass(BSComponentDropDownOptions.Dropdown);
    }

    /**
     * Construct a new drop down
     *
     * @param link
     */
    public BSDropDown(BSDropDownLink link)
    {
        this();
        setDropdownButton(link);
    }

    /**
     * Constructs a new bootstrap drop down with the given button
     *
     * @param button
     */
    public BSDropDown(BSDropDownButton button)
    {
        this();
        setDropdownButton(button);
    }

    /**
     * Returns the current dropdownMenu or a new one
     *
     * @return
     */
    public BSDropDownMenu getDropdownMenu()
    {
        if (dropdownMenu == null)
        {
            setMenu(new BSDropDownMenu());
        }
        return dropdownMenu;
    }

    /**
     * Sets the dropdownMenu
     *
     * @param menu
     *
     * @return
     */
    public BSDropDown setMenu(BSDropDownMenu menu)
    {
        this.dropdownMenu = menu;
        return this;
    }

    /**
     * Returns the drop down button
     *
     * @return
     */
    public ComponentHTMLBootstrapBase getDropdownButton()
    {
        if (dropdownButton == null)
        {
            setDropdownButton(new BSDropDownLink());
        }
        return dropdownButton;
    }

    /**
     * Sets the drop down dropdownMenu button
     *
     * @param <T>            bs drop down children type
     * @param dropdownButton
     *
     * @return
     */
    public final <T extends BSDropDownChildren & IComponentHTMLBootstrapBase> BSDropDown setDropdownButton(T dropdownButton)
    {
        this.dropdownButton = (ComponentHTMLBootstrapBase) dropdownButton;
        //dropdownButton.addClass(BSComponentDropDownOptions.Dropdown_Toggle);
        return this;
    }

    /**
     * Doesn't return anything
     *
     * @return
     */
    public final BSDropDownFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSDropDownFeature(this);
        }
        return feature;
    }

    /**
     * Doesn't return anything
     *
     * @return
     */
    @Override
    public BSDropDownOptions getOptions()
    {
        return getFeature().getOptions();
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getDropdownButton().addAttribute("role", "button");
            add((BSDropDownChildren) getDropdownButton());
            add((BSDropDownChildren) getDropdownMenu());

            getDropdownMenu().addAttribute(GlobalAttributes.Aria_LabelledBy, getDropdownButton().getID());

            if (Link.class.isAssignableFrom(getDropdownButton().getClass()))
            {
                addClass(BSComponentDefaultOptions.Show);
            }
        }
        super.preConfigure();
    }

}
