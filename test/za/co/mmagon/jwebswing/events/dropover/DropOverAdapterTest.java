package za.co.mmagon.jwebswing.events.dropover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class DropOverAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		DropOverAdapter aa = new DropOverAdapter(test)
		{
			@Override
			public void onDropOver(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-drop-over=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','za.co.mmagon.jwebswing.events.dropover" + "" + "" + "" + ".DropOverAdapterTest$1');\"></div>",
				test.toString(0));
	}


}
