/*
 * Copyright (C) 2014 MMagon
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
package za.co.mmagon.jwebswing.base.html;

import static org.junit.Assert.*;
import org.junit.Test;
import za.co.mmagon.jwebswing.base.client.Browsers;

/**
 *
 * @author MMagon
 */
public class AcronymTest
{

    public AcronymTest()
    {
    }

    @Test
    public void testDefault()
    {
        Acronym acr = new Acronym("This is my acronym");
        acr.getPage().setBrowser(Browsers.InternetExplorer6);
        System.out.println(acr.toString(true));
        assertEquals("<acronym>This is my acronym</acronym>", acr.toString(true).toString());

    }

    @Test
    public void testHTML5()
    {
        Acronym acr = new Acronym("This is my acronym");
        acr.getPage().setBrowser(Browsers.InternetExplorer9);
        System.out.println(acr.toString(true));
        assertEquals("<abbr>This is my acronym</abbr>", acr.toString(true).toString());
    }

}
