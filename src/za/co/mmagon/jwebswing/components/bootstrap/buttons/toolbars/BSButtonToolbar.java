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
package za.co.mmagon.jwebswing.components.bootstrap.buttons.toolbars;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;

/**
 * Button toolbar
 * <p>
 * Combine sets of button groups into button toolbars for more complex components.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSButtonToolbar extends Div<BSButtonToolbarChildren, BSButtonToolbarAttributes, BSButtonToolbarFeatures, BSButtonToolbarEvents, BSButtonToolbar>
{

    private static final long serialVersionUID = 1L;
    private BSButtonToolbarFeature feature;

    /**
     * Button toolbar
     * <p>
     * Combine sets of button groups into button toolbars for more complex components.
     */
    public BSButtonToolbar()
    {
        addAttribute(BSButtonToolbarAttributes.Role, "toolbar");
        setAriaLabel("Button Toolbar");
        addClass(BSComponentButtonToolbarOptions.Btn_Toolbar);
    }

    /**
     * Returns an object but does nothing
     *
     * @return
     */
    public final BSButtonToolbarFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSButtonToolbarFeature(this);
        }
        return feature;
    }

    /**
     * Returns an object but does nothing... for now.. oooooo
     *
     * @return
     */
    @Override
    public BSButtonToolbarOptions getOptions()
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
    public final BSButtonToolbar setAriaLabel(String label)
    {
        addAttribute(GlobalAttributes.Aria_Label, label);

        return this;
    }
    
    
}
