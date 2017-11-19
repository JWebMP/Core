package za.co.mmagon.jwebswing.utilities.dualquickpivot;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

public class QuickDualPivotTest extends BaseTestClass
{
	@Test
	public void testMe()
	{
		String[] args = new String[]{"test", "asdf", "zxcvzxcv", "asdfasd"};
		QuickDualPivot.sort(args);
		for (int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
		}
	}
}
