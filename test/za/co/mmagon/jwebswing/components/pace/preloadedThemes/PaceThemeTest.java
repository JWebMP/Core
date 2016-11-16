/*
 * Copyright (C) 2016 ged_m
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
package za.co.mmagon.jwebswing.components.pace.preloadedThemes;

import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.jwebswing.generics.WebReference;

/**
 *
 * @author ged_m
 */
public class PaceThemeTest
{

    public PaceThemeTest()
    {
    }

    /**
     * Test of values method, of class PaceTheme.
     */
    @Test
    public void testValues()
    {
        PaceTheme pc = PaceTheme.Barbershop;
        WebReference.setIsLocal(false);
        System.out.println(pc.getCSSReference());
        Assert.assertEquals("https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/red/pace-theme-barber-shop.css", pc.getCSSReference().toString());
    }

}
