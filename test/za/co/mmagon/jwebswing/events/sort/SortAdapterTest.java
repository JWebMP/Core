package za.co.mmagon.jwebswing.events.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class SortAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		SortAdapter aa = new SortAdapter(test)
		{
			@Override
			public void onSort(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals(
				"<div id=\"test\" ng-sort=\"jwCntrl.perform($event,[],'test','za.co.mmagon.jwebswing.events.sort.SortAdapterTest$1');" +
						"\"></div>",
				test.toString(0));
	}

}
