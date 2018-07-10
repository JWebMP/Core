package com.jwebmp.events.unselected;

import com.jwebmp.BaseTestClass;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnselectedAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		UnselectedAdapter aa = new UnselectedAdapter(test)
		{
			@Override
			public void onUnselected(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-un-selected=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com.jwebmp.events.unselected" + "" + "" + ".UnselectedAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
