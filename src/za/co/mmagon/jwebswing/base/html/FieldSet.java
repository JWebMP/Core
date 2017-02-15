/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.FieldSetChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.FormChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The fieldset tag is used to group related elements in a form.
 * <p>
 * The fieldset tag draws a box around the related elements. Browser Support Element fieldset Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: The legend tag defines a caption for the fieldset element. Differences Between HTML 4.01 and HTML5
 * <p>
 * HTML5 has added new attributes for fieldset.
 * <p>
 * @author GedMarc
 * @param <J>
 */
public class FieldSet<J extends FieldSet>
        extends Component<FieldSetChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements FormChildren, NoIDTag
{

    private static final long serialVersionUID = 1L;
    /**
     * The legend if any is applied
     */
    private Legend legend;

    /**
     * Constructs a new instance of Field Set
     */
    public FieldSet()
    {
        super(ComponentTypes.FieldSet);
        add(legend);
    }

    /**
     * Sets the legend
     *
     * @param legendText
     */
    public void setLegendText(String legendText)
    {
        if (legend == null)
        {
            legend = new Legend();
            legend.setText(legendText);
            add(legend);
        }
        else
        {
            legend.setText(legendText);
        }
    }

    /**
     * Returns the legends text
     *
     * @return
     */
    public String getLegendText()
    {
        return legend.getText(0).toString();
    }

}
