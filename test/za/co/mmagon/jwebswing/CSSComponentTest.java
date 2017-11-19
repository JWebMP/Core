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
package za.co.mmagon.jwebswing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class CSSComponentTest extends BaseTestClass
{
	@Test
	public void getJQueryID()
	{
	}

	@Test
	public void getID()
	{
		CSSComponentImpl impl = new CSSComponentImpl();
		System.out.println(impl.getID(true));
		Assertions.assertEquals(".TestClass", impl.getID(true));
	}

	@Test
	public void renderHTML()
	{
		CSSComponentImpl impl = new CSSComponentImpl();
		impl.add("stuffs");
		System.out.println(impl.toString(true));
		Assertions.assertEquals(impl.toString(true), "");
	}

	private class CSSComponentImpl extends CSSComponent
	{

		/**
		 * Constructs a new CSS Class with the given features and events associated
		 * <p>
		 */
		public CSSComponentImpl()
		{
			super("TestClass");
		}
	}
}
