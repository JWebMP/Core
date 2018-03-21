package za.co.mmagon.jwebswing.events.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class ResponseAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		ResponseAdapter aa = new ResponseAdapter(test)
		{
			@Override
			public void onResponse(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-response=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','za.co.mmagon.jwebswing.events.response" + "" + "" + "" + ".ResponseAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
