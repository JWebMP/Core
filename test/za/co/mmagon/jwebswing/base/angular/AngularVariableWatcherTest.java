package za.co.mmagon.jwebswing.base.angular;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;

public class AngularVariableWatcherTest extends BaseTestClass
{
	@Test
	public void test()
	{
		System.out.println(new AngularVariableWatcher("watchVariable", "variable.name", AngularChangeEventClass.class));
	}

	public class AngularChangeEventClass extends AngularChangeEvent<AngularChangeEventClass>
	{

		@Override
		public void onChange(AjaxCall call, AjaxResponse response)
		{

		}
	}
}
