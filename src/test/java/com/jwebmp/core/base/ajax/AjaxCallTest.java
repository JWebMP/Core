package com.jwebmp.core.base.ajax;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.CSSComponent;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AjaxCallTest
		extends BaseTestClass
{
	@Test
	public void fromCall()
	{
		AjaxCall call = new AjaxCall();
		call.setComponent(new CSSComponent("TestComponent")
		{
			@Override
			@NotNull
			protected StringBuilder renderHTML(int tabCount)
			{
				return super.renderHTML(tabCount);
			}

			@NotNull
			@Override
			public String getJQueryID()
			{
				return super.getJQueryID();
			}

			@NotNull
			@Override
			public String getID(boolean jQueryHolder)
			{
				return super.getID(jQueryHolder);
			}

			@NotNull
			@Override
			public String getID()
			{
				return super.getID();
			}
		});
		call.setComponentId("ComponentID");
		call.setDatetime(new Date(2017, 11, 18));
		call.setEventType(EventTypes.undefined);
		call.setEventId("EventID");
		call.getParameters()
		    .put("Test", "value");
		call.setClassName("classname");
		call.setValue(new AjaxEventValue().setAltKey(true)
		                                  .setBubbles(true)
		                                  .setCancelable(true)
		                                  .setClientX(0)
		                                  .setClientY(0)
		                                  .setComponentID("ComponentID")
		                                  .setCtrlKey(true)
		                                  .setData("data")
		                                  .setDetail(0)
		                                  .setEventPhase(0)
		                                  .setMetaKey(true)
		                                  .setOffsetX(0)
		                                  .setOffsetY(0)
		                                  .setPageX(0)
		                                  .setPageY(0)
		                                  .setScreenX(0)
		                                  .setScreenY(0)
		                                  .setShiftKey(true)
		                                  .setTarget("target")
		                                  .setType(EventTypes.undefined)
		                                  .setWhich("which"));

		System.out.println(call.toString());

		Assertions.assertEquals(
				"{\n" +
				"  \"componentId\" : \"ComponentID\",\n" +
				"  \"datetime\" : 61471692000000,\n" +
				"  \"eventType\" : \"undefined\",\n" +
				"  \"value\" : {\n" +
				"    \"altKey\" : true,\n" +
				"    \"ctrlKey\" : true,\n" +
				"    \"bubbles\" : true,\n" +
				"    \"cancelable\" : true,\n" +
				"    \"clientX\" : 0,\n" +
				"    \"clientY\" : 0,\n" +
				"    \"componentID\" : \"ComponentID\",\n" +
				"    \"detail\" : 0,\n" +
				"    \"eventPhase\" : 0,\n" +
				"    \"metaKey\" : true,\n" +
				"    \"offsetX\" : 0,\n" +
				"    \"offsetY\" : 0,\n" +
				"    \"pageX\" : 0,\n" +
				"    \"pageY\" : 0,\n" +
				"    \"screenX\" : 0,\n" +
				"    \"screenY\" : 0,\n" +
				"    \"shiftKey\" : true,\n" +
				"    \"type\" : \"undefined\",\n" +
				"    \"data\" : \"data\",\n" +
				"    \"target\" : \"target\",\n" +
				"    \"which\" : \"which\"\n" +
				"  },\n" +
				"  \"eventId\" : \"EventID\",\n" +
				"  \"parameters\" : {\n" +
				"    \"Test\" : \"value\"\n" +
				"  },\n" +
				"  \"className\" : \"classname\"\n" +
				"}",
				call.toString());
	}

}
