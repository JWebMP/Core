package za.co.mmagon.jwebswing.events.load;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class LoadAdapterTest
		extends BaseTestClass
{

	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		LoadAdapter aa = new LoadAdapter(test)
		{
			@Override
			public void onLoad(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-load=\"jwCntrl.perform($event,['jwCntrl.jw.localstorage'],'test','za.co.mmagon.jwebswing.events.load.LoadAdapterTest$1');" + "\"></div>",
				test.toString(0));
	}
}
