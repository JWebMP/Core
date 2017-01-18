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
package za.co.mmagon.jwebswing.components.bootstrap.forms;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;

/**
 * Forms
 * <p>
 * Bootstrap provides several form control styles, layout options, and custom components for creating a wide variety of forms.
 * <p>
 * @author Marc Magon
 * @since 14 Jan 2017
 * @version 1.0
 */
public class BSForm extends Div<BSFormChildren, BSFormAttributes, BSFormFeatures, BSFormEvents, BSForm>
{

    private static final long serialVersionUID = 1L;
    /**
     * The form feature not really used
     */
    private BSFormFeature feature;

    /**
     * Forms
     * <p>
     * Bootstrap provides several form control styles, layout options, and custom components for creating a wide variety of forms.
     */
    public BSForm()
    {
        setTag("form");
    }

    /**
     * Returns the feature
     *
     * @return
     */
    public final BSFormFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSFormFeature(this);
        }
        return feature;
    }

    /**
     * Returns the get options (nothing for this)
     *
     * @return
     */
    @Override
    public BSFormOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Pre configures the item with a name
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            addAttribute(GlobalAttributes.Name, getID());
        }
        super.preConfigure();
    }

}
