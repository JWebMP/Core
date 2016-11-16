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

import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 09 Mar 2016
 */
public class C3ColourOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private ArrayList<String> pattern;
    /**
     * @deprecated
     */
    private String threshold;

    public C3ColourOptions()
    {
    }

    /**
     * Set custom color pattern.<p>
     * Default:
     * <p>
     * <p>
     * undefined<p>
     * Format:
     * <p>
     * <p>
     * color: {
     * <p>
     * pattern: ['#1f77b4', '#aec7e8', ...]
     * <p>
     * }
     * <p>
     *
     *
     * @return
     */
    public ArrayList<String> getPattern()
    {
        return pattern;
    }

    /**
     * Set custom color pattern.<p>
     * Default:
     * <p>
     * <p>
     * undefined<p>
     * Format:
     * <p>
     * <p>
     * color: {
     * <p>
     * pattern: ['#1f77b4', '#aec7e8', ...]
     * <p>
     * }
     * <p>
     * @param pattern
     */
    public void setPattern(ArrayList<String> pattern)
    {
        this.pattern = pattern;
    }

    /**
     * not yet
     *
     * @deprecated
     * @return
     */
    public String getThreshold()
    {
        return threshold;
    }

    /**
     * not yet
     *
     * @deprecated
     * @param threshold
     */
    public void setThreshold(String threshold)
    {
        this.threshold = threshold;
    }

}
