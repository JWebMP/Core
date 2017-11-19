package za.co.mmagon.jwebswing.events.mouseenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

class MouseEnterAdapterTest extends BaseTestClass
{
	@Test
	void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		MouseEnterAdapter aa = new MouseEnterAdapter(test)
		{
			@Override
			public void onMouseEnter(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-mouseenter=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_mouseenter_MouseEnterAdapterTest$1','za.co.mmagon.jwebswing.events.mouseenter.MouseEnterAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		test.getPage().getAngular().getAngularDirectives().clear();
		MouseEnterAdapter aa = new MouseEnterAdapter(test)
		{
			@Override
			public void onMouseEnter(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(0, test.getPage().getAngular().getAngularDirectives().size());
	}

}
