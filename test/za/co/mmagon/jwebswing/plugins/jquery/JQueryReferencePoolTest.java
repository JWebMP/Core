package za.co.mmagon.jwebswing.plugins.jquery;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

public class JQueryReferencePoolTest extends BaseTestClass
{
	@Test
	public void getJavaScriptReference()
	{
		JQueryReferencePool jr = JQueryReferencePool.JQueryV2;
		System.out.println(jr.toString());
		System.out.println(jr.getJavaScriptReference().toString());
	}

}
