/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.navs;

/**
 * Tabs Takes the basic nav from above and adds the .nav-tabs class to generate a tabbed interface. Use them to create tabbable regions with our tab JavaScript plugin.
 *
 * @author GedMarc
 * @since 19 Jan 2017
 *
 */
public class BSNavTabs extends BSNavs
{

    private static final long serialVersionUID = 1L;

    /**
     * Tabs Takes the basic nav from above and adds the .nav-tabs class to generate a tabbed interface. Use them to create tabbable regions with our tab JavaScript plugin.
     */
    public BSNavTabs()
    {
        super();
        addClass(BSComponentNavsOptions.Nav_Tabs);
    }
}
