package za.co.mmagon.jwebswing.events.resizestart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class ResizeStartAdapterTest extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		ResizeStartAdapter aa = new ResizeStartAdapter(test)
		{
			@Override
			public void onResizeStart(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-resize-start=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_resizestart_ResizeStartAdapterTest$1','za.co.mmagon.jwebswing.events.resizestart.ResizeStartAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		test.getPage().getAngular().getAngularDirectives().clear();
		ResizeStartAdapter aa = new ResizeStartAdapter(test)
		{
			@Override
			public void onResizeStart(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(1, test.getPage().getAngular().getAngularDirectives().size());
	}

}
