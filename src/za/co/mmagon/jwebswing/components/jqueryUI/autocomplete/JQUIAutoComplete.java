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
package za.co.mmagon.jwebswing.components.jqueryUI.autocomplete;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Input;
import za.co.mmagon.jwebswing.base.html.InputTextType;
import za.co.mmagon.jwebswing.base.html.Label;
import za.co.mmagon.jwebswing.base.html.attributes.LabelAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.components.jqueryUI.themes.JQUIThemeBlocks;

/**
 *
 * @author Marc Magon
 * @since 06 Aug 2015
 * @version 1.0
 */
public class JQUIAutoComplete extends Div<JQUIAutoCompleteChildren, NoAttributes, JQUIAutoCompleteFeatures, JQUIAutoCompleteEvents, JQUIAutoComplete>
{

    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;
    private JQUIAutoCompleteFeature feature;

    private Label label;
    private Input input;

    public JQUIAutoComplete(String label)
    {
        input = new InputTextType();
        this.label = new Label(label, input);
        add(this.label);
        add(input);
        addFeature(feature = new JQUIAutoCompleteFeature(input));
        addClass(JQUIThemeBlocks.UI_Widget);
    }

    /**
     * Gets the label object for the auto complete
     *
     * @return
     */
    public Label getLabel()
    {
        return label;
    }

    /**
     * Sets the label object for the auto complete
     *
     * @param label
     */
    public void setLabel(Label label)
    {
        this.label = label;
        label.addAttribute(LabelAttributes.For, getInput().getID());
    }

    /**
     * Gets the input object for this auto complete
     *
     * @return
     */
    public Input getInput()
    {
        return input;
    }

    /**
     * Sets the input object
     *
     * @param input
     */
    public void setInput(Input input)
    {
        remove(input);
        input.addFeature(feature = new JQUIAutoCompleteFeature(input));
        this.input = input;
    }

    /**
     * Returns the feature attached to this component
     * <p>
     * @return
     */
    public JQUIAutoCompleteFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUIAutoCompleteFeature(input);
        }
        return feature;
    }

    /**
     * Sets the feature for the Auto Complete Function
     * <p>
     * @param feature
     */
    public void setFeature(JQUIAutoCompleteFeature feature)
    {
        this.feature = feature;
    }

    /**
     * Returns the options supported for the auto complete
     * <p>
     * @return
     */
    public JQUIAutoCompleteOptions getOptions()
    {
        return getFeature().getOptions();
    }
}
