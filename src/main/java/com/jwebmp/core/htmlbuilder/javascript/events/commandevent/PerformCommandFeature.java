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

package com.jwebmp.core.htmlbuilder.javascript.events.commandevent;

import com.jwebmp.core.Component;
import com.jwebmp.core.Feature;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.utilities.StaticStrings;

import java.util.Iterator;
import java.util.List;

/**
 * Executes the JavaScript lines of code directly after the component is executed
 *
 * @author MMagon
 * @since 2012-12-30
 */
public abstract class PerformCommandFeature
		extends Feature<JavaScriptPart, PerformCommandFeature>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The given command name to execute
	 */
	private String commandName;

	/**
	 * Tells the server to send something to the client
	 */
	public PerformCommandFeature()
	{
		super("JWPerformCommand");
		commandName = getName();
	}

	/*
	 * Constructs a new command feature
	 */
	public PerformCommandFeature(String commandName, Component assignedComponent, String name)
	{
		super(name);
		this.commandName = commandName;
		setComponent(assignedComponent);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public void assignFunctionsToComponent()
	{
		for (Iterator<String> it = getJQueryValuesForCommand().iterator(); it.hasNext(); )
		{
			String string = it.next();

			String showDiv = "$('" + getComponent().getID() + "').show();" + (getComponent().isTiny() ? "" : "\n");
			addQuery(showDiv);
			String jQuery = "performCommand('" + getComponent().getID() + "','" + getName() + "'," + string + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON;
			addQuery(jQuery);
		}
	}

	public abstract List<String> getJQueryValuesForCommand();

	/**
	 * Returns a given command name
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	public String getCommandName()
	{
		return commandName;
	}
}
