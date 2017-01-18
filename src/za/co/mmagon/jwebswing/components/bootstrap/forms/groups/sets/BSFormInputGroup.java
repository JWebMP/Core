/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.forms.groups.sets;

import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.components.bootstrap.forms.controls.BSFormSelectInput;
import za.co.mmagon.jwebswing.components.bootstrap.forms.controls.BSInput;
import za.co.mmagon.jwebswing.components.bootstrap.forms.groups.BSFormGroupChildren;

/**
 * Input group
 * <p>
 * Easily extend form controls by adding text, buttons, or button groups on either side of textual inputs.
 *
 * @author GedMarc
 * @since 18 Jan 2017
 *
 */
public class BSFormInputGroup extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, BSFormInputGroup>
        implements BSFormGroupChildren, BSFormSetChildren
{

    private static final long serialVersionUID = 1L;
    /**
     * The input group addons
     */
    private List<Span> inputGroupAddons;
    /**
     * The input group addons
     */
    private List<Span> inputGroupAddonsRight;

    /**
     * Input group
     * <p>
     * Easily extend form controls by adding text, buttons, or button groups on either side of textual input's.
     *
     * @param input
     * @param size
     */
    public BSFormInputGroup(BSInput input, BSComponentInputGroupOptions... size)
    {
        addClass(BSComponentInputGroupOptions.Input_Group);
        add(input);
        if (size != null && size.length > 0)
        {
            for (BSComponentInputGroupOptions bSComponentInputGroupOptions : size)
            {
                addClass(bSComponentInputGroupOptions);
            }
        }
    }

    /**
     * Input group
     * <p>
     * Easily extend form controls by adding text, buttons, or button groups on either side of textual input's.
     *
     * @param input
     * @param size
     */
    public BSFormInputGroup(BSFormSelectInput input, BSComponentInputGroupOptions... size)
    {
        addClass(BSComponentInputGroupOptions.Input_Group);
        add(input);
        if (size != null && size.length > 0)
        {
            for (BSComponentInputGroupOptions bSComponentInputGroupOptions : size)
            {
                addClass(bSComponentInputGroupOptions);
            }
        }
    }

    /**
     * Input group
     * <p>
     * Easily extend form controls by adding text, buttons, or button groups on either side of textual input's.
     *
     * @param input
     * @param size
     */
    public BSFormInputGroup(TextArea input, BSComponentInputGroupOptions... size)
    {
        addClass(BSComponentInputGroupOptions.Input_Group);
        add(input);
        if (size != null && size.length > 0)
        {
            for (BSComponentInputGroupOptions bSComponentInputGroupOptions : size)
            {
                addClass(bSComponentInputGroupOptions);
            }
        }
    }

    /**
     *
     * @return
     */
    public List<Span> getInputGroupAddons()
    {
        if (inputGroupAddons == null)
        {
            setInputGroupAddons(new ArrayList<>());
        }
        return inputGroupAddons;
    }

    /**
     * The input group addons
     *
     * @param inputGroupAddons
     *
     * @return
     */
    public BSFormInputGroup setInputGroupAddons(List<Span> inputGroupAddons)
    {
        this.inputGroupAddons = inputGroupAddons;
        return this;
    }

    /**
     * Sets the input group addons to the right
     *
     * @return
     */
    public List<Span> getInputGroupAddonsRight()
    {
        if (inputGroupAddonsRight == null)
        {
            setInputGroupAddonsRight(new ArrayList());
        }
        return inputGroupAddonsRight;
    }

    /**
     * Sets the input group addons to the right
     *
     * @param inputGroupAddonsRight
     *
     * @return
     */
    public BSFormInputGroup setInputGroupAddonsRight(List<Span> inputGroupAddonsRight)
    {
        this.inputGroupAddonsRight = inputGroupAddonsRight;
        return this;
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getInputGroupAddons().forEach(inputGroupAddon ->
            {
                inputGroupAddon.addClass(BSComponentInputGroupOptions.Input_Group_Addon);
                add(0, inputGroupAddon);
            });

            getInputGroupAddonsRight().forEach(inputGroupAddon ->
            {
                inputGroupAddon.addClass(BSComponentInputGroupOptions.Input_Group_Addon);
                add(inputGroupAddon);
            });
        }
        super.preConfigure();
    }

}
