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
package za.co.mmagon.jwebswing.components.jqxwidgets.combobox;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * jqxComboBox represents a jQuery combobox widget that contains an input field with auto-complete functionality and a list of selectable items displayed in a drop-down.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXComboBox extends Div<JQXComboBoxChildren, JQXComboBoxAttributes, JQXComboBoxFeature, JQXComboBoxEvents, JQXComboBox>
{

    private static final long serialVersionUID = 1L;
    private JQXComboBoxFeature feature;

    public JQXComboBox()
    {
        addFeature(getFeature());
    }

    public JQXComboBoxFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXComboBoxFeature(this);
        }
        return feature;
    }

    @Override
    public JQXComboBoxOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
