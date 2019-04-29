package com.jwebmp.core.plugins.jquery;

import com.jwebmp.BaseTestClass;
import org.junit.jupiter.api.Test;

public class JQueryReferencePoolTest
		extends BaseTestClass
{
	@Test
	public void getJavaScriptReference()
	{
		JQueryReferencePool jr = JQueryReferencePool.JQueryV3;
		System.out.println(jr.toString());
		System.out.println(jr.getJavaScriptReference()
		                     .toString());
	}

}
