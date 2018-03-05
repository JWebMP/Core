package za.co.mmagon.jwebswing.events.dragstart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class DragStartAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		DragStartAdapter aa = new DragStartAdapter(test)
		{
			@Override
			public void onDragStart(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-drag-start=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.dragstart" + "" + "" +
						"" + ".DragStartAdapterTest$1');\"></div>",
				test.toString(0));
	}


}
