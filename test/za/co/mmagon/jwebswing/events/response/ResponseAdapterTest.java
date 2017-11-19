package za.co.mmagon.jwebswing.events.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

class ResponseAdapterTest extends BaseTestClass
{
	@Test
	void test()
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
		Assertions.assertEquals("<div id=\"test\" ng-response=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_response_ResponseAdapterTest$1','za.co.mmagon.jwebswing.events.response.ResponseAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		test.getPage().getAngular().getAngularDirectives().clear();
		ResponseAdapter aa = new ResponseAdapter(test)
		{
			@Override
			public void onResponse(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(1, test.getPage().getAngular().getAngularDirectives().size());
	}
}
