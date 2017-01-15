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
package za.co.mmagon.jwebswing.components.bootstrap.forms.groups;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.components.bootstrap.forms.BSFormChildren;

/**
 * Form groups
 * <p>
 * The .form-group class is the easiest way to add some structure to forms.
 * <p>
 * Its only purpose is to provide margin-bottom around a label and control pairing. As a bonus, since it’s a class you can use it with fieldsets, divs, or nearly any other element.
 *
 * @author GedMarc
 * @since 14 Jan 2017
 *
 */
public class BSFormGroup extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, BSFormGroup>
        implements BSFormChildren
{

    private static final long serialVersionUID = 1L;

    public BSFormGroup()
    {
        //Nothing Needed
    }
}
