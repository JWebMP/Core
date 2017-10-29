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
package za.co.mmagon.jwebswing.features;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.commandevent.PerformCommandFeature;

import java.util.ArrayList;
import java.util.List;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_SINGLE_QUOTES;

/**
 * @author MMagon
 */
public class RenderOnLoadCommandFeature extends PerformCommandFeature
{

	private String nextComponentID;
	private String currentComponentID;

	public RenderOnLoadCommandFeature(String currentComponentID, String nextComponentID)
	{
		super("RenderOnLoad", null, "RenderOnLoad");
		this.nextComponentID = nextComponentID;
		this.currentComponentID = currentComponentID;
	}

	@Override
	public List<String> getJQueryValuesForCommand()
	{
		ArrayList<String> jQueries = new ArrayList();
		addQuery(STRING_SINGLE_QUOTES + nextComponentID + STRING_SINGLE_QUOTES);
		return jQueries;
	}
}
