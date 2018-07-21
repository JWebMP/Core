package com.jwebmp.core.base.html;

import com.jwebmp.BaseTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author MMagon
 */
public class IFrameTest
		extends BaseTestClass
{

	@Test
	public void testIFrame()
	{
		IFrame frame = new IFrame("url", "name", 200, 200);
		frame.setID("id");
		System.out.println(frame);
		System.out.println(frame.toString(true));
		Assertions.assertEquals("<iframe height=\"200\" id=\"id\" name=\"name\" src=\"url\" width=\"200\"></iframe>", frame.toString(true));
	}
}
