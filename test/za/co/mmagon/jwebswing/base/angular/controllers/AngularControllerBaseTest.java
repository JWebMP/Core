package za.co.mmagon.jwebswing.base.angular.controllers;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.AngularVariableWatcher;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;

class AngularControllerBaseTest extends BaseTestClass
{
	@Test
	public void testRender()
	{
		AngularControllerBase acb = new AngularControllerBase("testWatchBuilder")
		{
			@Override
			public String renderFunction()
			{
				return "render";
			}
		};
		Page p = getPage();

		p.getAngular()
				.getAngularWatchers()
				.add(new AngularVariableWatcher("watchName", "unexistingvariable.name", ClickAdapter.class));
		System.out.println(p.getAngular()
				                   .renderAngularJavascript(p));
	}
}
