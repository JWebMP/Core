package za.co.mmagon.jwebswing.base.html;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

/**
 * @author MMagon
 */
public class IFrameTest extends BaseTestClass
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
