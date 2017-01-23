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
package za.co.mmagon.jwebswing.components.jqueryui.spinner;

import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.components.globalize.cultures.GlobalizeCultures;

/**
 *
 * @author GedMarc
 * @since Mar 9, 2015
 * @version 1.0
 * <p>
 *
 */
public final class JQUISpinnerTime extends Div<JQUISpinnerChildren, NoAttributes, JQUISpinnerFeatures, JQUISpinnerEvents, JQUISpinnerTime>
{

    private static final long serialVersionUID = 1L;
    /**
     * The default header text for the time spinner
     */
    private String headerText = "JQuery UI Spinner Demo";
    /**
     * The component input
     */
    private Input input;

    /**
     * The pre-child labour
     */
    private Label entryLabel;
    /**
     * The spinner feature
     */
    private JQUISpinnerTimeFeature feature;

    /**
     * Constructs a new spinner paragraph object
     * <p>
     */
    public JQUISpinnerTime()
    {
        this(null);
    }

    /**
     * Constructs a new spinner paragraph object
     * <p>
     * @param labelText THe label of the Spinner
     */
    public JQUISpinnerTime(String labelText)
    {

        if (labelText != null)
        {
            entryLabel = new Label(labelText);
            input = new Input();
            add(entryLabel);
            add(input);
            input.addFeature(getFeature());
            input.setID(getID() + "_spinnerInput");
            entryLabel.setForInputComponent(input);
        }
    }

    /**
     * Returns the label object with this spinner
     * <p>
     * @return
     */
    public Label getEntryLabel()
    {
        return entryLabel;
    }

    /**
     * Sets the entry label with this spinner
     * <p>
     * @param entryLabel
     */
    public void setEntryLabel(Label entryLabel)
    {
        this.entryLabel = entryLabel;
    }

    /**
     * Returns the options associated with this spinner
     * <p>
     * @return
     */
    @Override
    public JQUISpinnerOptions getOptions()
    {
        return feature.getOptions();
    }

    public JQUISpinnerTimeFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUISpinnerTimeFeature(input);
        }
        return feature;
    }

    /**
     * Adds the specific culture to the options
     *
     * @param culture
     */
    public void addGlobalization(GlobalizeCultures culture)
    {
        getFeature().getJavascriptReferences().add(culture.getJavascriptCoreReference());
        getJavascriptReferences().add(culture.getJavascriptReference());
        getOptions().setCulture(culture.toString());
    }

}
