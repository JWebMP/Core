package com.jwebmp.events.checked;

import com.jwebmp.BaseTestClass;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckedAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		CheckedAdapter aa = new CheckedAdapter(test)
		{
			@Override
			public void onChecked(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-checked=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com.jwebmp.events.checked" + "" + "" + "" + "" + ".CheckedAdapterTest$1');\"></div>",
				test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");

		CheckedAdapter aa = new CheckedAdapter(test)
		{
			@Override
			public void onChecked(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));

	}
}
