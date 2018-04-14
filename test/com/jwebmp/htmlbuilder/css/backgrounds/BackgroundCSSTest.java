/*
 * Copyright (C) 2017 Marc Magon
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
package com.jwebmp.htmlbuilder.css.backgrounds;

import com.jwebmp.htmlbuilder.css.CSSPropertiesFactory;
import com.jwebmp.htmlbuilder.css.composer.CSSBlock;
import com.jwebmp.htmlbuilder.css.composer.CSSBlockIdentifier;
import com.jwebmp.htmlbuilder.css.enumarations.CSSTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
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
		BackgroundCSSObjectTest cssObject = new BackgroundCSSObjectTest();
		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		Map<String, Object> strings = factory.getCSS(cssObject);
		CSSBlock newBlock = factory.getCSSBlock("NewBlock", CSSTypes.None, strings, CSSBlockIdentifier.Class);
		System.out.println("out : " + newBlock.toString());
		Assertions.assertEquals(newBlock.toString(), ".NewBlock{background-attachment:inherit;background-color:colour1;background-image:url(url 1) url(url 2) ;}");
	}

}
