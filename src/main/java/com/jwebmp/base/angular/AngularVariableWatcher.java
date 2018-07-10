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

package com.jwebmp.base.angular;

import com.jwebmp.Event;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * Denotes an angular variable to watch with an event class mapped
 */
public class AngularVariableWatcher
		implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String watchName;
	private String variableName;
	private Class<? extends AngularChangeEvent<?>> eventClass;

	public AngularVariableWatcher(@NotNull String watchName, @NotNull String variableName, @NotNull Class<? extends AngularChangeEvent<?>> eventClass)
	{
		this.watchName = watchName;
		this.variableName = variableName;
		this.eventClass = eventClass;
	}

	public String getVariableName()
	{
		return variableName;
	}

	public void setVariableName(@NotNull String variableName)
	{
		this.variableName = variableName;
	}

	public Class<? extends Event<?>> getEventClass()
	{
		return eventClass;
	}

	public void setEventClass(@NotNull Class<? extends AngularChangeEvent<?>> eventClass)
	{
		this.eventClass = eventClass;
	}

	@Override
	public int hashCode()
	{
		return getWatchName().hashCode();
	}

	public String getWatchName()
	{
		return watchName;
	}

	public void setWatchName(@NotNull String watchName)
	{
		this.watchName = watchName;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		AngularVariableWatcher that = (AngularVariableWatcher) o;

		return getWatchName().equals(that.getWatchName());
	}

	@Override
	public String toString()
	{
		String returnable = "$scope.$watch('" + variableName + "'," + "function(newValue,oldValue){" + "if (newValue == oldValue){" + "}" + "else " + "{" + "$scope.angularchangeeventobject= {'old':oldValue,'new':newValue};" + "jw.env" + ".controller" + ".jw.isLoading || jw.env" + ".controller.perform(null" + "," + "['angularchangeeventobject']," + "'AngularWatchEvent'," + "'" + eventClass.getCanonicalName()
		                                                                                                                                                                                                                                                                                                                                                                                               .replace(
				                                                                                                                                                                                                                                                                                                                                                                                               CHAR_DOT,
				                                                                                                                                                                                                                                                                                                                                                                                               CHAR_UNDERSCORE) + "');";
		returnable += "}" + "});" + STRING_NEWLINE_TEXT;
		return returnable;
	}
}
