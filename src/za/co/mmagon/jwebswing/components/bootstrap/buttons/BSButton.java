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
package za.co.mmagon.jwebswing.components.bootstrap.buttons;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.buttons.groups.BSButtonGroupChildren;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDefaultOptions;
import za.co.mmagon.jwebswing.components.bootstrap.dropdown.BSDropDownChildren;
import za.co.mmagon.jwebswing.components.bootstrap.forms.BSFormChildren;

/**
 * Buttons
 * <p>
 * Use Bootstrap’s custom button styles for actions in forms, dialogs, and more. Includes support for a handful of contextual variations, sizes, states, and more.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSButton extends Div<BSButtonChildren, BSButtonAttributes, BSButtonFeatures, BSButtonEvents, BSButton>
        implements BSButtonGroupChildren, BSDropDownChildren, BSFormChildren
{

    private static final long serialVersionUID = 1L;
    private BSButtonFeature feature;

    /**
     * Constructs a new button
     */
    public BSButton()
    {
        addClass(BSComponentButtonOptions.Btn);
        setTag("button");
        addAttribute(GlobalAttributes.Type, "button");
    }

    /**
     * Constructs a new BS Button with the given text
     *
     * @param text
     */
    public BSButton(String text)
    {
        this();
        setText(text);
    }

    /**
     * Returns the feature associated (nothing really)
     *
     * @return
     */
    public final BSButtonFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSButtonFeature(this);
        }
        return feature;
    }

    /**
     * Returns the options associated (nothing really here either)
     *
     * @return
     */
    @Override
    public BSButtonOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Button tags
     * <p>
     * The .btn classes are designed to be used with the &lt;button&gt; element.
     * <p>
     * However, you can also use these classes on &lt;a&gt; or &lt;input&gt; elements (though some browsers may apply a slightly different rendering). &lt;p&gt; When using button classes on &lt;a&gt;
     * elements that are used to trigger in-page functionality (like collapsing content), rather than linking to new pages or sections within the current page, these links should be given a
     * role="button" to appropriately convey their purpose to assistive technologies such as screen readers.
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            if ("a".equalsIgnoreCase(getTag()))
            {
                addAttribute(BSButtonAttributes.Role, "button");
            }
        }
        super.preConfigure();
    }

    /**
     * Sizes
     * <p>
     * Fancy larger or smaller buttons? Add .btn-lg or .btn-sm for additional sizes.
     *
     * @param size
     *
     * @return
     */
    public BSButton setSize(BSComponentButtonSizeOptions size)
    {
        for (BSComponentButtonSizeOptions value : BSComponentButtonSizeOptions.values())
        {
            removeClass(value.toString());
        }
        addClass(size);

        return this;
    }

    /**
     * Buttons will appear pressed (with a darker background, darker border, and inset shadow) when active.
     * <p>
     * There’s no need to add a class to buttons as they use a pseudo-class. However, you can still force the same active appearance with .active (and include the aria-pressed="true" attribute) should
     * you need to replicate the state programmatically.
     *
     * @param pressed
     *
     * @return
     */
    public BSButton setPressed(boolean pressed)
    {
        if (pressed)
        {
            addAttribute(GlobalAttributes.Aria_Pressed, "true");
            addClass(BSComponentDefaultOptions.Active);
        }
        else
        {
            getAttributesGlobal().remove(GlobalAttributes.Aria_Pressed);
            removeClass(BSComponentDefaultOptions.Active.toString());
        }

        return this;
    }

    /**
     * Disabled state
     * <p>
     * Make buttons look inactive by adding the disabled boolean attribute to any button element.
     * <p>
     * Heads up! IE9 and below render disabled buttons with gray, shadowed text that we can’t override.
     * <p>
     * Disabled buttons using the a element behave a bit different:
     * <p>
     * a's don’t support the disabled attribute, so you must add the .disabled class to make it visually appear disabled. Some future-friendly styles are included to disable all pointer-events on
     * anchor buttons. In browsers which support that property, you won’t see the disabled cursor at all. Disabled buttons should include the aria-disabled="true" attribute to indicate the state of
     * the element to assistive technologies.
     * <p>
     * <p>
     * <p>
     * Link functionality caveat
     * <p>
     * The .disabled class uses pointer-events: none to try to disable the link functionality of as, but that CSS property is not yet standardized. In addition, even in browsers that do support
     * pointer-events: none, keyboard navigation remains unaffected, meaning that sighted keyboard users and users of assistive technologies will still be able to activate these links. So to be safe,
     * add a tabindex="-1" attribute on these links (to prevent them from receiving keyboard focus) and use custom JavaScript to disable their functionality.
     *
     * @param disabled
     *
     * @return
     */
    public BSButton setDisabled(boolean disabled)
    {
        if (disabled)
        {
            addAttribute(GlobalAttributes.Aria_Disabled, "true");
            addAttribute(BSButtonAttributes.Disabled, "");
        }
        else
        {
            getAttributesAll().remove(BSButtonAttributes.Disabled);
            getAttributesGlobal().remove(GlobalAttributes.Aria_Disabled);
        }

        return this;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }
}
