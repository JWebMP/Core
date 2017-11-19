package za.co.mmagon.jwebswing.utilities;

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;

public class ColourUtilsTest extends BaseTestClass
{
	@Test
	void getColourBetweenColours()
	{
		System.out.println(107560.0 / 1000);
		System.out.println(Math.ceil(107560.0 / 1000));
		System.out.println(Math.ceil(1.3));
		System.out.println("hi");
		Double dob = Double.parseDouble("2098.0583935946");
		System.out.println(dob);

		int minNumber = 2635518;
		int maxNumber = 49869420;


		System.out.println(ColourUtils.getColourBetweenColours(minNumber, maxNumber, 26671095, "ffffff", "900020"));
		System.out.println(ColourUtils.getColourBetweenColours(minNumber, maxNumber, 49869420, "ffffff", "900020"));
		System.out.println(ColourUtils.getColourBetweenColours(minNumber, maxNumber, 5538699, "ffffff", "900020"));
//    	System.out.println(getColour(minNumber, maxNumber, value));
	}


}
