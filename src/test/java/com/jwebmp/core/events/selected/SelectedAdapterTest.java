package com.jwebmp.core.events.selected;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectedAdapterTest
		extends BaseTestClass
{
	@Test
	public void test()
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
		test.addEvent(aa.setID("test"));
		assertTrue(!test.getEvents()
		                .isEmpty());
	}

	@Test
	public void testDirective()
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

	}

}
