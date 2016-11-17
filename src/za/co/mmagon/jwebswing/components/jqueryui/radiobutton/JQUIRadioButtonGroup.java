/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryui.radiobutton;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Label;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.components.jqueryui.button.JQUIButtonGroupOptions;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUIRadioButtonGroup extends Div<JQUIRadioButtonGroupChildren, NoAttributes, GlobalFeatures, GlobalEvents, JQUIRadioButtonGroup>
{

    private static final long serialVersionUID = 1L;

    private JQUIRadioButtonGroupFeature feature;

    /**
     *
     */
    public JQUIRadioButtonGroup()
    {
        addFeature(getFeature());

    }

    /**
     * Adds a radio button to the group
     *
     * @param radioButtonLabel
     * @param radioButton
     */
    public void addRadioButton(Label radioButtonLabel, JQUIRadioButton radioButton)
    {
        add(radioButton);
        add(radioButtonLabel);
        radioButtonLabel.setForInputComponent(radioButton);
    }

    /**
     * Adds a radio button to the group
     *
     * @param radioButtonLabel
     * @param radioButton
     * @return The new label
     */
    public Label addRadioButton(String radioButtonLabel, JQUIRadioButton radioButton)
    {
        Label lab;
        addRadioButton(lab = new Label(radioButtonLabel), radioButton);
        return lab;
    }

    public final JQUIRadioButtonGroupFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUIRadioButtonGroupFeature(this);
        }
        return feature;
    }

    public JQUIButtonGroupOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
