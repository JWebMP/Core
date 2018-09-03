package com.jwebmp.core.events.select;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		SelectAdapter aa = new SelectAdapter(test)
		{
			@Override
			public void onSelect(AjaxCall call, AjaxResponse response)
			{

			}
		};
		test.addEvent(aa);
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-select=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','com_jwebmp_core_events_select_SelectAdapterTest$1')" + ";" + "\"></div>",
				test.toString(0));
	}

}
