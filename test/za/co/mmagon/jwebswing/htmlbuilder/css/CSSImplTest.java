/*
 * Copyright (C) 2016 ged_m
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.htmlbuilder.css;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundClip;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSBlock;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSBlockIdentifier;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Displays;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.BorderStyles;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontStyles;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListStylePosition;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListStyleType;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.padding.PaddingSetting;
import za.co.mmagon.jwebswing.htmlbuilder.css.tables.TableBorderCollapse;
import za.co.mmagon.jwebswing.htmlbuilder.css.tables.TableCaptionSides;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextAlignments;

/**
 * Tests the generation for css
 *
 * @author ged_m
 */
public class CSSImplTest extends BaseTestClass
{

	public CSSImplTest()
	{
	}

	@Test
	public void testJson()
	{
		CSSImpl css = new CSSImpl();
		css.getBackground().setBackgroundColor$(ColourNames.Aqua);
		System.out.println(css);
		Assertions.assertEquals("{\"background\":{\"backgroundColor$\":\"Aqua\"}}", css.toString());
	}

	@Test
	public void testBackground()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
		System.out.println("CSS Map : " + imp.getMap());
		imp = new CSSImpl();
		imp.getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"background\":{\"backgroundColor$\":\"DarkGoldenRod\"}}", imp.toString());
	}

	/**
	 * Test of getBorder method, of class CSSImpl.
	 */
	@Test
	public void testGetBorder()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getBorder().setBorderBottomColor$(ColourNames.PowderBlue);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"border\":{\"borderBottomColor$\":\"PowderBlue\"}}", imp.toString());
	}

	/**
	 * Test of getColour method, of class CSSImpl.
	 */
	@Test
	public void testGetColour()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getBackground().setBackgroundColor(new ColourCSSImpl("asdf"));
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"background\":{\"backgroundColor\":\"asdf\"}}", imp.toString());
	}

	/**
	 * Test of getDisplay method, of class CSSImpl.
	 */
	@Test
	public void testGetDisplay()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getDisplay().setDisplay(Displays.Inline);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"display\":{\"display\":\"Inline\"}}", imp.toString());
	}

	/**
	 * Test of getFont method, of class CSSImpl.
	 */
	@Test
	public void testGetFont()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getFont().setFontStyle(FontStyles.Normal);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"font\":{\"fontStyle\":\"Normal\"}}", imp.toString());
	}

	/**
	 * Test of getDimensions method, of class CSSImpl.
	 */
	@Test
	public void testGetDimensions()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getDimensions().setHeight(300);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"dimensions\":{\"height\":'300px'}}", imp.toString());
	}

	/**
	 * Test of getList method, of class CSSImpl.
	 */
	@Test
	public void testGetList()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getList().setListStyleType(ListStyleType.circle);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"list\":{\"listStyleType\":\"circle\"}}", imp.toString());
	}

	/**
	 * Test of getMargins method, of class CSSImpl.
	 */
	@Test
	public void testGetMargins()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getMargins().setMarginBottom(new MeasurementCSSImpl(0));
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"margins\":{\"marginBottom\":'0px'}}", imp.toString());
	}

	/**
	 * Test of getOutline method, of class CSSImpl.
	 */
	@Test
	public void testGetOutline()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getOutline().setOutlineColor$(ColourNames.AliceBlue);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"outline\":{\"outlineColor$\":\"AliceBlue\"}}", imp.toString());
	}

	/**
	 * Test of getPadding method, of class CSSImpl.
	 */
	@Test
	public void testGetPadding()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getPadding().setPaddingBottom$(PaddingSetting.Auto);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"padding\":{\"paddingBottom$\":\"Auto\"}}", imp.toString());
	}

	/**
	 * Test of getTable method, of class CSSImpl.
	 */
	@Test
	public void testGetTable()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getTable().setBorderCollapse(TableBorderCollapse.Separate);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"table\":{\"borderCollapse\":\"Separate\"}}", imp.toString());
	}

	/**
	 * Test of getText method, of class CSSImpl.
	 */
	@Test
	public void testGetText()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getText().setTextAlign(TextAlignments.Center);
		System.out.println(imp.toString());
		Assertions.assertEquals("{\"text\":{\"textAlign\":\"Center\"}}", imp.toString());
	}

	/**
	 * Test of setBackground method, of class CSSImpl.
	 */
	@Test
	public void testSetBackground()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{background-color:darkgoldenrod;}", block.toString());
	}

	/**
	 * Test of setBorder method, of class CSSImpl.
	 */
	@Test
	public void testSetBorder()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getBackground().setBackgroundColor$(ColourNames.DarkGoldenRod);
		imp.getBackground().setBackgroundClip(BackgroundClip.border_box);
		imp.getBorder().setBorderBottomStyle(BorderStyles.Double);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{background-clip:border-box;background-color:darkgoldenrod;border-bottom-style:double;}", block.toString());
	}

	/**
	 * Test of setColour method, of class CSSImpl.
	 */
	@Test
	public void testSetColour()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getText().setColor(new ColourCSSImpl("asd"));

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{color:asd;}", block.toString());
	}

	/**
	 * Test of setDisplay method, of class CSSImpl.
	 */
	@Test
	public void testSetDisplay()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getDisplay().setDisplay(Displays.Inline);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{display:inline;}", block.toString());
	}

	/**
	 * Test of setFonts method, of class CSSImpl.
	 */
	@Test
	public void testSetFonts()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getFont().setFontStyle(FontStyles.Normal);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{font-style:normal;}", block.toString());
	}

	/**
	 * Test of setDimensions method, of class CSSImpl.
	 */
	@Test
	public void testSetDimensions()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getDimensions().setHeight(500);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{height:500px;}", block.toString());
	}

	/**
	 * Test of setList method, of class CSSImpl.
	 */
	@Test
	public void testSetList()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getList().setListStylePosition(ListStylePosition.Inherit);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{list-style-position:inherit;}", block.toString());
	}

	/**
	 * Test of setMargins method, of class CSSImpl.
	 */
	@Test
	public void testSetMargins()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getMargins().setMarginBottom(new MeasurementCSSImpl(500));

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{margin-bottom:500px;}", block.toString());
	}

	/**
	 * Test of setOutline method, of class CSSImpl.
	 */
	@Test
	public void testSetOutline()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getOutline().setOutlineStyle(BorderStyles.Dotted);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{outline-style:dotted;}", block.toString());
	}

	/**
	 * Test of setPadding method, of class CSSImpl.
	 */
	@Test
	public void testSetPadding()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getPadding().setPaddingLeft$(PaddingSetting.Inherit);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{padding-left:inherit;}", block.toString());
	}

	/**
	 * Test of setTables method, of class CSSImpl.
	 */
	@Test
	public void testSetTables()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getTable().setTableCaptionSide(TableCaptionSides.Bottom);

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{table-caption-side:bottom;}", block.toString());
	}

	/**
	 * Test of setText method, of class CSSImpl.
	 */
	@Test
	public void testSetText()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getText().setColor(new ColourCSSImpl("colour"));

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{color:colour;}", block.toString());
	}

	/**
	 * Test of setText method, of class CSSImpl.
	 */
	@Test
	public void testSetBackgroundDeep()
	{
		Page p = getInstance();
		CSSImpl imp = new CSSImpl();
		imp.getBackground().getBackground().setBackgroundColor$(ColourNames.Aquamarine);
		imp.getText().setColor(new ColourCSSImpl("colour"));

		CSSPropertiesFactory factory = new CSSPropertiesFactory();
		CSSBlock block = factory.getCSSBlock("id", CSSTypes.None, imp.getMap(), CSSBlockIdentifier.Id);

		System.out.println(block.toString());
		Assertions.assertEquals("#id{background:aquamarine;color:colour;}", block.toString());
	}
}
