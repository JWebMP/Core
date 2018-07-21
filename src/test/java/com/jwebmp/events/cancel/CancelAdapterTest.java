package com.jwebmp.core.events.cancel;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CancelAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		CancelAdapter aa = new CancelAdapter(test)
		{
			@Override
			public void onCancel(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-cancel=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com.jwebmp.core.events.cancel.CancelAdapterTest$1');" + "\"></div>",
				test.toString(0));
	}

}
