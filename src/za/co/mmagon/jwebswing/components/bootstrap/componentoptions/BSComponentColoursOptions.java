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
package za.co.mmagon.jwebswing.components.bootstrap.componentoptions;

/**
 * Colors
 * <p>
 * Convey meaning through color with a handful of emphasis utility classes. These may also be applied to links and will darken on hover just like our default link styles.
 *
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public enum BSComponentColoursOptions implements IBSComponentOptions
{
    /**
     * Text styled with class "text_muted"
     */
    Text_Muted,
    /**
     * Text styled with class "text_primary"
     */
    Text_Primary,
    /**
     * Text styled with class "text_success"
     */
    Text_Success,
    /**
     * Text styled with class "text_info"
     */
    Text_Info,
    /**
     * Text styled with class "text_warning"
     */
    Text_Warning,
    /**
     * Text styled with class "text_danger"
     */
    Text_Danger,
    /**
     * Text marked as white
     */
    Text_White,
    /**
     * with class "background primary"
     */
    Bg_Primary,
    /**
     * styled with class "background _success"
     */
    Bg_Success,
    /**
     * with class "background _info"
     */
    Bg_Info,
    /**
     * with class "background _warning"
     */
    Bg_Warning,
    /**
     * styled with class "background _danger"
     */
    Bg_Danger,
    /**
     * Reverses the colours, useful with text white
     */
    Bg_Inverse,
    /**
     * Displays a more faded background
     */
    Bg_Faded,
    /**
     * Hides colours on screen readers Using color to add meaning only provides a visual indication, which will not be conveyed to users of assistive technologies – such as screen readers. Ensure that
     * information denoted by the color is either obvious from the content itself (e.g. the visible text), or is included through alternative means, such as additional text hidden with the .sr-only
     * class.
     */
    Sr_Only,
    /**
     * Combine with sr_only to show the element again when it is focused (eg by a keyboard_only user)
     */
    Sr_Only_Focusable,;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
}
