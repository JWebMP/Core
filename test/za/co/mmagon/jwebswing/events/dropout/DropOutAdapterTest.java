package za.co.mmagon.jwebswing.events.dropout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class DropOutAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		DropOutAdapter aa = new DropOutAdapter(test)
		{
			@Override
			public void onDropOut(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-drop-out=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.dropout" + "" + "" + "" +
						".DropOutAdapterTest$1');\"></div>",
				test.toString(0));
	}

}
