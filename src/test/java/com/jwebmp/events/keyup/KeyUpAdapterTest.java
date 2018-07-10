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

package com.jwebmp.events.keyup;

import com.jwebmp.BaseTestClass;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KeyUpAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		KeyUpAdapter aa = new KeyUpAdapter(test)
		{
			@Override
			public void onKeyUp(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-keyup=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com.jwebmp.events.keyup.KeyUpAdapterTest$1');" + "\"></div>",
				test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");

		KeyUpAdapter aa = new KeyUpAdapter(test)
		{
			@Override
			public void onKeyUp(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));

	}
}
