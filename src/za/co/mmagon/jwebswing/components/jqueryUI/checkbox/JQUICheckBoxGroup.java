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
package za.co.mmagon.jwebswing.components.jqueryUI.checkbox;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Label;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUICheckBoxGroup extends Div<JQUICheckBoxGroupChildren, NoAttributes, GlobalFeatures, GlobalEvents, JQUICheckBoxGroup>
{

    private JQUICheckBoxGroupFeature feature;

    /**
     * Constructs a new Check Box Group
     */
    public JQUICheckBoxGroup()
    {
        addFeature(getFeature());
    }

    /**
     * Adds a new Check Box to the group
     * <p>
     * @param label    the label to create
     * @param checkBox the check box to add
     */
    public void addCheckBox(Label label, JQUICheckBox checkBox)
    {
        label.setForInputComponent(checkBox);
        add(checkBox);
        add(label);

    }

    /**
     * Adds a new Check Box to the group
     * <p>
     * @param label    the label to create
     * @param checkBox the check box to add
     * @return The label object that is created
     */
    public Label addCheckBox(String label, JQUICheckBox checkBox)
    {
        Label labelNew;
        addCheckBox(labelNew = new Label(label), checkBox);
        return labelNew;
    }

    /**
     * Returns this groups feature
     * <p>
     * @return
     */
    public final JQUICheckBoxGroupFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUICheckBoxGroupFeature(this);
        }
        return feature;
    }

}
