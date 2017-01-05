/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxwidgets.tree;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.events.select.SelectAdapter;

/**
 * Highlights the select event with the objects return values
 *
 * @author GedMarc
 * @since 30 Jan 2016
 */
public abstract class JQXTreeSelectEvent extends SelectAdapter implements JQXTreeEvents
{

    private static final long serialVersionUID = 1L;

    public JQXTreeSelectEvent(Component componentToAddTo)
    {
        super(componentToAddTo);
    }

    @Override
    public abstract void onSelect(AjaxCall ajaxObject, AjaxResponse ajaxReceiver);

    /**
     * Perform the JQX Tree Select Event
     * <p>
     */
    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(getComponent().getJQueryID() + "jqxSelectItem();" + getNewLine());
    }
}
