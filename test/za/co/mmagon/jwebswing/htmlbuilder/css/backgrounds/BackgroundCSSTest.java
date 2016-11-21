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
package za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds;

import java.util.*;
import org.junit.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.*;

/**
 *
 * @author GedMarc
 */
public class BackgroundCSSTest
{

    public BackgroundCSSTest()
    {

    }

    @Test
    public void testBackgroundOutput()
    {
        BackgroundCSSObjectTest t = new BackgroundCSSObjectTest();
        BackgroundCSSObjectTest cssObject = new BackgroundCSSObjectTest();
        CSSPropertiesFactory factory = new CSSPropertiesFactory();
        Map<String, Object> strings = factory.getCSS(cssObject);
        CSSBlock newBlock = factory.getCSSBlock("NewBlock", CSSTypes.None, strings, CSSBlockIdentifier.Class);
        System.out.println("out : " + newBlock.toString());
        // Assert.assertEquals(newBlock.toString(), ".NewBlock {background-attachment:inherit;background-image:url(image specified);background-image:url(url 1) url(url 2) ;}");
    }

}
