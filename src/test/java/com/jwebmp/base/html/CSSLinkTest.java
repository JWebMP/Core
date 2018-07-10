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

package com.jwebmp.base.html;

import com.jwebmp.BaseTestClass;
import com.jwebmp.Page;
import com.jwebmp.base.client.Browsers;
import com.jwebmp.base.html.attributes.CSSLinkAttributes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author MMagon
 */
public class CSSLinkTest
		extends BaseTestClass
{

	CSSLink instance;

	public CSSLinkTest()
	{
		instance = new CSSLink("");
	}

	@Test
	public void testOutput()
	{
		Page page = getPage();
		page.getBody()
		    .add(new Comment("meh"));
		page.getHead()
		    .add(instance);
		instance.addAttribute(CSSLinkAttributes.Target, "Target Frame");
		instance.addAttribute(CSSLinkAttributes.HRef, "This is a link to something");
		System.out.println(instance.toString(true));
		String expResult = "<link href=\"This is a link to something\" rel=\"stylesheet\" target=\"Target Frame\" type=\"text/css\">";
		String result = instance.toString(true);
		assertEquals(expResult, result);

		instance.setTiny(true);
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
		instance.setPage(page);
		/**
		 * Test XHTML change to the tag
		 */
		instance.getPage()
		        .setBrowser(Browsers.InternetExplorer6);
		expResult = "<link href=\"This is a link to something\" rel=\"stylesheet\" target=\"Target Frame\" type=\"text/css\">";
		instance.setTiny(false);
		result = instance.toString(true);
		System.out.println(instance.toString(true));
		System.out.println(expResult);
		assertEquals(expResult, result);

		instance.setTiny(true);
		System.out.println(instance.toString(true));
		assertEquals(expResult, result);
	}

}
