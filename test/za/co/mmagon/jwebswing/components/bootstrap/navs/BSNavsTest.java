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

import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class BSNavsTest
{

    public BSNavsTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        BSNavs nav = new BSNavs();
        nav.add((BSNavLinkItem) new BSNavLinkItem("#").setText("Stff"));
        System.out.println(nav.toString(true));

        nav = new BSNavPill();
        nav.add(((BSNavLinkItem) new BSNavLinkItem("#").setText("Stff")).setActive());
        System.out.println(nav.toString(true));
    }

    @Test
    public void testDropDownInTab()
    {
        BSNavs nav = new BSNavs();
        nav.add(new BSNavItemDropDown());
        System.out.println(nav.toString(true));
    }

    @Test
    public void testPillsDropDownInTab()
    {
        BSNavs nav = new BSNavPill();
        nav.add(new BSNavItemDropDown());
        System.out.println(nav.toString(true));
    }

    @Test
    public void testTabsDropDownInTab()
    {
        BSNavs nav = new BSNavTabs();
        nav.add(new BSNavItemDropDown());
        System.out.println(nav.toString(true));
    }
}
