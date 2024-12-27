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
package com.jwebmp.test.css.borders;

import com.jwebmp.core.htmlbuilder.css.composer.CSSComposer;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

/**
 * @author GedMarc
 */
public class BorderCSSTest
{

    public BorderCSSTest()
    {
    }

    @Test
    public void testBorder()
    {
        BorderCSSObjectTest cssObject = new BorderCSSObjectTest();
        CSSComposer composer = new CSSComposer();
        composer.addComponent(cssObject, new LinkedHashSet<>());
        System.out.println("out from : " + composer.toString());
        //   Assertions.assertEquals(composer.toString(), "#TestBorder {border:really deep colour;border-bottom-color:colourTop;border-left-style:double;}#text {border-bottom-color:antiquewhite;}");
    }

}
