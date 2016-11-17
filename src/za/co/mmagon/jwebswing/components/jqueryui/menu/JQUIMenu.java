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
package za.co.mmagon.jwebswing.components.jqueryui.menu;

import za.co.mmagon.jwebswing.base.html.List;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;

/**
 * A menu with the default configuration, disabled items and nested menus.
 * <p>
 * A list is transformed, adding theming, mouse and keyboard navigation support.
 * <p>
 * Try to tab to the menu then use the cursor keys to navigate.
 * <p>
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUIMenu extends List<JQUIMenuChildren, NoAttributes, JQUIMenu>
{

    private static final long serialVersionUID = 1L;
    private JQUIMenuFeature feature;

    /**
     * Creates an ordered list
     */
    public JQUIMenu(Orientation orientation)
    {
        addFeature(getFeature());
        if (orientation != null && orientation.equals(Orientation.HORIZONTAL))
        {
            //getFeature().getCssReferences().add(JqWidgetsReferencePool.MenuBar.getCssReference());

        }

    }

    /**
     * Returns an instance of this feature
     * <p>
     * @return
     */
    public final JQUIMenuFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUIMenuFeature(this);
        }
        return feature;
    }

    /**
     * Gets the options of the menu
     *
     * @return
     */
    public JQUIMenuOptions getOptions()
    {
        return getFeature().getOptions();
    }
}
