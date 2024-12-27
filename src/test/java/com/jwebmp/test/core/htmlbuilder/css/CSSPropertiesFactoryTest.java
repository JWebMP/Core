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
package com.jwebmp.test.core.htmlbuilder.css;

import com.jwebmp.core.htmlbuilder.css.CSSPropertiesFactory;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundCSSImpl;
import com.jwebmp.test.core.htmlbuilder.css.backgrounds.BackgroundCSSObjectTest;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.composer.CSSBlock;
import com.jwebmp.core.htmlbuilder.css.composer.CSSBlockIdentifier;
import com.jwebmp.core.htmlbuilder.css.enumarations.CSSTypes;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author GedMarc
 */
public class CSSPropertiesFactoryTest
{

	private BackgroundCSSObjectTest cssObject = new BackgroundCSSObjectTest();
	private com.jwebmp.core.htmlbuilder.css.CSSPropertiesFactory factory;

	public CSSPropertiesFactoryTest()
	{
	}

	/**
	 * Test of getCSSProperties method, of class CSSPropertiesFactory.
	 */
	@Test
	public void testGetCSSPropertiesClass()
	{
		com.jwebmp.core.htmlbuilder.css.CSSPropertiesFactory factory = new com.jwebmp.core.htmlbuilder.css.CSSPropertiesFactory();
		Map<StringBuilder, Object> strings = factory.getCSS(cssObject);
		for (Map.Entry<StringBuilder, Object> entry : strings.entrySet())
		{
			StringBuilder key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key - " + key + " [] " + value);
		}
		System.out.println("DONE WITH CLASS");
		try
		{
			Field[] f = cssObject.getClass()
			                     .getDeclaredFields();
			for (Field field : f)
			{
				//System.out.println("field " + field.getName());
			}

			Field fHello = cssObject.getClass()
			                        .getDeclaredField("hello");
			Map<StringBuilder, Object> strings2 = factory.getCSS(fHello, cssObject);
			for (Map.Entry<StringBuilder, Object> entry : strings2.entrySet())
			{
				StringBuilder key = entry.getKey();
				Object value = entry.getValue();
				System.out.println("key - " + key + " [] " + value);
			}
		}
		catch (NoSuchFieldException ex)
		{
			Logger.getLogger(CSSPropertiesFactoryTest.class.getName())
			      .log(Level.SEVERE, null, ex);
		}
		catch (SecurityException ex)
		{
			Logger.getLogger(CSSPropertiesFactoryTest.class.getName())
			      .log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Test of getCSSPropertiesFields method, of class CSSPropertiesFactory.
	 */
	@Test
	public void testCSSBlock()
	{
		com.jwebmp.core.htmlbuilder.css.CSSPropertiesFactory factory = new com.jwebmp.core.htmlbuilder.css.CSSPropertiesFactory();
		Map<String, Object> strings = factory.getCSS(cssObject);
		CSSBlock newBlock = factory.getCSSBlock("NewBlock", CSSTypes.None, strings, CSSBlockIdentifier.Id);
		System.out.println(newBlock);
	}

	/**
	 * Test of getCSSPropertiesFields method, of class CSSPropertiesFactory.
	 */
	@Test
	public void testCSSEnums()
	{
		com.jwebmp.core.htmlbuilder.css.CSSPropertiesFactory factory = new CSSPropertiesFactory();

		BackgroundCSSImpl back = new BackgroundCSSImpl();
		back.setBackgroundColor$(ColourNames.DarkGoldenRod);

		Map s = factory.getCSS(back);
		System.out.println(s);
	}

	/**
	 * Test of toString method, of class CSSPropertiesFactory.
	 */
	@Test
	public void testToString()
	{
	}

}
