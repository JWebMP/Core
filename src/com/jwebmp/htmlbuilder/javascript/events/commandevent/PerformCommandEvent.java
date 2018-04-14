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

package com.jwebmp.htmlbuilder.javascript.events.commandevent;

import com.jwebmp.Component;
import com.jwebmp.Event;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * This class enables a JQuery call to execute a java function directly after it
 * is rendered
 * <p>
 *
 * @author MMagon
 * @since 2012-12-30
 */
public abstract class PerformCommandEvent
		extends Event<PerformCommandEvent>
{

	public PerformCommandEvent(Component component)
	{
		super(EventTypes.performCommand, component);
	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		perform(call, response);
	}

	/**
	 * Executes the JavaScript lines of code directly after the component is executed
	 *
	 * @param call
	 * @param response
	 */
	public abstract void perform(AjaxCall call, AjaxResponse response);
}
