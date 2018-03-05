package za.co.mmagon.jwebswing.events.activate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class ActivateAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		ActivateAdapter aa = new ActivateAdapter(test)
		{
			@Override
			public void onActivate(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-activate=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.activate" + "" + "" + "" +
						".ActivateAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
