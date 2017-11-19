package za.co.mmagon.jwebswing.events.keydown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

class KeyDownAdapterTest extends BaseTestClass
{
	@Test
	void test()
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
		Assertions.assertEquals("<div id=\"test\" ng-keydown=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_keydown_KeyDownAdapterTest$1','za.co.mmagon.jwebswing.events.keydown.KeyDownAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		test.getPage().getAngular().getAngularDirectives().clear();
		KeyDownAdapter aa = new KeyDownAdapter(test)
		{
			@Override
			public void onKeyDown(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(0, test.getPage().getAngular().getAngularDirectives().size());
	}

}
