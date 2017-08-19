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
package za.co.mmagon.jwebswing.base.client;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Lists Browsers and their capable CSS. Stores when the compatibility changed per version Only includes the version number where the CSS and HTML version changes.
 *
 * @author MMagon
 * @version 1.0
 * @since 22 Jun 2013
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Browsers
{
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 5
	 */
	InternetExplorer55(CSSVersions.CSS1, HTMLVersions.XHTML11, 5.5, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 6
	 */
	InternetExplorer6(CSSVersions.CSS2, HTMLVersions.XHTML11, 6, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 7
	 */
	InternetExplorer7(CSSVersions.CSS21, HTMLVersions.XHTML11, 7, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 8
	 */
	InternetExplorer8(CSSVersions.CSS21, HTMLVersions.XHTML11, 8, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 8 CM
	 */
	InternetExplorer8CompatibilityMode(CSSVersions.CSS2, HTMLVersions.HTML401Loose, 7, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 9 CM
	 */
	InternetExplorer9CompatibilityMode(CSSVersions.CSS2, HTMLVersions.HTML401Loose, 7, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 9
	 */
	InternetExplorer9(CSSVersions.CSS3, HTMLVersions.HTML5, 9, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 10
	 */
	InternetExplorer10(CSSVersions.CSS3, HTMLVersions.HTML5, 10, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 10
	 */
	InternetExplorer13(CSSVersions.CSS3, HTMLVersions.HTML5, 10, BrowserGroups.InternetExplorer),
	/**
	 * Specifies the compatibility associated with the browser InternetExplorer 10
	 */
	Edge(CSSVersions.CSS3, HTMLVersions.HTML5, 13, BrowserGroups.Edge),
	/**
	 * Specifies the compatibility associated with the browser FireFox 2
	 */
	Firefox2(CSSVersions.CSS21, HTMLVersions.XHTML11, 2, BrowserGroups.Firefox),
	/**
	 * Specifies the compatibility associated with the browser FireFox 19
	 */
	Firefox19(CSSVersions.CSS3, HTMLVersions.HTML5, 19, BrowserGroups.Firefox),
	/**
	 * Specifies the compatibility associated with the browser Chrome
	 */
	Chrome(CSSVersions.CSS3, HTMLVersions.HTML5, 19, BrowserGroups.Chrome),
	/**
	 * Specifies the compatibility associated with the browser Opera 9
	 */
	Opera9(CSSVersions.CSS3, HTMLVersions.XHTML401Loose, 9, BrowserGroups.Opera),
	/**
	 * Specifies the compatibility associated with the browser Opera 11
	 */
	Opera11(CSSVersions.CSS3, HTMLVersions.HTML5, 11, BrowserGroups.Opera),
	/**
	 * Specifies the compatibility associated with the browser Safari 3
	 */
	Safari3(CSSVersions.CSS3, HTMLVersions.XHTML401Loose, 3, BrowserGroups.Safari),
	/**
	 * Specifies the compatibility associated with the browser Safari 5
	 */
	Safari5(CSSVersions.CSS3, HTMLVersions.HTML5, 5, BrowserGroups.Safari),
	/**
	 * Specifies the compatibility associated with the browser Custom or Undefined
	 */
	Custom(CSSVersions.CSS3, HTMLVersions.Custom, 5.5, BrowserGroups.InternetExplorer);

	@JsonProperty("cssVersion")
	private CSSVersions capableCSSVersion;
	@JsonProperty("browserGroup")
	private BrowserGroups browserGroup;
	@JsonProperty("htmlVersion")
	private HTMLVersions htmlVersion;
	@JsonProperty("browserLastCssHtmlUpdate")
	private double browserVersion;

	/**
	 * Constructs a Browser for the Enumeration
	 *
	 * @param capableCSSVersion  The CSS Version
	 * @param capableHTMLVersion The HTML Version
	 * @param browserVersion     The Browser Version
	 * @param browserGroup       The Browser Group
	 */
	private Browsers(CSSVersions capableCSSVersion, HTMLVersions capableHTMLVersion, double browserVersion, BrowserGroups browserGroup)
	{
		this.capableCSSVersion = capableCSSVersion;
		this.browserGroup = browserGroup;
		this.htmlVersion = capableHTMLVersion;
		this.browserVersion = browserVersion;
	}

	/**
	 * Returns all the browsers that exist in a group
	 *
	 * @param group The group name
	 *
	 * @return A list of browsers
	 */
	public static ArrayList<Browsers> getBrowsersForGroup(String group)
	{
		String groupRead = group;
		if (group.equalsIgnoreCase("Trident"))
		{
			groupRead = "Internet Explorer";
		}
		ArrayList<Browsers> browsers = new ArrayList();
		for (Browsers browsers1 : values())
		{
			if (browsers1.getBrowserGroup().name().equalsIgnoreCase(groupRead))
			{
				browsers.add(browsers1);
			}
		}
		return browsers;
	}

	/**
	 * Gets the browser object for a browser group name and version
	 *
	 * @param name    The name of the browser in the header file
	 * @param version The version of the browser in the header file
	 *
	 * @return The browser object applicable
	 */
	public static Browsers getBrowserFromNameAndVersion(String name, double version)
	{
		ArrayList<Browsers> browsers = getBrowsersForGroup(name);
		double maxCapableVersion = 0.0;
		Browsers maxCapabableBrowser = Firefox19;
		for (Browsers browsers1 : browsers)
		{
			if (browsers1.getBrowserVersion() > maxCapableVersion)
			{
				maxCapableVersion = browsers1.getBrowserVersion();
				maxCapabableBrowser = browsers1;
			}
		}
		if (maxCapableVersion < version)
		{
			return maxCapabableBrowser;
		}

		for (Browsers browsers1 : browsers)
		{
			if (browsers1.getBrowserVersion() < version)
			{
				return browsers1;
			}
		}
		return maxCapabableBrowser;
	}

	/**
	 * Retrieves the allowed CSS commands available
	 *
	 * @return The CSS Version
	 */
	public CSSVersions getCapableCSSVersion()
	{
		return capableCSSVersion;
	}

	/**
	 * Sets the capable CSS Version
	 *
	 * @param capableCSSVersion
	 */
	public void setCapableCSSVersion(CSSVersions capableCSSVersion)
	{
		this.capableCSSVersion = capableCSSVersion;
	}

	/**
	 * Returns the Browser Group
	 *
	 * @return The Browser Group
	 */
	public BrowserGroups getBrowserGroup()
	{
		return browserGroup;
	}

	/**
	 * Sets the browser group for this enumeration
	 *
	 * @param browserGroup
	 */
	public void setBrowserGroup(BrowserGroups browserGroup)
	{
		this.browserGroup = browserGroup;
	}

	/**
	 * Returns the HTML Version
	 *
	 * @return The Last HTML Version Allowed
	 */
	public HTMLVersions getHtmlVersion()
	{
		return htmlVersion;
	}

	/**
	 * Sets the capable HTML version of this version
	 *
	 * @param htmlVersion
	 */
	public void setHtmlVersion(HTMLVersions htmlVersion)
	{
		this.htmlVersion = htmlVersion;
	}

	/**
	 * Gets the browser version
	 *
	 * @return The Browser Version
	 */
	public double getBrowserVersion()
	{
		return browserVersion;
	}

	/**
	 * Sets the browser version
	 *
	 * @param browserVersion
	 */
	public void setBrowserVersion(double browserVersion)
	{
		this.browserVersion = browserVersion;
	}
}
