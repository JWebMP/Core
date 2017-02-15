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
package za.co.mmagon;

import net.sf.uadetector.ReadableUserAgent;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.client.Browsers;

/**
 * A pages next update pair
 */
public class UpdatePair extends za.co.mmagon.jwebswing.generics.Pair<String, Component>
{

    private static final long serialVersionUID = 1L;
    /*
     * The current browser of the render
     */
    private Browsers browser;
    /**
     * The current user agent of the render
     */
    private transient ReadableUserAgent userAgent;

    /**
     * Load an Update WebReference
     *
     * @param componentID           The component ID to replace
     * @param componentToUpdateWith The component to update with (Best to pool these)
     */
    public UpdatePair(String componentID, Component componentToUpdateWith)
    {
        super(componentID, componentToUpdateWith);
    }

    /**
     * Returns the assigned user agent
     *
     * @return
     */
    public ReadableUserAgent getUserAgent()
    {
        return userAgent;
    }

    /**
     * Sets the assigned user agent
     *
     * @param userAgent
     */
    public void setUserAgent(ReadableUserAgent userAgent)
    {
        this.userAgent = userAgent;
    }

    /**
     * Gets the current assigned browser
     *
     * @return
     */
    public Browsers getBrowser()
    {
        return browser;
    }

    /**
     * Sets the current assigned browser
     *
     * @param browser
     */
    public void setBrowser(Browsers browser)
    {
        this.browser = browser;
    }
}
