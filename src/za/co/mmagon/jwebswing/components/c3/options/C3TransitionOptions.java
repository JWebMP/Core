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
package za.co.mmagon.jwebswing.components.c3.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 09 Mar 2016
 */
public class C3TransitionOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Integer duration;

    public C3TransitionOptions()
    {
    }

    /**
     * Set duration of transition (in milliseconds) for chart animation.<p>
     * Note:
     * <p>
     * <p>
     * If 0 or null set, transition will be skipped. So, this makes initial rendering faster especially in case you have a lot of data.<p>
     *
     * @return
     */
    public Integer getDuration()
    {
        return duration;
    }

    /**
     * Set duration of transition (in milliseconds) for chart animation.<p>
     * Note:
     * <p>
     * <p>
     * If 0 or null set, transition will be skipped. So, this makes initial rendering faster especially in case you have a lot of data.<p>
     *
     * @param duration
     */
    public void setDuration(Integer duration)
    {
        this.duration = duration;
    }

}
