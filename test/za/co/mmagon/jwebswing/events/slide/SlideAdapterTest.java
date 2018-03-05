package za.co.mmagon.jwebswing.events.slide;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class SlideAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		SlideAdapter aa = new SlideAdapter(test)
		{
			@Override
			public void onSlide(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-slide=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.slide.SlideAdapterTest$1');"
						+ "\"></div>",
				test.toString(0));
	}


}
