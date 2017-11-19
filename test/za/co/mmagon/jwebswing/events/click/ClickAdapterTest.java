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
package za.co.mmagon.jwebswing.events.click;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

/**
 * @author Marc Magon
 */
public class ClickAdapterTest extends BaseTestClass
{
	
	public ClickAdapterTest()
	{
	}

	@Test
	void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		ClickAdapter aa = new ClickAdapter(test)
		{
			@Override
			public void onClick(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-click=\"jwCntrl.jw.isLoading || jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_click_ClickAdapterTest$1','za.co.mmagon.jwebswing.events.click.ClickAdapterTest$1');\" ng-disabled=\"jwCntrl.jw.isLoading\"></div>", test.toString(0));
	}

	@Test
	void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		test.getPage().getAngular().getAngularDirectives().clear();
		ClickAdapter aa = new ClickAdapter(test)
		{
			@Override
			public void onClick(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(0, test.getPage().getAngular().getAngularDirectives().size());
	}
}
