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

package com.jwebmp.core.htmlbuilder.javascript.events.commandevent;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;

/**
 * This class enables a JQuery call to execute a java function directly after it
 * is rendered
 * <p>
 *
 * @author MMagon
 * @since 2012-12-30
 */
public abstract class PerformCommandEvent<J extends PerformCommandEvent<J>>
		extends Event<GlobalFeatures, J>
{
	public PerformCommandEvent(IComponentHierarchyBase<?,?> component)
	{
		super(EventTypes.performCommand, component);
	}

	@Override
	public void assignFunctionsToComponent()
	{
		String jQuery = "jw.makeCall(jw.makeEmptyArticle('" +
				getComponent().asBase().getID() + "','" + getClassCanonicalName() + "'," + renderVariables()+ "));";
		addQuery(new StringBuilder(jQuery));
	}
	
	@Override
	public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
	{
		perform(call, response);
	}

	/**
	 * Executes the JavaScript lines of code directly after the component is executed
	 *
	 * @param call The call object
	 * @param response The response object
	 */
	public abstract void perform(AjaxCall<?> call, AjaxResponse<?> response);
}
