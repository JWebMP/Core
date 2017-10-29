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
package za.co.mmagon.jwebswing.base.servlets.enumarations;

import javax.validation.constraints.NotNull;
import java.util.Properties;

/**
 * Configures the global generation type
 *
 * @author mmagon
 * @version 1.0
 * @since 2013/11/20
 */
public enum DevelopmentEnvironments
{
	/**
	 * All commenting and everything
	 */
	Local(null),
	/**
	 * Lots of commenting
	 */
	Sandbox(null),
	/**
	 * Always pretty print HTML
	 */
	Development,
	/**
	 * Allows for pretty print of HTML
	 */
	QA,
	/**
	 * UI Test Environment
	 */
	UITest,
	/**
	 * PreProduction Environment
	 */
	PreProduction,
	/**
	 * Forces tiny HTML to be rendered
	 */
	Production;

	private Properties environmentProperties;

	DevelopmentEnvironments()
	{
		environmentProperties = null;
	}

	/**
	 * Constructs with a default properties set
	 *
	 * @param environmentProperties
	 */
	DevelopmentEnvironments(Properties environmentProperties)
	{
		this.environmentProperties = environmentProperties;
	}

	/**
	 * Returns the assigned environment properties
	 *
	 * @return
	 */
	@NotNull
	public Properties getEnvironmentProperties()
	{
		if (environmentProperties == null)
		{
			environmentProperties = new Properties();
		}
		return environmentProperties;
	}

	/**
	 * Sets the default properties
	 *
	 * @param environmentProperties
	 */
	@SuppressWarnings("unused")
	public void setEnvironmentProperties(@NotNull Properties environmentProperties)
	{
		this.environmentProperties = environmentProperties;
	}
}
