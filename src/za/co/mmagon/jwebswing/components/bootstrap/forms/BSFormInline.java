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
package za.co.mmagon.jwebswing.components.bootstrap.forms;

import za.co.mmagon.jwebswing.components.bootstrap.navs.BSNavsChildren;

/**
 * Inline forms
 * <p>
 * Use the .form-inline class to display a series of labels, form controls, and buttons on a single horizontal row. Form controls within inline forms vary slightly from their default states.
 * <p>
 * Controls are display: flex, collapsing any HTML white space and allowing you to provide alignment control with spacing and flexbox utilities. Controls and input groups receive width: auto to
 * override the Bootstrap default width: 100%. Controls only appear inline in viewports that are at least 576px wide to account for narrow viewports on mobile devices.
 * <p>
 * You may need to manually address the width and alignment of individual form controls with spacing utilities (as shown below).
 * <p>
 * Lastly, be sure to always include a label with each form control, even if you need to hide it from non-screenreader visitors with .sr-only.
 *
 * @author GedMarc
 * @since 15 Jan 2017
 *
 */
public class BSFormInline extends BSForm implements BSNavsChildren
{

    private static final long serialVersionUID = 1L;

    public BSFormInline()
    {
        addClass("form-inline");
    }
}
