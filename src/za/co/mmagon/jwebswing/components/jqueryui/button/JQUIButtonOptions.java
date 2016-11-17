/*
 * Copyright (C) 2015 MXM3727
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
package za.co.mmagon.jwebswing.components.jqueryui.button;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author MXM3727
 */
public class JQUIButtonOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * Specifies if the button is disabled or not
     */
    private Boolean disabled;
    /**
     * The icons to display for the button
     */
    private JQUIButtonIconOptions icons;
    /**
     * The label of the button
     */
    private String label;
    /**
     * Sets whether or not the label should be shown
     */
    private Boolean showLabel;

    /**
     * Returns if the button is disabled
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Sets the button disabled
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Gets the icons for the button
     *
     * @return
     */
    public JQUIButtonIconOptions getIcons()
    {
        if (icons == null)
        {
            icons = new JQUIButtonIconOptions();
        }
        return icons;
    }

    /**
     * Sets the icons for the button
     *
     * @param icons
     */
    public void setIcons(JQUIButtonIconOptions icons)
    {
        this.icons = icons;
    }

    /**
     * Sets the label for the button
     *
     * @return
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Gets the label for the button
     *
     * @param label
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * Gets if the label should be shown.
     *
     * @return
     */
    public Boolean getShowLabel()
    {
        return showLabel;
    }

    /**
     * Sets if the label should be shown but the icons option must be enabled, otherwise the text option will be ignored.
     *
     * @param showLabel
     */
    public void setShowLabel(Boolean showLabel)
    {
        this.showLabel = showLabel;
    }
}
