package za.co.mmagon.jwebswing.events.selected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Option;

class SelectedAdapterTest extends BaseTestClass
{
	@Test
	void test()
	{
		Option test = new Option<>("optionValue");
		test.setID("test");
		SelectedAdapter aa = new SelectedAdapter(test)
		{
			@Override
			public void onSelected(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<option label=\"optionValue\" value=\"optionValue\" id=\"test\" ng-selected=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_selected_SelectedAdapterTest$1','za.co.mmagon.jwebswing.events.selected.SelectedAdapterTest$1');\">optionValue</option>", test.toString(0));
	}

	@Test
	void testDirective()
	{
		Option test = new Option<>("optionValue");
		test.setID("test");
		test.getPage().getAngular().getAngularDirectives().clear();
		SelectedAdapter aa = new SelectedAdapter(test)
		{
			@Override
			public void onSelected(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(0, test.getPage().getAngular().getAngularDirectives().size());
	}

}
