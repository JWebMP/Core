/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.fontawesome;

import za.co.mmagon.jwebswing.base.html.Italic;

/**
 * The FontAwesome project.
 * <p>
 * @author Marc Magon
 * @param <P> All the font awesome property CSS classes
 * @since 21 May 2016
 * @version 1.0
 */
public class FontAwesome<P extends Enum & IFontAwesomeProperty> extends Italic
{

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new instance of the font awesome
     *
     * @param icon
     * @param size
     */
    public FontAwesome(FontAwesomeIcons icon, FontAwesomeProperties... size)
    {
        addCssReference(FontAwesomeReferencePool.FontAwesomeReference.getCssReference());
        setTiny(true);
        if (icon != null)
        {
            addClass(icon.toString());
        }
        
        if (size != null)
        {
            for (FontAwesomeProperties fontAwesomeProperties : size)
            {
                if (fontAwesomeProperties != null)
                {
                    addClass(fontAwesomeProperties.toString());
                }
            }
        }
    }

    /**
     * Construct a new instant of a font awesome icon
     *
     * @param icon
     */
    public FontAwesome(FontAwesomeIcons icon)
    {
        this(icon, (FontAwesomeProperties) null);
    }

    /**
     * Creates a new FontAwesome Icon with the given icon and size
     *
     * @param icon The icon to use
     * @param size The size to have
     * @return
     */
    public static FontAwesome icon(FontAwesomeIcons icon, FontAwesomeProperties... size)
    {
        return new FontAwesome(icon, size);
    }
    
    /**
     * Creates a new FontAwesome Icon with the given icon and size
     *
     * @param icon The icon to use
     * @return
     */
    public static FontAwesome icon(FontAwesomeIcons icon)
    {
        return new FontAwesome(icon, (FontAwesomeProperties)null);
    }

    /**
     * Sets the size of this icon
     *
     * @param size
     * @return
     */
    public FontAwesome setSize(FontAwesomeProperties size)
    {
        if (size != null)
        {
            addClass(size.toString());
        }
        return this;
    }
}
