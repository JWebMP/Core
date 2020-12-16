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
package com.jwebmp.core.htmlbuilder.css.borders;

import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H1;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSS;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.composer.CSSComposer;
import com.jwebmp.core.htmlbuilder.css.enumarations.BorderStyles;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 * @since 17 Jan 2016
 */
@BorderCSS(BorderBottomColor = @ColourCSS("colourTop"),
		BorderLeftStyle = BorderStyles.Double,
		Border = @Border(Border = @BorderLeftCSS(BorderLeftColor = @ColourCSS("really deep colour"))))
public class BorderCSSObjectTest
		extends DivSimple<BorderCSSObjectTest>
{

	@BorderCSS(BorderBottomColor$ = ColourNames.AntiqueWhite,
			Border = @Border())
	private H1 hello;

	public BorderCSSObjectTest()
	{
		hello = new H1("Testing CSS Object Hello Field");
		setID("TestBorder");
		hello.setID("text");
	}

	@Test
	public void testObject()
	{
		CSSComposer comp = new CSSComposer();
		comp.addComponent(this, true);
		System.out.println(comp.toString());
		// comp.getBlockMaster().reset();
		//comp.addComponent(hello, true);
		// hello.setBackgroundColor$(ColourNames.DarkGoldenRod);
		// System.out.println(comp);

		//        Assertions.assertEquals("#TestBorder {border:really deep colour;border-bottom-color:colourTop;border-left-style:double;}#text {border-bottom-color:antiquewhite;}", comp.toString());
	}
}
