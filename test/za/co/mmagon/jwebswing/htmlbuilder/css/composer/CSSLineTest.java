package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author MMagon
 */
public class CSSLineTest
{

	public CSSLineTest()
	{
	}
	
	@BeforeAll
	public static void setUpClass()
	{
	}
	
	@AfterAll
	public static void tearDownClass()
	{
	}
	
	@BeforeEach
	public void setUp()
	{
	}
	
	@AfterEach
	public void tearDown()
	{
	}

	@Test
	public void testToString()
	{
		System.out.println("Testing CSS Line");
		CSSLine line1 = new CSSLine("Propert1", "Value1");
		assertEquals("propert1:Value1", line1.toString());
		CSSLine line2 = new CSSLine("text-decoration", "textDecoration");
		assertEquals("text-decoration:textDecoration", line2.toString());
		System.out.println("Passed CSS Line");
	}
}
