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
package za.co.mmagon.jwebswing.components.bootstrap.buttons.groups;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.buttons.toolbars.BSButtonToolbarChildren;

/**
 * Button group
 * <p>
 * Group a series of buttons together on a single line with the button group. Add on optional JavaScript radio and checkbox style behavior with our buttons plugin.
 * <p>
 * @author Marc Magon
 * @since 01 Jan 2017
 * @version 1.0
 */
public class BSButtonGroup extends Div<BSButtonGroupChildren, BSButtonGroupAttributes, BSButtonGroupFeatures, BSButtonGroupEvents, BSButtonGroup>
        implements BSButtonToolbarChildren, BSButtonGroupChildren
{

    private static final long serialVersionUID = 1L;
    private BSButtonGroupFeature feature;

    /**
     * Button group
     * <p>
     * Group a series of buttons together on a single line with the button group. Add on optional JavaScript radio and checkbox style behavior with our buttons plugin.
     */
    public BSButtonGroup()
    {
        addAttribute(BSButtonGroupAttributes.Role, "group");
        setAriaLabel("Button Group");
        addClass(BSComponentButtonGroupOptions.Btn_Group);
    }

    /**
     * Button group
     * <p>
     * Group a series of buttons together on a single line with the button group. Add on optional JavaScript radio and checkbox style behavior with our buttons plugin.
     *
     * @param size
     */
    @SuppressWarnings("")
    public BSButtonGroup(BSComponentButtonGroupSizeOptions size)
    {
        this();
        setSize(size);
    }

    public final BSButtonGroupFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSButtonGroupFeature(this);
        }
        return feature;
    }

    /**
     * No JS Options.. yet
     *
     * @return
     */
    @Override
    public BSButtonGroupOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Sets the screen reader label for this group
     *
     * @param label
     *
     * @return
     */
    public final BSButtonGroup setAriaLabel(String label)
    {
        addAttribute(GlobalAttributes.Aria_Label, label);

        return this;
    }

    /**
     * Sizes
     * <p>
     * Fancy larger or smaller buttons? Add .btn-lg or .btn-sm for additional sizes.
     *
     * @param size
     *
     * @return
     */
    public BSButtonGroup setSize(BSComponentButtonGroupSizeOptions size)
    {
        for (BSComponentButtonGroupSizeOptions value : BSComponentButtonGroupSizeOptions.values())
        {
            removeClass(value.toString());
        }
        addClass(size);
        return this;
    }
}
