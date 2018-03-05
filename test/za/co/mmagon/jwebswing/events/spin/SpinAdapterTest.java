package za.co.mmagon.jwebswing.events.spin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class SpinAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		SpinAdapter aa = new SpinAdapter(test)
		{
			@Override
			public void onSpin(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-spin=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.spin.SpinAdapterTest$1');" +
						"\"></div>",
				test.toString(0));
	}


}
