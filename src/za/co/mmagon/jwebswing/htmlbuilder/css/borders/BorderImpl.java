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
package za.co.mmagon.jwebswing.htmlbuilder.css.borders;

import za.co.mmagon.jwebswing.base.client.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;

/**
 * A default border
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class BorderImpl extends CSSImplementationAdapter<Border, BorderImpl> implements CSSImplementationClass<Border, BorderImpl>
{

    private static final long serialVersionUID = 1L;
    @CSSDetail(cssName = "border-bottom-color", cssVersion = CSSVersions.CSS21)
    private BorderLeftCSSImpl border;

    @Override
    public String toString()
    {
        if (border != null)
        {
            return border.toString();
        }
        else
        {
            return "";
        }
    }

    /**
     * Returns the border
     *
     * @return
     */
    public BorderLeftCSSImpl getBorder()
    {
        return border;
    }

    /**
     * Sets the border
     *
     * @param Border
     */
    public void setBorder(BorderLeftCSSImpl Border)
    {
        this.border = Border;
    }

}
