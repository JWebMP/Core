package com.jwebmp.core.events.receive;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiveAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		ReceiveAdapter aa = new ReceiveAdapter(test)
		{
			@Override
			public void onReceive(AjaxCall call, AjaxResponse response)
			{

			}
		};
		test.addEvent(aa);
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-receive=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com_jwebmp_core_events_receive_ReceiveAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
