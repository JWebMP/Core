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
package za.co.mmagon.jwebswing.components.jqueryUI.radiobutton;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.InputRadioType;
import za.co.mmagon.jwebswing.base.html.Label;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUIRadioButton extends InputRadioType implements JQUIRadioButtonGroupChildren
{

    private static final long serialVersionUID = 1L;
    private final Label radioButtonLabel;
    private Component buttonGroup;

    public JQUIRadioButton(Component buttonGroup)
    {
        this("Empty Label", buttonGroup);

    }

    /**
     *
     * @param name A group name for the radio button
     */
    public JQUIRadioButton(String name, Component buttonGroup)
    {
        this.buttonGroup = buttonGroup;
        radioButtonLabel = new Label(name);
        radioButtonLabel.setTiny(true);
        radioButtonLabel.setForInputComponent(this);
        addAttribute(GlobalAttributes.Name, buttonGroup.getID());
    }

    /**
     * Sets the name of the radio button
     * <p>
     * @param name
     */
    @Override
    public JQUIRadioButton setName(String name)
    {
        radioButtonLabel.setLabel(name);
        return this;
    }

    @Override
    protected StringBuilder renderAfterChildren()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(radioButtonLabel.toString(true));
        return sb;
    }

}
