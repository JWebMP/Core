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
package za.co.mmagon.jwebswing.components.bootstrap.alerts;

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the four required contextual classes (e.g., .alert-success). For inline dismissal,
 * use the alerts jQuery plugin.
 *
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public enum BSComponentAlertOptions implements IBSComponentOptions
{
    /**
     * Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the four required contextual classes (e.g., .alert-success). For inline
     * dismissal, use the alerts jQuery plugin.
     */
    Alert,
    /**
     * Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the four required contextual classes (e.g., .alert-success). For inline
     * dismissal, use the alerts jQuery plugin.
     */
    Alert_Success,
    /**
     * Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the four required contextual classes (e.g., .alert-success). For inline
     * dismissal, use the alerts jQuery plugin.
     */
    Alert_Warning,
    /**
     * Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the four required contextual classes (e.g., .alert-success). For inline
     * dismissal, use the alerts jQuery plugin.
     */
    Alert_Danger,
    /**
     * Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the four required contextual classes (e.g., .alert-success). For inline
     * dismissal, use the alerts jQuery plugin.
     */
    Alert_Info,
    /**
     * Use the .alert-link utility class to quickly provide matching colored links within any alert.
     */
    Alert_Link,
    /**
     *
     * Be sure you’ve loaded the alert plugin, or the compiled Bootstrap JavaScript.
     * <p>
     * Add a dismiss button and the .alert-dismissible class, which adds extra padding to the right of the alert and positions the .close button.
     * <p>
     * On the dismiss button, add the data-dismiss="alert" attribute, which triggers the JavaScript functionality. Be sure to use the <button> element with it for proper behavior across all devices.
     * <p>
     * To animate alerts when dismissing them, be sure to add the .fade and .in classes.
     * <p>
     */
    Alert_Dismissible;

    private BSComponentAlertOptions()
    {

    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

}
