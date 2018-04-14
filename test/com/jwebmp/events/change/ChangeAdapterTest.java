package com.jwebmp.events.change;

import com.jwebmp.BaseTestClass;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		ChangeAdapter aa = new ChangeAdapter(test)
		{
			@Override
			public void onChange(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-change=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com.jwebmp.events.change.ChangeAdapterTest$1')" + ";" + "\"></div>",
				test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");

		ChangeAdapter aa = new ChangeAdapter(test)
		{
			@Override
			public void onChange(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));

	}
}
