/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryui.progressbar;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUIProgressBarOptions extends JavaScriptPart
{

    private Boolean disabled;
    private Integer max;
    private Integer value;

    /**
     *
     */
    public JQUIProgressBarOptions()
    {

    }

    /**
     * Returns if the progress bar is disabled or not
     * <p>
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Returns if the progress bar is disabled or not
     * <p>
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Gets the max
     * <p>
     * @return
     */
    public Integer getMax()
    {
        return max;
    }

    /**
     * Sets the maximum value
     * <p>
     * @param max
     */
    public void setMax(Integer max)
    {
        this.max = max;
    }

    /**
     * Gets the current value
     * <p>
     * @return
     */
    public Integer getValue()
    {
        return value;
    }

    /**
     * Sets the current value
     * <p>
     * @param value
     */
    public void setValue(Integer value)
    {
        this.value = value;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
