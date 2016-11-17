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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.LabelAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryui.autocomplete.JQUIAutoCompleteChildren;
import za.co.mmagon.jwebswing.components.jqueryui.checkbox.JQUICheckBoxGroupChildren;
import za.co.mmagon.jwebswing.components.jqueryui.radiobutton.JQUIRadioButtonGroupChildren;
import za.co.mmagon.jwebswing.components.jqueryui.spinner.JQUISpinnerChildren;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;label&lt; tag defines a label for an &gt;input&lt; element.<p>
 * <p>
 * The &gt;label&lt; element does not render as anything special for the user. However, it provides a usability improvement for mouse users, because if the user clicks on the text within the
 * &gt;label&lt;
 * <p>
 * element, it toggles the control.<p>
 * <p>
 * The for attribute of the &gt;label&lt; tag should be equal to the id attribute of the related element to bind them together. Browser Support Element<p>
 * &gt;label&lt; Yes Yes Yes Yes Yes Tips and Notes<p>
 * <p>
 * Tip: A label can be bound to an element either by using the "for" attribute, or by placing the element inside the &gt;label&lt; element. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "form" attribute is new in HTML5.<p>
 * <p>
 * @author GedMarc
 * @since Feb 9, 2015
 * @version 1.0
 * <p>
 *
 */
public final class Label extends Component<NoChildren, LabelAttributes, GlobalFeatures, GlobalEvents, Label>
        implements JQUICheckBoxGroupChildren, JQUIRadioButtonGroupChildren, ParagraphChildren, JQUIAutoCompleteChildren, NoNewLineBeforeChildren, NoNewLineForRawText, NoNewLineBeforeClosingTag, JQUISpinnerChildren
{

    private static final long serialVersionUID = 1L;
    private Input forInputComponent;
    private Form forFormComponent;

    /**
     * Constructs a new label with the attribute set
     * <p>
     * @param label
     */
    public Label(String label)
    {
        super(ComponentTypes.Label);
        setLabel(label);
    }

    /**
     * Constructs a new label with the attribute set and the component specified
     * <p>
     * @param label
     * @param forInputComponent
     */
    public Label(String label, Input forInputComponent)
    {
        super(ComponentTypes.Label);
        setForInputComponent(forInputComponent);
        setLabel(label);
        if (forInputComponent != null)
        {
            addAttribute(LabelAttributes.For, label);
        }

    }

    /**
     * Sets the text of this label
     * <p>
     * @param label
     */
    public void setLabel(String label)
    {
        setText(label);
    }

    /**
     * Gets the text of this label
     * <p>
     * @return
     */
    public String getLabel()
    {
        return getText(0).toString();
    }

    /**
     * Returns the input type for which this is the component for
     * <p>
     * @return
     */
    public Input getForInputComponent()
    {
        return forInputComponent;
    }

    /**
     * Sets the for component with the given ID
     * <p>
     * @param forInputComponent
     */
    public void setForInputComponent(Input forInputComponent)
    {
        this.forInputComponent = forInputComponent;
        addAttribute(LabelAttributes.For, forInputComponent.getID());
    }

    /**
     * Returns the form component that the label is attached to
     * <p>
     * @return
     */
    public Form getForFormComponent()
    {
        return forFormComponent;
    }

    /**
     * Sets the form for which the label is for
     * <p>
     * @param forFormComponent
     */
    public void setForFormComponent(Form forFormComponent)
    {
        this.forFormComponent = forFormComponent;
        addAttribute(LabelAttributes.Form, forInputComponent.getID());
    }

}
