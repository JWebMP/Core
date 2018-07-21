package com.jwebmp.core.events.keydown;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KeyDownAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		KeyDownAdapter aa = new KeyDownAdapter(test)
		{
			@Override
			public void onKeyDown(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-keydown=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com.jwebmp.core.events.keydown" +
				"" +
				"" +
				"" +
				"" +
				".KeyDownAdapterTest$1');\"></div>",
				test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");

		KeyDownAdapter aa = new KeyDownAdapter(test)
		{
			@Override
			public void onKeyDown(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));

	}

}
