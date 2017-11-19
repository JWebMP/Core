package za.co.mmagon.jwebswing.events.mousemove;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class MouseMoveAdapterTest extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		MouseMoveAdapter aa = new MouseMoveAdapter(test)
		{
			@Override
			public void onMouseMove(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-mousemove=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_mousemove_MouseMoveAdapterTest$1','za.co.mmagon.jwebswing.events.mousemove.MouseMoveAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		test.getPage().getAngular().getAngularDirectives().clear();
		MouseMoveAdapter aa = new MouseMoveAdapter(test)
		{
			@Override
			public void onMouseMove(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(0, test.getPage().getAngular().getAngularDirectives().size());
	}
}
