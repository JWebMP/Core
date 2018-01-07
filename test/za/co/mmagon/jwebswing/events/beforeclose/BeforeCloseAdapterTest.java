package za.co.mmagon.jwebswing.events.beforeclose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class BeforeCloseAdapterTest extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		BeforeCloseAdapter aa = new BeforeCloseAdapter(test)
		{
			@Override
			public void onBeforeClose(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-before-close=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.beforeclose.BeforeCloseAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.getPage().getAngular().getAngularDirectives().clear();
		test.setID("test");
		BeforeCloseAdapter aa = new BeforeCloseAdapter(test)
		{
			@Override
			public void onBeforeClose(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(1, test.getPage().getAngular().getAngularDirectives().size());
	}
}
