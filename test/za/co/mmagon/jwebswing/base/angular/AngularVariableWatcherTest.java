package za.co.mmagon.jwebswing.base.angular;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;

class AngularVariableWatcherTest extends BaseTestClass
{
	@Test
	public void test()
	{
		System.out.println(new AngularVariableWatcher("watchVariable", "variable.name", ClickAdapter.class));
	}
}
