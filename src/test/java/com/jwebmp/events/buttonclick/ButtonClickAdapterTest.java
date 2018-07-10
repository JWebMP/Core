package com.jwebmp.events.buttonclick;

import com.jwebmp.BaseTestClass;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonClickAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		ButtonClickAdapter aa = new ButtonClickAdapter(test)
		{
			@Override
			public void onButtonClick(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-button-click=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com.jwebmp.events.buttonclick" + "" + "" + ".ButtonClickAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
