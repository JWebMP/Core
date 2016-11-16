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
package za.co.mmagon.jwebswing.components.jqMetro.metro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.components.jqMetro.metro.enumerations.TileAccentThemes;
import za.co.mmagon.jwebswing.components.jqMetro.metro.references.JQMetroJavascriptReference;

/**
 *
 * @author GedMarc
 */
public class JQMetroTileTest extends BaseTestClass
{
    
    public JQMetroTileTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }

    /**
     * Test of getFeature method, of class JQMetroTiles.
     */
    @Test
    public void testGroup()
    {
        Page p = getPage();
        JQMetroTiles instance = new JQMetroTiles();
        instance.setID("id");
        instance.setTheme(TileAccentThemes.Cobalt);
        System.out.println(instance.toString(true));
        String expResult = "<div class=\"tiles tile-group four-wide cobalt\" id=\"id\"></div>";
        String result = instance.toString(true);
        assertEquals(expResult, result);
    }

    @Test
    public void testJavascriptLinks()
    {
        Page p = getPage();
        JQMetroTiles instance = new JQMetroTiles();
        instance.setID("id");
        instance.setTheme(TileAccentThemes.Cobalt);
        System.out.println(instance.getJavascriptReferencesAll());
        String expResult = "[bower_components/metrojs/release/MetroJs.Full/MetroJs.js]";
        String result = "[" + new JQMetroJavascriptReference().getLocalReference() + "]";
        assertEquals(expResult, result);
    }
    
    
}
