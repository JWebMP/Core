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

package com.jwebmp.core.events.search;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		SearchAdapter aa = new SearchAdapter(test)
		{
			@Override
			public void onSearch(AjaxCall call, AjaxResponse response)
			{

			}
		};
		test.addEvent(aa.setID("test"));
		assertTrue(!test.getEvents()
		                .isEmpty());
	}

}
